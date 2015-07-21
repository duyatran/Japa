package demo;
import japa.Processing;

import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library A3Demo16.java
 * Purpose: A demo file for animation testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A3Demo20 {
	// *Butterflies with Finn & Jake, by student20*//
	static int recX = 130;
	static int recY = 200;
	static int hatWidth = 100;
	static int hatLength = 60;

	static int headWidth = 80;
	static int headLength = 50;

	static int armX = 40;
	static int armY = 280;
	static int armWidth = 90;
	static int armLength = 10;

	static int circleX = 10;
	static int circleY = 10;
	static int circleWidth = 5;
	static int circleLength = 5;

	static int moveX = 0;
	static int STARTMOVING = 4;

	static int incX = STARTMOVING;

	static boolean discoCircles = true;

	public static void student20() {
		Processing.size(600, 500);
		Processing.smooth();
		Processing.strokeWeight(2);
		Processing.frameRate(30);
		Processing.animate("A3Demo20");
	}

	// background color of the screen
	public static void draw() {
		Processing.background(250, 237, 141);
		int offsetX = 0;
		while (offsetX < Processing.width) {
			drawCircles(10 + offsetX, 10, circleWidth * 2, circleLength * 2);
			drawCircles(35 + offsetX, 15, circleWidth * 5, circleLength * 5);
			drawCircles(70 + offsetX, 20, circleWidth, circleLength);
			offsetX = offsetX + 85;
			if (discoCircles) {
				Processing.fill(Processing.random(128, 255),
						Processing.random(128, 255),
						Processing.random(128, 255));
			} else {
				Processing.fill(247, 115, 161);
			}

		}

		drawButterfly(400 + moveX, 80, 80);
		drawButterfly(200 + moveX, 100, 50);
		drawButterfly(500 + moveX, 150, 120);

		moveX = moveX + incX;
		if (moveX > Processing.width + 50) {
			moveX = -200;
		}
	}

	// this are the shaped grass I used
	public static void drawCircles(int circleX, int circleY, int circleWidth,
			int circleLength) {
		if (discoCircles)
			Processing.fill(Processing.random(128, 255),
					Processing.random(128, 255), Processing.random(128, 255));
		else
			Processing.fill(247, 115, 161);

		Processing.ellipse(circleX, circleY, circleWidth, circleLength);
		drawFinn();
	}

	public static void drawFinn() {
		// Finn's Hat
		Processing.fill(255);
		Processing.ellipse(recX + 10, recY - 2, hatWidth - 80, hatLength - 30);
		Processing.ellipse(recX + 90, recY - 2, hatWidth - 80, hatLength - 30);
		Processing.rect(recX, recY, hatWidth, hatLength);

		// Finn's Head
		Processing.fill(255, 231, 196);
		Processing.ellipse(recX + 50, recY + 30, headWidth, headLength);

		// Finn's Face
		Processing.fill(0);
		Processing.ellipse(recX + 30, recY + 25, 4, 6);
		Processing.ellipse(recX + 70, recY + 25, 4, 6);

		// mouth
		Processing.line(172, 240, 190, 240);
		Processing.line(172, 240, 172, 237);
		Processing.line(190, 240, 190, 237);

		// Finn's Shirt
		Processing.fill(60, 167, 219);
		Processing.rect(130, 260, hatWidth, hatLength + 30);

		// Finn's Arms
		Processing.fill(255, 231, 196);
		Processing.rect(armX, armY, armWidth, armLength);
		Processing.rect(armX + 190, armY, armWidth, armLength);

		// Finn's Shorts
		Processing.fill(56, 90, 222);

		// Left Leg
		Processing.rect(130, 350, 20, 50);

		// Right Leg
		Processing.rect(210, 350, 20, 50);

		// Middle
		Processing.rect(130, 350, 100, 20);

		// Finn's Legs
		Processing.fill(255, 231, 196);
		Processing.rect(132, 400, 15, 80);
		Processing.rect(212, 400, 15, 80);

		// Finn's Shoes
		Processing.fill(0);
		Processing.rect(132, 475, 15, 40);
		Processing.rect(213, 475, 15, 40);

		Processing.ellipse(130, 500, 30, 10);
		Processing.ellipse(230, 500, 30, 10);

		// Finn's Socks
		Processing.fill(255);
		Processing.ellipse(140, 480, 30, 10);
		Processing.ellipse(220, 480, 30, 10);

		drawJake();
	}

	public static void drawJake() {
		// Jake's Arms
		Processing.fill(245, 200, 74);
		Processing.rect(armX + 250, armY + 80, armWidth - 5, armLength);
		Processing.rect(armX + 420, armY + 80, armWidth - 5, armLength);

		// Jake's Legs
		Processing.fill(245, 200, 74);
		Processing.rect(380, 400, 15, 95);
		Processing.rect(445, 400, 15, 95);

		Processing.ellipse(383, 492, 27, 15);
		Processing.ellipse(458, 492, 27, 15);

		// Jake's Body
		Processing.fill(245, 200, 74);
		Processing.ellipse(420, 350, armWidth + 10, armWidth + 43);

		// Jake's Ears
		Processing.triangle(383, 300, 365, 340, 365, 300);
		Processing.triangle(457, 300, 476, 340, 476, 300);

		// Jake's Eyes
		Processing.fill(0);
		Processing.ellipse(400, 330, armWidth - 65, armWidth - 65);
		Processing.fill(255);
		Processing.ellipse(400, 328, armWidth - 67, armWidth - 67);

		Processing.fill(0);
		Processing.ellipse(440, 330, armWidth - 65, armWidth - 65);
		Processing.fill(255);
		Processing.ellipse(440, 328, armWidth - 67, armWidth - 67);

		// Jake's Jowels
		Processing.fill(245, 200, 74);
		Processing.ellipse(405, 350, 15, 27);
		Processing.ellipse(435, 350, 15, 27);
		Processing.ellipse(420, 340, 40, 15);

		// Jake's Nose
		Processing.fill(0);
		Processing.ellipse(420, 340, 20, 10);

		// Jake's Mouth
		Processing.line(413, 353, 426, 353);

		Processing.fill(245, 200, 74);

		// Jake's Tail
		Processing.triangle(460, 390, 485, 400, 455, 400);
	}

	public static void drawButterfly(double localX, double localY,
			double objSize) {
		double bigWingSize = objSize / 4.0;

		Processing.fill(0);
		Processing.ellipse(localX + 0.06 * objSize, localY, bigWingSize,
				bigWingSize * 1.1);

		Processing.fill(250, 141, 219);
		Processing.ellipse(localX, localY, bigWingSize, 1.2 * bigWingSize);
		Processing.ellipse(localX - 0.1 * objSize, localY, bigWingSize,
				1.2 * bigWingSize);

		Processing.fill(0);
		Processing.ellipse(localX, localY + bigWingSize / 2, objSize / 2,
				bigWingSize / 3);

		Processing.line(localX + bigWingSize, localY + bigWingSize / 2, localX
				+ objSize / 3, localY + bigWingSize / 4);
		Processing.line(localX + bigWingSize, localY + bigWingSize / 2, localX
				+ objSize / 3, localY + bigWingSize / 2);
		// line(localX+localX*.03,localY+localY*.05,localX+localX*.09,localY+localY*.03);
	}

	public static void keyPressed() {
		if ((Processing.key == 'P') || (Processing.key == 'p'))
			incX = 0;
		else if ((Processing.key == 'S') || (Processing.key == 's')) {
			incX = STARTMOVING;
		}
	}

	public static void mousePressed() {
		discoCircles = !discoCircles;

	}

	public static void main(String[] args) throws IOException {
		student20();
	}
}