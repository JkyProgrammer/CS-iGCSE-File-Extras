package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static Scanner s;

	
	public static void sliceString () {
		String input = "23456,West Kirby,04/11/15,23.0,11.5,30,D1";
		
		int length = input.length();
		int lastEnd = -1;
		
		ArrayList<String> strings = new ArrayList<String>();
		
		while (lastEnd + 1 < length) {
			String newString = "";
			int loc = lastEnd + 1;
			while (loc < length) {
				if (input.charAt(loc) == ',')
					break;
				newString += input.charAt(loc);
				loc++;
			}
			lastEnd = loc;
			strings.add(newString);
		}
		System.out.println("The original string was " + input + " and we split it at the ','.");
		System.out.println("The results were: ");
		for (String s : strings)
			System.out.println(s);
	}
	
	public static void sliceStringAtSpace () {
		System.out.print ("Enter a sentence: ");
		
		s = new Scanner (System.in);
		String input = s.nextLine().trim();
		
		int length = input.length();
		int lastEnd = -1;
		
		ArrayList<String> strings = new ArrayList<String>();
		
		while (lastEnd + 1 < length) {
			String newString = "";
			int loc = lastEnd + 1;
			while (loc < length) {
				if (input.charAt(loc) == ' ')
					break;
				newString += input.charAt(loc);
				loc++;
			}
			lastEnd = loc;
			strings.add(newString);
		}
		System.out.println("The original string was " + input + " and we split it at the ' ' character.");
		System.out.println("The results were: ");
		for (String string : strings)
			System.out.println(string);
	}
	
	public static void usernameGenerator () {
		s = new Scanner (System.in);
		
		System.out.print ("Enter your first name: ");
		String firstName = s.nextLine();
		
		System.out.print ("Enter your last name: ");
		String lastName = s.nextLine();
		
		String userName = "";
		
		for (int i = 0; i < 4; i++) {
			if (i < lastName.length()) {
				userName += lastName.charAt(i);
			} else {
				userName += "X";
			}
		}
		
		userName += firstName.charAt(0);
		
		System.out.println("Your username is: " + userName);
	}
	
	public static void vowelCounter () {
		s = new Scanner (System.in);
		
		System.out.println("Enter a string: ");
		String input = s.nextLine();
		
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		
		String vowels = "";
		
		for (char c : input.toLowerCase().toCharArray()) {
			switch (c) {
			case 'a':
				a++;
				vowels += 'a';
				break;
			case 'e':
				e++;
				vowels += 'e';
				break;
			case 'i':
				i++;
				vowels += 'i';
				break;
			case 'o':
				o++;
				vowels += 'o';
				break;
			case 'u':
				u++;
				vowels += 'u';
				break;
			default:
				break;
			}
		}
		
		System.out.println("There were: ");
		System.out.println(a + " 'a's,");
		System.out.println(e + " 'e's,");
		System.out.println(i + " 'i's,");
		System.out.println(o + " 'o's,");
		System.out.println(u + " 'u's.");
		
		System.out.println("And it looks like this: " + vowels);
	}
}
