/*Question 4:
Feed a file that contains numbers into your program using command line 
redirection. Have your program read & print the file on the screen.*/


package readFilePrintToScreen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("You must provide a file path.");
			System.exit(1);
		}
		String strFilePath = args[0].toString(); // takes an arg from command line
		File someFile = new File(strFilePath);
		try {
			Scanner fileScanner = new Scanner(someFile);
			while (fileScanner.hasNext()){
				System.out.println(fileScanner.next().toString());
			}
			fileScanner.close();
			System.exit(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}
	



