import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ProcessingShape.java
 * Purpose: Creates a class representing a rectangle.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

public class ProcessingShape extends Shape
{
    private ArrayList<Point2D.Double> vertices;
    private ArrayList<Double> curveVerticesX;
    private ArrayList<Double> curveVerticesY;
    private int vIndex = 0;
    private Path2D.Double path;
    private ShapeAttributes att;

    /**
     */
    public ProcessingShape(ShapeAttributes current){
    	path = new Path2D.Double();
    	vertices = new ArrayList<Point2D.Double>();
    	curveVerticesX = new ArrayList<Double>();
    	curveVerticesY = new ArrayList<Double>();
    	this.att = current.copy();
    }
    
    /**
     * 
     */
    public void add(double x, double y, int type){
    	if (vertices.isEmpty()) {
    		path.moveTo(x, y);
        	vertices.add(new Point2D.Double(x, y));
    		curveVerticesX.add(x);
			curveVerticesY.add(y);
    	}
    	else {
    		switch (type){
    			case Consts.VERTEX:
    	    		path.lineTo(x, y);
    	    		break;
    			case Consts.CURVE_VERTEX:
    				curveVerticesX.add(x);
    				curveVerticesY.add(y);
    				drawCurveSegment();
    		}
    	}
    }
    
    private void drawCurveSegment() {
    	if (curveVerticesX.size() >= 4) {
    		Point2D.Double[] currentSet = new Point2D.Double[4];
    		for (int i = 0; i < 4; i++){
    			currentSet[i] = new Point2D.Double(curveVerticesX.get(vIndex),
    					curveVerticesY.get(vIndex));
    			vIndex++;
    		}
    		vIndex -= 3;
    		Point2D.Double[] coords = produceCurve(currentSet, 
    				Consts.CATMULL_ROM, att.getCurveTightness());
    		path.curveTo(coords[1].getX(), coords[1].getY(), coords[2].getX(), 
    				coords[2].getY(), coords[3].getX(), coords[3].getY());	
    	}
	}

	//quadratic
	public void add(double x1, double y1, double x2, double y2) {
		path.quadTo(x1, y1, x2, y2);
	}
	
	//bezier
	public void add(double x1, double y1, double x2, double y2, double x3,
			double y3) {
		path.curveTo(x1, y1, x2, y2, x3, y3);
	}
    
    /* @return the arc's attributes object.
     * @see Shape#getAttributes()
     */
    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    @Override
    public String toString(){
        //TO-DO;
    	return null;
        }
    
    /* Do the actual drawing of the shape.
     * @see Shape#paintShape(java.awt.Graphics2D)
     */
    public void paintShape(Graphics2D g2){
        if (att.getFill()){
            g2.setColor(att.getFillColor());
            g2.fill(path);
        }
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            g2.draw(path);
        }
    }
}
