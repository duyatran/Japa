import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingLine.java
 * Purpose: Creates a class representing a line.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingLine implements Shape
{
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private ShapeAttributes att;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public ProcessingLine(float x1, float y1, 
                          float x2, float y2, ShapeAttributes current){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.att = current.copy();
    }
    
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
        return "Line[x1=" + x1 + ",y1=" + y1 + ",x2=" + x2 + ",y2=" + y2 +
            " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
        if (att.getStroke() == true){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Line2D.Float(x1, y1, x2, y2));
        }
    }
}
