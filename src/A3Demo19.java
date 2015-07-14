import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library A3Demo16.java
 * Purpose: A demo file for animation testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A3Demo19 {
	static double colorStart = 1;
	static double moonColorStart = 1;
	static double colorS = 1;
	static double focusAlpha = 550;
	static double focusX = 550;
	static double focusY = 120;
	static double counter = 1;
	static double STARTINC = 5;
	static double moveInc = STARTINC;
	static int roofHeight = 10;
	static int roofBaseY = 216;
	static int startX = 450;
	static int houseX = startX;
	static int houseSize = 20;
	static int houseDistance = houseSize + startX / 5;
	static int houseJump = 50;
	static boolean on = false;

	public static void student19() {
		Processing.colorMode(Consts.HSB, 360, 100, 100);
		Processing.size(800, 500);
		Processing.frameRate(40);
		for (int i = 0; i < 800; i = i + 18) {
			Processing.strokeWeight(20);
			Processing.stroke(220, 90, 59 - i * .15);
			Processing.line(i, 0, i, 500);
		}
		Processing.animate("A3Demo19");
	}

	// background color of the screen
	public static void draw() {
		drawCloud();
		drawStar(320, 210, 90);
		drawStar(200, 50, 60);
		drawStar(20, 200, 50);
		drawStar(90, 260, 60);
		drawStar(280, 130, 30);
		drawStar(600, 80, 50);
		drawHill();
		drawMountain();
		drawMoon(740, 100, 100, 100);
		moonColorStart = (moonColorStart + .4) % 100;
		drawHouses();
		// noLoop();
		Processing.saveFrame();
	}

	public static void drawHill() { // This image is stationary and does not
									// change
		Processing.noStroke();
		Processing.fill(134, 46, 75, 100);
		Processing.triangle(-50, 500, 800, 500, 800, 300);
		// Processing.size(800, 500); Calling size inside animation is a BAD
		// idea

	}

	public static void drawStar(float localX, float localY, float chosenSize) {
		// The "for" loop in this function serves to draw the saturation line
		// repeatedly outward.
		colorStart = (colorStart + 2) % 100; // perfect, don't touch
		// println("next " + colorStart);
		for (double circleWidth = 1; circleWidth < chosenSize; circleWidth = circleWidth + 2) {
			double colorRing = (colorStart + circleWidth * 2) % 100;
			Processing.strokeWeight(2);
			Processing.stroke(61, colorRing, 100);
			Processing.ellipse(localX, localY, chosenSize - circleWidth,
					chosenSize - circleWidth);
		}
	}

	public static void drawMountain() { // stationary image.
		Processing.noStroke();
		Processing.fill(0);
		Processing.beginShape();
		Processing.curveVertex(90, 500);
		Processing.curveVertex(90, 500);
		Processing.curveVertex(105, 380);
		Processing.curveVertex(100, 340);
		Processing.curveVertex(120, 250);
		Processing.curveVertex(100, 200);
		Processing.curveVertex(105, 150);
		Processing.curveVertex(105, 120);
		Processing.curveVertex(115, 260);
		Processing.curveVertex(140, 100);
		Processing.curveVertex(150, 110);
		Processing.curveVertex(150, 0);
		Processing.curveVertex(175, 205);
		Processing.curveVertex(190, 200);
		Processing.curveVertex(205, 320);
		Processing.curveVertex(210, 295);
		Processing.curveVertex(210, 340);
		Processing.curveVertex(205, 375);
		Processing.curveVertex(220, 420);
		Processing.curveVertex(240, 300);
		Processing.curveVertex(260, 340);
		Processing.curveVertex(260, 380);
		Processing.curveVertex(290, 400);
		Processing.curveVertex(305, 450);
		Processing.curveVertex(300, 500);
		Processing.curveVertex(300, 500);
		Processing.endShape(Consts.CLOSE);
	}

	public static void drawCloud() {
		// the for loop limits it to before the moon so that it doesn't go
		// behind the moon.
		// I use focusAlpha as a focus point to bounce back and forth
		// Also! There is a key press function "p" stops the cloud moving and
		// "i" starts the cloud moving.
		Processing.background(0, 0, 100); // make a gradient
		for (int i = 0; i < 800; i = i + 18) {
			Processing.strokeWeight(20);
			Processing.stroke(220, 90, 59 - i * .15);
			Processing.line(i, 0, i, 500);
		}
		Processing.noStroke();
		Processing.fill(181, 45, 50);
		Processing.beginShape();
		Processing.curveVertex(focusAlpha, focusY);
		Processing.curveVertex(focusX, focusY);
		Processing.curveVertex(focusX + 60, focusY + 30);
		Processing.curveVertex(focusX, focusY + 60);
		Processing.curveVertex(focusX + 30, focusY + 90);
		Processing.curveVertex(focusX + 90, focusY + 30);
		Processing.curveVertex(focusX + 60, focusY - 20);
		Processing.curveVertex(focusX - 30, focusY - 30);
		Processing.curveVertex(focusX - 150, focusY + 20);
		Processing.curveVertex(focusX - 210, focusY + 30);
		Processing.curveVertex(focusX - 360, focusY + 20);
		Processing.curveVertex(focusX - 390, focusY);
		Processing.curveVertex(focusX - 510, focusY - 20);
		Processing.curveVertex(focusX - 600, focusY);
		Processing.curveVertex(focusX - 660, focusY + 30);
		Processing.curveVertex(focusX - 660, focusY - 70);
		Processing.curveVertex(focusX - 510, focusY - 90);
		Processing.curveVertex(focusX - 360, focusY - 100);
		Processing.curveVertex(focusX - 270, focusY - 50);
		Processing.curveVertex(focusX - 210, focusY - 10);
		Processing.curveVertex(focusX - 180, focusY);
		Processing.curveVertex(focusX - 120, focusY - 15);
		Processing.curveVertex(focusX, focusY - 40);
		Processing.curveVertex(focusX + 90, focusY - 30);
		Processing.curveVertex(focusX + 135, focusY);
		Processing.curveVertex(focusX + 135, focusY + 60);
		Processing.curveVertex(focusX + 90, focusY + 120);
		Processing.curveVertex(focusX + 30, focusY + 125);
		Processing.curveVertex(focusX - 30, focusY + 120);
		Processing.curveVertex(focusX - 90, focusY + 90);
		Processing.curveVertex(focusX - 90, focusY + 30);
		Processing.curveVertex(focusX - 60, focusY + 10);
		Processing.curveVertex(focusX - 60, focusY + 10);
		Processing.endShape(Consts.CLOSE);

		if ((focusAlpha > Processing.width - 250)
				|| (focusAlpha < Processing.width - 660)) {
			counter = counter * -1;
			// println("1" + focusAlpha);
		}
		focusX = focusX + counter * .5;
		focusAlpha = focusAlpha + counter * .5;
		// println( "2" + focusAlpha);

	}

	public static void drawMoon(int moonX, int moonY, int sizeW, int sizeH) {
		// the gradient in this increases intil 100 and resets.
		// I have two ellipses layered to create the crescent shape
		Processing.fill(50, moonColorStart, 99);
		Processing.ellipse(moonX, moonY, sizeW, sizeH);
		Processing.fill(0);
		Processing.ellipse(moonX + 30, moonY, sizeW, sizeH);
	}

	public static void drawHouses() {
		// These are a nested loop with a mousePress function in them-- the
		// lights turn on and off
		houseX = startX;
		roofHeight = 10;
		roofBaseY = 416;
		startX = 450;
		houseDistance = houseSize + startX / 12;
		while (roofBaseY < Processing.height) {
			while (houseX + houseSize < Processing.width) {
				Processing.fill(220, 30, 30);
				Processing.triangle(houseX, roofBaseY, houseX + houseSize / 2,
						roofBaseY - roofHeight, houseX + houseSize, roofBaseY);
				Processing.fill(160, 11, 11);
				Processing.triangle(houseX, roofBaseY, houseX + houseSize / 2,
						roofBaseY - roofHeight, houseX - 2, roofBaseY - 2);

				Processing.fill(239, 40, 85);

				Processing.stroke(1);
				Processing.rect(houseX, roofBaseY, houseSize, houseSize);
				Processing.quad(houseX, roofBaseY, houseX, roofBaseY + 20,
						houseX - 4, roofBaseY + 12, houseX - 4, roofBaseY - 1);
				// println("light On " + on);
				if (on)
					Processing.fill(59, 94, 91);
				else
					Processing.fill(0);
				Processing.rect(houseX + houseSize / 4, roofBaseY + 9, 11, 10);
				houseX = houseX + houseDistance;
			}
			houseX = startX;
			roofBaseY = roofBaseY + houseJump;
		}
		Processing.fill(239, 17, 87);
		Processing.triangle(447, 416, 470, 416, 460, 365);

	}

	public static void mousePressed() { // see, the drawHouses
		on = !on;
		// println("light on" + on);
	}

	public static void keyPressed() { // see, drawCloud
		if ((Processing.key == 'P') || (Processing.key == 'p'))
			counter = 0;
		else if (Processing.key == 'i') {
			counter = counter + 5;
		} else {
			counter = STARTINC;
		}
	}

	public static void main(String[] args) throws IOException {
		student19();
	}
}