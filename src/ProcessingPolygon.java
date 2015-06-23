/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingPolygon.java
 * Purpose: Creates a class to draw a polygon.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class ProcessingPolygon implements Shape {
	private double[] x;
    private double[] y;
    private ShapeAttributes att;

    /**
     * @param xCoor: x-coordinates array
     * @param yCoor: y-coordinates array
     * @param current: the current ShapeAttributes object
     */
    public ProcessingPolygon(double[] xCoor, double[] yCoor, ShapeAttributes current){
        x = new double[xCoor.length];
        y = new double[yCoor.length];
    	for (int i = 0; i < xCoor.length; i++){
        	x[i] = xCoor[i];
        	y[i] = yCoor[i];
        }
        this.att = current.copy();
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

    /* Do the actual drawing of the polygon.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        Path2D.Double polygon = new Path2D.Double();
    	if (att.getFill()){
            g2.setColor(att.getFillColor());
            polygon.moveTo(x[0], y[0]);
            for (int i = 0; i < x.length; i++){
            	polygon.lineTo(x[i], y[i]);
            }
            polygon.closePath();            
            g2.fill(polygon);
    	}
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            polygon = new Path2D.Double();
            polygon.moveTo(x[0], y[0]);
            for (int i = 0; i < x.length; i++){
            	polygon.lineTo(x[i], y[i]);
            }
            polygon.closePath();            
            g2.draw(polygon);
        }
    }
}
