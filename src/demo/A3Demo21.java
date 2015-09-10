package demo;
import japa.Consts;
import japa.Processing;

import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library A3Demo16.java
 * Purpose: A demo file for animation testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A3Demo21 {

	public static void student21() {
		Processing.size(950, 700);
		Processing.noStroke();
		Processing.smooth();
		Processing.frameRate(15);
		Processing.animate("demo.A3Demo21");
	}

	static double windCount = 0;
	static int incX = 15;
	static int dir = 1;

	// background color of the screen
	public static void draw() {
		Processing.background(32, 41, 88);
		theTent();
		theBackdrop();
		theCloud(150 - windCount, 100);
		double leftCloud = 325;
		theCloud(leftCloud - windCount, 180);
		double rightCloud = 450;
		theCloud(rightCloud + windCount, 50);
		double bottomRight = 755;
		theCloud(bottomRight + windCount, 175);
		windCount = windCount + incX * dir;
		// Reinitializes the clouds
		if ((rightCloud + windCount - 105 > Processing.width)
				|| (bottomRight + windCount + 105 < 0)) {
			dir = dir * -1;
		}
		// Changes the color of the balloons
		if (Processing.mousePressed) {
			Processing.fill(0);
			theBalloons(25, 375, 20, 30);
			theBalloons(55, 480, 20, 30);
			theBalloons(165, 450, 20, 30);
			theBalloons(235, 505, 20, 30);
			theBalloons(280, 400, 20, 30);
			theBalloons(725, 375, 20, 30);
			theBalloons(740, 515, 20, 30);
			theBalloons(780, 420, 20, 30);
			theBalloons(890, 525, 20, 30);
			theBalloons(930, 420, 20, 30);
		}
		// Processing.save("student21_results3.png");
	}

	// Pauses and restarts the moving of the clouds
	public static void keyPressed() {
		if ((Processing.key == 'P') || (Processing.key == 'p'))
			incX = 0;
		else if ((Processing.key == 'S') || (Processing.key == 's')) {
			incX = 15;
		} else {
			incX = 20;
		}
	}

	// Compile the components of the background
	public static void theBackdrop() {
		theGround();
		theSky();
	}

	// Create the Grass
	public static void theGround() {
		double lawn = .825 * Processing.height;
		Processing.fill(8, 44, 8);
		Processing.rect(0, lawn, Processing.width, Processing.height);
	}

	// Compile components of the Sky: Balloons and Stars
	public static void theSky() {
		Processing.fill(188, 248, 255);
		theBalloons(25, 375, 20, 30);
		theBalloons(55, 480, 20, 30);
		theBalloons(165, 450, 20, 30);
		theBalloons(235, 505, 20, 30);
		theBalloons(280, 400, 20, 30);
		theBalloons(725, 375, 20, 30);
		theBalloons(740, 515, 20, 30);
		theBalloons(780, 420, 20, 30);
		theBalloons(890, 525, 20, 30);
		theBalloons(930, 420, 20, 30);
		Processing.noStroke();
		// Loop to randomly draw Stars
		for (double i = 0; i < Processing.width; i = i + Processing.random(50)) {
			theStars(i, Processing.random(250), Processing.random(20));
		}
	}

	// Create the Star
	public static void theStars(double centerX, double centerY, double starSize) {
		Processing.fill(196, 197, 198);
		Processing.beginShape();
		Processing.vertex(centerX, centerY - starSize / 2.0);
		Processing.vertex(centerX + starSize / 6.0, centerY - starSize / 6.0);
		Processing.vertex(centerX + starSize / 2.0, centerY - starSize / 6.0);
		Processing.vertex(centerX + starSize / 4.0, centerY + starSize / 12.0);
		Processing.vertex(centerX + starSize / 3.0, centerY + starSize / 2.0);
		Processing.vertex(centerX, centerY + starSize / 4.0);
		Processing.vertex(centerX - starSize / 3.0, centerY + starSize / 2.0);
		Processing.vertex(centerX - starSize / 4.0, centerY + starSize / 12.0);
		Processing.vertex(centerX - starSize / 2.0, centerY - starSize / 6.0);
		Processing.vertex(centerX - starSize / 6.0, centerY - starSize / 6.0);
		Processing.endShape(Consts.CLOSE);
	}

	// Create the Cloud
	public static void theCloud(double cloudX, int cloudY) {
		Processing.fill(102, 103, 108);
		Processing.ellipse(cloudX, cloudY, 140, 100);
		Processing.ellipse(cloudX + 60, cloudY, 90, 60);
		Processing.ellipse(cloudX - 60, cloudY, 90, 60);
	}

	// Compilation of all components of the Circus Tent
	public static void theTent() {
		theFlag(.5 * Processing.width, .40 * Processing.height,
				.55 * Processing.width, .45 * Processing.height,
				.5 * Processing.width, .45 * Processing.height,
				.5 * Processing.height);
		theRoof(.5 * Processing.width, .5 * Processing.height,
				.75 * Processing.width, .75 * Processing.height,
				.25 * Processing.width, .75 * Processing.height);
		theBody(.3 * Processing.width, .75 * Processing.height, 18,
				.2 * Processing.height);
	}

	// Create the Flag on top of the Tent
	public static void theFlag(double TopX, double TopY, double RightX,
			double RightY, double BottomX, double BottomY, double BottomYY) {
		Processing.fill(222, 237, 60);
		Processing.triangle(TopX, TopY, RightX, RightY, BottomX, BottomY);
		Processing.stroke(3);
		Processing.stroke(219, 213, 93);
		Processing.line(TopX, TopY, BottomX, BottomYY);
	}

	// Create the Roof of the Tent
	public static void theRoof(double ToppX, double ToppY, double RighttX,
			double RighttY, double LefttX, double LefttY) {
		Processing.fill(142, 23, 10);
		Processing.noStroke();
		Processing.triangle(ToppX, ToppY, RighttX, RighttY, LefttX, LefttY);
		Processing.fill(255);
		Processing.triangle(ToppX, ToppY, .3 * Processing.width, RighttY,
				.7 * Processing.width, LefttY);
		Processing.fill(142, 23, 10);
		Processing.triangle(ToppX, ToppY, .35 * Processing.width, RighttY,
				.65 * Processing.width, LefttY);
		Processing.fill(255);
		Processing.triangle(ToppX, ToppY, .4 * Processing.width, RighttY,
				.6 * Processing.width, LefttY);
		Processing.fill(142, 23, 10);
		Processing.triangle(ToppX, ToppY, .45 * Processing.width, RighttY,
				.55 * Processing.width, LefttY);
		Processing.fill(255);
		Processing.triangle(ToppX, ToppY, .52 * Processing.width, RighttY,
				.48 * Processing.width, LefttY);
	}

	// Create the Body and Opening of the Tent
	public static void theBody(double UpperLeftX, double UpperLeftY,
			double stripeThickness, double stripeHeight) {
		int counter = 0;
		// Loop to create red and white stripes
		while (UpperLeftX < .69 * Processing.width) {
			if (counter % 2 == 0) {
				Processing.fill(255);
			} else {
				Processing.fill(142, 23, 10);
			}
			Processing.rect(UpperLeftX, UpperLeftY, stripeThickness,
					stripeHeight);
			UpperLeftX = UpperLeftX + stripeThickness;
			counter = counter + 1;
		}
		Processing.fill(0);
		Processing.triangle(.5 * Processing.width, .75 * Processing.height,
				.45 * Processing.width, .95 * Processing.height,
				.55 * Processing.width, .95 * Processing.height);
	}

	// Create Balloon and String
	public static void theBalloons(double balloonX, double balloonY,
			double balloonWidth, double balloonHeight) {
		Processing.stroke(3);
		Processing.stroke(188, 248, 255);
		Processing.line(balloonX, balloonY, balloonX + 2, balloonY + 45);
		Processing.ellipse(balloonX, balloonY, balloonWidth, balloonHeight);
	}

	public static void main(String[] args) throws IOException {
		student21();
	}
}