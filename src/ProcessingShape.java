import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library ProcessingShape.java
 * Purpose: Creates a class representing a rectangle.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingShape extends Shape {
	private ArrayList<Point2D.Double> vertices;
	private ArrayList<Point2D.Double> curveVertices;
	private ArrayList<Shape> shapeList;
	private Path2D.Double path;
	private ShapeAttributes att;
	private int kind;
	private int vertexIndex = 0;
	private double[] xCoords;
	private double[] yCoords;
	private int vertexCount;

	/**
	 */
	public ProcessingShape(ShapeAttributes current, int kind) {
		vertices = new ArrayList<Point2D.Double>();
		curveVertices = new ArrayList<Point2D.Double>();
		shapeList = new ArrayList<Shape>();
		path = new Path2D.Double();
		this.att = current.copy();
		this.kind = kind;
	}

	/**
	  * 
	  */
	public void addVertex(double x, double y) {
		vertices.add(new Point2D.Double(x, y));
		vertexCount = vertices.size();

		switch (this.kind) {

		case Consts.POINTS:
			// stroke cap of points must be ROUND
			shapeList.add(new ProcessingLine(x, y, x + Consts.EPSILON, y
					+ Consts.EPSILON, att));
			break;

		case Consts.LINES:
			if ((vertexCount % 2) == 0) {
				shapeList.add(new ProcessingLine(vertices.get(vertexCount - 2)
						.getX(), vertices.get(vertexCount - 2).getY(), x, y,
						att));
			}
			break;

		case Consts.TRIANGLES:
			if ((vertexCount % 3) == 0) {
				xCoords = new double[] { vertices.get(vertexCount - 3).getX(),
						vertices.get(vertexCount - 2).getX(), x };

				yCoords = new double[] { vertices.get(vertexCount - 3).getY(),
						vertices.get(vertexCount - 2).getY(), y };

				shapeList.add(new ProcessingPolygon(xCoords, yCoords, att));
			}
			break;

		case Consts.TRIANGLE_STRIP:
			if (vertexCount >= 3) {
				xCoords = new double[] { vertices.get(vertexCount - 2).getX(),
						vertices.get(vertexCount - 1).getX(),
						vertices.get(vertexCount - 3).getX() };

				yCoords = new double[] { vertices.get(vertexCount - 2).getY(),
						vertices.get(vertexCount - 1).getY(),
						vertices.get(vertexCount - 3).getY() };

				shapeList.add(new ProcessingPolygon(xCoords, yCoords, att));
			}
			break;

		case Consts.TRIANGLE_FAN:
			if (vertexCount >= 3) {
				// From Processing: This is an unfortunate implementation
				// because the stroke for an
				// adjacent triangle will be repeated. However, if the stroke is
				// not
				// redrawn, it will replace the adjacent line (when it lines up
				// perfectly) or show a faint line (when off by a small amount).
				// The alternative would be to wait, then draw the shape as a
				// polygon fill, followed by a series of verticesSet. But that's
				// a
				// poor method when used with PDF, DXF, or other recording
				// objects,
				// since discrete triangles would likely be preferred.

				xCoords = new double[] { vertices.get(0).getX(),
						vertices.get(vertexCount - 2).getX(), x };

				yCoords = new double[] { vertices.get(0).getY(),
						vertices.get(vertexCount - 2).getY(), y };

				shapeList.add(new ProcessingPolygon(xCoords, yCoords, att));
			}
			break;

		case Consts.QUADS:
			if ((vertexCount % 4) == 0) {
				xCoords = new double[] { vertices.get(vertexCount - 4).getX(),
						vertices.get(vertexCount - 3).getX(),
						vertices.get(vertexCount - 2).getX(), x };

				yCoords = new double[] { vertices.get(vertexCount - 4).getY(),
						vertices.get(vertexCount - 3).getY(),
						vertices.get(vertexCount - 2).getY(), y };

				shapeList.add(new ProcessingPolygon(xCoords, yCoords, att));
			}
			break;

		case Consts.QUAD_STRIP:
			if ((vertexCount >= 4) && ((vertexCount % 2) == 0)) {
				xCoords = new double[] { vertices.get(vertexCount - 4).getX(),
						vertices.get(vertexCount - 2).getX(), x,
						vertices.get(vertexCount - 3).getX() };

				yCoords = new double[] { vertices.get(vertexCount - 4).getY(),
						vertices.get(vertexCount - 2).getY(), y,
						vertices.get(vertexCount - 3).getY() };

				shapeList.add(new ProcessingPolygon(xCoords, yCoords, att));
			}
			break;
		case Consts.POLYGON:
			if (vertices.size() == 1) {
				path.moveTo(x, y);
			} else {
				path.lineTo(x, y);
			}
		}
	}

	public void addCurveVertex(double x, double y) {
		if (vertices.isEmpty() && curveVertices.isEmpty()) {
			path.moveTo(x, y);
			curveVertices.add(new Point2D.Double(x, y));
		} else {
			curveVertices.add(new Point2D.Double(x, y));
			drawCurveSegment();
		}

	}

	private void drawCurveSegment() {
		if (curveVertices.size() >= 4) {
			Point2D.Double[] currentSet = new Point2D.Double[4];
			for (int i = 0; i < 4; i++) {
				currentSet[i] = curveVertices.get(vertexIndex);
				vertexIndex++;
			}
			vertexIndex -= 3;
			Point2D.Double[] coords = produceCurve(currentSet,
					Consts.CATMULL_ROM, att.getCurveTightness());
			path.curveTo(coords[1].getX(), coords[1].getY(), coords[2].getX(),
					coords[2].getY(), coords[3].getX(), coords[3].getY());
		}
	}

	// quadratic
	public void add(double x1, double y1, double x2, double y2) {
		path.quadTo(x1, y1, x2, y2);
	}

	// bezier
	public void add(double x1, double y1, double x2, double y2, double x3,
			double y3) {
		path.curveTo(x1, y1, x2, y2, x3, y3);
	}

	public void closePath(int mode) {
		if (mode == Consts.CLOSE) {
			path.closePath();
		}
		shapeList.add(this);// lol, really?
	}

	/*
	 * @return the arc's attributes object.
	 * 
	 * @see Shape#getAttributes()
	 */
	public ShapeAttributes getAttributes() {
		return this.att;
	}

	@Override
	public String toString() {
		// TO-DO;
		return "A custom shape " + this.kind;
	}

	/*
	 * Do the actual drawing of the shape.
	 * 
	 * @see Shape#paintShape(java.awt.Graphics2D)
	 */
	public void paintShape(Graphics2D g2) {
		if (att.getSmooth())
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		else
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
		
		if (att.getFill()) {
			g2.setColor(att.getFillColor());
			g2.fill(path);
		}
		if (att.getStroke()) {
			g2.setStroke(att.getStrokeStyle());
			g2.setColor(att.getStrokeColor());
			g2.draw(path);
		}
	}

	public ArrayList<Shape> getShapeList() {
		// TODO Auto-generated method stub
		return shapeList;
	}

}
