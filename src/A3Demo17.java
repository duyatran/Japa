import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library A3Demo.java Purpose:
 * A demo file for animation testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A3Demo17 {
	static double sunCount = 10;
	static int startPointSun = 10;
	static int incX = 1;

	static double FoxCount = 0;
	static int startPointFox = 10;
	static int sunSize = 100;

	static double moonCount = 0;
	static int startPointMoon = 10;
	static int moonSize = 70;

	public static void student17() {
		Processing.size(600, 600);
		Processing.background(184, 236, 255);
		Processing.smooth();
		Processing.noStroke();
		Processing.frameRate(30);
		Processing.animate("A3Demo17");
	}

	static boolean isDay = true;
	static boolean isNightOver = false;

	// background color of the screen
	public static void draw() {
		if (isDay) {
			// in the day scence we have the sun and the fox appearing to day
			// light
			Processing.background(184, 236, 255);
			Processing.fill(50, 100, 30);
			Processing.rect(0, 0.7 * Processing.height, Processing.width,
					Processing.height);
			drawSun(200 + sunCount, 150, sunSize);
			sunCount = sunCount + incX;
			drawFox(200 + FoxCount, 550, 100, 100);
			drawFox(210 + FoxCount, 480, 100, 100);
			drawFox(270 + FoxCount, 500, 100, 100);
			FoxCount = FoxCount + incX;
			// this next code will initiate the night scene
		} else {
			// in the night scene we have the moon going around but no foxes
			// foxes are sleeping but later when we mouse press the day comes
			// back and the sun and fox reappear
			Processing.background(0, 0, 0);
			Processing.fill(0, 0, 0);
			Processing.rect(0, 0.7 * Processing.height, Processing.width,
					Processing.height);
			drawMoon(-moonSize / 2 + moonCount, 150, moonSize);
			moonCount = moonCount + incX;

		}

		if (200 + sunCount - sunSize / 2 > Processing.width && isDay) {
			// this next code helps define when the sun disappears completely
			// then the next scene appears hence the radius is smaller than the
			// width
			isDay = false;
		} else if ((!isDay) && (-moonSize / 2 + moonCount > Processing.width)) {
			isNightOver = true;
		} else {
			// Same here for the moon we want to make sure the transition only
			// happens when the whole moon has disappeared
			double where = -moonSize / 2 + moonCount;
		}
	}

	// functions calling below

	public static void drawSun(double localX, double localY, int localRad) {
		// Sun drawing
		Processing.fill(255, 170, 0);
		Processing.ellipse(localX, localY, localRad, localRad);
	}

	public static void drawMoon(double localX, double localY, int localSize) {
		// Moon drawing
		Processing.fill(255, 255, 255);
		Processing.ellipse(localX, localY, localSize, localSize);
	}

	public static void drawFox(double centerX, double centerY, double objWidth,
			double objHeight) {

		Processing.noStroke();
		double headSize = objHeight / 2.0;

		double headX = centerX + 3 / 2.0 * objWidth / 5.0;
		double headY = centerY - objHeight / 4.0;
		Processing.fill(106, 59, 59);
		Processing.ellipse(headX, headY, headSize, headSize);
		Processing.fill(0);
		Processing.ellipse(headX + headSize / 6, headY - headSize / 6,
				headSize / 4, headSize / 4);
		Processing.fill(255);
		Processing.ellipse(headX + headSize / 6, headY - headSize / 6,
				headSize / 8, headSize / 8);
		Processing.fill(0);
		Processing.ellipse(headX - headSize / 6, headY - headSize / 6,
				headSize / 4, headSize / 4);
		Processing.fill(255);
		Processing.ellipse(headX - headSize / 6, headY - headSize / 6,
				headSize / 8, headSize / 8);
	}

	// Key pressed "p" to stop the animation
	public static void keyPressed() {

		if (Processing.key == 'p') {
			incX = 0;
		} else {
			incX = 1;
		}
	}

	// Once the day scene and moon scene have gone through we can go back around
	// to the day scene with a mouse press
	public static void mousePressed() {
		if (isNightOver) {
			isDay = true;
			sunCount = 10;
			FoxCount = 0;
			moonCount = 0;
			isNightOver = false;
		}
	}

	public static void main(String[] args) throws IOException {
		student17();
	}
}