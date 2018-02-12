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
  

/*My Approach:
 For this to work efficiently, the same function must be performed on each row.
 To better visualize what's happening here, it best to treat this as a square
 matrix, while selectively printing the numbers that form the pyramid.
 
 So the above example should be conceptualized as:
-5 -4 -3 -2 -3 -4 -5 
-4 -3 -2 -1 -2 -3 -4 
-3 -2 -1  0 -1 -2 -3 
-2 -1  0  1  0 -1 -2 
-1  0  1  2  1  0 -1 
 0  1  2  3  2  1  0 
 1  2  3  4  3  2  1 
 
 From here it's simple to see that to hold the pyramid you need a matrix with n rows,
 where n = height + 2(height-1) AND that each row has a seed (starting point) relative to x / y.
 The values count up from that seed to the center of the pyramid, then decrease.
 
 To display the pyramid, you can simply assign the value to matrix or (print to console) if it is greater than 0.
 * 
 * */

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
			colCount = rowCount;
			centerColIndex = pyramidHeight- 1; //adjusted for 0-indexed array
		} catch (IOException | NumberFormatException e){
			return false;
		}
		return true;
	}
	public static void populatePyramid() {
		for (int x = 0;x < matrix.length; x++) {
			int seed = (-rowCount+2+x); // this is the number each row should begin at in terms of x
			 for (int y = 0; y < matrix.length; y++) {
				 if(seed > 0) { // only allocate if number will print
					 matrix[x][y] = seed;						 
				 }
				 //increment based on which side of pyramid we are on
				 if(y < centerColIndex) { // intentionally do not want to increment at centerColIndex
					 seed++;
				 }else {
					 seed--;					  
				 }
			 }			
		}
	}
	public static void printMatrix() {
		for (int x = 0; x < matrix.length; x++) {
		    for (int y = 0; y < matrix.length; y++) {
		    	if(matrix[x][y] != 0) {
		    		System.out.print(matrix[x][y] + " "); //TODO formatting with .printf
		    	} else {
		    		System.out.print(" " + " ");
		    	}
		    }
		    System.out.println();
		}
	}
}
