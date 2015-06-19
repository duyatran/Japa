/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Demo.java
 * Purpose: A demo file for testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class Demo{
    public static void student1(){
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

    	//Processing.save("student1.png");




    }
    
    public static void student2(){
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
    }
    
    public static void student3(){
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

    	//Processing.save("student3.png");
    }
    
    public static void student4(){
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

    	//Processing.save("student4.png");
    }

    public static void student5(){
    	/* Assignment 1 - Date: February 14
    	Picture of my father's hometown - My father hometown has many
    	mountains and river. People often get on their wooden boats floating
    	in the river at night to watch the moon. It's a really peaceful
    	scenery. The scence is viewed from the river bank so it has
    	some trees.
    	Created by student4*/



    	//The background is blue - the color of the water
    	Processing.background(59,110,234);
    	Processing.size(640,500);
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
//    	Processing.beginShape();
//    	Processing.curveVertex(400,0);
//    	Processing.curveVertex(400,0);
//    	Processing.curveVertex(418,18);
//    	Processing.curveVertex(415,45);
//    	Processing.curveVertex(402,63);
//    	Processing.curveVertex(370,70);
//    	Processing.curveVertex(350,13);
//    	Processing.endShape();

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
//    	Processing.ellipseMode(CENTER);
    	Processing.fill(13,129,18);
    	Processing.ellipse(620,120,180,180);
    	Processing.fill(119,222,92);
    	Processing.ellipse(580,200,150,150);
    	//Processing.save("student5.png");
    }

    public static void student6(){
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
//    	Processing.beginShape();
//    	Processing.curveVertex(880,500);
//    	Processing.curveVertex(880,500);
//    	Processing.curveVertex(940,510);
//    	Processing.curveVertex(965,540);
//    	Processing.curveVertex(970,580);
//    	Processing.curveVertex(970,580);
//    	Processing.endShape();

    	//Processing.save("student6.png");
    }

    
    public static void test(){
        Processing.size(100,100);
        Processing.line(0,50,50,0);
        
//       Processing.background(255);
//        Processing.colorMode(Consts.HSB, 360, 100, 100);
//        Processing.fill(325,89,79);
//        Processing.line(0, 80, 80, 0);
//        Processing.rect(20, 40, 100, 50);
//        Processing.rect(20, 40, 100, 50);
//        Processing.rect(150, 40, 80, 80);
//        Processing.ellipse(70, 200, 100, 50);
//        Processing.ellipse(190, 200, 80, 80);
//        Processing.arc(300, 180, 100, 100, 0, 90, Consts.PIE);
//        Processing.triangle(50, 300, 110, 320, 90, 360);
//        Processing.line(300, 40, 340, 100);
//        Processing.point(300, 320);
        
    }
    
    public static void main(String[] args){
        test();
    }
}