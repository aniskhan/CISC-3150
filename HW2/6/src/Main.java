import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter a String:");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(""); // how is this not "." ?!!
		//https://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner; user:hoat4
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

}
