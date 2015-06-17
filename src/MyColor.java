import java.awt.Color;

/**
 * @author Duy
 *
 */
public class MyColor extends Color {
	
	public MyColor(int rgb){
    
	}
    
    public MyColor(int rgb, double alpha) {
        canvas.stroke(rgb, alpha);
      }

    public MyColor(double gray){
        canvas.stroke(gray);
    }
    
    public MyColor(double gray, double alpha){
        canvas.stroke(gray, alpha);
    }
    
    public MyColor(double v1, double v2, double v3){
        canvas.stroke(v1,v2,v3);
    }
    
    public MyColor(double v1, double v2, double v3, double alpha){
        canvas.stroke(v1,v2,v3,alpha);
    }
	
	private void colorCalc(){}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
