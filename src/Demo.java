import java.io.IOException;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Demo.java
 * Purpose: A demo file for testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class Demo {
	public static void student1() throws IOException{
		Processing.size(720, 580);

		Processing.colorMode(Consts.HSB);

		//Processing.size(720, 580);
		for (int i=0; i<580; i++) {
			Processing.stroke(200, 200, i*0.2);
			Processing.line(0, i, 720, i);
		}

		Processing.colorMode(Consts.RGB);

		Processing.smooth();
		Processing.stroke(0);
		Processing.rect(60, 20, 120, 40);
		Processing.rect(100, 60, 80, 40);
		Processing.rect(120, 100, 60, 40);

		Processing.fill(0);
		Processing.triangle(60, 60, 70, 70, 180, 60);
		Processing.triangle(100, 100, 110, 110, 180, 100);
		Processing.triangle(120, 140, 130, 150, 180, 140);

		Processing.fill(255);
		Processing.rect(180, 140, 60, 40);
		Processing.rect(180, 180, 80, 40);
		Processing.rect(180, 220, 120, 40);
		Processing.rect(180, 260, 140, 40);
		Processing.rect(180, 300, 160, 40);
		Processing.rect(180, 340, 180, 40);
		Processing.rect(160, 380, 180, 40);
		Processing.rect(140, 420, 180, 40);
		Processing.rect(120, 460, 180, 40);
		Processing.rect(100, 500, 180, 50);

		Processing.fill(0);
		Processing.triangle(340, 380, 360, 380, 340, 420);
		Processing.triangle(320, 420, 340, 420, 320, 460);
		Processing.triangle(300, 460, 320, 460, 300, 500);
		Processing.triangle(280, 500, 300, 500, 280, 550);

		Processing.noStroke();
		Processing.fill(70, 163, 232, 200);
		Processing.triangle(420, 540, 440, 540, 420, 560);
		Processing.triangle(420, 520, 480, 560, 420, 540);

		Processing.fill(34, 117, 178);
		Processing.triangle(720, 380, 640, 560, 720, 560);

		Processing.fill(247, 211, 65, 180);
		Processing.ellipse(540, 140, 180, 180);

		Processing.fill(0);
		Processing.triangle(538, 140, 542, 140, 540, 60);

		Processing.stroke(0);
		Processing.line(600, 140, 620, 140);
		Processing.line(540, 200, 540, 220);
		Processing.line(480, 140, 460, 140);

		//Processing.save("student1.gif");
	}

	public static void student2() throws IOException{
		Processing.size(1100, 850);
		Processing.background(71, 206, 54);
		Processing.smooth();

		Processing.fill(0);//straight black trees
		Processing.rect(0, 0, 135, 725);//far left tree
		Processing.rect(155, 0, 110, 625);//smaller left tree
		Processing.rect(825, 0, 110, 625);//smaller right tree
		Processing.rect(965, 0, 135, 725);//far right tree

		Processing.stroke(0);//fallen trees background
		Processing.strokeWeight(50);
		Processing.strokeCap(Consts.SQUARE);
		Processing.line(290, -50, 550, 515);//far left fallen tree
		Processing.line(530, -50, 700, 400);//left fallen tree
		Processing.line(650, -50, 400, 500);//right fallen tree
		Processing.line(725, -50, 490, 500);//far right fallen tree

		Processing.noStroke();

		Processing.fill(255, 153, 0);//burnt orange house roof
		Processing.triangle(275, 275, 500, 60, 820, 275);

		Processing.fill(155, 82, 27);//brown gingerbread house
		Processing.rect(300, 275, 480, 310);

		Processing.fill(0);//black door to house
		Processing.rect(400, 360, 160, 225);

		Processing.fill(255, 0, 0);//red foreboding window
		Processing.rect(600, 360, 130, 130);

		Processing.fill(255, 208, 137);//witch's head in window
		Processing.ellipse(665, 455, 65, 65);

		Processing.stroke(0);
		Processing.strokeWeight(10);
		Processing.strokeCap(Consts.SQUARE);
		Processing.line(630, 430, 700, 430);//brim of witch's hat

		Processing.fill(0);//witch's hat
		Processing.triangle(650, 430, 665, 390, 680, 430);

		Processing.noStroke();

		Processing.fill(251, 255, 44);//yellow candies on house
		Processing.ellipse(350, 315, 60, 60);
		Processing.ellipse(550, 315, 60, 60);
		Processing.ellipse(740, 315, 60, 60);
		Processing.ellipse(350, 470, 60, 60);
		Processing.ellipse(600, 545, 60, 60);
		Processing.ellipse(740, 545, 60, 60);

		Processing.fill(144, 226, 255);//light blue candies on house
		Processing.ellipse(350, 390, 60, 60);
		Processing.ellipse(350, 545, 60, 60);
		Processing.ellipse(455, 315, 60, 60);
		Processing.ellipse(650, 316, 60, 60);
		Processing.ellipse(670, 545, 60, 60);

		Processing.fill(44, 116, 255);//Hansel
		Processing.triangle(250, 760, 365, 570, 460, 760);

		Processing.fill(252, 176, 231);//Gretel
		Processing.triangle(400, 825, 510, 630, 600, 825);
		Processing.save("student2");

	}

	public static void student3() throws IOException{
		/*Author: student3 
    	Title: Hamlet & Yorik
    	This picture is meant to represent Act 5 Scene 1 of the play Hamlet, in which Hamlet talks to a skull who was formally the person 'Yorik'. Their similarity is seen by haveing 
    	them both be constructed with straight, long shapes. Hamlet is alive, while Yorik is not, so his shapes are thicker and horizonal, instead of thin and vertical. But both still are/were
    	human and therefore made from the same stuff*/


		Processing.size(1000,600);
		Processing.background(5,5,5);//black
		Processing.smooth();

		//Hamlet data
		Processing.noStroke();
		Processing.fill(247,224,145);//fleshtonne

		//Side profile of Hamlet's face. He is made out of long rectancles
		Processing.rect(0,125,325,25);// shape 1/9
		Processing.rect(0,175,262.5,25);// shape 2/9
		Processing.rect(0,225,262.5,25);//shape 3/9
		Processing.rect(0,275,300,25);//shape 4/9
		Processing.rect(0,325,350,25);//shape 5/9
		Processing.rect(0,375,400,25); //shape 6/9
		Processing.rect(0,425,350,25); //shape 7/19
		Processing.rect(0,475,287.5,25); //shape 8/9
		Processing.rect(0,525,325,25); //shape 9/9

		//Hamlet hair. Made out of two long ellipses
		Processing.fill(118,80,41); //brown
		Processing.ellipse(150,100,500,60); //bottom shape
		Processing.ellipse(130,60,400,50); //top shape

		//Hamlet eye
		Processing.fill(106,196,240);//light blue
		Processing.ellipse(215,215,75,50);//outer ellipse
		Processing.fill(24,154,216);//dark blue
		Processing.ellipse(215,215,37.5,25);//inner ellipse

		//skull line data
		Processing.stroke(254,255,31); //Yellow
		Processing.strokeWeight(3);

		//Yorik's lines- running left to right
		Processing.line(456.25,256.25,456.25, 268.75); //begin nose
		Processing.line(460.5,253.25,460.5, 271.75);
		Processing.line(468.25,250,468.25,275);//end nose

		//front part lines 
		Processing.line(460.5,350,460.5,368.75);
		Processing.line(468.25,325,468.25,450);
		Processing.line(487.5,187.5,487.5,468.75);
		Processing.line(500,162.25,500,468.75);
		Processing.line(512.5,137.5,512.5,462.5);
		Processing.line(537.5,112.5,537.5,450);
		Processing.line(550,106.25,550,437.5);

		Processing.line( 575,100,575,425);
		Processing.line(582.5,87.5,582.5,425);
		Processing.line(593.25,87.5,593.25,437.5);
		Processing.line(615.25,75,615.25,412.5);
		Processing.line(637.3,75,637.5,412.5);
		Processing.line(650,406.25,650,75);
		Processing.line(662.5,400,662.5,75);

		Processing.line(681.25,75,681.25,381.25);
		Processing.line(706.25,67,706.25,325);
		Processing.line(525,120,525,450);
		Processing.line(737.5,70,737.5,350);
		Processing.line(756.25,70,756.25,343.75);
		Processing.line(775,87.5,775,337.5);

		Processing.line(807.5,75,807.5,337.5);
		Processing.line(800,75,800,337.5);
		Processing.line(812.5,75,812.5,350);
		Processing.line(837.5,87.5,837.5,312.5);
		Processing.line(850,100,850,325);
		Processing.line(862.5,112.5,862.5,312.5);
		Processing.line(887.5,125,887.5,300);
		Processing.line(900,150,900,300);
		Processing.line(925,175,925,162.5);
		Processing.line(720,80,720,320);
		Processing.line(695,80,695,320);


		//facial feature data
		Processing.noStroke();
		Processing.fill(5,5,5); //black

		//facial features
		Processing.ellipse(520,220,55,55);//eye
		Processing.triangle(710,275,680,308,740,308);//lobe
		Processing.rect(450.25,369.75,70,20);//mounth
		Processing.ellipse(530,355,30,30);//mouth corner

		//Blue data
		Processing.noStroke();

		//blue neck frill outer ellipse
		Processing.fill(106,196,240);//light blue
		Processing.ellipse(572.5,447.5,85,55);
		Processing.ellipse(612.5,427.5,85,55);
		Processing.ellipse(652.5,426.5,85,55);
		Processing.ellipse(692.5,400.5,85,55);
		Processing.ellipse(732.5,385.5,85,55);
		Processing.ellipse(772.5,365.5,85,55);
		Processing.ellipse(812.5,350.5,85,55);

		//blue neck frill innter ellipse
		Processing.fill(24,154,216);//dark blue
		Processing.ellipse(572.5,447.5,40,25);
		Processing.ellipse(612.5,427.5,40,25);
		Processing.ellipse(652.5,426.5,40,25);
		Processing.ellipse(692.5,400.5,40,25);
		Processing.ellipse(732.5,385.5,40,25);
		Processing.ellipse(772.5,365.5,40,25);
		Processing.ellipse(812.5,350.5,40,25);

		//fingers data
		Processing.strokeCap(Consts.SQUARE);
		Processing.stroke(247,224,145);//fleshtone
		Processing.strokeWeight(40);

		//fingers
		Processing.line(790,112.5,890,62.5);
		Processing.line(875,175,981.25,162.5);
		Processing.line(850,287.5,962.5,275);
		Processing.line(502.5,420.5,450,500);

		Processing.save("student3");
	}

	public static void student4() throws IOException{
		Processing.size(1000,800);
		Processing.background(0,153,255);
		Processing.smooth();


		Processing.noStroke();

		Processing.rect(0,500, 1000,300);//playa
		Processing.fill(240,240,218);

		//Right Range

		//mntn1
		Processing.fill(200,170);
		Processing.triangle(760,500,
				900,370,
				1050,500);


		//mntn2
		Processing.fill(205,190);
		Processing.triangle(765,380,
				625,500,
				900,500);


		//mntn3
		Processing.fill(185,205,195,245);
		Processing.triangle(590,500,
				680,385,
				790,500);


		//mntn4
		Processing.fill(185,212,230,240);
		Processing.triangle(700,500,
				950,500,
				820,390);


		//mntn5
		Processing.fill(195,200,200,235);
		Processing.triangle(795,500,
				1040,500,
				940,385);


		//mntn6
		Processing.fill(170,202,210,235);
		Processing.triangle(900,500,
				1070,500,
				990,390);


		//mntn7
		Processing.fill(195,220,215,230);
		Processing.triangle(820,500,
				945,500,
				875,420);


		//mntn8
		Processing.fill(195,190,200,240);
		Processing.triangle(770,500,
				840,500,
				805,450);

		//Left Range

		//mntn1b
		Processing.fill(140,160,170, 170);
		Processing.triangle(200,500,
				350,370,
				500,500);


		//mntn2b
		Processing.fill(195,212,210,190);
		Processing.triangle(240,380,
				360,500,
				105,500);


		//mntn3b
		Processing.fill(185,212,195,245);
		Processing.triangle(440,500,
				320,385,
				210,500);


		//mntn4b
		Processing.fill(185,212,230, 240);
		Processing.triangle(80,500,
				300,500,
				170,390);


		//mntn5b
		Processing.fill(195,200,200, 235);
		Processing.triangle(205,500,
				-40,500,
				80,385);


		//mntn6b
		Processing.fill(180,200,210,235);
		Processing.triangle(100,500,
				-70,500,
				10,390);


		//mntn7b
		Processing.fill(195,220,215,230);
		Processing.triangle(180,500,
				55,500,
				120,420);


		//mntn8b
		Processing.fill(195,190,200,240);
		Processing.triangle(230,500,
				150,500,
				185,450);

		//Boulders

		Processing.stroke(170);
		Processing.strokeWeight(2);

		Processing.fill(215);
		Processing.ellipse(525,800,300,900);

		Processing.fill(210);
		Processing.ellipse(620,900,300,900);

		Processing.fill(190);
		Processing.ellipse(340,800,330,500);

		Processing.fill(170);
		Processing.ellipse(100,760,330,300);

		Processing.fill(195);
		Processing.ellipse(660,920,600,600);

		Processing.fill(180);
		Processing.ellipse(450,770,190,300);

		Processing.stroke(0);
		Processing.strokeWeight(3);
		Processing.line(515,350, 535, 350);
		Processing.strokeWeight(2);
		Processing.line(523,350,530,355);
		Processing.line(535,350,539,343);
		Processing.line(539,343,543,354);

		Processing.fill(0);
		Processing.ellipse(514,350,7,7);

		Processing.save("student4.png");
	}

	public static void student5() throws IOException{
		/* Assignment 1 - Date: February 14
    	Picture of my father's hometown - My father hometown has many
    	mountains and river. People often get on their wooden boats floating
    	in the river at night to watch the moon. It's a really peaceful
    	scenery. The scence is viewed from the river bank so it has
    	some trees.
    	Created by student4*/


		Processing.size(640,500);

		//The background is blue - the color of the water
		Processing.background(59,110,234);
		//Processing.size(640,500); move to before background
		Processing.noStroke();
		Processing.smooth();

		//The color of the sky is painted dark blue
		Processing.fill(31,33,85);
		Processing.rect(0,0,640,200);

		//The triangles are the mountains. They are painted
		// light yellow because I want to indicate that the moon
		// brightens the scenerio
		Processing.fill(240,214,117);
		Processing.triangle(0,200,180,200,80,50);
		Processing.triangle(150,200,400,200,260,40);
		Processing.triangle(395,200,500,200,420,100);
		Processing.triangle(495,200,530,20,700,200);

		//The moon is a crescent moon but it's still bright, so I painted
		//a really bright yellow
		// I use beginShape, endShape and curveVertex because the moon has
		//curves
		Processing.fill(258,218,16);
		Processing.beginShape();
		Processing.curveVertex(400,0);
		Processing.curveVertex(400,0);
		Processing.curveVertex(418,18);
		Processing.curveVertex(415,45);
		Processing.curveVertex(402,63);
		Processing.curveVertex(370,70);
		Processing.curveVertex(350,13);
		Processing.endShape();

		//The trapezoid is a wooden boat in which people use to watch
		//the moon. I painted it with the color combined by deeper brown
		//because the wooden boat is permeated by water
		Processing.fill(124,38,17);
		Processing.quad(120,350,140,400,300,400,320,350);

		//The triangle represents the sail of the boat.
		Processing.fill(252,111,3);
		Processing.triangle(210,350,270,280,210,210);

		//The lines are the bodies of the trees, carrying different
		//brown colors
		Processing.stroke(111,70,38);
		Processing.strokeWeight(55);
		Processing.line(620,120,620,500);
		Processing.stroke(64,34,11);
		Processing.strokeWeight(55);
		Processing.line(580,160,580,500);

		//The circles are leafs of the trees with different green colors
		//I inserted the stroke in the previous codes so here I put noStroke
		Processing.noStroke();
		Processing.ellipseMode(Consts.CENTER);
		Processing.fill(13,129,18);
		Processing.ellipse(620,120,180,180);
		Processing.fill(119,222,92);
		Processing.ellipse(580,200,150,150);
		Processing.save("student5.png");
	}

	public static void student6() throws IOException{
		/*Assignment 1 
    	02/07/14
    	Based on Edward Hopper's Nighthawks (1942)*/

		Processing.size(1000,800);
		Processing.background(255);

		Processing.smooth();
		Processing.noStroke();

		//the lowest part of the bar
		Processing.fill(11,54,36);
		Processing.quad(400,520,1000,650,1000,880,400,680);

		//upper orange part of the background store
		Processing.fill(139,52,17);
		Processing.rect(0,0,700,200);

		//black top right corner
		Processing.fill(0);
		Processing.rect(700,0,200,200);

		//5th small window
		Processing.stroke(15,95,43);
		Processing.strokeWeight(70);
		Processing.strokeCap(Consts.SQUARE);
		Processing.line(530,50,530,180);

		Processing.noStroke();

		//the bar sign
		Processing.fill(75,23,4);
		Processing.quad(455,80,1000,-20,1000,50,455,150);

		//triangle part where the people sit 
		Processing.fill(250,243,103);
		Processing.triangle(400,520,1000,400,1000,650);

		//the big wall window
		Processing.fill(51,82,81);
		Processing.quad(400,200,900,230,900,420,400,520);

		//little quad on the right
		Processing.fill(247,168,47);
		Processing.quad(900,230,1000,150,1000,440,900,420);

		//the ceiling
		Processing.fill(250,247,192);
		Processing.triangle(400,200,1000,150,900,230);

		//the 4th small window
		Processing.stroke(15,95,43);
		Processing.strokeWeight(70);
		Processing.strokeCap(Consts.SQUARE);
		Processing.line(410,50,410,180);

		Processing.noStroke();

		// the quad right below the bar sign
		Processing.fill(7,36,24);
		Processing.quad(400,150,400,200,1000,150,1000,50);

		//the woman in red
		Processing.fill(255,0,38);
		Processing.quad(800,400,830,435,800,500,780,444);

		//the man in black
		Processing.fill(0);
		Processing.quad(650,500,680,490,700,560,630,560);

		//the man's hat
		Processing.fill(0);
		Processing.ellipse(680,490,40,25);

		Processing.stroke(15,95,43);
		Processing.strokeWeight(70);
		Processing.strokeCap(Consts.SQUARE);

		//the other small windows
		Processing.line(50,50,50,180);
		Processing.line(170,50,170,180);
		Processing.line(290,50,290,180);

		Processing.stroke(0);
		Processing.line(50,140,50,180);
		Processing.line(170,90,170,180);
		Processing.line(290,120,290,180);

		Processing.noStroke();

		//the front of the background store
		Processing.fill(11,54,36);
		Processing.rect(0,200,400,320);

		//the two black thin pillars on the front of the store
		Processing.stroke(0);
		Processing.strokeWeight(10);
		Processing.line(170,200,170,520);
		Processing.line(230,200,230,520);

		//the two black windows on the front of the store
		Processing.strokeWeight(100);
		Processing.line(80,230,80,480);
		Processing.line(320,230,320,480);

		Processing.noStroke();

		//ground 1
		Processing.fill(130,137,134);
		Processing.rect(0,520,400,160);

		//ground 2
		Processing.fill(53,96,106);
		Processing.quad(0,680,400,680,800,800,0,800);

		//the waiter in white
		Processing.fill(255);
		Processing.beginShape();
		Processing.curveVertex(880,500);
		Processing.curveVertex(880,500);
		Processing.curveVertex(940,510);
		Processing.curveVertex(965,540);
		Processing.curveVertex(970,580);
		Processing.curveVertex(970,580);
		Processing.endShape();

		Processing.save("student6.png");
	}

	public static void student7() throws IOException{

		//Initial Constrains
		Processing.size (600,500);
		Processing.smooth ();
		//Solid background (96,245,216);

		//Horizontal Gradient using HSB 
		Processing.colorMode (Consts.HSB,360,100,100);
		for (int i=0; i<500; i++) {
			Processing.stroke (185,84,i/3);
			//going from bottom to top
			Processing.line (0,500-i,600,500-i);
		}

		//SUN
		Processing.colorMode (Consts.RGB,255);
		Processing.stroke (0);
		Processing.strokeWeight (1);
		//fill (255,95,3);
		Processing.fill (252,242,33);
		//SUN WITHOUT TRUNK OF TREE B ellipse (600,0,375,375);
		//SUN HIDDEN BEHIND TRUNK OF TREE B ellipse (475,0,300,300);
		//SMALL SUN NOT HIDDEN 
		Processing.ellipse (380,50,70,70);
		//Sunbeams

		//TREE 
		Processing.stroke (139,69,19); //SADDLE BROWN COLOR 
		Processing.strokeWeight (10);
		Processing.strokeCap (Consts.SQUARE);
		//Trunk of tree A
		Processing.fill (139,69,19);
		Processing.rect (0,0,72,500);
		/*
    	Hole in Tree A
    	Processing.fill (0);
    	Processing.noStroke();
    	Processing.ellipse (45,300,50,50);
    	Processing.stroke (102,51,0);
    	Processing.strokeWeight (2);
    	Processing.curve (20,300,20,300,45,250,60,300);
		 */
		//body of branch A
		Processing.smooth ();
		Processing.stroke (139,69,19);
		Processing.strokeWeight (13);
		Processing.noFill();
		Processing.beginShape ();
		Processing.vertex (0,165);
		Processing.vertex (0,175);
		Processing.vertex (30,175);
		Processing.vertex (50,180);
		Processing.vertex (60, 180);
		Processing.vertex (70,178);
		Processing.vertex (90,185);
		Processing.vertex (120,185);
		Processing.vertex (170,185);
		Processing.vertex (225,190);
		Processing.endShape (Consts.CLOSE);
		Processing.line (225,190,245,165); //little twig coming off of branch pointing up
		//sloping part of branch A
		Processing.beginShape ();
		Processing.curveVertex (225,190);
		Processing.curveVertex (225,190);
		Processing.curveVertex (260,210);
		Processing.curveVertex (270,220);
		Processing.curveVertex (278,235);
		Processing.curveVertex (278,235);
		Processing.endShape ();
		//BRANCH B
		Processing.stroke (102,51,0); //Dark Brown juxtuposing light brown, creating depth (?)
		Processing.fill (102,51,0);
		Processing.rect(600,0,-125,500); //trunk of Tree B
		Processing.fill (0);
		Processing.noStroke();
		//ellipse (585,150,100,150);//hole in tree
		//body of Branch B
		Processing.stroke(102,51,0);
		Processing.noFill ();
		Processing.smooth ();
		Processing.beginShape ();
		Processing.strokeWeight (25);
		Processing.strokeCap (Consts.ROUND);
		Processing.curveVertex (600,345);
		Processing.curveVertex (600,345);
		Processing.curveVertex (580,350);
		Processing.curveVertex (560,355);
		Processing.curveVertex (540,358);
		Processing.curveVertex (490,360);
		Processing.curveVertex (465,358);
		Processing.curveVertex (420,345);
		Processing.curveVertex (380,335);
		Processing.curveVertex (360,325);
		Processing.curveVertex (340,315);
		Processing.curveVertex (320,305);
		Processing.curveVertex (300,300);
		Processing.curveVertex (280,297);
		Processing.curveVertex (260,298);
		Processing.curveVertex (235,300);
		Processing.curveVertex (235,300);
		Processing.endShape ();
		Processing.strokeWeight (18);
		Processing.beginShape ();
		Processing.curveVertex (235,300);
		Processing.curveVertex (235,300);
		Processing.curveVertex (165,335);
		Processing.curveVertex (165,335);
		Processing.endShape ();
		//little twig coming off of branch pointing up (Branch B)
		Processing.strokeWeight (12);
		Processing.line (235,300,212,280);

		//BIRD A
		//FEET
		Processing.stroke (0);
		Processing.fill (0);
		Processing.strokeWeight (2);
		//left foot
		Processing.triangle (100,145,105,170,110,155);
		Processing.strokeWeight (3);
		Processing.line (105,170,98,188);
		Processing.line (105,170,105,188);
		//right foot
		Processing.strokeWeight (6);
		Processing.triangle (140,162,155,155,145,172);
		Processing.strokeWeight (3);
		Processing.line (145,172,143,188);
		Processing.line (145,172,150,188);
		//TAIL
		Processing.strokeWeight (10);
		Processing.noFill();
		Processing.strokeCap(Consts.ROUND);
		//top-tail
		Processing.beginShape ();
		Processing.curveVertex (90,80);
		Processing.curveVertex (90,80);
		Processing.curveVertex (40,30);
		Processing.curveVertex (20,35);
		Processing.curveVertex (18,50);
		Processing.curveVertex (30,52);
		Processing.curveVertex (35,45);
		Processing.curveVertex (30,43);
		Processing.curveVertex (30,43);
		Processing.endShape();
		//middle-tail
		Processing.beginShape ();
		Processing.curveVertex (90,80);
		Processing.curveVertex (90,80);
		Processing.curveVertex (70,60);
		Processing.curveVertex (40,60);
		Processing.curveVertex (25,80);
		Processing.curveVertex (30,94);
		Processing.curveVertex (40,95);
		Processing.curveVertex (48,80);
		Processing.curveVertex (40,78);
		Processing.curveVertex (40,78);
		Processing.endShape ();
		//bottom-tail
		Processing.beginShape ();
		Processing.curveVertex (90,80);
		Processing.curveVertex (90,80);
		Processing.curveVertex (60,82);
		Processing.curveVertex (63,100);
		Processing.curveVertex (75,100);
		Processing.curveVertex (73,95);
		Processing.curveVertex (73,95);
		Processing.endShape ();
		//BODY
		Processing.fill (234,43,110);
		Processing.strokeWeight (3);
		Processing.smooth();
		Processing.beginShape();
		Processing.curveVertex (85,70);
		Processing.curveVertex (85,70);
		Processing.curveVertex (90,127);
		Processing.curveVertex (130,165);
		Processing.curveVertex (180,150);
		Processing.curveVertex (210,112);
		Processing.curveVertex (210,112);
		Processing.endShape(Consts.CLOSE);
		//WING
		Processing.stroke (0);
		Processing.strokeWeight (2);
		Processing.fill (255,133,3);
		Processing.smooth ();
		Processing.beginShape ();
		Processing.curveVertex (132,127);
		Processing.curveVertex (132,127);
		Processing.curveVertex (120,100);
		Processing.curveVertex (118,85);
		Processing.curveVertex (119, 80);
		Processing.curveVertex (120,78);
		Processing.curveVertex (125,72);
		Processing.curveVertex (130,73);
		Processing.curveVertex (140,80);
		Processing.curveVertex (143,82);
		Processing.curveVertex (150,78);
		Processing.curveVertex (160,72);
		Processing.curveVertex (170,74);
		Processing.curveVertex (178,90);
		Processing.curveVertex (170,103);
		Processing.curveVertex (160,112);
		Processing.curveVertex (150,120);
		Processing.curveVertex (132,127);
		Processing.curveVertex (132,127);
		Processing.endShape ();
		//BEAK
		Processing.strokeWeight (1);
		Processing.fill (255,128,54);
		Processing.triangle (210,112,220,130,200,128);
		Processing.triangle (210,112,200,128,223,118);
		//EYE
		Processing.stroke (0);
		Processing.fill (0);
		Processing.ellipse (190,120,8,8);


		//BIRD B
		//FEET
		//left foot
		Processing.triangle (330,250,350,260,325,295);
		Processing.strokeWeight (3);
		Processing.line (325,295,320,300);
		Processing.line (325,295,330,300);
		Processing.strokeWeight (6);
		//right foot
		Processing.triangle (420,260,400,260,360,310);
		Processing.strokeWeight (3);
		Processing.line (360,310,340,310);
		Processing.line (360,310,355,320);
		//TAIL
		Processing.strokeWeight (10);
		Processing.noFill();
		Processing.strokeCap(Consts.ROUND);
		//top tail
		Processing.beginShape ();
		Processing.curveVertex (435,225);
		Processing.curveVertex (435,225);
		Processing.curveVertex (530,190);
		Processing.curveVertex (540,220);
		Processing.curveVertex (530,225);
		Processing.curveVertex (528,210);
		Processing.curveVertex (528,210);
		Processing.endShape();
		//middle tail
		Processing.beginShape ();
		Processing.curveVertex (435,225);
		Processing.curveVertex (435,225);
		Processing.curveVertex (480,200);
		Processing.curveVertex (510,200);
		Processing.curveVertex (520,230);
		Processing.curveVertex (515,255);
		Processing.curveVertex (505,255);
		Processing.curveVertex (490,245);
		Processing.curveVertex (500, 230);
		Processing.curveVertex (508,235);
		Processing.curveVertex (508,235);
		Processing.endShape();
		//bottom tail
		Processing.beginShape ();
		Processing.curveVertex (440,225);
		Processing.curveVertex (440,225);
		Processing.curveVertex (460,220);
		Processing.curveVertex (475,232);
		Processing.curveVertex (465,220);
		Processing.curveVertex (430,230);
		Processing.curveVertex (425,230);
		Processing.curveVertex (420,240);
		Processing.curveVertex (415,235);
		Processing.curveVertex (415,235);
		Processing.endShape();
		//BEAK
		Processing.strokeWeight (1);
		Processing.fill (255,128,54);
		Processing.triangle (330,170,315,195,298,187);
		Processing.triangle (330,170,305,167,315,195);
		//BODY
		Processing.stroke(0);
		Processing.strokeWeight (3);
		Processing.fill (0,191,255);
		Processing.smooth();
		/*CODED BODY BY POINT (Option 1)
    	Processing.beginShape();
    	Processing.curveVertex (320,180);
    	Processing.curveVertex (320,180);
    	Processing.curveVertex (313,220);
    	Processing.curveVertex (320,245);
    	Processing.curveVertex (330,268);
    	Processing.curveVertex (340,280);
    	Processing.curveVertex (390,300);
    	//curveVertex (400,300);
    	Processing.curveVertex (420,285);
    	Processing.curveVertex (430,280);
    	Processing.curveVertex (440,275);
    	Processing.curveVertex (455,260);
    	Processing.curveVertex (455,260);
    	Processing.endShape(CLOSE);
<<<<<<< HEAD
    	*/
    	Processing.arc (380,220,140,140,0,Consts.PI+Consts.QUARTER_PI,Consts.CHORD); //CODED BODY BY ARC (Option 2)
    	//eye
    	Processing.stroke (0);
    	Processing.fill (0);
    	Processing.ellipse (330,190,8,8);
    	//WING
    	Processing.fill (6,191,19);
    	Processing.strokeWeight (2);
    	Processing.beginShape();
    	Processing.curveVertex (372,245);
    	Processing.curveVertex (372,245);
    	Processing.curveVertex (360,190);
    	Processing.curveVertex (370,170);
    	Processing.curveVertex (380,167);
    	Processing.curveVertex (388,186);
    	Processing.curveVertex (390,200);
    	Processing.curveVertex (400,190);
    	Processing.curveVertex (410,190);
    	Processing.curveVertex (425,205);
    	Processing.curveVertex (428,215);
    	Processing.curveVertex (420,230);
    	Processing.curveVertex (372,245);
    	Processing.curveVertex (372,245);
    	Processing.endShape ();




    	//SHAPES DANGLING FROM LEFTMOST BRANCH (from left to right)
    	//SHAPE 1
    	Processing.fill (30,34,147);
    	Processing.line (120,170,120,210);
    	Processing.beginShape ();
    	Processing.curveVertex (120, 220);
    	Processing.curveVertex (120,220);
    	Processing.curveVertex (112,215);
    	Processing.curveVertex (115,208);
    	Processing.curveVertex (120,210);
    	Processing.curveVertex (123,208);
    	Processing.curveVertex (125,215);
    	Processing.curveVertex (120,220);
    	Processing.curveVertex (120,220);
    	Processing.endShape ();

    	//SHAPE 2
    	Processing.fill (255,0,30);
    	Processing.beginShape ();
    	Processing.curveVertex (155,260);
    	Processing.curveVertex (155,260);
    	Processing.curveVertex (135,245);
    	Processing.curveVertex (140,231);
    	Processing.curveVertex (155,225);
    	Processing.curveVertex (160,240);
    	Processing.curveVertex (167,225);
    	Processing.curveVertex (178,237);
    	Processing.curveVertex (155,260);
    	Processing.curveVertex (155,260);
    	Processing.endShape();
    	Processing.line (169,190,168,228);
    	//SHAPE 3
    	Processing.fill (203,21,85);
    	Processing.line (200,190,200,200);
    	Processing.beginShape ();
    	Processing.curveVertex (190,220);
    	Processing.curveVertex (190,220);
    	Processing.curveVertex (182,205);
    	Processing.curveVertex (188,200);
    	Processing.curveVertex (190,205);
    	Processing.curveVertex (200,200);
    	Processing.curveVertex (203,203);
    	Processing.curveVertex (200,210);
    	Processing.curveVertex (190,220);
    	Processing.curveVertex (190,220);
    	Processing.endShape();

    	//SHAPES DANGLING FROM RIGHTMOST BRANCH (from left to right)
    	//Shape 4
    	Processing.fill (255,0,30);
    	Processing.line (219,317,219,329);
    	Processing.beginShape();
    	Processing.curveVertex (210,350);
    	Processing.curveVertex (210,350);
    	Processing.curveVertex (203,330);
    	Processing.curveVertex (208, 326);
    	Processing.curveVertex (215,335);
    	Processing.curveVertex (220,330);
    	Processing.curveVertex (223,335);
    	Processing.curveVertex (210,350);
    	Processing.curveVertex (210,350);
    	Processing.endShape();
    	//Shape 5
    	Processing.fill (203,21,85);
    	Processing.line (298,315,298,350);
    	Processing.beginShape ();
    	Processing.curveVertex (290,400);
    	Processing.curveVertex (290,400);
    	Processing.curveVertex (260,360);
    	Processing.curveVertex (258,350);
    	Processing.curveVertex (270,338);
    	Processing.curveVertex (290,350);
    	Processing.curveVertex (310,338);
    	Processing.curveVertex (322,350);
    	Processing.curveVertex (324,360);
    	Processing.curveVertex (290,400);
    	Processing.curveVertex (290,400);
    	Processing.endShape ();
    	//Shape 6
    	Processing.fill (30,34,147);
    	Processing.line (418,354,416,420);
    	Processing.beginShape ();
    	Processing.curveVertex (390,440);
    	Processing.curveVertex (390,440);
    	Processing.curveVertex (350,400);
    	Processing.curveVertex (370,398);
    	Processing.curveVertex (390,410);
    	Processing.curveVertex (410,398);
    	Processing.curveVertex (422,410);
    	Processing.curveVertex (424,420);
    	Processing.curveVertex (390,440);
    	Processing.curveVertex (390,440);
    	Processing.endShape();
    	
    	Processing.save("student7.png");
    }
	
	public static void student8(){
		Processing.size (800,800);
		Processing.smooth();

		Processing.colorMode(Consts.RGB);
		for (int i = 0; i < Processing.width; i++) {
			double r = 20 + (i*.95);
			double g = 10 + (i*.34);
			double b = 60 + (i*2.5);
			Processing.stroke(r, g, b);
			Processing.line(i, 0, i, Processing.height);
		}

		//change colors of repeated shape
		int centerX = 25;
		int centerY = 25;
		int dotSize = 30;

		int rowCount = 0;
		while(centerY <= Processing.height) {

			Processing.noStroke();
			if (rowCount % 2 == 0) {
				Processing.fill(Processing.random(80, 255), Processing.random(80, 240), Processing.random(255, 255));
			} else {
				Processing.fill(Processing.random(10, 255), Processing.random(15, 255), Processing.random(20, 255));
			}
			rowCount = rowCount + 1;
			while(centerX <= Processing.width) {
				Processing.ellipse(centerX, centerY, dotSize, dotSize);
				centerX = centerX + dotSize;
			}
			centerY = centerY + dotSize;
			centerX = 25;
		}

		//Change thickness of repeated shape
		Processing.noFill();
		Processing.stroke(0);
		int count = 0;
		for (int d = 400; d>0; d=d-20){
			if (count % 2 == 0) {
				Processing.strokeWeight(5);
			} else {
				Processing.strokeWeight(1);
			}
			Processing.ellipse(400,400,d,d);
			count =  count + 1;
		}

		//Change height of repeated shape
		Processing.fill(255,255,255,130);
		Processing.noStroke();
		int barX = 100;
		int barWidth = 30;
		int barThickness = 1000;

		while(barX<Processing.width) {
			Processing.rect(barX, barX, barWidth, barThickness);
			barX = barX + 40;
		}

		//create shadow effect with triangle shape

		Processing.fill(0,0,0,20);
		int TriangleSize = 20;
		Processing.smooth();
		Processing.noStroke();
		double xVal = 0;
		double yVal = 0;
		double sizeNoise = 100;

		for (int i=0; i<Processing.width; i=i+1) {
			xVal = Processing.random(Processing.width);
			yVal = Processing.random(Processing.height);
			sizeNoise = Processing.random(15);

			if ((xVal > 700) && (xVal < 750)) {
				Processing.triangle(xVal,yVal,sizeNoise,sizeNoise,xVal+100,yVal);
			}
		}

		//right
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

	public static void student9(){
		/*Assignment 2
    	 Processing 2 Program
    	 Computer Science 100
    	 Professor Fourquet
    	 Reference: "Starry Night" by Vincent Van Gogh
		 */

		Processing.size (700, 500);
		Processing.background (7, 12, 67);
		Processing.smooth ();
		Processing.noStroke ();

		//ground
		int level=340;

		Processing.fill (5, 52, 32, 160);
		Processing.rect (0, level, Processing.width, level);


		//mountain
		int x1=0;
		int y1=0;
		int mWidth=200;
		int mHeight=250;
		int mMiddle=100;
		int minus=30;

		while (x1<Processing.width) {
			Processing.fill (183, 193, 193, 50);
			Processing.triangle (x1, level, mMiddle, mHeight, mWidth, level);
			x1=x1+mWidth-minus;
			mMiddle=mMiddle+mWidth-minus;
			mWidth=mWidth+mWidth-minus;
		}



		//STARS

		//smallStars
		Processing.fill (255, 247, 173, 120);
		for (int i=10; i<60; i=i+20) {
			Processing.ellipse (350, 50, i, i);
			Processing.ellipse (430, 30, i, i);
			Processing.ellipse (30, 180, i, i);
		}

		//mediumStars
		Processing.fill (247, 206, 55, 80);
		for (int i=10; i<100; i=i+25) {
			Processing.ellipse (190, 40, i, i);
			Processing.ellipse (525, 230, i, i);
			Processing.ellipse (260, 190, i, i);
		}

		//largeStar
		Processing.fill (252, 252, 71, 100);
		for (int i=10; i<200; i=i+45) {
			Processing.ellipse (630, 50, i, i);
		}


		//snow
		int snowSize= 5;
		double xVal= 0;
		double yVal= 0;
		double sizeVar= 0;

		for (int i=0; i<700; i=i+3) {
			xVal= Processing.random (Processing.width);
			yVal= Processing.random (level);
			sizeVar = Processing.random (3);
			Processing.fill (240, 223, 201, 100);
			Processing.ellipse (xVal, yVal, snowSize+sizeVar, snowSize+sizeVar);
		}


		//ground
		int barWidth=8;
		int barHeight=40;
		int gap=3;
		int bar=0;
		int locY=300;
		Processing.noStroke ();

		//horizontal row of trees across the picture
		while (bar<Processing.width) {
			if (bar%2==0) {
				Processing.fill (11, 39, 1);
			}
			else {
				Processing.fill (13, 28, 24);
			}
			Processing.rect (bar, locY, barWidth, barHeight);
			bar=bar+gap+barWidth;
		}



		//ground horizontal line
		//right side
		bar=300;
		locY=locY+barHeight;
		Processing.fill (3, 13, 28);

		int bar2Height=3;
		int barInterval=20;

		while (locY<Processing.width) {
			Processing.rect (bar, locY, Processing.width, bar2Height);
			bar=bar+barInterval;
			locY=locY+bar2Height+gap;
		}

		//leftside
		int bar3Interval=250;
		bar=0;
		locY=340;
		while (bar<Processing.width){
			Processing.rect (bar, locY, bar3Interval, bar2Height);
			bar=bar+barInterval;
			locY=locY+bar2Height+gap;
		}


		//TREE
		Processing.stroke (1);
		Processing.strokeWeight (1);

		int space=410;
		int count=0;
		int fromLeft=56;
		int treeWidth=30;
		int treeHeight=30;
		gap=2;

		//tree1
		Processing.fill (14, 67, 53);
		while (count<=3) {
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree2
		count=0;
		space=410-treeHeight-gap;
		fromLeft=fromLeft+treeWidth;

		while (count<4) {
			Processing.fill (14, 67, 22);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree3
		count=0;
		fromLeft=fromLeft+treeWidth+gap;
		space=90;
		treeWidth=20;

		while (count<13) {
			Processing.fill (39, 67, 14);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree4
		count=0;
		fromLeft=fromLeft+treeWidth;
		space=154;

		while (count<11) {
			Processing.fill (66, 67, 14);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree5
		count=0;
		fromLeft=fromLeft+treeWidth;
		space=218;

		while (count<9) {
			Processing.fill (46, 67, 14);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree6
		treeWidth=30;
		count=0;
		fromLeft=fromLeft+treeWidth+gap;
		space=314;

		while (count<6) {
			Processing.fill (14, 67, 57);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}

		//tree7
		count=0;
		fromLeft=fromLeft+treeWidth;
		space=410;

		while (count <3) {
			Processing.fill (14, 62, 67);
			Processing.rect (fromLeft, space, treeWidth, treeHeight);
			space=space+treeHeight+gap;
			count=count+1;
		}
		Processing.save ("student9.png");
	}

	public static void student10() {
		//Colored Pencils in Dreamform by student10 
		Processing.size(500,500);
		Processing.background(255);

		Processing.noStroke();
		Processing.smooth();

		//colorbars as background
		for(int z=0; z<Processing.width+75; z=z+75) {
			Processing.fill(Processing.random(100,225), Processing.random(100,225), Processing.random(100,225));
			Processing.quad(z-150,200, z,0, z+75,0, z,200);
			Processing.quad(z-150,350, z,200, z+75,200, z,350);
			Processing.quad(z-150,450, z,350, z+75,350, z,450);
			Processing.quad(z-150,550, z,450, z+75,450, z,550);
		}


		//brown circles
		for(int i=0; i < Processing.width+75; i= i+75) {
			if(i %2==0){
				Processing.fill(162,84,44);
			} else {
				Processing.fill(126, 58, 24);
			}
			Processing.ellipse(i, 200, 75, 75);
			Processing.ellipse(i, 350, 75, 75);
			Processing.ellipse(i, 450, 75, 75);
		}

		//triangle top to brown circles
		int i = 0;
		int a = 208;
		while(i<Processing.width+75) {
			Processing.fill(Processing.random(100,225), Processing.random(100,225), Processing.random(100,225));
			Processing.triangle(i,a-18, i-10,a , i+10,a);
			i = i+75;
		}
		i = 0;
		a = 358;
		while(i<Processing.width+75) {
			Processing.fill(Processing.random(100,225), Processing.random(100,225), Processing.random(100,225));
			Processing.triangle(i,a-18, i-10,a , i+10,a);
			i = i+75;
		}
		i = 0;
		a = 458;
		while(i<Processing.width+75) {
			Processing.fill(Processing.random(100,225), Processing.random(100,225), Processing.random(100,225));
			Processing.triangle(i,a-18, i-10,a , i+10,a);
			i = i+75;
		}
		// new line to save
		Processing.save("student10");
	}

	public static void student11() {
		/*
		Assignment 2
		 Computer Science 101
		 By student11 
		 "City Skyline"
		 */

		//PImage img;
		Processing.size(960, 642); //size of "sundayriver" image

		//image of ski mountain "sundayriver"
		img = loadImage("sundayriver.jpg");
		Processing.image(img, 0, 0, 960, 642);

		//image of Rockport Harbor, Maine
		Processing.tint(199, 213, 0, 110);
		img = loadImage("harborsunset.jpg");
		Processing.image(img, 0, 0, 960, 642);

		//black line building #1
		Processing.fill(0);

		int startY = 20;
		int start2Y = 150;
		for (int x = 20; x <= 700; x=x+5) {
		  Processing.strokeWeight(2);
		  Processing.strokeCap(Consts.SQUARE);
		  Processing.line(20, x, 150, x);
		}

		//black line building #2
		Processing.noFill();
		for (int y = 200; y<= 700; y=y+5) {
		  Processing.fill(60, 53, 165);
		  Processing.strokeWeight(2);
		  Processing.strokeCap(Consts.SQUARE);
		  Processing.line(200, y, 300, y);
		}

		Processing.noStroke();
		//darkest purple transparent building on right
		Processing.fill(106, 34, 102, 95);
		int DKpurpX1 = 790;
		int DKpurpY1 = 150;
		int DKpurpX2 = 105;
		int DKpurpY2 = 400;
		Processing.rect(DKpurpX1, DKpurpY1, DKpurpX2, DKpurpY2);

		//black and purple striped building (on right)

		int gap = 3;
		int down = 170;
		int barWidth = 150;
		int bar2Y = down;
		int bar2Width = 125;
		int barThickness = 8;
		int bar2X = Processing.width-barWidth-bar2Width;
		int bar2Thickness = 4 + 2*barThickness;

		int oddEven = 0;

		while (bar2Y<Processing.height) {
		  //even iteration
		  if (oddEven %2 == 0) {
		    System.out.println("even ");
		    Processing.fill(0, 120);
		  }
		  else {
		    System.out.println("odd ");
		    Processing.fill(129, 96, 131, 160);
		  }
		  Processing.rect(bar2X, bar2Y, bar2Width, bar2Thickness);
		  bar2Y = bar2Y + bar2Thickness;

		  System.out.println("oddEven" + oddEven);
		  oddEven = oddEven + 1;
		}

		//lighter purple transparant building on right
		Processing.noFill();
		Processing.fill(193, 31, 186, 100);
		int LTpurpX1 = 860;
		int LTpurpY1 = 240;
		int LTpurpX2 = 95;
		int LTpurpY2 = 355;
		Processing.rect(LTpurpX1, LTpurpY1, LTpurpX2, LTpurpY2);

		//Dark purple building made up of three squares on right

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

		//snow falling using the function "random"
		//using shape ellipse
		Processing.noFill();
		Processing.fill(255, 100);

		int snowFlakeSize = 1;
		Processing.noStroke();
		double xVal = 0;
		double yVal = 0;
		double flakeDensity = 0;

		for (int i = 0; i<960; i = i+1) {
		  xVal = Processing.random (Processing.width);
		  yVal = Processing.random (Processing.height);
		  flakeDensity = Processing.random (2);
		  Processing.ellipse(xVal, yVal, snowFlakeSize + flakeDensity, snowFlakeSize + flakeDensity);
		}

		//transparent black building with some lit windows, and some dark on left
		//also using shapes rectangle, and triangle
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
		Processing.triangle(BLKtriX1, BLKtriY1, BLKtriX2, BLKtriY2, BLKtriX3, BLKtriY2);

		//loop for windows in building WITH nested
		int squareDistance = 20;
		int windowSize = 20;
		double on = 0;
		//nested for and while loop to create my windows like we did in lab 4 :)

		for(BLKrectX1 = 190; BLKrectX1<380; BLKrectX1=BLKrectX1+squareDistance +20) {
		  while(BLKrectY1<670) {
		       on = Processing.random (0,2);
		  if (on < 1) {
		    System.out.println("lightOn");
		    Processing.fill(0);
		  } else {
		    System.out.println("lightOff");
		    Processing.fill(255, 247, 0, 100);
		  }
		    Processing.rect(BLKrectX1, BLKrectY1, windowSize, windowSize);
		    BLKrectY1 = BLKrectY1 + squareDistance +20;
		  }
		  BLKrectY1 = 370;
		}

		//for some reason, trying to save a copy png file of the image created was simply not working
		//and was really messing with the way processing saved my files so I could not do it
		//I am perfectly fine with you doing this and picking whatever looks nice for the website, I don't have a preference!
		//enjoy :)
	}

	public static void student12() {
		//"Easter Egg" by student12

		Processing.size(600, 500);

		Processing.background(255);
		Processing.smooth();

		Processing.fill(119, 95, 203);//creates random pastel color for triangles
		Processing.noStroke();

		int trig1 = 0;
		int trig2 = 50;
		int trig3 = 25;
		int trig4 = 150;
		int trigY = 200;

		//nested loop creates two rows of diamonds composed of triangles
		while (trigY<=300) {
			while(trig3<=Processing.width) {
				Processing.triangle(trig1, trigY, trig2, trigY, trig3, trig4);//upper triangle
				Processing.triangle(trig1, trigY, trig2, trigY, trig3, trig4+100);//lower triangle
				trig1 = trig1 + 50;
				trig2 = trig2 + 50;
				trig3 = trig3 + 50;
			}
			trig4 = 250;
			trig1 = 0;
			trig2 = 50;
			trig3 = 25;
			trigY = trigY+100;
		}

		Processing.fill(202, 237, 170);//makes rectangle light green
		for (int yVal=0; yVal<=350; yVal=yVal+350) {
			if(yVal<350) {
				Processing.rect(0, yVal, Processing.width, 150);//creates upper color block rectangle
			}
			if(yVal>=350) {
				Processing.rect(0, yVal, Processing.width, Processing.height);//creates lower color block rectangle
			}
		}

		Processing.strokeWeight(3);
		Processing.stroke(228, 170, 237);//makes Xs purple

		//loop creates top row of Xs
		int lineX1 = 25;
		int lineX2 = 75;
		while(lineX2<=575) {
			Processing.line(lineX1, 0, lineX2, 150);
			Processing.line(lineX2, 0, lineX1, 150);
			lineX1= lineX1 + 50;
			lineX2 = lineX2 + 50;
		}

		//loop creates bottom row of Xs
		lineX1 = 25;
		lineX2 = 75;
		while(lineX2<=575) {
			Processing.line(lineX1, 350, lineX2, Processing.height);
			Processing.line(lineX2, 350, lineX1, Processing.height);
			lineX1= lineX1 + 50;
			lineX2 = lineX2 + 50;
		}

		Processing.line(0, 150, Processing.width, 150);//upper line containng diamonds
		Processing.line(0, 350, Processing.width, 350);//lower line containing diamonds

		Processing.noStroke();
		Processing.fill(Processing.random(128, 255), Processing.random(128, 255), Processing.random(128, 255));//creates random color balls
		int ballX = 50;
		int ballSize= 22;
		double sizeNoise= 0;

		while(ballX<=550) {
			sizeNoise= Processing.random(22);
			Processing.ellipse(ballX, 250, ballSize+sizeNoise, ballSize+sizeNoise);//creates middle line of circles
			ballX=ballX+50;
		}

		Processing.save("student12.png");
	}

	public static void student13() {
		//this is an abstract piece, originally illustrated by Lynne Taetzch. 

		Processing.size(1000, 650);
		Processing.background(240, 230, 201); //creates a beige background 


		Processing.noStroke();
		Processing.smooth();
		for (double i = 0; i < Processing.width; i=i+Processing.random(20, 30)){
			Processing.fill(Processing.random(100, 230), Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 0, Processing.random(20, 30), 50);

		} // creates the first layer of lines 
		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.fill(Processing.random(100, 230), Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 50, Processing.random(20,30), 100);

		} // creates the second layer of lines

		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.fill(Processing.random(100, 230), Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 150, Processing.random(20,30), 50);

		} // creates the smaller third layer of lines

		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.fill(Processing.random(100, 250), Processing.random(100, 250), Processing.random(100, 250));
			Processing.rect(i, 200 , Processing.random(20,30), 50);

		} // creates the small fourth layer of lines

		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.fill(Processing.random(100, 230), Processing.random(100, 200), Processing.random(100, 200));
			Processing.rect(i, 250 , Processing.random(20,30), 100);

		} // creates the fifth layer of lines

		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.fill(Processing.random(130, 230), Processing.random(100, 200), Processing.random(130, 200));
			Processing.rect(i, 350 , Processing.random(20,30), 100);

		} //creates the sixth layer of lines 

		for (double i = 0; i < Processing.width; i=i+Processing.random(20,30)){
			Processing.stroke(Processing.random(100, 230), Processing.random(100, 200), Processing.random(100, 200));
			Processing.strokeWeight(Processing.random(10, 60));
			Processing.strokeCap(Consts.SQUARE);
			Processing.line(i, 450 , i, 1000);

		} // creates the last larger layer of lines


		int i= 100;
		int j= 100;
		int jGap = 100;
		while(i<Processing.width){
			while(j<=450){
				Processing.stroke(Processing.random(40, 250), Processing.random(40, 250), Processing.random(40, 250));
				Processing.strokeWeight(10);
				Processing.fill(Processing.random(40, 250), Processing.random(40, 250), Processing.random(40, 250));
				Processing.ellipse(i, j, 55, 55);
				j = j+jGap;
			}
			j = 100;
			i = i+ 150;
		} // creates the four rows of circles 
		//new line to save
		Processing.save("student13");
	}

	public static void student14() {
		//student14, Abstract
		Processing.size (500,500);
		Processing.background(255);
		Processing.smooth();
		Processing.noStroke();

		//recrangles, orange and black
		int rectW=Processing.width/30;
		int rectH=Processing.height;
		int rowCount=0;

		//the loop goes on until the i value hits width(500)
		for (int i=0;i<Processing.width;i=i+rectW*2){

		  //alternating colors orange and black
		  if (rowCount % 2 == 0) {
		    Processing.fill(255, 149, 10);
		  } else {
		    Processing.fill(0);
		  }
		  rowCount = rowCount + 1;
		Processing.rect (i,0,rectW,rectH);

		}

		//nested loop circles drawn above the rectangles
		int centerX=0;
		int centerY=0;
		int circleSize=5;


		while (centerY<=Processing.height){

		while (centerX<=Processing.width){
		Processing.strokeWeight(5);
		Processing.stroke(255);
		Processing.smooth();
		Processing.ellipse(centerX,centerY,circleSize,circleSize);
		centerX=centerX+2*circleSize;
		}
		centerY=centerY+2*circleSize;
		centerX=0;
		}



		//ellipses

		//left elipses
		Processing.ellipse (120,120,50,50);
		Processing.fill (255, 149, 10);
		Processing.ellipse (120,120,25,25);
		Processing.fill(255);
		Processing.ellipse (120,120,4,4);

		//center elipses
		Processing.fill (255, 149, 10);
		Processing.ellipse (250,250,70,70);
		Processing.fill (255);
		Processing.ellipse (250,250,50,50);
		Processing.fill(0);
		Processing.ellipse (250,250,20,20);

		//top right elipses
		Processing.fill (255);
		Processing.ellipse (350,100,90,90);
		Processing.fill (0);
		Processing.ellipse (350,100,50,50);
		Processing.fill(255, 149, 10);
		Processing.ellipse (350,100,20,20);

		//bottom ellipses
		Processing.fill (255);
		Processing.ellipse (470,470,140,140);
		Processing.fill (255, 149, 10);
		Processing.ellipse (470,470,90,90);
		Processing.fill(0);
		Processing.ellipse (470,470,20,20);



		//nested loop,the most right dots-random dots

		Processing.stroke(255);
		Processing.strokeWeight(3);

		double xVal = 0;
		double yVal = 0;


		for (int i=0; i<100; i=i+1) {

		//sets the constrains for dots within the radius=45
		  xVal = Processing.random(425, 515);
		  yVal = Processing.random(425,515);
		  if (Math.sqrt(Math.pow((xVal-470),2)+ Math.pow((yVal-470),2))<45)
		  {

		  Processing.point(xVal, yVal);
		  }
		}

		Processing.save("student14.png");
	}
	
    static double y = 50.0;
    static double speed = 1.0;
    static double radius = 15.0;
    static int direction = 1;
    
    public static void test() {
    	//Processing.size(100,100);
//        Processing.setClass("Demo");

    	Processing.colorMode(Consts.HSB, 360, 100, 100);
    	Processing.size(800, 500);
        	  for (int i=0; i<800; i=i+18) {
        		  Processing.strokeWeight(20);
        		  Processing.stroke(220, 90, 59-i*.15);
        		  Processing.line(i, 0, i, 500);
        	  }
    }

//    public static void draw(){
//    	Processing.fill(0, 255-12);
//    	Processing.rect(0, 0, 100, 100);
//    	Processing.fill(255);
//    	Processing.ellipse(33, y, radius, radius);
//    	y += speed * direction;
//    	  if ((y > Processing.height - radius) || (y < radius)) {
//    	    direction = -direction;
//    	  }
//    }
    
    public static void main(String[] args) throws IOException{
        test();
    }
}