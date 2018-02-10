/*Question 6: 
Write a program that prompts the user to enter the center coordinates and 
radiuses of two circles. Determine whether the circles are separate from 
each other, touching each other, overlapping each other, or completely 
within one another. Test each case and show the output.*/

package isCirclesTouching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
	static Map <Integer, myCircle> mapCircles =  new HashMap<Integer, myCircle>();
	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("Enter [x,y,r] center coordinate / radius for circle ["
					+ i + "]:");
			if (parseStoreInput(i)) {
				i++;
			} else {
				System.err.println("Unable to parse input. "
						+ "Enter three numeric values, separated by a comma.");
				continue;
			}
		} while (i <= 2); 

	}
	public static boolean parseStoreInput(int intCircleID) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] tempArray = reader.readLine().split(",");
			if (tempArray.length != 3) {
				return false;
			}
			Double[] arrayInput = new Double [tempArray.length];
			for (int i = 0; i < tempArray.length; i++) {
				try {
					arrayInput[i] = Double.parseDouble(tempArray[i]);
					mapCircles.put(intCircleID, new myCircle(arrayInput[0], arrayInput[1], arrayInput[2]));
				}catch (NumberFormatException e){
					return false;
				}
			}
		} catch (IOException e){
			return false;
			
		}
		return true;
		
	}
	
    static class myCircle {
	Double x;
    Double y;
    Double r;
    public myCircle (Double x, Double y, Double r) { //setter
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public Double getRadius() {
        return r;
    }
}
}
