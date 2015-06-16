
public interface ProcessingConstants {
	static final float EPSILON = 0.0001f;

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
	static final float QUARTER_PI = 45f;
	static final float HALF_PI = 90f;
	static final float PI = 180f;
	static final float TWO_PI = 360f;

	// Arc mode
	static final int OPEN = 0;
	static final int CHORD = 1;
	static final int PIE = 2;

}
