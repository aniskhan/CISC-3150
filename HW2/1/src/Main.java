import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Question 1:
Write a program that asks the user how tall of a pyramid do they want to 
display on the screen, and then displays the pyramid that counts up on the 
left, and counts down on the right. For eg, if the user enters 4, the 
program shows:

        1
      1 2 1
    1 2 3 2 1
  1 2 3 4 3 2 1*/
  

class Main {
	static int pyramidHeight = 0;
	static int rowCount;
	static int colCount;
	static int [][] matrix;
	static int centerColIndex;
	public static void main(String[] args) {	
		while(true) {
			System.out.println("How tall would you like your pyramid to be?");
			if (parseStoreInput()) {
				///continue;
				matrix = new int[rowCount][colCount];
				populatePyramid();
				printMatrix();
			} else {
				System.err.println("Unable to parse input. "
						+ "Enter a positive whole number.");
				continue;
			}
		}
	}
	public static boolean parseStoreInput() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer input = Integer.parseUnsignedInt(reader.readLine());
			pyramidHeight = input; // pyramid height
			rowCount = pyramidHeight + (pyramidHeight- 1); // how many rows needed in each array?
			colCount = rowCount; //b/c it's a square
			centerColIndex = pyramidHeight- 1; //adjusted for 0-indexed array
		} catch (IOException | NumberFormatException e){
			return false;
		}
		return true;
	}
	public static void populatePyramid() {
		for (int x = 0;x < matrix.length; x++) {
			int seed = pyramidHeight - (2*pyramidHeight) +x; // 
			 for (int y = 0; y < matrix.length; y++) {
				 //determine which side of pyramid we are one
				 if(y <= centerColIndex) {
					 if(seed > 0) {
						 matrix[x][y] = seed;						 
					 }
					 seed++;
				 }else {
					 seed--;
					 if(seed > 0) {
						 matrix[x][y] = seed;						 
					 } 
				 }
			 }			
		}
	}
	public static void printMatrix() {
		for (int x = 0; x < matrix.length; x++) {
		    for (int y = 0; y < matrix.length; y++) {
		        System.out.print(matrix[x][y] + " ");
		    }
		    System.out.println();
		}
	}
}
