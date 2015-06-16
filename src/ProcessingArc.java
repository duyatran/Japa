import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingEllipse.java
 * Purpose: Creates a class representing an arc.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingArc implements Shape, ProcessingConstants
{
    private float x;
    private float y;
    private float w;
    private float h;
    private float start;
    private float stop;
    private int fillMode = PIE;
    private int strokeMode = OPEN;
    private ShapeAttributes att;

    /** 
     * @param  x - The x-coordinate of the upper-left corner of the arc's framing rectangle.
     * @param  y - The Y coordinate of the upper-left corner of the arc's framing rectangle.
     * @param  w - The width of the full ellipse of which this arc is a partial section.
     * @param  h - The overall height of the full ellipse of which this arc is a partial section.
     * @param  start - The starting angle of the arc in degrees.
     * @param  stop - The angular extent of the arc in degrees.
     * @param  mode - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE.
     */
    public ProcessingArc(float x, float y, float w, float h, 
    		float start, float stop, int mode, ShapeAttributes current){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.start = start;
        this.stop = stop;
        this.att = current.copy();
        if (mode != -1){
        	this.fillMode = mode;
        	this.strokeMode = mode;
        }
    }

    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
        return "Ellipse[x=" + x + ",y=" + y + ",w=" + w + ",h=" + h +
            " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
    	if (att.getFill() == true){
            g2.setColor(att.getFillColor());
            g2.fill(new Arc2D.Float(x, y, w, h, start, stop, fillMode));
        }
        if (att.getStroke() == true){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Arc2D.Float(x, y, w, h, start, stop, strokeMode));
        }
    }
}
