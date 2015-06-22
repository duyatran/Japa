/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingBezier.java
 * Purpose: Creates a class for Catmull-Rom curves.
 *
 * @author Duy Tran
 * @version 1.0 6/20/2015
 */

import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

public class ProcessingCurve implements Shape{
	private double[] x;
    private double[] y;
    Point2D.Double[] points = new Point2D.Double[4];
    private ShapeAttributes att;
    //private double s = 0.5;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public ProcessingCurve(double[] xCoor, double[] yCoor, ShapeAttributes current){
        x = new double[xCoor.length];
        y = new double[yCoor.length];
    	for (int i = 0; i < xCoor.length; i++){
        	x[i] = xCoor[i];
        	y[i] = yCoor[i];
        	points[i] = new Point2D.Double(x[i], y[i]);
        }
        this.att = current.copy();
    }
    
    private CubicCurve2D.Double toBezier(Point2D.Double p1, Point2D.Double p2, 
    		Point2D.Double p3, Point2D.Double p4){
    	double newPoint1X = p2.getX();
    	double newPoint1Y = p2.getY();
    	double newPoint2X = -(p1.getX()/6) + p2.getX() + (p3.getX()/6);
    	double newPoint2Y = -(p1.getY()/6) + p2.getY() + (p3.getY()/6);
    	double newPoint3X = (p2.getX()/6) + p3.getX() - (p4.getX()/6);
    	double newPoint3Y = (p2.getY()/6) + p3.getY() - (p4.getY()/6);
    	double newPoint4X = p3.getX();
    	double newPoint4Y = p3.getY();

    	return new CubicCurve2D.Double(newPoint1X, newPoint1Y, newPoint2X, newPoint2Y,
    			newPoint3X, newPoint3Y, newPoint4X, newPoint4Y);
    }
    
//    private static double[][] multiply(double[][] A, double[][] B) {
//        int mA = A.length;
//        int nA = A[0].length;
//        int mB = B.length;
//        int nB = B[0].length;
//        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
//        double[][] C = new double[mA][nB];
//        for (int i = 0; i < mA; i++)
//            for (int j = 0; j < nB; j++)
//                for (int k = 0; k < nA; k++)
//                    C[i][j] += (A[i][k] * B[k][j]);
//        return C;
//    } 

    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
    	//TO-DO
        return " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
    	CubicCurve2D.Double curve = toBezier(points[0],points[1],points[2],points[3]);
    	if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(curve);
    	}
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(curve);
        }
    }
}
