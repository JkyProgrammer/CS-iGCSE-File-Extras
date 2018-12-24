package main;

import java.util.Scanner;

public class PasswordStrengthChecker {

	public static void main(String[] args) {
		System.out.print("Enter a password: ");
		Scanner s = new Scanner (System.in);
		String password = s.nextLine();
		int strength = returnStrength (password);
		String[] strengths = {"very weak", "quite weak", "quite strong", "very strong"};
		System.out.println("That password is " + strengths[strength]);
	}
	
	private static String symbols = "!@£$%^&*()_+=-,./<>?'\"|[]{}`~§±";
	private static String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String lowercase = "abcdefghijklmnopqrstuvwxyz";
	
	private static boolean containsSymbol (String password) {
		boolean contains = false;
		for (int i = 0; i < symbols.length(); i++) {
			if (password.contains(String.valueOf(symbols.charAt(i)))) {
				contains = true;
			}
		}
		return contains;
	}
	
	private static boolean containsUppercase (String password) {
		boolean contains = false;
		for (int i = 0; i < uppercase.length(); i++) {
			if (password.contains(String.valueOf(uppercase.charAt(i)))) {
				contains = true;
			}
		}
		return contains;
	}
	
	private static boolean containsLowercase (String password) {
		boolean contains = false;
		for (int i = 0; i < lowercase.length(); i++) {
			if (password.contains(String.valueOf(lowercase.charAt(i)))) {
				contains = true;
			}
		}
		return contains;
	}
	
	public static int returnStrength (String password) {
		boolean containsBothCases = (containsUppercase (password) && containsLowercase (password));
		boolean isLongerThanSeven = (password.length() > 7);
		boolean containsSymbolChr = (containsSymbol (password));
		
		int numSatisfiedConstraints = (containsBothCases ? 1 : 0) + (isLongerThanSeven ? 1 : 0) + (containsSymbolChr ? 1 : 0);
		return numSatisfiedConstraints;
	}

}
