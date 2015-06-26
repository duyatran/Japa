import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingEllipse.java
 * Purpose: Creates a class to draw an ellipse.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingEllipse extends Shape
{
    private double x;
    private double y;
    private double w;
    private double h;
    private int ellipseMode = Consts.CENTER;
    private ShapeAttributes att;

    /**
     * @param x: by default, x-coordinate of the ellipse
     * @param y: by default, y-coordinate of the ellipse
     * @param w: by default, width of the ellipse
     * @param h: by default, height of the ellipse
     * @param current: the current ShapeAttributes object
     */
    public ProcessingEllipse(double v1, double v2, 
                          double v3, double v4, ShapeAttributes current){
    	this.att = current.copy();
        double[] newCoord = setCoordinates(ellipseMode, v1, v2, v3, v4);
        this.x = newCoord[0];
        this.y = newCoord[1];
        this.w = newCoord[2];
        this.h = newCoord[3];
    }

	/* @return the arc's attributes object.
     * @see Shape#getAttributes()
     */
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    @Override
    public String toString(){
        return "Ellipse[x=" + x + ",y=" + y + ",w=" + w + ",h=" + h +
            " attributes: " + att.toString();
    }

    /* Do the actual drawing of the ellipse.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
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
