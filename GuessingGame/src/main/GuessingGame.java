package main;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Random r = new Random ();
		Scanner s = new Scanner (System.in);
		int randomNum = r.nextInt(6) + 1;
		System.out.println("I have chosen a random number. Now you must guess it.");
		
		while (true) {
			System.out.print("Enter a number between 1 and 6: ");
			try {
				int userInput = Integer.parseInt(s.nextLine());
				if (userInput > 6 || userInput < 1) {
					System.out.println ("Make sure your guess is between 1 and 6.");
				} else {
					if (userInput == randomNum) {
						System.out.println ("Well done! You guessed my number.");
						break;
					} else {
						System.out.println ("Wrong. Try again.");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println ("Please enter a valid number.");
			}
		}
		s.close();
	}
}
