import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingRect.java
 * Purpose: Creates a class representing a rectangle.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingRect extends Shape
{
    private double v1;
    private double v2;
    private double v3;
    private double v4;
    private int rectMode = Consts.CORNER;
    private ShapeAttributes att;

    /**
     * @param v1: by default, x-coordinate of the rectangle
     * @param v2: by default, y-coordinate of the rectangle
     * @param v3: by default, width of the rectangle
     * @param v4: by default, height of the rectangle
     * @param current: the current ShapeAttributes object
     */
    public ProcessingRect(double v1, double v2, 
            double v3, double v4, ShapeAttributes current){
        this.att = current.copy();
        double[] newCoord = setCoordinates(rectMode, v1, v2, v3, v4);
        this.v1 = newCoord[0];
        this.v2 = newCoord[1];
        this.v3 = newCoord[2];
        this.v4 = newCoord[3];
    }
    
    /* @return the arc's attributes object.
     * @see Shape#getAttributes()
     */
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    @Override
    public String toString(){
        return "Rect[v1=" + v1 + ",v2=" + v2 + ",v3=" + v3 + ",v4=" + v4 +
                " attributes: " + att.toString();
        }
    
    /* Do the actual drawing of the rectangle.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(new Rectangle2D.Double(v1, v2, v3, v4));
        }
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(new Rectangle2D.Double(v1, v2, v3, v4));
        }
    }
}
