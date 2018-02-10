/*Question 6: 
Write a program that prompts the user to enter the center coordinates and 
radiuses of two circles. Determine whether the circles are separate from 
each other, touching each other, overlapping each other, or completely 
within one another. Test each case and show the output.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
	static Map <Integer, myCircle> myCirlcesMap =  new HashMap<Integer, myCircle>();
	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("Enter center coordinate / radius [x,y,r] for circle "
					+ i + ":");
			if (parseStoreInput(i)) {
				i++;
			} else {
				System.err.println("Unable to parse input. "
						+ "Enter three numeric values, separated by a comma.");
				continue;
			}
		} while (i <= 2);
		analyzeCircles();

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
					myCirlcesMap.put(intCircleID, new myCircle(arrayInput[0], arrayInput[1], arrayInput[2]));
				}catch (NumberFormatException e){
					return false;
				}
			}
		} catch (IOException e){
			return false;
			
		}
		return true;
	}
	
	public static void analyzeCircles(){
		Double xDiff = myCirlcesMap.get(2).getX()-myCirlcesMap.get(1).getX();
		Double yDiff = myCirlcesMap.get(2).getY()-myCirlcesMap.get(1).getY();
		Double distCircles = Math.sqrt((Math.pow(xDiff, 2))+ (Math.pow(yDiff, 2)));
		
		Boolean isTouching = false;
		Boolean isOverlapping = false;
		Boolean isCirc1InCirc2 = false;
		Boolean isCirc2InCirc1 = false;
		if (distCircles <= myCirlcesMap.get(1).getRadius() + myCirlcesMap.get(2).getRadius()) {
			isTouching = true;
			if (distCircles < myCirlcesMap.get(1).getRadius() + myCirlcesMap.get(2).getRadius()) {
				isOverlapping = true;
				if (distCircles < myCirlcesMap.get(2).getRadius() &&
				(myCirlcesMap.get(1).getRadius()) < myCirlcesMap.get(2).getRadius()){
					isCirc1InCirc2 = true;
				} else if(distCircles < myCirlcesMap.get(1).getRadius() &&
						(myCirlcesMap.get(2).getRadius()) < myCirlcesMap.get(1).getRadius()){
					isCirc2InCirc1 = true;
				}
				
			}
		}
		
		System.out.println("Circles Touching?: " + isTouching);
		System.out.println("Circles Overlapping?: " + isOverlapping);
		System.out.println("Circle 1 in circle 2?: " + isCirc1InCirc2);
		System.out.println("Circle 2 in circle 1?: " + isCirc2InCirc1);
		
		
		
		
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
