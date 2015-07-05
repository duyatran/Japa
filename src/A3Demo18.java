import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * A3Demo16.java
 * Purpose: A demo file for animation testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A3Demo18 {
	// Dyanmic Fish Tank
	// student18
	// Assignment 3
	public static void student18() {
		Processing.size(500, 600);
		Processing.smooth();
		Processing.background(16, 4, 75);

		double dotsX=0;
		double dotsY=0;
		double dotsSize=0;
		for (int i=0; i<100; i++) {
			dotsX=Processing.random(Processing.width);
			dotsY=Processing.random(Processing.height);
			dotsSize=Processing.random(3, 30);
			Processing.fill(255, 255, 255, 90);
			Processing.ellipse(dotsX, dotsY, dotsSize, dotsSize);
		}
		Processing.animate("A3Demo18");
	}

	static int fgH=359;
	static int fgChange=-3;

	//background color of the screen
	public static void draw() {
		//loop();
		Processing.colorMode(Consts.HSB);

		  drawSide(fgH, 64, 97, 470, 0);
		  drawSide(fgH, 64, 97, 0, 0);
		  if (fgH+fgChange>=0) {
		    fgH=fgH+fgChange;
		  }
		  else
		    fgH=359;

		  drawScallopedBorder();

//		  if (mousePressed) {
//		    float fishSize=random(10, 70);
//		    drawFish(mouseX, mouseY, fishSize);
//		  }
//
//		  if (key == 'P' || key == 'p') {
//		    fgChange=0;
//		  }
//		  else
//		    fgChange=-3;
	}
	public static void drawSide(int fgH, int fgS, int fgB, int cornerX, int cornerY) {
		  Processing.fill(fgH, fgS, fgB);
		  Processing.noStroke();
		  Processing.rect(cornerX, cornerY, 30, Processing.height);

		  Processing.save("student18_result3.png");
		  }

	public static void drawFish(double centerX, double centerY, double fishSize) {
		    Processing.colorMode(Consts.RGB);
		    Processing.fill(255, 64, 154);
		    Processing.ellipse(centerX, centerY, fishSize, fishSize/2.5);
		    Processing.strokeWeight(fishSize/12);
		    Processing.stroke(0);
		    Processing.point(centerX-fishSize/4, centerY-fishSize/12);
		    Processing.noStroke();
		    Processing.triangle(centerX+fishSize/2, centerY, centerX+fishSize, centerY-fishSize/6, centerX+fishSize, centerY+fishSize/6);
		  }

	public static void drawScallopedBorder() {
		  Processing.smooth();
		  for (int i=0; i<20; i++) {
		    Processing.ellipse(0+i*30, 0, 30, 30);
		    Processing.ellipse(0+i*30, Processing.height, 30, 30);
		  }
	}

	public static void main(String[] args) throws IOException{
		student18();
	}
}