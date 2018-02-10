/*Question 6: 
Write a program that prompts the user to enter the center coordinates and 
radiuses of two circles. Determine whether the circles are separate from 
each other, touching each other, overlapping each other, or completely 
within one another. Test each case and show the output.*/

package isCirclesTouching;

public class Main {

	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("Enter [x,y,r] center coordinate / radius for circle ["
					+ i + "]:");
			i++;
		} while (i <= 2); 

	}

}
