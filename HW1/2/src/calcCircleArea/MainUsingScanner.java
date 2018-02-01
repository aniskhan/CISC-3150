/*
Question 2: 
In a loop, read radiuses from a user. Calculate the area of a circle using 
the formula PI*r^2. Use the pow function, and the PI constant in the Math 
class. Pick your data types wisely. Exit when the user sends EOF (either 
ctrl-d, or ctrl-z depending on your operating system). Show your output.

package calcCircleArea;
import java.util.Scanner;
import java.lang.Math; // do I need this if I explicitly call Math?

public class MainUsingScanner {


	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	   start://  entry point for restart
	   while (true) {
		   Double circleRadius = null;
		   Double circleArea = null;
		   System.out.print("Enter a circle radius (numeric value only): ");
		   while (scanner.hasNextLine()) {
			   String input = scanner.nextLine();
			   try {
				circleRadius = Double.parseDouble(input);
			} catch (NumberFormatException ex) {
				System.err.println("Hey! Numbers only.. \n"); // System.err makes it print in red :)
				continue start;	
			}
				circleArea = Math.PI * (Math.pow(circleRadius, 2)); // https://www.tutorialspoint.com/java/lang/math_pow.htm
	    	    System.out.println("Your radius: " + circleRadius);
	    	    System.out.println("... means your circle has an area of: " + circleArea + "\n");
	    	    scanner.close();
		   }
	   }
		   }

}



*/