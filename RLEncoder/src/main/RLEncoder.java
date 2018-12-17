package main;

import java.util.Scanner;

public class RLEncoder {
	public static void main (String[] args) {
		Scanner s = new Scanner (System.in);
		String text = s.nextLine();
		String encoded = RLEncoder.encode(text);
		System.out.println(encoded);
		s.close();
	}
	
	public static String encode (String inputText) {
		char searchChar;
		String outString = "";
		int length = inputText.length();
		
		// Breaks if contains numerical character
		
		if (length < 1) {
			System.out.println("You need to enter valid input text.");
			return "";
		} else if (length == 1) {
			outString += 1 + charToString (inputText.charAt(0));
		}
		
		int run = 0;
		searchChar = inputText.charAt(0);
		for (int index = 0; index < length; index++) {
			if (inputText.charAt(index) == searchChar) {
				run++;
			} else {
				if (run > 1)
					outString += run + charToString (searchChar);
				else 
					outString += charToString (searchChar);
				run = 1;
				searchChar = inputText.charAt(index);
			}
		}
		outString += run + charToString (searchChar);
		return outString;
	}
	
	private static String charToString (char c) {
		return String.valueOf(c);
	}
}
