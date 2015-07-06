import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * MyCanvas.java
 * Purpose: Create MyCanvas class that holds the graphical containers
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

@SuppressWarnings("serial")
public class ProcessingCanvas extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	private static int canvasWidth = Consts.DEFAULT_WIDTH;
	private static int canvasHeight = Consts.DEFAULT_HEIGHT;
	private Color backgroundColor = Color.LIGHT_GRAY;
	private ProcessingShape currentShape;
	private ShapeAttributes att = new ShapeAttributes();
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private ArrayList<Shape> setupList = new ArrayList<Shape>();
	private DrawCanvas drawCanvas;
	private BufferedImage paintImage;
	private boolean save;
	private String fileName;
	
	// testing purposes
	private static Queue<InputEvent> eventQ = new LinkedList<InputEvent>(); 
	
	public ProcessingCanvas(){
		this(canvasWidth, canvasHeight);
	}

	public ProcessingCanvas(final int w, final int h){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(w, h);
			}
		});
	}

	private void createAndShowGUI(int w, int h){
		drawCanvas = new DrawCanvas();
		drawCanvas.setFocusable(true);
		drawCanvas.requestFocusInWindow();
		drawCanvas.setPreferredSize(new Dimension(w,h));
		drawCanvas.addMouseListener(this);
		drawCanvas.addMouseMotionListener(this);
		drawCanvas.addKeyListener(this);
		canvasWidth = w;
		canvasHeight = h;
		Container cp = getContentPane();
		cp.add(drawCanvas);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("My Canvas");
		
		if (w >= Consts.MIN_WIDTH && h >= Consts.MIN_HEIGHT){
			this.pack();
		}
		else {
			// TO FIX
			this.setLayout(null);
			this.setMinimumSize(new Dimension(Consts.MIN_WIDTH, Consts.MIN_HEIGHT));
			int x = (Consts.MIN_WIDTH - w)/2;
			int y = (Consts.MIN_HEIGHT - h)/2;
			drawCanvas.setBounds(x, y, w, h);
		}

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e){
				if (save){
					// Use a swingworker to do the saving on another thread, so as
					// not to queue save() on EDT and cause flicker in GUI
					SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
						@Override
						public Void doInBackground() {
							String fileType = "";
							if (fileName.indexOf(".") == -1){
								fileType = "png";
								fileName = fileName.concat(".png");
							}
							else {
								fileType = fileName.substring(fileName.indexOf(".") + 1);
							}
							int outputFormat = (fileType.toLowerCase().equals("png")) ?
									BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;

							paintImage = new BufferedImage(canvasWidth, 
									canvasHeight, outputFormat);
							Graphics2D g = paintImage.createGraphics();
							drawCanvas.paint(g); // or print
							g.dispose();

							try {
								ImageIO.write(paintImage, fileType, new File(fileName));
							}
							catch (IOException ex) {
								System.out.println(ex.toString());				
							}
							catch (IllegalArgumentException ex) {
								System.out.println(ex.toString());				
							}
							return null;
						}
					};
					worker.execute();
				}
			}
		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void background(Color c){
		backgroundColor = c;
		repaint();
	}

	public void fill(Color c){
		att.setFill(true);
		att.setFillColor(c);
		repaint();
	}

	public void stroke(Color c){
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
	 * 
	 */
	public void vertex(double x, double y){
		currentShape.addVertex(x, y);
	}

	/**
	 * 
	 */
	public void curveVertex(double x, double y){
		currentShape.addCurveVertex(x, y);
	}

	/**
	 * 
	 */
	public void quadraticVertex(double x1, double y1,
			double x2, double y2){
		currentShape.add(x1, y1, x2, y2);
	}

	/**
	 * 
	 */
	public void bezierVertex(double x1, double y1,
			double x2, double y2, double x3, double y3){
		currentShape.add(x1, y1, x2, y2, x3, y3);
	}

	/**
	 * 
	 */
	public void beginShape(int kind){
		currentShape = new ProcessingShape(att, kind);
	}

	/**
	 * 
	 */
	public void endShape(int mode){
		currentShape.closePath(mode);
		shapeList.addAll(currentShape.getShapeList());
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
	 * Adds a curve to the shapeList.
	 * @param x1	x-coordinate of the first anchor point
	 * @param y1	y-coordinate of the first anchor point
	 * @param x2	x-coordinate of the first control point
	 * @param y2	y-coordinate of the first control point
	 * @param x3	x-coordinate of the second control point
	 * @param y3	y-coordinate of the second control point
	 * @param x4	x-coordinate of the second anchor point
	 * @param y4	y-coordinate of the second anchor point
	 */
	public void curve(double x1, double y1, double x2, double y2, 
			double x3, double y3, double x4, double y4, int type){
		double[] x = new double[] {x1, x2, x3, x4};
		double[] y = new double[] {y1, y2, y3, y4};
		shapeList.add(new ProcessingCurve(x, y, type, att));
	}

	/**
	 * Modifies the quality of forms created with curve().
	 * @param t  the tension value of the cardinal curve
	 */
	public void curveTightness(double t){
		att.setCurveTightness(t);
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
		repaint();
	}

	/**
	 * 
	 */
	public void ellipseMode(int mode){
		att.setEllipseMode(mode);
	}

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
		att.setStrokeCap(Consts.ROUND);
		shapeList.add(new ProcessingLine(x, y, x+Consts.EPSILON, y+Consts.EPSILON, att));
		att.setStrokeCap(Consts.SQUARE);
	}

	/**
	 * Adds a polygon (triangle and quad) to the screen
	 * @param x1	x-coordinate of the first corner
	 * @param y1	y-coordinate of the first corner
	 * @param x2	x-coordinate of the second corner
	 * @param y2	y-coordinate of the second corner
	 * @param x3	x-coordinate of the third corner
	 * @param y3	y-coordinate of the third corner
	 * @param x4	x-coordinate of the fourth corner
	 * @param y4	y-coordinate of the fourth corner
	 */
	public void polygon(double[] x, double [] y){
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

	public void rect(double v1, double v2, double v3, double v4,
			double tl, double tr, double br, double bl){
		beginShape(Consts.POLYGON);

		double[] temp = currentShape.setCoordinates(att.getRectMode(),
				v1, v2, v3, v4);
		double x = temp[0];
		double y = temp[1];
		double w = temp[2];
		double h = temp[3];

		// top left corner
		vertex(x+tl, y);
		quadraticVertex(x, y, x, y+tl);

		// bottom left corner
		vertex(x, y+h-bl);
		quadraticVertex(x, y+h, x+bl, y+h);

		// bottom right corner
		vertex(x+w-br, y+h);
		quadraticVertex(x+w, y+h, x+w, y+h-br);

		// top right corner
		vertex(x+w, y+tr);
		quadraticVertex(x+w, y, x+w-tl, y);

		endShape(Consts.CLOSE);
	}

	/**
	 *
	 */
	public void rectMode(int mode){
		att.setRectMode(mode);
	}

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

	public void save(String fileName){
		this.save = true;
		this.fileName = fileName;
	}
	
	// DEVELOPMENT MODE: ANIMATION
	
	public void resetShapeList(boolean firstFrame){
		if (firstFrame)
			setupList.addAll(shapeList);
		else
			shapeList.retainAll(setupList);
	}
	
	private class DrawCanvas extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
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

	@Override
	public void mouseClicked(MouseEvent e) {
		eventQ.add(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		eventQ.add(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		eventQ.add(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		eventQ.add(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		eventQ.add(e);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		eventQ.add(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		eventQ.add(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		eventQ.add(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public Queue<InputEvent> getEventQ() {
		return eventQ;
	}


}