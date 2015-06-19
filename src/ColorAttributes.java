import java.awt.Color;

/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * MyColor.java
 * Purpose: A class that handles color.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */
public class ColorAttributes {
	private boolean PROCESSING = true;
	private int colorMode = Consts.RGB;
	private Color completeColor;
	private float max1;
	private float max2;
	private float max3;
	private float maxA;
	
	public ColorAttributes(){
		setDefaultValues();
	}

	private void setDefaultValues(){
		if (PROCESSING) {
			this.max1 = Consts.DEFAULT_RGB;
			this.max2 = Consts.DEFAULT_RGB;
			this.max3 = Consts.DEFAULT_RGB;
			this.maxA = Consts.DEFAULT_RGB;
		}
		else {
			if (colorMode == Consts.RGB) {
				this.max1 = Consts.DEFAULT_RGB;
				this.max2 = Consts.DEFAULT_RGB;
				this.max3 = Consts.DEFAULT_RGB;
				this.maxA = Consts.DEFAULT_ALPHA;
			}
			else if (colorMode == Consts.HSB) {
				this.max1 = Consts.DEFAULT_HUE;
				this.max2 = Consts.DEFAULT_SATURATION;
				this.max3 = Consts.DEFAULT_BRIGHTNESS;
				this.maxA = Consts.DEFAULT_ALPHA;
			}
		}
	}

    public Color calc(float gray){
    	return calc(gray, maxA);
    }
    
    public Color calc(float gray, float alpha){
    	return calc(gray, gray, gray, alpha);
    }
    
    public Color calc(float v1, float v2, float v3){
    	return calc(v1, v2, v3, maxA);
    }
    
    public Color calc(float v1, float v2, float v3, float alpha){
    	if (v1 > max1) v1 = max1;
    	if (v2 > max2) v2 = max2;
    	if (v3 > max3) v3 = max3;
    	if (alpha > maxA) alpha = maxA;

    	if (v1 < 0) v1 = 0;
        if (v2 < 0) v2 = 0;
        if (v3 < 0) v3 = 0;
        if (alpha < 0) alpha = 0;
        
    	float x = v1/max1;
    	float y = v2/max2;
    	float z = v3/max3;
    	float a = alpha/maxA;
    	
    	if (colorMode == Consts.RGB) {
			completeColor = new Color(x, y, z, a);
    	}
		else if (colorMode == Consts.HSB){
	    	Color temp = Color.getHSBColor(x, y, z);
			x = temp.getRed()/Consts.DEFAULT_RGB;
			y = temp.getGreen()/Consts.DEFAULT_RGB;
			z = temp.getBlue()/Consts.DEFAULT_RGB;
			completeColor = new Color(x, y, z, (float)a);
		}
    	return completeColor;
    }
    
    public void setColorMode(int mode){
    	colorMode = mode;
    	setDefaultValues();
    }
    
    public void setColorMode(int mode, float max){
        colorMode = mode;
    	this.max1 = max;
        this.max2 = max;
        this.max3 = max;
    }
    
    public void setColorMode(int mode, float max1, float max2, float max3){
    	colorMode = mode;
    	this.max1 = max1;
        this.max2 = max2;
        this.max3 = max3;
    }
    
    public void setColorMode(int mode, float max1, float max2, float max3, float maxA){
    	colorMode = mode;
    	this.max1 = max1;
        this.max2 = max2;
        this.max3 = max3;
        this.maxA = maxA;
    }
}
