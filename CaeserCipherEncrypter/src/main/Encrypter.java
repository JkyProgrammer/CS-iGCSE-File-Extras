package main;

import java.util.Scanner;

public class Encrypter {

	public static void main(String[] args) {
//		Scanner s = new Scanner (System.in);
//		System.out.print ("Enter 'e' to encrypt, or anything else to decrypt: ");
//		boolean isEncrypt = s.nextLine().equals("e");
//		
//		System.out.print("Enter plain text to encrypt/decrypt: ");
//		String input = s.nextLine();
//		System.out.print("Enter an integer to use as a shift key: ");
//		int inputKey = Integer.parseInt (s.nextLine());
//		
//		if (isEncrypt) {
//			String cipherText = encrypt (input, inputKey);
//			System.out.println(cipherText);
//		} else {
//			String plainText = decrypt (input, inputKey);
//			System.out.println(plainText);
//		}
		
		String in = "Ujnft-Trvbsf jt uif nffuvq tqpu";
		for (int i = 1; i < 26; i++) {
			System.out.println (Encrypter.decrypt(in, i));
		}
	}
	
	
	
	public static String encrypt (String plainText, int shiftKey) {
		String cipherText = "";
		
		for (char c : plainText.toCharArray()) {
			cipherText += getChar (c, shiftKey);
		}
		
		return cipherText;
	}
	
	public static String decrypt (String plainText, int shiftKey) {
		String cipherText = "";
		
		for (char c : plainText.toCharArray()) {
			cipherText += getChar (c, -shiftKey);
		}
		
		return cipherText;
	}

	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	private static char getChar (char inChar, int shiftKey) {
		char outChar = inChar;
		String inString = String.valueOf(inChar);
		
		if (alphabet.contains(inString)) {
			outChar += shiftKey;
			if (inString.equals(inString.toLowerCase())) { // Was lowercase letter
				while (outChar > 'z') {
					outChar -= 26;
				}
				while (outChar < 'a') {
					outChar += 26;
				}
			} else { // Was uppercase letter
				while (outChar > 'Z') {
					outChar -= 26;
				}
				while (outChar < 'A') {
					outChar += 26;
				}
			}
		}
		
		return outChar;
	}
	
}
