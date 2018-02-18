
import java.util.InputMismatchException;
import java.util.Scanner;


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
 
 The above example should be conceptualized as:

-2 -1  0  1  0 -1 -2 
-1  0  1  2  1  0 -1 
 0  1  2  3  2  1  0 
 1  2  3  4  3  2  1 
 
 From here it's simple to see that in order to hold the pyramid, you need a matrix with n rows,
 where n = height + (height-1) AND that each row has a seed (starting point) relative to x / y.
 The values count up from that seed to the center of the pyramid, then decreases. 
 
 To display the pyramid, you can simply print to console if the value is greater than 0.
 * 
 * */

class Main {
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
			System.out.println("How tall would you like your pyramid to be?");
			try{
				Integer pyramidHeight = input.nextInt();
				int rCount = pyramidHeight;
				int kCount = pyramidHeight + (pyramidHeight- 1); // how many columns needed
				String printWidth = "%" + pyramidHeight.toString().length() + "s";
				for (int r = 1; r <= rCount; r++) {
					Integer seed = (-rCount+1+r); // this is the number each row should begin at in terms of x
					System.out.println(); //move cursor for next row
					for (int k = 1; k <= kCount; k++){
						if(seed > 0) { // if value is a part of printable pyramid
							 System.out.printf(printWidth,seed.toString());				 
						 } else {
							 System.out.printf(printWidth,"");	
						 }
						 //increment based on which side of pyramid we are on
						 if(k < pyramidHeight) { //pyramidHeight = center column; intentionally do not want to increment at centerColIndex
							 seed++;
						 } else {
							 seed--;					  
						 }
					}
				}
			}
			catch (InputMismatchException e){
				System.err.println("Unable to parse input. "
						+ "Enter a positive whole number.");
			}
			input.close();
	}
}