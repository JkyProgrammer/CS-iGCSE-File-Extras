import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print ("Enter your age: ");
		int age = Integer.parseInt (in.nextLine());
		int lessonsNeeded = 20;
		
		if (age > 18) {
			lessons += ((age - 18) * 2)
		}

		System.out.println ("You will need ", lessonsNeeded, " lessons.");
	}
}