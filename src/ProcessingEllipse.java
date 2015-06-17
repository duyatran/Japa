import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingEllipse.java
 * Purpose: Creates a class representing an ellipse.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingEllipse implements Shape
{
    private double x;
    private double y;
    private double w;
    private double h;
    private ShapeAttributes att;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public ProcessingEllipse(double x, double y, 
                          double w, double h, ShapeAttributes current){
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
        return "Ellipse[x=" + x + ",y=" + y + ",w=" + w + ",h=" + h +
            " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
    	if (att.getFill() == true){
            g2.setColor(att.getFillColor());
            g2.fill(new Ellipse2D.Double(x, y, w, h));
        }
        if (att.getStroke() == true){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Ellipse2D.Double(x, y, w, h));
        }
    }
}
