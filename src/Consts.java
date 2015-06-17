/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingConstants.java
 * Purpose: Create an interface (TBD) that holds all constants for convenience
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public final class Consts {
	public static final double EPSILON = 0.0001;

	// Color mode
	public static int RGB = 0;
	public static int HSB = 1;
	
	// Default width and height of canvas
	public static int DEFAULT_WIDTH = 800;
	public static int DEFAULT_HEIGHT = 600;	

	// Stroke Cap and Join modes
	public static final int SQUARE   = 0;  // called 'CAP_BUTT' in Java API
	public static final int PROJECT  = 2; 
	public static final int ROUND    = 1;
	public static final int MITER    = 0;
	public static final int BEVEL    = 2; 

	// Angles for arc()
	public static final double QUARTER_PI = 45;
	public static final double HALF_PI = 90;
	public static final double PI = 180;
	public static final double TWO_PI = 360;

	// Arc mode
	public static final int OPEN = 0;
	public static final int CHORD = 1;
	public static final int PIE = 2;
	
	//Private constructor
	private Consts(){
		throw new AssertionError();
	}
}
