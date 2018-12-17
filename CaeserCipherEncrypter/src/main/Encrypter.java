package main;

import java.util.Scanner;

public class Encrypter {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		System.out.print("Enter plain text to encrypt: ");
		String input = s.nextLine();
		System.out.print("Enter an integer to use as a shift key: ");
		int inputKey = Integer.parseInt (s.nextLine());
		
		String cipherText = encrypt (input, inputKey);
		System.out.println(cipherText);
	}
	
	public static String encrypt (String plainText, int shiftKey) {
		String cipherText = "";
		
		for (char c : plainText.toCharArray()) {
			if (c == '.' || c == ' ') {
				cipherText += c;
			} else {
				int chr = (int) c;
				chr += shiftKey;
				char chrr = (char) chr;
				cipherText += chrr;
			}
		}
		
		return cipherText;
	}

}
