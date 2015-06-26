import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import java.util.ArrayList;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingShape.java
 * Purpose: Creates a class representing a rectangle.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingShape extends Shape
{
    private ArrayList<Point2D.Double> vertices;
    private ArrayList<Point2D.Double> curveVertices;
    private int vIndex = 0;
    private Path2D.Double shape;
    private ShapeAttributes att;
    private int kind;

    /**
     */
    public ProcessingShape(ShapeAttributes current, int kind){
    	//shape = new Path2D.Double();
    	vertices = new ArrayList<Point2D.Double>();
    	curveVertices = new ArrayList<Point2D.Double>();
    	this.att = current.copy();
    	this.kind = kind;
    }
    
    /**
     * 
     */
//    public void addVertex(double x, double y){
//    	if (vertices.isEmpty() && curveVertices.isEmpty()) {
//    		shape.moveTo(x, y);
//        	vertices.add(new Point2D.Double(x, y));
//    		curveVertices.add(new Point2D.Double(x, y));
//    	}
//    	else {
//    		switch (kind){
//
//    	    case Consts.POINTS:
//    	      point(x, y);
//    	      break;
//
//    	    case Consts.LINES:
//    	      if ((vertexCount % 2) == 0) {
//    	        line(vertices[vertexCount-2][X],
//    	             vertices[vertexCount-2][Y], x, y);
//    	      }
//    	      break;
//
//    	    case Consts.TRIANGLES:
//    	      if ((vertexCount % 3) == 0) {
//    	        triangle(vertices[vertexCount - 3][X],
//    	                 vertices[vertexCount - 3][Y],
//    	                 vertices[vertexCount - 2][X],
//    	                 vertices[vertexCount - 2][Y],
//    	                 x, y);
//    	      }
//    	      break;
//
//    	    case Consts.TRIANGLE_STRIP:
//    	      if (vertexCount >= 3) {
//    	        triangle(vertices[vertexCount - 2][X],
//    	                 vertices[vertexCount - 2][Y],
//    	                 vertices[vertexCount - 1][X],
//    	                 vertices[vertexCount - 1][Y],
//    	                 vertices[vertexCount - 3][X],
//    	                 vertices[vertexCount - 3][Y]);
//    	      }
//    	      break;
//
//    	    case Consts.TRIANGLE_FAN:
//    	      if (vertexCount >= 3) {
//    	        // This is an unfortunate implementation because the stroke for an
//    	        // adjacent triangle will be repeated. However, if the stroke is not
//    	        // redrawn, it will replace the adjacent line (when it lines up
//    	        // perfectly) or show a faint line (when off by a small amount).
//    	        // The alternative would be to wait, then draw the shape as a
//    	        // polygon fill, followed by a series of vertices. But that's a
//    	        // poor method when used with PDF, DXF, or other recording objects,
//    	        // since discrete triangles would likely be preferred.
//    	        triangle(vertices[0][X],
//    	                 vertices[0][Y],
//    	                 vertices[vertexCount - 2][X],
//    	                 vertices[vertexCount - 2][Y],
//    	                 x, y);
//    	      }
//    	      break;
//
//    	    case Consts.QUADS:
//    	      if ((vertexCount % 4) == 0) {
//    	        quad(vertices[vertexCount - 4][X],
//    	             vertices[vertexCount - 4][Y],
//    	             vertices[vertexCount - 3][X],
//    	             vertices[vertexCount - 3][Y],
//    	             vertices[vertexCount - 2][X],
//    	             vertices[vertexCount - 2][Y],
//    	             x, y);
//    	      }
//    	      break;
//
//    	    case Consts.QUAD_STRIP:
//    	      // 0---2---4
//    	      // |   |   |
//    	      // 1---3---5
//    	      if ((vertexCount >= 4) && ((vertexCount % 2) == 0)) {
//    	        quad(vertices[vertexCount - 4][X],
//    	             vertices[vertexCount - 4][Y],
//    	             vertices[vertexCount - 2][X],
//    	             vertices[vertexCount - 2][Y],
//    	             x, y,
//    	             vertices[vertexCount - 3][X],
//    	             vertices[vertexCount - 3][Y]);
//    	      }
//    	      break;
//    		}
//    	}
//    }
//    

	public void addCurveVertex(double x, double y) {
	   	if (vertices.isEmpty() && curveVertices.isEmpty()) {
    		shape.moveTo(x, y);
    		curveVertices.add(new Point2D.Double(x, y));
    	}
	   	else {
			curveVertices.add(new Point2D.Double(x, y));
			drawCurveSegment();
	   	}
	   		
	}
    
    private void drawCurveSegment() {
    	if (curveVertices.size() >= 4) {
    		Point2D.Double[] currentSet = new Point2D.Double[4];
    		for (int i = 0; i < 4; i++){
    			currentSet[i] = curveVertices.get(vIndex);
    			vIndex++;
    		}
    		vIndex -= 3;
    		Point2D.Double[] coords = produceCurve(currentSet, 
    				Consts.CATMULL_ROM, att.getCurveTightness());
    		shape.curveTo(coords[1].getX(), coords[1].getY(), coords[2].getX(), 
    				coords[2].getY(), coords[3].getX(), coords[3].getY());	
    	}
	}

	//quadratic
	public void add(double x1, double y1, double x2, double y2) {
		shape.quadTo(x1, y1, x2, y2);
	}
	
	//bezier
	public void add(double x1, double y1, double x2, double y2, double x3,
			double y3) {
		shape.curveTo(x1, y1, x2, y2, x3, y3);
	}
    

	public void closePath() {
		shape.closePath();
	}
	
    /* @return the arc's attributes object.
     * @see Shape#getAttributes()
     */
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    @Override
    public String toString(){
        //TO-DO;
    	return null;
        }
    
    /* Do the actual drawing of the shape.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(shape);
        }
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(shape);
        }
    }



}
