import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingRect.java
 * Purpose: Creates a class representing a rectangle.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingRect implements Shape
{
	private float x;
    private float y;
    private float w;
    private float h;
    private ShapeAttributes att;

    /**
     * Constructs a rectangle with a given starting and ending location.
     * @param x the x-coordinate of the starting point
     * @param y the y-coordinate of the starting point
     * @param w the width of the rectangle
     * @param h the height of the rectangle
     */
    public ProcessingRect(float x, float y, float w, 
                          float h, ShapeAttributes current){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.att = current.copy();
    }

    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
        return "Rect[x1=" + x + ",y1=" + y + ",w=" + w + ",h=" + h + "]";
    }

    public void paintShape(Graphics2D g2){
        if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(new Rectangle2D.Float(x, y, w, h));
        }
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Rectangle2D.Float(x, y, w, h));
        }
    }
}
