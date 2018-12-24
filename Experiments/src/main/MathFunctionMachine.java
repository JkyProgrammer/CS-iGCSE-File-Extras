package main;

import java.util.Scanner;

public class MathFunctionMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		while (true) {
			System.out.print ("Enter an integer: ");
			int i = Integer.parseInt(s.nextLine());
			System.out.println("Calculating...");
			int result = machine1 (i);
			System.out.println("Result was " + result);
		}
	}
	
	public static int machine1 (int input) {
		int cubed = (input*input*input);
		int squared = (input*input);
		return cubed-squared;
	}
	
	// Sample table:
	// INPUT          OUTPUT (EXPECTED)  OUTPUT (REAL)
	// 0              0                  0
	// 1              0                  0
	// 2              4                  4
	// 3              18                 18
	// 4              48                 48
	// 5              100                100
	// 8              448                448
	// 10             900                900
	// 15             3150               3150

}
