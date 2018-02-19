import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter a String:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int lenInput = input.length();
		char[] charArray = input.toCharArray();
		for (int i = 0; i < lenInput/2; i++) {
			char head = charArray[i];
			char tail = charArray[charArray.length - i -1];
			if (head == tail) {
				continue;
			} else {
				System.out.println("Not a palidrome.");
				System.exit(0);
			}
		}
		System.out.println("Yay a palidrome!");
		sc.close();
	}
}
