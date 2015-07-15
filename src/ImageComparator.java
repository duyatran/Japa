import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utility to compare two images and verify if the are equal to the human eye, or not. See the
 * {@link Mode} enumeration for comparison modes. The image comparison logic has been ported to Java
 * from Resemble.js, https://github.com/Huddle/Resemble.js
 * 
 * @author Andrea Aime - GeoSolutions
 * 
 */
public class ImageComparator {

    public enum Mode {
        /**
         * Checks if the images are equal taking into account the full color and all pixels. Some
         * light difference between the two images is still being tolerated
         */
        IgnoreNothing,
        /**
         * Same as above, but if a pixel is found to be anti-aliased, only brightness will be
         * compared, instead of the full color component
         */
        IgnoreAntialiasing,
        /**
         * Ignores the colors and compares only the brightness
         */
        IgnoreColors
    };

    final class Pixel {
        int r;
        int g;
        int b;
        int a;

        private int brightness;
        private double hue;
        public Pixel() {
        }

        public void init(int[] px) {
            if (bands < 2) {
                r = g = b = px[0];
                if (bands == 2) {
                    a = px[1];
                } else {
                    a = 255;
                }
            } else {
                r = px[0];
                g = px[1];
                b = px[2];
                if (bands == 4) {
                    a = px[3];
                } else {
                    a = 255;
                }
            }
            brightness = Integer.MIN_VALUE;
            hue = Double.NaN;
        }

        int getBrightness() {
            if (brightness == Integer.MIN_VALUE) {
                brightness = (int) Math.round(0.3 * r + 0.59 * g + 0.11 * b);
            }
            return brightness;
        }

        double getHue() {
            if (hue == Double.NaN) {
                double r = this.r / 255d;
                double g = this.g / 255d;
                double b = this.b / 255d;
                double max = Math.max(r, Math.max(g, b));
                double min = Math.min(r, Math.max(g, b));

                if (max == min) {
                    hue = 0; // achromatic
                } else {
                    double d = max - min;
                    if (max == r) {
                        hue = (g - b) / d + (g < b ? 6 : 0);
                    } else if (max == g) {
                        hue = (b - r) / d + 2;
                    } else {
                        hue = (r - g) / d + 4;
                    }
                    hue /= 6;
                }
            }
            return hue;
        }

        public boolean isRGBSame(Pixel other) {
            if (a != other.a) {
                return false;
            }
            if (b != other.b)
                return false;
            if (g != other.g)
                return false;
            if (r != other.r)
                return false;
            return true;
        }

        public boolean isSimilar(Pixel other) {
            return isColorSimilar(r, other.r, RED) && //
                    isColorSimilar(g, other.g, GREEN) && //
                    isColorSimilar(b, other.b, BLUE) && //
                    isColorSimilar(a, other.a, ALPHA);
        }

        public boolean isConstrasting(Pixel other) {
            return Math.abs(getBrightness() - other.getBrightness()) > tolerance[MAX_BRIGHTNESS];
        }

        private boolean isColorSimilar(int a, int b, int color) {
            final int diff = Math.abs(a - b);
            return diff == 0 || diff < tolerance[color];
        }

        public boolean isBrightnessSimilar(Pixel other) {
            return isColorSimilar(a, other.a, ALPHA)
                    && isColorSimilar(getBrightness(), other.getBrightness(), MIN_BRIGHTNESS);
        }

        public boolean hasDifferentHue(Pixel cursor) {
            return Math.abs(getHue() - cursor.getHue()) > 0.3;
        }

