package main;

import java.util.Random;
import java.util.Scanner;

public class DiceGuesser {	
	public static void v1 () {
		int diceRoll = ((new Random ()).nextInt (6)) + 1;
		System.out.print ("Guess the number on the hypothetical dice: ");
		Scanner s = new Scanner (System.in);
		int input = Integer.parseInt (s.nextLine ());
		while (input != diceRoll) {
			System.out.print ("Incorrect! Try again: ");
			input = Integer.parseInt (s.nextLine ());
		}
		System.out.println ("Well done, that's correct!");
	}
	
	public static void v2 () {
		int diceRoll = ((new Random ()).nextInt (6)) + 1;
		System.out.print ("Guess the number on the hypothetical dice: ");
		Scanner s = new Scanner (System.in);
		int input;
		do {
			input = Integer.parseInt (s.nextLine ());
			if (input != diceRoll)
				System.out.print ("Incorrect! Try again: ");
			
		} while (input != diceRoll);
		System.out.println ("Well done, that's correct!");
	}
}
