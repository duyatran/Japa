import java.awt.*;
import java.awt.event.*; // Event-handling
import java.awt.geom.*; //to use Graphics2D
import java.util.*;
import javax.swing.*;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * MyCanvas.java
 * Purpose: Create MyCanvas class that holds the graphical containers
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

@SuppressWarnings("serial")
public class MyCanvas extends JFrame implements ProcessingConstants{
	private String colorMode = "RGB";
    private Color backgroundColor = Color.LIGHT_GRAY;
    private ShapeAttributes att = new ShapeAttributes();
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
    private DrawCanvas drawCanvas;
    
    public MyCanvas(){
        init(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    public MyCanvas(int w, int h){ 
    	//cannot require user to run
        init(w, h);
    }
    
    private void init(int w, int h){
        drawCanvas = new DrawCanvas();
        
        drawCanvas.setPreferredSize(new Dimension(w, h));
 
        Container cp = getContentPane();
        cp.add(drawCanvas);
   
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setTitle("My Canvas");
        this.setVisible(true);
    }
    
    /*****************************************************
     * Implementation of background(), stroke(), and fill()
     * not complete because the color handling method is not
     * done. 
     *****************************************************/
    
    public void background(float v1, float v2, float v3){
        backgroundColor = getColor(v1, v2, v3);
    }
  
    public void setColorMode(String mode){
        if (mode.equals("RGB") || mode.equals("HSB"))
            colorMode = mode;
        else{
            throw new 
            IllegalArgumentException("Color must be either RGB or HSB");
        }
    }
    
    private Color getColor(float v1, float v2, float v3){
        switch (colorMode) {
            case "RGB": return (new Color((int)v1, (int)v2, (int)v3));
            case "HSB": 
                Color c = Color.getHSBColor(v1, v2, v3);
                return c;
            default: return null;               
        }
    }
    
    public void fill(int rgb){
        att.setFill(true);
        att.setFillColor(new Color(rgb));
    }

//    public void fill(int rgb, float alpha){
//        att = new ShapeAttributes(att, new Color(rgb), 0);
//    }
    
    public void fill(int r, int g, int b){
        att.setFill(true);
        att.setFillColor(new Color(r,g,b));
    }
    
    public void fill(int r, int g, int b, int a){
        att.setFill(true);
        att.setFillColor(new Color(r,g,b,a));
    }
    
    public void stroke(int rgb){
//    	colorCalc(rgb);
    }
    
    public void stroke(int rgb, float alpha) {
//        colorCalc(rgb, alpha);
      }

    public void stroke(float gray){
//        colorCalc(gray);
    }
    
    public void stroke(float gray, float alpha){
//        colorCalc(gray, alpha);
    }
    
    public void stroke(float v1, float v2, float v3){
//        colorCalc(v1,v2,v3);
    }
    
    public void stroke(float v1, float v2, float v3, float alpha){
//        colorCalc(v1,v2,v3,alpha);
    	getColor(v1, v2, v3);
    }
       
    public void setStrokeCap(int cap){
    	// TO-DO
//                throw new IllegalArgumentException
//                ("Stroke cap must be either SQUARE, ROUND or PROJECT");
        att.setStrokeCap(cap);

    }
    
    public void setStrokeJoin(int join){
        att.setStrokeJoin(join);
    }
    
    public void setStrokeWeight(float w){
        att.setStrokeWeight(w);
    }
    
    public void noStroke(){
        att.setStroke(false);
    }
    
    public void noFill(){
        att.setFill(false);
    } 
    
    /**
     * Draws an arc to the screen.
     * @param x  by default, x-coordinate of the ellipse
     * @param y  by default, y-coordinate of the ellipse
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     * @param  start - The starting angle of the arc in degrees.
     * @param  stop - The angular extent of the arc in degrees.
     * @param  mode - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE.
     */
    public void arc(float x, float y, float w, float h, float start, float stop, int mode){
    	// Arguments modified to produce Processing-like arc with Java2D Arc2D constructor,
    	// which draws arc counter-clockwise and use 'extent' instead of 'stop' angle.
    	shapeList.add(new ProcessingArc(x, y, w, h, TWO_PI-stop, stop-start, mode, att));	
    }

    public void ellipse(float x, float y, float w, float h){
        shapeList.add(new ProcessingEllipse(x, y, w, h, att));
    }
    
    public void line(float x1, float y1, float x2, float y2){
        shapeList.add(new ProcessingLine(x1, y1, x2, y2, att));
    }
    
    /**
     * Draws a point to the screen.
     * @param x  x-coordinate of the point
     * @param y  y-coordinate of the point
     */
    public void point(float x, float y){
        shapeList.add(new ProcessingLine(x, y, x+EPSILON, y+EPSILON, att));
    }
    
    public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4){
    	float[] x = new float[] {x1, x2, x3, x4};
    	float[] y = new float[] {y1, y2, y3, y4};
    	shapeList.add(new ProcessingPolygon(x, y, att));
    }
    
    public void rect(float x, float y, float w, float h){
        shapeList.add(new ProcessingRect(x, y, w, h, att));
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3){
    	float[] x = new float[] {x1, x2, x3};
    	float[] y = new float[] {y1, y2, y3};
    	shapeList.add(new ProcessingPolygon(x, y, att));
    }
    
    public void smooth(){
        att.setSmooth(true);
    }
    
    public void noSmooth(){
        att.setSmooth(false);
    }
    
    private class DrawCanvas extends JPanel {
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            setBackground(backgroundColor);
        	ShapeAttributes current = new ShapeAttributes();
            for (Shape s : shapeList){
            	current = s.getAttributes();
                if (current.getSmooth())
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                RenderingHints.VALUE_ANTIALIAS_ON);
                else
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                        RenderingHints.VALUE_ANTIALIAS_OFF);
                s.paintShape(g2);
            }
        }
        
        
    }
}

