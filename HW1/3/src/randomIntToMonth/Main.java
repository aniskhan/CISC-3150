/*Question 3:
Write a program that randomly generates an integer between 1 & 12, and 
displays the English name of that month. Run the program & show the 
output.
*/
package randomIntToMonth;
import java.text.DateFormatSymbols;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random randInt = new Random() ; //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		randInt.setSeed(System.currentTimeMillis());
		Integer randMonthNumber = randInt.nextInt(11); //zero-based
		Integer displayMonthNumber = randMonthNumber + 1; // only adding 1 for display purposes
		String[] months = new DateFormatSymbols().getMonths(); //https://stackoverflow.com/questions/14832151/how-to-get-month-name-from-calendar
		String strMonthName = months[randMonthNumber]; // array is zero-based
		System.out.println("Your random month number is: " + displayMonthNumber +"..." + strMonthName);
	}

}
