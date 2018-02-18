import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.text.DateFormat;
import java.util.InputMismatchException;
import java.util.Locale;
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
			System.out.println("Enter the year, comma, and first weekday-number to print your calendar (ex. '2017,1')");
			Scanner input = new Scanner(System.in);
			try {
				input.useDelimiter("\\D"); // can't figure out how to take comma, using "not digit"
				int inputYear = input.nextInt();
				int inputFirstDay = input.nextInt();
				//adopted from: https://stackoverflow.com/questions/13624442/getting-last-day-of-the-month-in-given-string-date
		        for (int intMonth = 1; intMonth <= 12; intMonth++) {
		        	String dummyDateString = intMonth + "/01/"+inputYear; //every month has a first!
		        	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/dd/yyyy", Locale.US); 
		        	LocalDate someDate = LocalDate.parse(dummyDateString, dateFormat);
		        	int ctMonthDays = someDate.lengthOfMonth(); // this method handles leap years
		        	String monthName = someDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US);

		            System.out.println(monthName +" "+ inputYear);  
		            
		            String [] weekDayNames = new DateFormatSymbols().getShortWeekdays();
		        	for (int i= 1; i<=7;i++) {
		                System.out.printf("%4s",weekDayNames[i]); 
		                //TODO print only left, 2 of weekday
		            }
		        	System.out.println();
		        	for (int dayNumber = 1;dayNumber<=ctMonthDays;dayNumber++) {
		        		System.out.printf("%4s",dayNumber);
		        		
		        	}
		        	System.out.println();
		        }
			}
			catch(InputMismatchException e) {
				System.out.println("Bad Input");
			}
			input.close();
	}
}
