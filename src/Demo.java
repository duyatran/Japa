/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Demo.java
 * Purpose: A demo file for testing and demonstration purposes.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class Demo implements ProcessingConstants{
    public static void student1(){
    	Processing.size(720, 580);

    	//colorMode(HSB);

    	for (int i=0; i<580; i++) {
    	Processing.stroke(200, 200, i*2);
    	Processing.line(0, i, 720, i);
    	}

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
    	Processing.strokeCap(SQUARE);
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
    	Processing.strokeCap(SQUARE);
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
    
    public static void test(){
        Processing.size();
        Processing.rect(20, 40, 100, 50);
        Processing.rect(150, 40, 80, 80);
        Processing.ellipse(70, 200, 100, 50);
        Processing.ellipse(190, 200, 80, 80);
        Processing.arc(300, 180, 100, 100, 0, 90);
        Processing.triangle(50, 300, 110, 320, 90, 360);
        Processing.line(300, 40, 340, 100);
        Processing.point(300, 320);
        
    }
    
    public static void main(String[] args){
        student2();
    }
}