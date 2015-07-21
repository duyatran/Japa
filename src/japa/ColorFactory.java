package japa;
/**
 * Summer 2015 - Processing-inspired Java Graphics Library
 * ColorFactory.java
 * Purpose: A class that handles color.
 *
 * @author Duy Tran
 * @version 1.0 6/10/2015
 */

import java.awt.Color;

public class ColorFactory {
	private boolean PROCESSING = true; // Using Processing's convention for
										// default values
	private int colorMode = Consts.RGB;
	private Color finalColor; // the final color to be returned
	private float max1;
	private float max2;
	private float max3;
	private float maxA;

	public ColorFactory() {
		setDefaultValues();
	}

	/**
	 * Sets the default maximum value for ranges of color components.
	 */
	private void setDefaultValues() {
		// Processing sets all components' max to 255
		// This library sets (255, 255, 255, 100) for RBG
		// and (360, 100, 100, 100) for HSB.
		if (PROCESSING) {
			this.max1 = Consts.DEFAULT_RGB;
			this.max2 = Consts.DEFAULT_RGB;
			this.max3 = Consts.DEFAULT_RGB;
			this.maxA = Consts.DEFAULT_RGB;
		} else {
			if (colorMode == Consts.RGB) {
				this.max1 = Consts.DEFAULT_RGB;
				this.max2 = Consts.DEFAULT_RGB;
				this.max3 = Consts.DEFAULT_RGB;
				this.maxA = Consts.DEFAULT_ALPHA;
			} else if (colorMode == Consts.HSB) {
				this.max1 = Consts.DEFAULT_HUE;
				this.max2 = Consts.DEFAULT_SATURATION;
				this.max3 = Consts.DEFAULT_BRIGHTNESS;
				this.maxA = Consts.DEFAULT_ALPHA;
			}
		}
	}

	/**
	 * This method computes the final color depending on the color mode and
	 * maximum values.
	 * 
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param alpha
	 * @return the final color
	 */
	public Color produce(float v1, float v2, float v3, float alpha) {
		// clamp these values to their max or min values
		if (v1 > max1)
			v1 = max1;
		if (v2 > max2)
			v2 = max2;
		if (v3 > max3)
			v3 = max3;
		if (alpha > maxA)
			alpha = maxA;

		if (v1 < 0)
			v1 = 0;
		if (v2 < 0)
			v2 = 0;
		if (v3 < 0)
			v3 = 0;
		if (alpha < 0)
			alpha = 0;

		// for convenient usage of the Color constructor
		float x = v1 / max1;
		float y = v2 / max2;
		float z = v3 / max3;
		float a = alpha / maxA;

		// Switch between two color modes.
		// There is no direct method to create a HSB color with
		// alpha value, hence the use of temp.
		if (colorMode == Consts.RGB) {
			finalColor = new Color(x, y, z, a);
		} else if (colorMode == Consts.HSB) {
			Color temp = Color.getHSBColor(x, y, z);
			x = temp.getRed() / Consts.DEFAULT_RGB;
			y = temp.getGreen() / Consts.DEFAULT_RGB;
			z = temp.getBlue() / Consts.DEFAULT_RGB;
			finalColor = new Color(x, y, z, (float) a);
		}
		return finalColor;
	}

	/**
	 * @param gray
	 * @return
	 */
	public Color produce(float gray) {
		return produce(gray, maxA);
	}

	/**
	 * @param gray
	 * @param alpha
	 * @return
	 */
	public Color produce(float gray, float alpha) {
		return produce(gray, gray, gray, alpha);
	}

	/**
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return
	 */
	public Color produce(float v1, float v2, float v3) {
		return produce(v1, v2, v3, maxA);
	}

	/**
	 * @param mode
	 */
	public void setColorMode(int mode) {
		colorMode = mode;
		setDefaultValues();
	}

	/**
	 * @param mode
	 * @param max
	 */
	public void setColorMode(int mode, float max) {
		colorMode = mode;
		this.max1 = max;
		this.max2 = max;
		this.max3 = max;
	}

	/**
	 * @param mode
	 * @param max1
	 * @param max2
	 * @param max3
	 */
	public void setColorMode(int mode, float max1, float max2, float max3) {
		colorMode = mode;
		this.max1 = max1;
		this.max2 = max2;
		this.max3 = max3;
	}

	/**
	 * @param mode
	 * @param max1
	 * @param max2
	 * @param max3
	 * @param maxA
	 */
	public void setColorMode(int mode, float max1, float max2, float max3,
			float maxA) {
		colorMode = mode;
		this.max1 = max1;
		this.max2 = max2;
		this.max3 = max3;
		this.maxA = maxA;
	}
}
