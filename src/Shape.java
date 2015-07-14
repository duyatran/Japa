import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library Shape.java Purpose:
 * Provides a Shape interface for geometric objects.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public abstract class Shape {

	/**
	 * @return the actual curve to be drawn
	 */
	protected Point2D.Double[] produceCurve(Point2D.Double[] points, int type,
			double tension) {
		Point2D.Double[] result = new Point2D.Double[points.length];
		// For Bezier curves
		double newPoint1X = points[0].getX();
		double newPoint1Y = points[0].getY();
		double newPoint2X = points[1].getX();
		double newPoint2Y = points[1].getY();
		double newPoint3X = points[2].getX();
		double newPoint3Y = points[2].getY();
		double newPoint4X = points[3].getX();
		double newPoint4Y = points[3].getY();

		// Coordinates conversion from Catmull-Rom curve to
		// Bezier control points
		// @see http://pomax.github.io/bezierinfo/#catmullconv
		if (type == Consts.CATMULL_ROM) {
			double s = (1 - tension) / 2;
			newPoint1X = points[1].getX();
			newPoint1Y = points[1].getY();

			newPoint2X = points[1].getX() + s
					* (points[2].getX() - points[0].getX()) / 3;
			newPoint2Y = points[1].getY() + s
					* (points[2].getY() - points[0].getY()) / 3;

			newPoint3X = points[2].getX() + s
					* (points[1].getX() - points[3].getX()) / 3;
			newPoint3Y = points[2].getY() + s
					* (points[1].getY() - points[3].getY()) / 3;

			newPoint4X = points[2].getX();
			newPoint4Y = points[2].getY();
		}
		result[0] = new Point2D.Double(newPoint1X, newPoint1Y);
		result[1] = new Point2D.Double(newPoint2X, newPoint2Y);
		result[2] = new Point2D.Double(newPoint3X, newPoint3Y);
		result[3] = new Point2D.Double(newPoint4X, newPoint4Y);

		return result;
	}

	/**
	 * @param mode
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param v4
	 */
	protected double[] setCoordinates(int mode, double v1, double v2,
			double v3, double v4) {
		switch (mode) {
		case Consts.CORNER:
			break;
		case Consts.CORNERS: // (v1,v2) is top-left, (v3,v4) is bottom-right
			v3 = v3 - v1; // v3 is now the width
			v4 = v4 - v2; // v4 is now the height
			break;
		case Consts.CENTER: // (v1,v2) is the center, v3 is w and v4 is h
			v1 = v1 - (v3 / 2); // v1 is now the top left x-coor
			v2 = v2 - (v4 / 2); // v2 is now the top left y-coor
			break;
		case Consts.RADIUS: // (v1,v2) is the center, v3 is w/2 and v4 is h/2
			v1 = v1 - v3;
			v2 = v2 - v4;
			v3 = v3 * 2;
			v4 = v4 * 2;
			break;
		default:
			System.out.println("Invalid shape mode");
		}

		if (v3 < 0) { // undo negative width
			v1 += v3;
			v3 = -v3;
		}

		if (v4 < 0) { // undo negative height
			v2 += v4;
			v4 = -v4;
		}
		return new double[] { v1, v2, v3, v4 };
	}

	abstract ShapeAttributes getAttributes();

	abstract void paintShape(Graphics2D g2);
}