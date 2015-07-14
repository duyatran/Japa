/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingCurve.java
 * Purpose: Creates a class to draw curves.
 *
 * @author Duy Tran
 * @version 1.0 6/22/2015
 */

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

public class ProcessingCurve extends Shape {
	private double[] x;
	private double[] y;
	private Point2D.Double[] points;
	private int type; // either Consts.BEZIER or Consts.CATMULLROM
	private double tension = 0;
	private ShapeAttributes att;

	/**
	 * @param xCoor
	 *            : x-coordinates array
	 * @param yCoor
	 *            : y-coordinates array
	 * @param t
	 *            : the tension value (0.0 to 1.0)
	 * @param current
	 *            : the current ShapeAttributes object
	 */
	public ProcessingCurve(double[] xCoor, double[] yCoor, int t,
			ShapeAttributes current) {
		x = new double[xCoor.length];
		y = new double[yCoor.length];
		points = new Point2D.Double[4];
		for (int i = 0; i < xCoor.length; i++) {
			x[i] = xCoor[i];
			y[i] = yCoor[i];
			points[i] = new Point2D.Double(x[i], y[i]);
		}
		this.att = current.copy();
		this.type = t;
		this.tension = att.getCurveTightness();
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
		// TO-DO
		return " attributes: " + att.toString();
	}

	/*
	 * Do the actual drawing of the curve.
	 * 
	 * @see Shape#paintShape(java.awt.Graphics2D)
	 */
	public void paintShape(Graphics2D g2) {
		Point2D.Double[] c = produceCurve(points, type, tension);
		CubicCurve2D.Double curve = new CubicCurve2D.Double(c[0].getX(),
				c[0].getY(), c[1].getX(), c[1].getY(), c[2].getX(),
				c[2].getY(), c[3].getX(), c[3].getY());
		
		if (att.getSmooth())
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		else
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);

		if (att.getFill()) {
			g2.setColor(att.getFillColor());
			g2.fill(curve);
		}
		if (att.getStroke()) {
			g2.setStroke(att.getStrokeStyle());
			g2.setColor(att.getStrokeColor());
			g2.draw(curve);
		}
	}
}
