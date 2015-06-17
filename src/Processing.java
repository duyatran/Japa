import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * Processing.java
 * Purpose: Provides public methods for the client code.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class Processing{

    public static int width;
    public static int height;
    public static double mouseX;
    public static double mouseY;
    private static MyCanvas canvas; // not sure about access level, 
                                    // but not public.
    
    /**
     * This method sets up the canvas and defines the dimension of
     * the display windows (in pixels) with default parameters (800 x 600).
     * It must be the first method called to start drawing.
     */
    public static void size(){
        // QUESTION: restrictions include only called once? no resizing?
        canvas = new MyCanvas();
        // making width and height public variables.
        width = canvas.getWidth();
        height = canvas.getHeight();
    }
    
    /**
     * See size() above.
     * @param width  Desired width of the display window.
     * @param height Desired height of the display window.
     */
    public static void size(int width, int height){
        canvas = new MyCanvas(width, height);
        //TO-DO
        //why not this.width = width;
        //and this.height = height;
        width = canvas.getWidth();
        height = canvas.getHeight();
    }
    
    /*****************************************************
     * Implementation of background(), stroke(), and fill()
     * not complete because the color handler method is not
     * done. 
     *****************************************************/
    public static void colorMode(int mode){
        canvas.setColorMode(mode);
    }
    
    public static void background(int rgb){
        canvas.background(new MyColor(rgb));
    }
    
    public static void background(int rgb, double alpha){
        canvas.background(new MyColor(rgb, alpha));
    }
    
    /**
     * Sets the grayscale color used for the background 
     * of the displaying. The default background is light 
     * gray.
     * @param int  Background color (grayscale).
     */
    public static void background(double gray){
        canvas.background(new MyColor(gray));
    }
    
    public static void background(double gray, double alpha){
        canvas.background(new MyColor(gray, alpha));
    }
    
    /**
     * Sets the color used for the background of the display 
     * window. The default background is light gray.
     * @param width  Desired width of the display window.
     * @param height Desired height of the display window.
     */
    public static void background(double v1, double v2, double v3){
        canvas.background(new MyColor(v1, v2, v3));
    }
    
    public static void background(double v1, double v2, double v3, double alpha){
        canvas.background(new MyColor(v1, v2, v3, alpha));
    }
    
    /**
     * TO-DO: Sets the background of the display window 
     * to an image.
     * @throws IOException
     */
    public static void background(String image){}
    
    public static void fill(int rgb){
        canvas.fill(new MyColor(rgb));
    }
   
    public static void fill(int rgb, double alpha){
        canvas.fill(new MyColor(rgb, alpha));
    }
   
    public static void fill(double v1, double v2, double v3){
        canvas.fill(new MyColor(v1, v2, v3));
    }
    
    public static void fill(double v1, double v2, double v3, double alpha){
        canvas.fill(new MyColor(v1, v2, v3, alpha));
    }
    
    public static void stroke(int rgb){
    	canvas.stroke(rgb);
    }
    
    public static void stroke(int rgb, double alpha) {
        canvas.stroke(rgb, alpha);
      }

    public static void stroke(double gray){
        canvas.stroke(gray);
    }
    
    public static void stroke(double gray, double alpha){
        canvas.stroke(gray, alpha);
    }
    
    public static void stroke(double v1, double v2, double v3){
        canvas.stroke(v1,v2,v3);
    }
    
    public static void stroke(double v1, double v2, double v3, double alpha){
        canvas.stroke(v1,v2,v3,alpha);
    }
    
    /**
     * Sets the style for rendering stroke endings.
     * @param cap - either SQUARE, ROUND or PROJECT
     * @throws IllegalArgumentException
     */
    public static void strokeCap(int cap){
        canvas.setStrokeCap(cap);
    }
    
    /**
     * Sets the style of the joints between strokes.
     * @param join - either MITER, BEVEL, and ROUND
     * @throws IllegalArgumentException
     */
    public static void strokeJoin(int join){
        canvas.setStrokeJoin(join);
    }
    
    /**
     * Sets the width (in pixels) of the stroke used for 
     * lines, points, and the border around shapes.
     * @throws IllegalArgumentException
     */    
    public static void strokeWeight(double w){
        canvas.setStrokeWeight((float)w);
    }
    
    /**
     * Disables drawing the stroke(outline).
     */    
    public static void noStroke(){
        canvas.noStroke();
    }
    
    /**
     * Disables filling geometry.
     */    
    public static void noFill(){
        canvas.noFill();
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
    public static void arc(double x, double y, double w, double h, double start, double stop, int mode){
        canvas.arc(x, y, w, h, start, stop, mode);
    }
    
    /**
     * @param x  by default, x-coordinate of the ellipse
     * @param y  by default, y-coordinate of the ellipse
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     * @param  start - The starting angle of the arc in degrees.
     * @param  stop - The angular extent of the arc in degrees.
     */
    public static void arc(double x, double y, double w, double h, double start, double stop){
        canvas.arc(x, y, w, h, start, stop, -1);
    }
    
    /**
     * Draws an ellipse to the screen.
     * @param x  by default, x-coordinate of the ellipse
     * @param y  by default, y-coordinate of the ellipse
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     */
    public static void ellipse(double x, double y, double w, double h){
        canvas.ellipse(x, y, w, h);
    }
    
    /**
     * Draws a line to the screen.
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     */
    public static void line(double x1, double y1, double x2, double y2){
        canvas.line(x1, y1, x2, y2);
    }
    
    /**
     * Draws a point to the screen.
     * @param x1  x-coordinate of the point
     * @param y1  y-coordinate of the point
     */
    public static void point(double x, double y){
        canvas.point(x, y);
    }
    
    
    /**
     * Draws a four-sided polygon to the screen
     * @param x1	x-coordinate of the first corner
     * @param y1	y-coordinate of the first corner
     * @param x2	x-coordinate of the second corner
     * @param y2	y-coordinate of the second corner
     * @param x3	x-coordinate of the third corner
     * @param y3	y-coordinate of the third corner
     * @param x4	x-coordinate of the fourth corner
     * @param y4	y-coordinate of the fourth corner

     */
    public static void quad(double x1, double y1, double x2, double y2, 
    		double x3, double y3, double x4, double y4){
    	canvas.quad(x1, y1, x2, y2, x3, y3, x4, y4);

    }
    
    /**
     * Draws a rectangle to the screen.
     * TO-DO: extra params for rounded-rectangle
     * @param x  by default, x-coordinate of the rectangle
     * @param y  by default, y-coordinate of the rectangle
     * @param w  by default, width of the rectangle
     * @param h  by default, height of the rectangle
     */
    public static void rect(double x, double y, double w, double h){
        canvas.rect(x, y, w, h);
    }
    
    /**
     * TO-DO
     */
    public static void rectMode(){}

    /**
     * Draws a triangle to the screen.
     * @param x1	x-coordinate of the first vertex
     * @param y1	y-coordinate of the first vertex
     * @param x2	x-coordinate of the second vertex
     * @param y2	y-coordinate of the second vertex
     * @param x3	x-coordinate of the third vertex
     * @param y3	y-coordinate of the third vertex
     */
    public static void triangle(double x1, double y1, double x2, double y2, double x3, double y3){
    	canvas.triangle(x1, y1, x2, y2, x3, y3);
    }
    
    /**
     * TO-DO: Save image as image file
     * @param filename
     */
    public static void save(String filename){        
    }
    
    /**
     * Turn on anti-aliasing, which is on by default.
     */
    public static void smooth(){
        canvas.smooth();
    }
    
    /**
     * Turn off anti-aliasing. smooth() is active by default, 
     * so it is necessary to call this method to disable anti-aliasing.
    */
    public static void noSmooth(){
        canvas.noSmooth();
    }
}

