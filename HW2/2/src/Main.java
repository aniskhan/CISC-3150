import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			System.out.println("Enter the year, comma, and beginning weekday-number to print your calendar (ex. '2017,1')");
			Scanner input = new Scanner(System.in);
			try {
				input.useDelimiter("\\D"); // can't figure out how to take comma
				int inputYear = input.nextInt();
				int inputFirstDay = input.nextInt();
				//System.out.println(inputYear);
				//System.out.println(inputFirstDay);
				String[] months = new DateFormatSymbols().getMonths(); //https://kodejava.org/how-do-i-get-a-list-of-month-names/
				
				//DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US); 
				//LocalDate date = LocalDate.parse(dateString, dateFormat);
				//LocalDate newDate = date.withDayOfMonth(date.getMonth().maxLength());
				//System.out.println(newDate);
		        for (int intMonth = 0; intMonth <= 11; intMonth++) {
		        	//Integer formattedintMonth = ();
		        	String dummyDateString = intMonth + 1+"/01/"+inputYear; //every month has a first!
		        	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/dd/yyyy", Locale.US); 
		        	LocalDate date = LocalDate.parse(dummyDateString, dateFormat);
		        	int ctMonthDays = date.lengthOfMonth(); // this handles leap years
		        	
		            System.out.println(months[intMonth] +" "+ inputYear+ " "+ ctMonthDays);  
		        }
			}
			catch(InputMismatchException e) {
				System.out.println("Bad Input");
			}
			input.close();
	}
}
