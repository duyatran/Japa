import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class ProcessingPolygon implements Shape{
	private double[] x;
    private double[] y;
    private ShapeAttributes att;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public ProcessingPolygon(double[] xCoor, double[] yCoor, ShapeAttributes current){
        x = new double[xCoor.length];
        y = new double[yCoor.length];
    	for (int i = 0; i < xCoor.length; i++){
        	x[i] = xCoor[i];
        	y[i] = yCoor[i];
        }
        this.att = current.copy();
    }

    public ShapeAttributes getAttributes(){
    	return this.att;
    }
    
    public String toString(){
    	//TO-DO
        return " attributes: " + att.toString();
    }

    public void paintShape(Graphics2D g2){
        Path2D.Double polygon = new Path2D.Double();
    	if (att.getFill()){
            g2.setColor(att.getFillColor());
            polygon.moveTo(x[0], y[0]);
            for (int i = 0; i < x.length; i++){
            	polygon.lineTo(x[i], y[i]);
            }
            polygon.closePath();            
            g2.fill(polygon);
    	}
        if (att.getStroke()){
            g2.setStroke(att.getStrokeStyle());
            g2.setColor(att.getStrokeColor());
            polygon = new Path2D.Double();
            polygon.moveTo(x[0], y[0]);
            for (int i = 0; i < x.length; i++){
            	polygon.lineTo(x[i], y[i]);
            }
            polygon.closePath();            
            g2.draw(polygon);
        }
    }
}
