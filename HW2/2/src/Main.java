import java.util.InputMismatchException;
import java.util.Scanner;

/*Question 2: 
Write a program that displays a calendar on the screen. It asks the user 
the year, what day the first of January fell on, then displays every month 
from January to December. Make sure to get the leap years and the number 
of days in each month right. Your months should resemble the following 
format:

   February 2015      
Su Mo Tu We Th Fr Sa  
 1  2  3  4  5  6  7  
 8  9 10 11 12 13 14  
15 16 17 18 19 20 21  
22 23 24 25 26 27 28 */


public class Main {
	public static void main(String[] args) {
			System.out.println("Enter the year, comma, and beginning weekday-number to print your calendar (ex. '2017,1')");
			Scanner input = new Scanner(System.in);
			try {
				int inputYear = input.nextInt();
				int inputFirstDay = input.nextInt();
			}
			catch(InputMismatchException e) {
				
			}

	}
}
