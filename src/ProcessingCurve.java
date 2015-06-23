/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingCurve.java
 * Purpose: Creates a class to draw curves.
 *
 * @author Duy Tran
 * @version 1.0 6/22/2015
 */

import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;

public class ProcessingCurve implements Shape{
	private double[] x;
    private double[] y;
    private int type; // either Consts.BEZIER or Consts.CATMULLROM
    private double tension = 0;
    private ShapeAttributes att;

    
    /**
     * @param xCoor: x-coordinates array
     * @param yCoor: y-coordinates array
     * @param t: the tension value (0.0 to 1.0)
     * @param current: the current ShapeAttributes object
     */
    public ProcessingCurve(double[] xCoor, double[] yCoor,
    		int t, ShapeAttributes current){
        x = new double[xCoor.length];
        y = new double[yCoor.length];
    	for (int i = 0; i < xCoor.length; i++){
        	x[i] = xCoor[i];
        	y[i] = yCoor[i];
        }
    	this.type = t;
        this.att = current.copy();
    }
    
    /**
     * @return the actual curve to be drawn
     */
    private CubicCurve2D.Double produceCurve(){
    	// For Bezier curves
    	double newPoint1X = x[0];
		double newPoint1Y = y[0];
		double newPoint2X = x[1];
		double newPoint2Y = y[1];
		double newPoint3X = x[2];
		double newPoint3Y = y[2];
		double newPoint4X = x[3];
		double newPoint4Y = y[3];
		
		// Coordinates conversion from Catmull-Rom curve to
		// Bezier control points
		// @see http://pomax.github.io/bezierinfo/#catmullconv
    	if (type == Consts.CATMULLROM) {
    		double s = (1 - tension)/2;
    		newPoint1X = x[1];
    		newPoint1Y = y[1];
    		newPoint2X = x[1] + s*(x[2] - x[0])/3;
    		newPoint2Y = y[1] + s*(y[2] - y[0])/3;
    		newPoint3X = x[2] + s*(x[1] - x[3])/3;
    		newPoint3Y = y[2] + s*(y[1] - y[3])/3;
    		newPoint4X = x[2];
    		newPoint4Y = y[2];
    	}
    	return new CubicCurve2D.Double(newPoint1X, newPoint1Y, newPoint2X, newPoint2Y,
    			newPoint3X, newPoint3Y, newPoint4X, newPoint4Y);
    }
    
    /* @return the arc's attributes object. 
     * @see Shape#getAttributes()
     */
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    @Override
    public String toString(){
    	//TO-DO
        return " attributes: " + att.toString();
    }

    /* Do the actual drawing of the curve.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        CubicCurve2D.Double curve = produceCurve();
    	if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(curve);
    	}
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(curve);
        }
    }
}
