package main;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mn();
	}

	
	public static void mn () {
		System.out.println ("Welcome to the Calculator");
		System.out.println ("The operations you can choose from are: 'add', 'subtract', 'divide', 'multiply.");
		
		// Set up the input scanner.
		Scanner s = new Scanner (System.in);
		
		while (true) {
			// Receive the operation the user would like to perform.
			System.out.print ("Enter the operation you would like to perform: ");
			String selectedOperation = s.nextLine();
			
			// Receive the two operands as doubles.
			System.out.print ("Enter your first number operand: ");
			double op1 = Double.parseDouble(s.nextLine());
			System.out.print ("Enter your second number operand: ");
			double op2 = Double.parseDouble(s.nextLine());
			
			// Prepare the result storage.
			double result = 0d;
			boolean inputWasRecognised = true;
			
			// Handle the operation input and calculate the result accordingly.
			if (selectedOperation.equals("add")) {
				result = op1 + op2;
			} else if (selectedOperation.equals("subtract")) {
				result = op1 - op2;
			} else if (selectedOperation.equals("divide")) {
				result = op1 / op2;
			} else if (selectedOperation.equals("multiply")) {
				result = op1 * op2;
			} else {
				inputWasRecognised = false;
			}
			
			// Output the result of the calculation, if the input was recognised.
			if (inputWasRecognised) {
				System.out.println ("The result of the calculation was: " + result);
			} else {
				System.out.println ("The operation you entered was not recognised.");
			}
		}
	}
}
