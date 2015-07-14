import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library A2Demo.java Purpose:
 * A demo file for A2 testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 7/05/2015
 */

public class A2Demo {

	public static void student8() {
		Processing.size(800, 800);
		Processing.smooth();

		Processing.colorMode(Consts.RGB);
		for (int i = 0; i < Processing.width; i++) {
			double r = 20 + (i * .95);
			double g = 10 + (i * .34);
			double b = 60 + (i * 2.5);
			Processing.stroke(r, g, b);
			Processing.line(i, 0, i, Processing.height);
		}

		// change colors of repeated shape
		int centerX = 25;
		int centerY = 25;
		int dotSize = 30;

		int rowCount = 0;
		while (centerY <= Processing.height) {

			Processing.noStroke();
			if (rowCount % 2 == 0) {
				Processing
						.fill(Processing.random(80, 255),
								Processing.random(80, 240),
								Processing.random(255, 255));
			} else {
				Processing.fill(Processing.random(10, 255),
						Processing.random(15, 255), Processing.random(20, 255));
			}
			rowCount = rowCount + 1;
			while (centerX <= Processing.width) {
				Processing.ellipse(centerX, centerY, dotSize, dotSize);
				centerX = centerX + dotSize;
			}
			centerY = centerY + dotSize;
			centerX = 25;
		}

		// Change thickness of repeated shape
		Processing.noFill();
		Processing.stroke(0);
		int count = 0;
		for (int d = 400; d > 0; d = d - 20) {
			if (count % 2 == 0) {
				Processing.strokeWeight(5);
			} else {
				Processing.strokeWeight(1);
			}
			Processing.ellipse(400, 400, d, d);
			count = count + 1;
		}

		// Change height of repeated shape
		Processing.fill(255, 255, 255, 130);
		Processing.noStroke();
		int barX = 100;
		int barWidth = 30;
		int barThickness = 1000;

		while (barX < Processing.width) {
			Processing.rect(barX, barX, barWidth, barThickness);
			barX = barX + 40;
		}

		// create shadow effect with triangle shape

		Processing.fill(0, 0, 0, 20);
		int TriangleSize = 20;
		Processing.smooth();
		Processing.noStroke();
		double xVal = 0;
		double yVal = 0;
		double sizeNoise = 100;

		for (int i = 0; i < Processing.width; i = i + 1) {
			xVal = Processing.random(Processing.width);
			yVal = Processing.random(Processing.height);
			sizeNoise = Processing.random(15);

			if ((xVal > 700) && (xVal < 750)) {
				Processing.triangle(xVal, yVal, sizeNoise, sizeNoise,
						xVal + 100, yVal);
			}
		}

		// right
		Processing.stroke(0);
		Processing.strokeCap(Consts.PROJECT);
		Processing.strokeWeight(5);
		int i = 0;
		while (i < Processing.width) {
			Processing.line(750, i, Processing.width, i);
			i = i + 85;
		}

		Processing.save("student8.png");
	}

