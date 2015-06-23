import java.awt.Graphics2D;
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
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private ShapeAttributes att;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1: the x-coordinate of the starting point
     * @param y1: the y-coordinate of the starting point
     * @param x2: the x-coordinate of the ending point
     * @param y2: the y-coordinate of the ending point
     * @param current: the current ShapeAttributes object
     */
    public ProcessingLine(double x1, double y1, 
                          double x2, double y2, ShapeAttributes current){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
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
        return "Line[x1=" + x1 + ",y1=" + y1 + ",x2=" + x2 + ",y2=" + y2 +
            " attributes: " + att.toString();
    }

    /* Do the actual drawing of the line.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        if (att.getStroke() == true){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
}
