/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Consts.java
 * Purpose: Create public class that holds all constants for convenience
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public final class Consts {
	public static final double EPSILON = 0.0001;

	// Color mode and default values
	public static int RGB = 0;
	public static int HSB = 1;
	public static float DEFAULT_RGB = 255;
	public static float DEFAULT_HUE = 360;
	public static float DEFAULT_SATURATION = 100;
	public static float DEFAULT_BRIGHTNESS = 100;
	public static float DEFAULT_ALPHA = 100;
	
	
	// Default width and height of canvas
	public static int DEFAULT_WIDTH = 800;
	public static int DEFAULT_HEIGHT = 600;
	public static int MIN_WIDTH = 200;
	public static int MIN_HEIGHT = 200;
	
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
	public static final int DEFAULT_ARC = 3;
	
	// Curve type
	public static final int BEZIER = 0;
	public static final int CATMULL_ROM = 1;
	
	// Ellipse and rectangle mode
	public static final int CENTER = 0;
	public static final int RADIUS = 1;
	public static final int CORNER = 2;
	public static final int CORNERS = 3;
	
	// Types of vertices
	public static final int VERTEX = 0;
	public static final int CURVE_VERTEX = 1;
	public static final int QUADRATIC_VERTEX = 2;
	public static final int BEZIER_VERTEX = 3;
	
	// Shape kinds for use with beginShape/endShape 
	public static final int POINTS = 0;
	public static final int LINES = 1;
	public static final int TRIANGLES = 2;
	public static final int TRIANGLE_FAN = 3;
	public static final int TRIANGLE_STRIP = 4;
	public static final int QUADS = 5;
	public static final int QUAD_STRIP = 6;
	
	// Path mode for endShape
	public static final int PATH_OPEN = 0;
	public static final int CLOSE = 1;

	//Private constructor
	private Consts(){
		throw new AssertionError();
	}
}
