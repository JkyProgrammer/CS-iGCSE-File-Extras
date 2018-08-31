package main;

import java.util.Random;
import java.util.Scanner;

public class ParkCharge {
	
	/**
	 * Generates a pseudorandom integer between the two specified bounds inclusively. This uses the java.util.Random class to implement generating a random integer.
	 * 
	 * @param start The lower bound (inclusive) of the random.
	 * @param end The upper bound (inclusive) of the random.
	 * @return A random integer.
	 */
	
	public static int randomInt (int start, int end) {
		int initial = new Random ().nextInt((end+1)-start);
		int finall = initial + start;
		return finall;
	}
	
	public static void mn () {
		int parkCharge = randomInt (1, 20);
		int paid = 000;
		
		Scanner s = new Scanner (System.in);
		
		while (paid < parkCharge) {
			System.out.println ("The remaining charge is £" + ((double)(parkCharge - paid))/100);
			System.out.println ("Enter an amount, up to £20 maximum: ");
			int amountEntered = (int)(Double.parseDouble(s.nextLine()) * 100);
			paid += amountEntered;
			int changeDue = paid - parkCharge;
			int changeGiven = 000;
			
			while (changeDue >= 1000) {
				System.out.println ("*returns £10 note to you*");
				changeDue -= 1000;
				changeGiven += 1000;
			}
			while (changeDue >= 500) {
				System.out.println ("*returns £5 note to you*");
				changeDue -= 500;
				changeGiven += 500;
			}
			while (changeDue >= 200) {
				System.out.println ("*returns £2 coin to you*");
				changeDue -= 200;
				changeGiven += 200;
			}
			while (changeDue >= 100) {
				System.out.println ("*returns £1 coin to you*");
				changeDue -= 100;
				changeGiven += 100;
			}
			while (changeDue >= 50) {
				System.out.println ("*returns 50p coin to you*");
				changeDue -= 50;
				changeGiven += 50;
			}
			while (changeDue >= 20) {
				System.out.println ("*returns 20p coin to you*");
				changeDue -= 20;
				changeGiven += 20;
			}
			while (changeDue >= 10) {
				System.out.println ("*returns 10p coin to you*");
				changeDue -= 10;
				changeGiven += 10;
			}
			while (changeDue >= 5) {
				System.out.println ("*returns 5p coin to you*");
				changeDue -= 5;
				changeGiven += 5;
			}
			while (changeDue >= 2) {
				System.out.println ("*returns 2p coin to you*");
				changeDue -= 2;
				changeGiven += 2;
			}
			while (changeDue >= 1) {
				System.out.println ("*returns 1p coin to you*");
				changeDue -= 1;
				changeGiven += 1;
			}

			paid -= changeGiven;
		}
		s.close();
	}
}
