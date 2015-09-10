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

public class A3Demo16 {
	public static void student16() {
		Processing.size(800, 500);
		Processing.smooth();
		Processing.frameRate(30);
		Processing.animate("demo.A3Demo16");
	}

	static int bulbSize = 50;
	static int stemSize = 10;
	static int moveX = 0;
	static int incX = 1;

	// background color of the screen
	public static void draw() {
		Processing.background(170, 253, 255);
		int bulbX = 60;
		while (bulbX < Processing.width) {

			drawFlower(bulbX, 250);
			bulbX = bulbX + 100;
		}
		drawGrass();
		drawAnt(100 - moveX, 450, 100, 40);
		drawAnt(360 - moveX, 425, 90, 60);
		drawAnt(630 - moveX, 450, 150, 50);
		drawBird(670, 150, 270, 200);
		drawSun();

		// moving the ants back and forth in and out the screen
		moveX = moveX + incX;
		// println("moveX" +moveX);

		drawAnt(100 + moveX, 450, 100, 40);
		drawAnt(360 + moveX, 425, 90, 60);
		drawAnt(630 + moveX, 450, 150, 50);

		if (moveX > 850) {
			moveX = Processing.width - 1600;
		}
		Processing.saveFrame();

	}

	// this are the shaped grass I used
	public static void drawGrass() {
		Processing.fill(30, 137, 50, 240);
		Processing.beginShape();
		Processing.vertex(0, Processing.height);
		Processing.vertex(0, 350);
		Processing.vertex(100, 370);
		Processing.vertex(100, 350);
		Processing.vertex(200, 370);
		Processing.vertex(200, 350);
		Processing.vertex(300, 370);
		Processing.vertex(300, 350);
		Processing.vertex(400, 370);
		Processing.vertex(400, 350);
		Processing.vertex(500, 370);
		Processing.vertex(500, 350);
		Processing.vertex(600, 370);
		Processing.vertex(600, 350);
		Processing.vertex(700, 370);
		Processing.vertex(700, 350);
		Processing.vertex(800, 370);
		Processing.vertex(800, 350);
		Processing.vertex(Processing.width, 430);
		Processing.vertex(Processing.width, Processing.height);
		Processing.endShape(Consts.CLOSE);
	}

	public static void drawAnt(int cX, int cY, int objWidth, int objHeight) {
		Processing.fill(0);
		int headX = cX - objWidth / 2;
		int bodyX = cX - objWidth / 4;

		double taleX = cX + objWidth / 2.5;
		Processing.ellipse(headX, cY, objWidth / 5, objWidth / 5);
		Processing.ellipse(bodyX, cY, objWidth / 2.2, objWidth / 3);
		Processing.ellipse(taleX, cY, objWidth, objWidth / 2);
		Processing.stroke(0);
		Processing.line(headX, cY, headX - objWidth / 4, cY - objWidth / 4);
		Processing.line(headX, cY, headX - objWidth / 4, cY + objWidth / 4);
		Processing.line(bodyX, cY, bodyX - objWidth / 4, cY - objWidth / 4);
		Processing.line(bodyX, cY, bodyX - objWidth / 4, cY + objWidth / 4);
		Processing.line(taleX, cY, taleX - objWidth / 2, cY - objWidth / 2);
		Processing.line(taleX, cY, taleX - objWidth / 2, cY + objWidth / 2);
		Processing.line(taleX, cY, taleX + objWidth / 2, cY + objWidth / 2);
		Processing.line(taleX, cY, taleX + objWidth / 2, cY - objWidth / 2);

		Processing.noStroke();
	}

	public static void keyPressed() {

		if (Processing.key == 'p') {
			incX = 0;

		} else {
			incX = 1;
		}

	}

	// the bird on the right of the screen
	public static void drawBird(int cX, int cY, int objWidth, int objHeight) {

		// the head and body of the bird
		int bodyX = cX + objWidth / 4;
		int headY = cY - objHeight / 4;
		double headSize = objWidth / 2.5;
		double eyeSize = objHeight / 6;
		// allowing the beak to float
		double beakSize = 1 / 4.0 * headSize;
		Processing.fill(0, 63, 247);

		Processing.triangle(cX - headSize / 2.4, headY, cX - headSize / 2.4,
				headY - beakSize, cX - headSize / 2 - beakSize, headY
						- beakSize / 2);

		Processing.fill(113, 14, 229);
		Processing.ellipse(cX, headY, headSize, objHeight / 1.8);
		Processing.ellipse(bodyX, cY, objWidth / 1.5, objHeight / 2);
		Processing.fill(0);
		Processing.ellipse(650, 80, 30, 30);
		Processing.fill(255, 0, 0);
		Processing.ellipse(650, 80, 15, 15);

		Processing.stroke(0);
		Processing.strokeWeight(6);
		Processing.strokeWeight(1);
		Processing.noStroke();
	}

	// the sun half way out the screen
	public static void drawSun() {
		Processing.fill(255, 219, 39);
		Processing.ellipse(0, 0, 300, 300);
		Processing.fill(0);

	}

	// flowers in back of the grass
	public static void drawFlower(int localX, int localY) {

		double stemX = localX - stemSize / 2.0;
		double stemY = localY + bulbSize / 2 - 10;
		Processing.fill(59, 205, 216);
		Processing.rect(stemX, stemY, stemSize, 120);

		Processing.fill(255, 0, 166);
		Processing.ellipse(localX, localY, bulbSize, bulbSize);

	}

	public static void main(String[] args) throws IOException {
		student16();
	}

}