	public static void student9() {
		/*
		 * Assignment 2 Processing 2 Program Computer Science 100 Professor
		 * Fourquet Reference: "Starry Night" by Vincent Van Gogh
		 */

		Processing.size(700, 500);
		Processing.background(7, 12, 67);
		Processing.smooth();
		Processing.noStroke();

		// ground
		int level = 340;

		Processing.fill(5, 52, 32, 160);
		Processing.rect(0, level, Processing.width, level);

		// mountain
		int x1 = 0;
		int y1 = 0;
		int mWidth = 200;
		int mHeight = 250;
		int mMiddle = 100;
		int minus = 30;

		while (x1 < Processing.width) {
			Processing.fill(183, 193, 193, 50);
			Processing.triangle(x1, level, mMiddle, mHeight, mWidth, level);
			x1 = x1 + mWidth - minus;
			mMiddle = mMiddle + mWidth - minus;
			mWidth = mWidth + mWidth - minus;
		}

		// STARS

		// smallStars
		Processing.fill(255, 247, 173, 120);
		for (int i = 10; i < 60; i = i + 20) {
			Processing.ellipse(350, 50, i, i);
			Processing.ellipse(430, 30, i, i);
			Processing.ellipse(30, 180, i, i);
		}

		// mediumStars
		Processing.fill(247, 206, 55, 80);
		for (int i = 10; i < 100; i = i + 25) {
			Processing.ellipse(190, 40, i, i);
			Processing.ellipse(525, 230, i, i);
			Processing.ellipse(260, 190, i, i);
		}

		// largeStar
		Processing.fill(252, 252, 71, 100);
		for (int i = 10; i < 200; i = i + 45) {
			Processing.ellipse(630, 50, i, i);
		}

		// snow
		int snowSize = 5;
		double xVal = 0;
		double yVal = 0;
		double sizeVar = 0;

		for (int i = 0; i < 700; i = i + 3) {
			xVal = Processing.random(Processing.width);
			yVal = Processing.random(level);
			sizeVar = Processing.random(3);
			Processing.fill(240, 223, 201, 100);
			Processing.ellipse(xVal, yVal, snowSize + sizeVar, snowSize
					+ sizeVar);
		}

		// ground
		int barWidth = 8;
		int barHeight = 40;
		int gap = 3;
		int bar = 0;
		int locY = 300;
		Processing.noStroke();

		// horizontal row of trees across the picture
		while (bar < Processing.width) {
			if (bar % 2 == 0) {
				Processing.fill(11, 39, 1);
			} else {
				Processing.fill(13, 28, 24);
			}
			Processing.rect(bar, locY, barWidth, barHeight);
			bar = bar + gap + barWidth;
		}

		// ground horizontal line
		// right side
		bar = 300;
		locY = locY + barHeight;
		Processing.fill(3, 13, 28);

		int bar2Height = 3;
		int barInterval = 20;

		while (locY < Processing.width) {
			Processing.rect(bar, locY, Processing.width, bar2Height);
			bar = bar + barInterval;
			locY = locY + bar2Height + gap;
		}

		// leftside
		int bar3Interval = 250;
		bar = 0;
		locY = 340;
		while (bar < Processing.width) {
			Processing.rect(bar, locY, bar3Interval, bar2Height);
			bar = bar + barInterval;
			locY = locY + bar2Height + gap;
		}

		// TREE
		Processing.stroke(1);
		Processing.strokeWeight(1);

		int space = 410;
		int count = 0;
		int fromLeft = 56;
		int treeWidth = 30;
		int treeHeight = 30;
		gap = 2;

		// tree1
		Processing.fill(14, 67, 53);
		while (count <= 3) {
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree2
		count = 0;
		space = 410 - treeHeight - gap;
		fromLeft = fromLeft + treeWidth;

		while (count < 4) {
			Processing.fill(14, 67, 22);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree3
		count = 0;
		fromLeft = fromLeft + treeWidth + gap;
		space = 90;
		treeWidth = 20;

		while (count < 13) {
			Processing.fill(39, 67, 14);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree4
		count = 0;
		fromLeft = fromLeft + treeWidth;
		space = 154;

		while (count < 11) {
			Processing.fill(66, 67, 14);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree5
		count = 0;
		fromLeft = fromLeft + treeWidth;
		space = 218;

		while (count < 9) {
			Processing.fill(46, 67, 14);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree6
		treeWidth = 30;
		count = 0;
		fromLeft = fromLeft + treeWidth + gap;
		space = 314;

		while (count < 6) {
			Processing.fill(14, 67, 57);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}

		// tree7
		count = 0;
		fromLeft = fromLeft + treeWidth;
		space = 410;

		while (count < 3) {
			Processing.fill(14, 62, 67);
			Processing.rect(fromLeft, space, treeWidth, treeHeight);
			space = space + treeHeight + gap;
			count = count + 1;
		}
		Processing.save("student9.png");
	}

	public static void student10() {
		// Colored Pencils in Dreamform by student10
		Processing.size(500, 500);
		Processing.background(255);

		Processing.noStroke();
		Processing.smooth();

		// colorbars as background
		for (int z = 0; z < Processing.width + 75; z = z + 75) {
			Processing.fill(Processing.random(100, 225),
					Processing.random(100, 225), Processing.random(100, 225));
			Processing.quad(z - 150, 200, z, 0, z + 75, 0, z, 200);
			Processing.quad(z - 150, 350, z, 200, z + 75, 200, z, 350);
			Processing.quad(z - 150, 450, z, 350, z + 75, 350, z, 450);
			Processing.quad(z - 150, 550, z, 450, z + 75, 450, z, 550);
		}

		// brown circles
		for (int i = 0; i < Processing.width + 75; i = i + 75) {
			if (i % 2 == 0) {
				Processing.fill(162, 84, 44);
			} else {
				Processing.fill(126, 58, 24);
			}
			Processing.ellipse(i, 200, 75, 75);
			Processing.ellipse(i, 350, 75, 75);
			Processing.ellipse(i, 450, 75, 75);
		}

		// triangle top to brown circles
		int i = 0;
		int a = 208;
		while (i < Processing.width + 75) {
			Processing.fill(Processing.random(100, 225),
					Processing.random(100, 225), Processing.random(100, 225));
			Processing.triangle(i, a - 18, i - 10, a, i + 10, a);
			i = i + 75;
		}
		i = 0;
		a = 358;
		while (i < Processing.width + 75) {
			Processing.fill(Processing.random(100, 225),
					Processing.random(100, 225), Processing.random(100, 225));
			Processing.triangle(i, a - 18, i - 10, a, i + 10, a);
			i = i + 75;
		}
		i = 0;
		a = 458;
		while (i < Processing.width + 75) {
			Processing.fill(Processing.random(100, 225),
					Processing.random(100, 225), Processing.random(100, 225));
			Processing.triangle(i, a - 18, i - 10, a, i + 10, a);
			i = i + 75;
		}
		// new line to save
		Processing.save("student10");
	}

	public static void student11() {
		/*
		 * Assignment 2 Computer Science 101 By student11 "City Skyline"
		 */

		// PImage img;
		Processing.size(960, 642); // size of "sundayriver" image

		// image of ski mountain "sundayriver"
		// img = loadImage("sundayriver.jpg");
		// Processing.image(img, 0, 0, 960, 642);
		//
		// //image of Rockport Harbor, Maine
		// Processing.tint(199, 213, 0, 110);
		// img = loadImage("harborsunset.jpg");
		// Processing.image(img, 0, 0, 960, 642);
		Processing.loadImage("sundayriver.jpg");
		Processing.tint(199, 213, 0, 110);
		Processing.loadImage("harborsunset.jpg");

		// black line building #1
		Processing.fill(0);

		int startY = 20;
		int start2Y = 150;
		for (int x = 20; x <= 700; x = x + 5) {
			Processing.strokeWeight(2);
			Processing.strokeCap(Consts.SQUARE);
			Processing.line(20, x, 150, x);
		}

		// black line building #2
		Processing.noFill();
		for (int y = 200; y <= 700; y = y + 5) {
			Processing.fill(60, 53, 165);
			Processing.strokeWeight(2);
			Processing.strokeCap(Consts.SQUARE);
			Processing.line(200, y, 300, y);
		}

		Processing.noStroke();
		// darkest purple transparent building on right
		Processing.fill(106, 34, 102, 95);
		int DKpurpX1 = 790;
		int DKpurpY1 = 150;
		int DKpurpX2 = 105;
		int DKpurpY2 = 400;
		Processing.rect(DKpurpX1, DKpurpY1, DKpurpX2, DKpurpY2);

		// black and purple striped building (on right)

		int gap = 3;
		int down = 170;
		int barWidth = 150;
		int bar2Y = down;
		int bar2Width = 125;
		int barThickness = 8;
		int bar2X = Processing.width - barWidth - bar2Width;
		int bar2Thickness = 4 + 2 * barThickness;

		int oddEven = 0;

		while (bar2Y < Processing.height) {
			// even iteration
			if (oddEven % 2 == 0) {
				// System.out.println("even ");
				Processing.fill(0, 120);
			} else {
				// System.out.println("odd ");
				Processing.fill(129, 96, 131, 160);
			}
			Processing.rect(bar2X, bar2Y, bar2Width, bar2Thickness);
			bar2Y = bar2Y + bar2Thickness;

			// System.out.println("oddEven" + oddEven);
			oddEven = oddEven + 1;
		}

		// lighter purple transparant building on right
		Processing.noFill();
		Processing.fill(193, 31, 186, 100);
		int LTpurpX1 = 860;
		int LTpurpY1 = 240;
		int LTpurpX2 = 95;
		int LTpurpY2 = 355;
		Processing.rect(LTpurpX1, LTpurpY1, LTpurpX2, LTpurpY2);

		// Dark purple building made up of three squares on right

		Processing.noFill();
		Processing.fill(84, 25, 137, 160);

		int X = 610;
		int Y = 255;
		int squareHight = 90;
		int squareWidth = squareHight;

		for (int i = 1; i <= 4; i++) {
			Processing.rect(X, Y, squareHight, squareWidth);
			Y = Y + 100;
		}

		// snow falling using the function "random"
		// using shape ellipse
		Processing.noFill();
		Processing.fill(255, 100);

		int snowFlakeSize = 1;
		Processing.noStroke();
		double xVal = 0;
		double yVal = 0;
		double flakeDensity = 0;

		for (int i = 0; i < 960; i = i + 1) {
			xVal = Processing.random(Processing.width);
			yVal = Processing.random(Processing.height);
			flakeDensity = Processing.random(2);
			Processing.ellipse(xVal, yVal, snowFlakeSize + flakeDensity,
					snowFlakeSize + flakeDensity);
		}

		// transparent black building with some lit windows, and some dark on
		// left
		// also using shapes rectangle, and triangle
		Processing.noFill();
		Processing.fill(0, 150);
		int BLKrectX1 = 180;
		int BLKrectY1 = 370;
		int BLKrectX2 = 200;
		int BLKrectY2 = 300;
		Processing.rect(BLKrectX1, BLKrectY1, BLKrectX2, BLKrectY2);
		int BLKtriX1 = 280;
		int BLKtriY1 = 320;
		int BLKtriX2 = 380;
		int BLKtriY2 = 370;
		int BLKtriX3 = 180;
		Processing.triangle(BLKtriX1, BLKtriY1, BLKtriX2, BLKtriY2, BLKtriX3,
				BLKtriY2);

		// loop for windows in building WITH nested
		int squareDistance = 20;
		int windowSize = 20;
		double on = 0;
		// nested for and while loop to create my windows like we did in lab 4
		// :)

		for (BLKrectX1 = 190; BLKrectX1 < 380; BLKrectX1 = BLKrectX1
				+ squareDistance + 20) {
			while (BLKrectY1 < 670) {
				on = Processing.random(0, 2);
				if (on < 1) {
					// System.out.println("lightOn");
					Processing.fill(0);
				} else {
					// System.out.println("lightOff");
					Processing.fill(255, 247, 0, 100);
				}
				Processing.rect(BLKrectX1, BLKrectY1, windowSize, windowSize);
				BLKrectY1 = BLKrectY1 + squareDistance + 20;
			}
			BLKrectY1 = 370;
		}
		Processing.save("test.png");
		// for some reason, trying to save a copy png file of the image created
		// was simply not working
		// and was really messing with the way processing saved my files so I
		// could not do it
		// I am perfectly fine with you doing this and picking whatever looks
		// nice for the website, I don't have a preference!
		// enjoy :)
	}

	public static void student12() {
		// "Easter Egg" by student12

		Processing.size(600, 500);

		Processing.background(255);
		Processing.smooth();

		Processing.fill(119, 95, 203);// creates random pastel color for
										// triangles
		Processing.noStroke();

		int trig1 = 0;
		int trig2 = 50;
		int trig3 = 25;
		int trig4 = 150;
		int trigY = 200;

		// nested loop creates two rows of diamonds composed of triangles
		while (trigY <= 300) {
			while (trig3 <= Processing.width) {
				Processing.triangle(trig1, trigY, trig2, trigY, trig3, trig4);// upper
																				// triangle
				Processing.triangle(trig1, trigY, trig2, trigY, trig3,
						trig4 + 100);// lower triangle
				trig1 = trig1 + 50;
				trig2 = trig2 + 50;
				trig3 = trig3 + 50;
			}
			trig4 = 250;
			trig1 = 0;
			trig2 = 50;
			trig3 = 25;
			trigY = trigY + 100;
		}

		Processing.fill(202, 237, 170);// makes rectangle light green
		for (int yVal = 0; yVal <= 350; yVal = yVal + 350) {
			if (yVal < 350) {
				Processing.rect(0, yVal, Processing.width, 150);// creates upper
																// color block
																// rectangle
			}
			if (yVal >= 350) {
				Processing.rect(0, yVal, Processing.width, Processing.height);// creates
																				// lower
																				// color
																				// block
																				// rectangle
			}
		}

		Processing.strokeWeight(3);
		Processing.stroke(228, 170, 237);// makes Xs purple

		// loop creates top row of Xs
		int lineX1 = 25;
		int lineX2 = 75;
		while (lineX2 <= 575) {
			Processing.line(lineX1, 0, lineX2, 150);
			Processing.line(lineX2, 0, lineX1, 150);
			lineX1 = lineX1 + 50;
			lineX2 = lineX2 + 50;
		}

		// loop creates bottom row of Xs
		lineX1 = 25;
		lineX2 = 75;
		while (lineX2 <= 575) {
			Processing.line(lineX1, 350, lineX2, Processing.height);
			Processing.line(lineX2, 350, lineX1, Processing.height);
			lineX1 = lineX1 + 50;
			lineX2 = lineX2 + 50;
		}

		Processing.line(0, 150, Processing.width, 150);// upper line containng
														// diamonds
		Processing.line(0, 350, Processing.width, 350);// lower line containing
														// diamonds

		Processing.noStroke();
		Processing.fill(Processing.random(128, 255),
				Processing.random(128, 255), Processing.random(128, 255));// creates
																			// random
																			// color
																			// balls
		int ballX = 50;
		int ballSize = 22;
		double sizeNoise = 0;

		while (ballX <= 550) {
			sizeNoise = Processing.random(22);
			Processing.ellipse(ballX, 250, ballSize + sizeNoise, ballSize
					+ sizeNoise);// creates middle line of circles
			ballX = ballX + 50;
		}

		Processing.save("student12.png");
	}

	public static void student13() {
		// this is an abstract piece, originally illustrated by Lynne Taetzch.

		Processing.size(1000, 650);
		Processing.background(240, 230, 201); // creates a beige background

		Processing.noStroke();
		Processing.smooth();
		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(100, 230),
					Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 0, Processing.random(20, 30), 50);

		} // creates the first layer of lines
		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(100, 230),
					Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 50, Processing.random(20, 30), 100);

		} // creates the second layer of lines

		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(100, 230),
					Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 150, Processing.random(20, 30), 50);

		} // creates the smaller third layer of lines

		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(100, 250),
					Processing.random(100, 250), Processing.random(100, 250));
			Processing.rect(i, 200, Processing.random(20, 30), 50);

		} // creates the small fourth layer of lines

		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(100, 230),
					Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 250, Processing.random(20, 30), 100);

		} // creates the fifth layer of lines

		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.fill(Processing.random(130, 230),
					Processing.random(100, 200), Processing.random(130, 200));
			Processing.rect(i, 350, Processing.random(20, 30), 100);

		} // creates the sixth layer of lines

		for (double i = 0; i < Processing.width; i = i
				+ Processing.random(20, 30)) {
			Processing.stroke(Processing.random(100, 230),
					Processing.random(100, 200), Processing.random(100, 200));
			Processing.strokeWeight(Processing.random(10, 60));
			Processing.strokeCap(Consts.SQUARE);
			Processing.line(i, 450, i, 1000);

		} // creates the last larger layer of lines

		int i = 100;
		int j = 100;
		int jGap = 100;
		while (i < Processing.width) {
			while (j <= 450) {
				Processing.stroke(Processing.random(40, 250),
						Processing.random(40, 250), Processing.random(40, 250));
				Processing.strokeWeight(10);
				Processing.fill(Processing.random(40, 250),
						Processing.random(40, 250), Processing.random(40, 250));
				Processing.ellipse(i, j, 55, 55);
				j = j + jGap;
			}
			j = 100;
			i = i + 150;
		} // creates the four rows of circles
			// new line to save
		Processing.save("student13");
	}

	public static void student14() {
		// student14, Abstract
		Processing.size(500, 500);
		Processing.background(255);
		Processing.smooth();
		Processing.noStroke();

		// recrangles, orange and black
		int rectW = Processing.width / 30;
		int rectH = Processing.height;
		int rowCount = 0;

		// the loop goes on until the i value hits width(500)
		for (int i = 0; i < Processing.width; i = i + rectW * 2) {

			// alternating colors orange and black
			if (rowCount % 2 == 0) {
				Processing.fill(255, 149, 10);
			} else {
				Processing.fill(0);
			}
			rowCount = rowCount + 1;
			Processing.rect(i, 0, rectW, rectH);

		}

		// nested loop circles drawn above the rectangles
		int centerX = 0;
		int centerY = 0;
		int circleSize = 5;

		while (centerY <= Processing.height) {

			while (centerX <= Processing.width) {
				Processing.strokeWeight(5);
				Processing.stroke(255);
				Processing.smooth();
				Processing.ellipse(centerX, centerY, circleSize, circleSize);
				centerX = centerX + 2 * circleSize;
			}
			centerY = centerY + 2 * circleSize;
			centerX = 0;
		}

		// ellipses

		// left elipses
		Processing.ellipse(120, 120, 50, 50);
		Processing.fill(255, 149, 10);
		Processing.ellipse(120, 120, 25, 25);
		Processing.fill(255);
		Processing.ellipse(120, 120, 4, 4);

		// center elipses
		Processing.fill(255, 149, 10);
		Processing.ellipse(250, 250, 70, 70);
		Processing.fill(255);
		Processing.ellipse(250, 250, 50, 50);
		Processing.fill(0);
		Processing.ellipse(250, 250, 20, 20);

		// top right elipses
		Processing.fill(255);
		Processing.ellipse(350, 100, 90, 90);
		Processing.fill(0);
		Processing.ellipse(350, 100, 50, 50);
		Processing.fill(255, 149, 10);
		Processing.ellipse(350, 100, 20, 20);

		// bottom ellipses
		Processing.fill(255);
		Processing.ellipse(470, 470, 140, 140);
		Processing.fill(255, 149, 10);
		Processing.ellipse(470, 470, 90, 90);
		Processing.fill(0);
		Processing.ellipse(470, 470, 20, 20);

		// nested loop,the most right dots-random dots

		Processing.stroke(255);
		Processing.strokeWeight(3);

		double xVal = 0;
		double yVal = 0;

		for (int i = 0; i < 100; i = i + 1) {

			// sets the constrains for dots within the radius=45
			xVal = Processing.random(425, 515);
			yVal = Processing.random(425, 515);
			if (Math.sqrt(Math.pow((xVal - 470), 2) + Math.pow((yVal - 470), 2)) < 45) {

				Processing.point(xVal, yVal);
			}
		}

		Processing.save("student14.png");
	}

	public static void main(String[] args) throws IOException {
		Processing.randomSeed(13);
		student9();
	}

}