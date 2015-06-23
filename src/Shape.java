import java.awt.Graphics2D;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Shape.java
 * Purpose: Provides a Shape interface for geometric objects.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public interface Shape{
	ShapeAttributes getAttributes();
	    
    void paintShape(Graphics2D g2);
}
