import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		int testScore = Integer.parseInt (in.nextLine());
		
		String result;

		if (testScore >= 80) {
			result = "A";
		} else if (testScore >= 70) {
			result = "B";
		} else if (testScore >= 60) {
			result = "C";
		} else if (testScore > 0) {
			result = "D";
		} else {
			result = "FAIL";
		}

		System.out.println (result);
	}
}