        @Override
        public String toString() {
            return "Pixel [r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + "]";
        }
    }

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static final int ALPHA = 3;
    static final int MIN_BRIGHTNESS = 4;
    static final int MAX_BRIGHTNESS = 5;
    int[] tolerance = new int[MAX_BRIGHTNESS + 1];

    Mode mode;
    long mismatchCount = 0;
    double mismatchPercent;
    int bands;

    public ImageComparator(Mode mode, BufferedImage image1, BufferedImage image2) {

        int height = image1.getHeight();
        int width = image1.getWidth();
        if (width != image2.getWidth() || height != image2.getHeight()) {
            mismatchCount = Integer.MAX_VALUE;
            mismatchPercent = 1d;
            return;
        }

        this.bands = image1.getSampleModel().getNumBands();
        final boolean hasAlpha = image1.getColorModel().hasAlpha();
        if (bands > 4 || (bands == 2 && !hasAlpha) || (bands == 3 && hasAlpha)) {
            throw new IllegalArgumentException(
                    "Images have the wrong type, this code only supports gray, gray/alpha, "
                            + "RGB, RGBA images, or images that can be transformed in those models");
        }
        
        this.mode = mode;
        switch (mode) {
        case IgnoreNothing:
            tolerance[RED] = 16;
            tolerance[GREEN] = 16;
            tolerance[BLUE] = 16;
            tolerance[ALPHA] = 16;
            tolerance[MIN_BRIGHTNESS] = 16;
            tolerance[MAX_BRIGHTNESS] = 240;
            break;
        case IgnoreAntialiasing:
            tolerance[RED] = 32;
            tolerance[GREEN] = 32;
            tolerance[BLUE] = 32;
            tolerance[ALPHA] = 128;
            tolerance[MIN_BRIGHTNESS] = 64;
            tolerance[MAX_BRIGHTNESS] = 98;
            break;
        case IgnoreColors:
            tolerance[ALPHA] = 16;
            tolerance[MIN_BRIGHTNESS] = 16;
            tolerance[MAX_BRIGHTNESS] = 240;
            break;
        }

        computeDifference(image1, image2);
        mismatchPercent = mismatchCount * 1d / (width * image2.getHeight());
    }

    public double getMismatchPercent() {
        return mismatchPercent;
    }

    public long getMismatchCount() {
        return mismatchCount;
    }

    void computeDifference(BufferedImage image1, BufferedImage image2) {
        int[] components = new int[bands];
        Pixel px1 = new Pixel();
        Pixel px2 = new Pixel();

        final int width = image1.getWidth();
        final int height = image1.getHeight();
        int[] pixels1 = new int[width * height];
        int[] pixels2 = new int[width * height];
        PixelGrabber pg1 = new PixelGrabber(image1, 0, 0, width, height, pixels1, 0, width);
        PixelGrabber pg2 = new PixelGrabber(image2, 0, 0, image2.getWidth(), image2.getHeight(),
        		pixels2, 0, width);
        
        try {
			pg1.grabPixels();
			pg2.grabPixels();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        Pixel cursor = new Pixel();
        for (int r = 0; r < height; r++) {
        	for (int c = 0; c < width; c++) {
        		
        		int pixel1ARGB = pixels1[r * width + c];
        		components[3] = (pixel1ARGB >> 24) & 0xff;
        		components[0]   = (pixel1ARGB >> 16) & 0xff;
        		components[1] = (pixel1ARGB >>  8) & 0xff;
        		components[2]  = (pixel1ARGB      ) & 0xff;
        		//                    it1.getPixel(c, r, components);
        		px1.init(components);

        		int pixel2ARGB = pixels2[r * width + c];
        		components[3] = (pixel2ARGB >> 24) & 0xff;
        		components[0]   = (pixel2ARGB >> 16) & 0xff;
        		components[1] = (pixel2ARGB >>  8) & 0xff;
        		components[2]  = (pixel2ARGB      ) & 0xff;
        		//it2.getPixel(c, r, components);
        		px2.init(components);

        		if (mode == Mode.IgnoreColors) {
        			if (!px1.isBrightnessSimilar(px2)) {
        				mismatchCount++;
        			}
        		} else if (!px1.isSimilar(px2)) {
        			if (mode == Mode.IgnoreAntialiasing) {
        				if (isAntialised(px1, pixels1, r, c, width, height, components, cursor)
        						|| isAntialised(px2, pixels2, r, c, width, height, components,
        								cursor)) {
        					if (!px1.isBrightnessSimilar(px2)) {
        						mismatchCount++;
        					}
        				} else {
        					mismatchCount++;
        				}
        			} else {
        				mismatchCount++;
        			}
        		}
        	}
        }
    }

    private boolean isAntialised(Pixel source, int[] pixels, int row, int col, int width,
            int height, int[] components, Pixel cursor) {
        final int DISTANCE = 1;

        int highContrastSibling = 0;
        int siblingWithDifferentHue = 0;
        int equivalentSibling = 0;

        final int rowMin = Math.max(row - DISTANCE, 0);
        final int rowMax = Math.min(row + DISTANCE, width);
        final int colMin = Math.max(col - DISTANCE, 0);
        final int colMax = Math.min(col + DISTANCE, height);
        for (int c = colMin; c < colMax; c++) {
            for (int r = rowMin; r < rowMax; r++) {
                if (c == col && r == row) {
                    // ignore source pixel
                    continue;
                } else {
                	int pixelARGB = pixels[r * colMax + c];
            		components[3] = (pixelARGB >> 24) & 0xff;
            		components[0]   = (pixelARGB >> 16) & 0xff;
            		components[1] = (pixelARGB >>  8) & 0xff;
            		components[2]  = (pixelARGB      ) & 0xff;
                    cursor.init(components);

                    if (source.isRGBSame(cursor)) {
                        equivalentSibling++;
                    } else if (source.isConstrasting(cursor)) {
                        highContrastSibling++;
                    }

                    if (source.hasDifferentHue(cursor)) {
                        siblingWithDifferentHue++;
                    }

                    if (siblingWithDifferentHue > 1 || highContrastSibling > 1) {
                        return true;
                    }
                }
            }
        }

        if (equivalentSibling < 2) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
    	String image1 = "./student11/processing.png";
    	String image2 = "./student11/japa.png";
    	
    	BufferedImage pic1 = ImageIO.read(new File(image1));
    	BufferedImage compatibleImage1 = new BufferedImage(pic1.getWidth(), pic1.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g1 = (Graphics2D) compatibleImage1.createGraphics();
		g1.drawImage(pic1, 0, 0, null);
		
    	BufferedImage pic2 = ImageIO.read(new File(image2));
    	BufferedImage compatibleImage2 = new BufferedImage(pic2.getWidth(), pic2.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) compatibleImage2.createGraphics();
		g2.drawImage(pic2, 0, 0, null);


    	ImageComparator ic = new ImageComparator(Mode.IgnoreNothing, compatibleImage1, compatibleImage2);
    	System.out.println(ic.getMismatchPercent());
    	System.out.println(ic.getMismatchCount());
    }
}