import java.awt.Graphics2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Shape.java
 * Purpose: Provides a Shape interface for geometric objects.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public abstract class Shape{
	
    /**
     * @param mode
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     */
    protected double[] setCoordinates(int mode, double v1, double v2, 
            double v3, double v4) {
    	switch (mode) {
    		case Consts.CORNER: 
    			break;
    		case Consts.CORNERS: // (v1,v2) is top-left, (v3,v4) is bottom-right
    			v3 = v3 - v1; // v3 is now the width
    			v4 = v4 - v2; // v4 is now the height
    			break;
    		case Consts.CENTER: // (v1,v2) is the center, v3 is w and v4 is h
    			v1 = v1 - (v3/2); // v1 is now the top left x-coor
    			v2 = v2 - (v4/2); // v2 is now the top left y-coor
    			break;
    		case Consts.RADIUS: // (v1,v2) is the center, v3 is w/2 and v4 is h/2
    			v1 = v1 - v3;
    			v2 = v2 - v4;
    			v3 *= 2;
    			v4 *= 2;
    			break;
    		default: System.out.println("Invalid shape mode");
    	}
    	return new double[] {v1, v2, v3, v4};
	}
    
	abstract ShapeAttributes getAttributes();
    abstract void paintShape(Graphics2D g2);
}