import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		int number1 = Integer.parseInt (in.nextLine());
		int number2 = Integer.parseInt (in.nextLine());
		
		double result1 = number1 / number2;
		double result2 = number1 % number2;
		int result3 = Math.floor (number1 / number2);

		System.out.println (result1);
		System.out.println (result2);
		System.out.println (result3);
	}
}