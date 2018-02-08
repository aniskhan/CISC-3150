import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) {
		// take a param directly from console
		BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = sysReader.readLine();
			System.out.println("Repeat Back: " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}