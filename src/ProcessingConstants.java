/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingConstants.java
 * Purpose: Create an interface (TBD) that holds all constants for convenience
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public interface ProcessingConstants {
	static final double EPSILON = 0.0001;

	// Color mode
	static int RGB = 0;
	static int HSB = 1;
	
	// Default width and height of canvas
	static int DEFAULT_WIDTH = 800;
	static int DEFAULT_HEIGHT = 600;	

	// Stroke Cap and Join modes
	static final int SQUARE   = 0;  // called 'CAP_BUTT' in Java API
	static final int PROJECT  = 2; 
	static final int ROUND    = 1;
	static final int MITER    = 0;
	static final int BEVEL    = 2; 

	// Angles for arc()
	static final double QUARTER_PI = 45;
	static final double HALF_PI = 90;
	static final double PI = 180;
	static final double TWO_PI = 360;

	// Arc mode
	static final int OPEN = 0;
	static final int CHORD = 1;
	static final int PIE = 2;

}
