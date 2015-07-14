/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingArc.java
 * Purpose: Creates a class to draw an arc.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

public class ProcessingArc extends Shape {

	private double x;
	private double y;
	private double w;
	private double h;
	private double start;
	private double stop;
	private int fillMode;
	private int strokeMode;
	private ShapeAttributes att;

	/**
	 * @param x
	 *            : x-coordinate of the arc's ellipse
	 * @param y
	 *            : y-coordinate of the arc' ellipse
	 * @param w
	 *            : width of the arc's ellipse
	 * @param h
	 *            : height of the arc's ellipse
	 * @param start
	 *            : angle to start the arc (in degrees).
	 * @param stop
	 *            : angle to stop the arc (in degrees).
	 * @param mode
	 *            : the closure type for the arc, either OPEN, CHORD, or PIE.
	 * @param current
	 *            : the current ShapeAttributes object
	 */
	public ProcessingArc(double x, double y, double w, double h, double start,
			double stop, int mode, ShapeAttributes current) {
		this.x = x - (w / 2);
		this.y = y - (h / 2);
		this.w = w;
		this.h = h;
		this.start = start;
		this.stop = stop;
		this.att = current.copy();
		if (mode == Consts.DEFAULT_ARC) {
			this.fillMode = Consts.PIE;
			this.strokeMode = Consts.OPEN;
		} else {
			this.fillMode = mode;
			this.strokeMode = mode;
		}
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
		return "Arc[x=" + x + ",y=" + y + ",w=" + w + ",h=" + h
				+ " attributes: " + att.toString();
	}

	/*
	 * Do the actual drawing of the arc.
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
		
		if (att.getFill() == true) {
			g2.setColor(att.getFillColor());
			g2.fill(new Arc2D.Double(x, y, w, h, start, stop, fillMode));
		}
		if (att.getStroke() == true) {
			g2.setStroke(att.getStrokeStyle());
			g2.setColor(att.getStrokeColor());
			g2.draw(new Arc2D.Double(x, y, w, h, start, stop, strokeMode));
		}
	}
}
