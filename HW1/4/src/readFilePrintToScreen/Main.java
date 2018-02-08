/*Question 4:
Feed a file that contains numbers into your program using command line 
redirection. Have your program read & print the file on the screen.*/


package readFilePrintToScreen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		// TODO take filePath arg directly from console
		String strFilePath = "C:\\Users\\Anisa\\Documents\\CUNY\\CISC\\CISC-3150\\HW1\\4\\sampleInput\\sample_SomeNumbers.txt";
		File someFile = new File(strFilePath);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(someFile);
			while (fileScanner.hasNext()){
				System.out.println(fileScanner.next().toString());
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
	



