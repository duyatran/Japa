import java.awt.Color;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * MyColor.java
 * Purpose: A class that handles color.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */
public class MyColor {
	private boolean PROCESSING = true;
	private int colorMode = Consts.RGB;
	private Color completeColor;
	private double max1;
	private double max2;
	private double max3;
	private double maxA;
	
	public MyColor(){
		setDefaultValues();
	}

	private void setDefaultValues(){
		if (PROCESSING) {
			this.max1 = 255;
			this.max2 = 255;
			this.max3 = 255;
			this.maxA = 255;
		}
		else {
			if (colorMode == Consts.RGB) {
				this.max1 = 255;
				this.max2 = 255;
				this.max3 = 255;
				this.maxA = 100;
			}
			else if (colorMode == Consts.HSB) {
				this.max1 = 360;
				this.max2 = 100;
				this.max3 = 100;
				this.maxA = 100;
			}
		}
	}

    public Color calc(double gray){
    	return calc(gray, maxA);
    }
    
    public Color calc(double gray, double alpha){
    	return calc(gray, gray, gray, alpha);
    }
    
    public Color calc(double v1, double v2, double v3){
    	return calc(v1, v2, v3, maxA);
    }
    
    public Color calc(double v1, double v2, double v3, double alpha){
    	if (v1 > max1) v1 = max1;
    	if (v2 > max2) v2 = max2;
    	if (v3 > max3) v3 = max3;
    	if (alpha > maxA) alpha = maxA;

        if (v1 < 0) v1 = 0;
        if (v2 < 0) v2 = 0;
        if (v3 < 0) v3 = 0;
        if (alpha < 0) alpha = 0;
        
    	double x = v1/max1;
    	double y = v2/max2;
    	double z = v3/max3;
    	double a = alpha/maxA;
    	
    	if (colorMode == Consts.RGB) {
			completeColor = new Color((float)x,(float)y,(float)z,(float)a);
		}
		else if (colorMode == Consts.HSB){
			float floatx = (float) x;
			float floaty = (float) y;
			float floatz = (float) z;
	    	Color temp = Color.getHSBColor(floatx,floaty,floatz);
			float r = temp.getRed()/255.0f;
			float g = temp.getGreen()/255.0f;
			float b = temp.getBlue()/255.0f;
			
			completeColor = new Color(r, g, b, (float)a);
		}
    	return completeColor;
    }
    
    public void setColorMode(int mode){
    	colorMode = mode;
    	setDefaultValues();
    }
    
    public void setColorMode(int mode, double max){
        colorMode = mode;
    	this.max1 = max;
        this.max2 = max;
        this.max3 = max;
    }
    
    public void setColorMode(int mode, double max1, double max2, double max3){
    	colorMode = mode;
    	this.max1 = max1;
        this.max2 = max2;
        this.max3 = max3;
    }
    
    public void setColorMode(int mode, double max1, double max2, double max3, double maxA){
    	colorMode = mode;
    	this.max1 = max1;
        this.max2 = max2;
        this.max3 = max3;
        this.maxA = maxA;
    }
}
