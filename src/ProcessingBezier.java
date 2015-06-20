/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingBezier.java
 * Purpose: Creates a class for Bezier curves.
 *
 * @author Duy Tran
 * @version 1.0 6/20/2015
 */

import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;

public class ProcessingBezier implements Shape{
	private double[] x;
    private double[] y;
    private ShapeAttributes att;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public ProcessingBezier(double[] xCoor, double[] yCoor, ShapeAttributes current){
        x = new double[xCoor.length];
        y = new double[yCoor.length];
    	for (int i = 0; i < xCoor.length; i++){
        	x[i] = xCoor[i];
        	y[i] = yCoor[i];
        }
        this.att = current.copy();
    }

    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
    	//TO-DO
        return " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
        CubicCurve2D.Double curve = new CubicCurve2D.Double(
        		x[0], y[0], x[1], y[1], x[2], y[2], x[3], y[3]);
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
