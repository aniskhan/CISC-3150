/*
Question 2: 
In a loop, read radiuses from a user. Calculate the area of a circle using 
the formula PI*r^2. Use the pow function, and the PI constant in the Math 
class. Pick your data types wisely. Exit when the user sends EOF (either 
ctrl-d, or ctrl-z depending on your operating system). Show your output.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math; // do I need this if I explicitly call Math?

public class Main {

	public static void main(String[] args) {
	//BufferedReader/InputStreamReader/IO Exception portions adapted from:
    	//https://stackoverflow.com/questions/4644415/java-how-to-get-input-from-system-console
    	
	   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	   start://  
	   while (true) {
		   
		   Double circleRadius = null;
		   Double circleArea = null;
		   System.out.print("Enter a circle radius (numeric value only): ");
		try {
			circleRadius = Double.parseDouble(reader.readLine());
		} catch (NumberFormatException | IOException ex) {
			System.err.println("Hey! Numbers only... \n"); // System.err makes it print in red :)
			continue start;	
		}
			circleArea = Math.PI * (Math.pow(circleRadius, 2)); // https://www.tutorialspoint.com/java/lang/math_pow.htm
    	    		System.out.println("Your radius: " + circleRadius);
    	    		System.out.println("... means your circle has an area of: " + circleArea + "\n");
	   }

	}
}
