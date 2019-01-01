package main;

import java.util.Scanner;

public class VerySimpleMachine {

	public static void main(String[] args) {
		Integer nums[] = {0, 0, 0};
		Scanner s = new Scanner (System.in);
		for (int x = 0; x < 3; x++) {
			System.out.print("Enter a number: ");
			Integer result = null;
			while (result == null) {
				String ss = s.nextLine();
				try {
					result = Integer.parseInt (ss);
				} catch (NumberFormatException e) {System.out.print ("Try entering again: ");}
			}
			nums[x] = result;
		}
		int sum = nums[0] + nums[1] + nums[2];
		System.out.println("The sum of those numbers is " + sum);
	}

}
