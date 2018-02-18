import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter a String:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(input);

		sc.close();
	}

}
