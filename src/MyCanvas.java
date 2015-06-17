import java.awt.*;
import java.awt.event.*; // Event-handling
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
public class MyCanvas extends JFrame{
	private int colorMode = Consts.RGB;
    private Color backgroundColor = Color.LIGHT_GRAY;
    private ShapeAttributes att = new ShapeAttributes();
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
    private DrawCanvas drawCanvas;
    
    public MyCanvas(){
        init(Consts.DEFAULT_WIDTH, Consts.DEFAULT_HEIGHT);
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
    
    public void setColorMode(int mode){
        if (mode == Consts.RGB || mode == Consts.HSB)
            colorMode = mode;
        else{
            throw new 
            IllegalArgumentException("Color must be either RGB or HSB");
        }
    }
    
    public int getColorMode(){
    	return colorMode;
    }
    
    public void background(MyColor c){
        backgroundColor = c;
    }
    
    public void fill(MyColor c){
        att.setFill(true);
        att.setFillColor(c);
    }
    
    public void stroke(MyColor c){
    	att.setStroke(true);
    	att.setStrokeColor(c);
    }
    
    /**
     * Sets the style for rendering stroke endings.
     * @param cap - either SQUARE, ROUND or PROJECT
     * @throws IllegalArgumentException
     */
    public void setStrokeCap(int cap){
    	// TO-DO
//                throw new IllegalArgumentException
//                ("Stroke cap must be either SQUARE, ROUND or PROJECT");
        att.setStrokeCap(cap);

    }
    
    /**
     * Sets the style of the joints between strokes.
     * @param join - either MITER, BEVEL, and ROUND
     * @throws IllegalArgumentException
     */
    public void setStrokeJoin(int join){
        att.setStrokeJoin(join);
    }
    
    /**
     * Sets the width (in pixels) of the stroke used for 
     * lines, points, and the border around shapes.
     * @throws IllegalArgumentException
     */    
    public void setStrokeWeight(float w){
        att.setStrokeWeight(w);
    }
    
    /**
     * Disables drawing the stroke(outline).
     */
    public void noStroke(){
        att.setStroke(false);
    }
    
    /**
     * Disables filling geometry.
     */  
    public void noFill(){
        att.setFill(false);
    } 
    
    /**
     * Adds an arc to the shapeList.
     * @param x  by default, x-coordinate of the ellipse
     * @param y  by default, y-coordinate of the ellipse
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     * @param  start - The starting angle of the arc in degrees.
     * @param  stop - The angular extent of the arc in degrees.
     * @param  mode - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE.
     */
    public void arc(double x, double y, double w, double h, double start, double stop, int mode){
    	// Arguments modified to produce Processing-like arc with Java2D Arc2D constructor,
    	// which draws arc counter-clockwise and use 'extent' instead of 'stop' angle.
    	shapeList.add(new ProcessingArc(x, y, w, h, Consts.TWO_PI-stop, stop-start, mode, att));	
    }
    
    /**
     * Adds an ellipse to the shapeList.
     * @param x  by default, x-coordinate of the rectangle containing the ellipse
     * @param y  by default, y-coordinate of the rectangle containing the ellipse
     * @param w  by default, width of the ellipse
     * @param h  by default, height of the ellipse
     */
    public void ellipse(double x, double y, double w, double h){
        shapeList.add(new ProcessingEllipse(x, y, w, h, att));
    }
    
    /**
     * TO-DO
     */
    public static void ellipseMode(){}
    
    /**
     * Adds a line to the shapeList.
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     */
    public void line(double x1, double y1, double x2, double y2){
        shapeList.add(new ProcessingLine(x1, y1, x2, y2, att));
    }
    
    /**
     * Adds a point to the shapeList.
     * @param x1  x-coordinate of the point
     * @param y1  y-coordinate of the point
     */
    public void point(double x, double y){
        shapeList.add(new ProcessingLine(x, y, x+Consts.EPSILON, y+Consts.EPSILON, att));
    }
    
    /**
     * Adds a four-sided polygon to the screen
     * @param x1	x-coordinate of the first corner
     * @param y1	y-coordinate of the first corner
     * @param x2	x-coordinate of the second corner
     * @param y2	y-coordinate of the second corner
     * @param x3	x-coordinate of the third corner
     * @param y3	y-coordinate of the third corner
     * @param x4	x-coordinate of the fourth corner
     * @param y4	y-coordinate of the fourth corner
     */
    public void quad(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
    	double[] x = new double[] {x1, x2, x3, x4};
    	double[] y = new double[] {y1, y2, y3, y4};
    	shapeList.add(new ProcessingPolygon(x, y, att));
    }
    
    /**
     * Adds a rectangle to the shapeList.
     * @param x  by default, x-coordinate of the rectangle
     * @param y  by default, y-coordinate of the rectangle
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     */
    public void rect(double x, double y, double w, double h){
        shapeList.add(new ProcessingRect(x, y, w, h, att));
    }
    
    /**
     * TO-DO
     */
    public static void rectMode(){}
    
    /**
     * Adds a triangle to the shapeList.
     * @param x1	x-coordinate of the first vertex
     * @param y1	y-coordinate of the first vertex
     * @param x2	x-coordinate of the second vertex
     * @param y2	y-coordinate of the second vertex
     * @param x3	x-coordinate of the third vertex
     * @param y3	y-coordinate of the third vertex
     */
    public void triangle(double x1, double y1, double x2, double y2, double x3, double y3){
    	double[] x = new double[] {x1, x2, x3};
    	double[] y = new double[] {y1, y2, y3};
    	shapeList.add(new ProcessingPolygon(x, y, att));
    }
    
    /**
     * TO-DO: Save image as image file
     * @param filename
     */
    public void save(String filename){        
    }
    
    /**
     * Turn on anti-aliasing, which is on by default.
     */
    public void smooth(){
        att.setSmooth(true);
    }
    
    /**
     * Turn off anti-aliasing.
     */
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

