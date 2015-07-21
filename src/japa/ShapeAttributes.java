package japa;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library ShapeAttributes.java
 * Purpose: Creates a class that holds a shape's attributes.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ShapeAttributes {
	private float strokeWeight = 1;
	private int strokeCap = BasicStroke.CAP_ROUND;
	private int strokeJoin = BasicStroke.JOIN_MITER;
	private Color strokeColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private boolean fill = true; // to fill shapes or not
	private boolean stroke = true; // to draw stroke or not
	private boolean smooth = true; // to be anti-aliased or not

	// defaults for shape-specific attributes
	private int rectMode = Consts.CORNER;
	private int ellipseMode = Consts.CENTER;
	private double curveTightness = 0;

	public ShapeAttributes() {
	}

	/**
	 * @return a copy of this ShapeAttributes object
	 */
	public ShapeAttributes copy() {
		ShapeAttributes newAtt = new ShapeAttributes();
		newAtt.setSmooth(this.getSmooth());
		newAtt.setFill(this.getFill());
		newAtt.setStroke(this.getStroke());
		newAtt.setFillColor(this.getFillColor());
		newAtt.setStrokeColor(this.getStrokeColor());
		newAtt.setStrokeWeight(this.getStrokeWeight());
		newAtt.setStrokeCap(this.getStrokeCap());
		newAtt.setStrokeJoin(this.getStrokeJoin());
		return newAtt;
	}

	/***************************************
	  Getters and setters of all attributes
	 ***************************************/

	public boolean getSmooth() {
		return smooth;
	}

	public boolean getFill() {
		return fill;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public boolean getStroke() {
		return stroke;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public BasicStroke getStrokeStyle() {
		return new BasicStroke(strokeWeight, strokeCap, strokeJoin);
	}

	public int getStrokeCap() {
		return strokeCap;
	}

	public int getStrokeJoin() {
		return strokeJoin;
	}

	public float getStrokeWeight() {
		return strokeWeight;
	}

	public int getRectMode() {
		return rectMode;
	}

	public int getEllipseMode() {
		return ellipseMode;
	}

	public double getCurveTightness() {
		return curveTightness;
	}
	
	/**
	 * @param b
	 */
	public void setSmooth(boolean b) {
		smooth = b;
	}

	/**
	 * @param b
	 */
	public void setFill(boolean b) {
		fill = b;
	}

	/**
	 * @param c
	 */
	public void setFillColor(Color c) {
		fillColor = c;
	}

	/**
	 * @param b
	 */
	public void setStroke(boolean b) {
		stroke = b;
	}

	/**
	 * @param c
	 */
	public void setStrokeColor(Color c) {
		strokeColor = c;
	}

	/**
	 * @param i
	 */
	public void setStrokeCap(int i) {
		strokeCap = i;
	}

	/**
	 * @param i
	 */
	public void setStrokeJoin(int i) {
		strokeJoin = i;
	}

	/**
	 * @param w
	 */
	public void setStrokeWeight(float w) {
		strokeWeight = w;
	}

	/**
	 * @param rectMode
	 *            the rectMode to set
	 */
	public void setRectMode(int mode) {
		this.rectMode = mode;
	}

	/**
	 * @param ellipseMode
	 *            the ellipseMode to set
	 */
	public void setEllipseMode(int mode) {
		this.ellipseMode = mode;
	}

	/**
	 * @param curveTension
	 *            the curveTension to set
	 */
	public void setCurveTightness(double t) {
		this.curveTightness = t;
	}

	@Override
	public String toString() {
		return ("stroke weight: " + getStrokeWeight()
				+ "stroke join: " + getStrokeJoin() + "stroke cap: "
				+ getStrokeCap() + " strokeColor: " + strokeColor
				+ " fillColor: " + fillColor + " fill: " + fill + " stroke: "
				+ stroke + " smooth: " + smooth);
	}
}