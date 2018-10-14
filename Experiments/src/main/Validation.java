package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Validation {

	public static void main (String[] args) {fileRead ();}
	
	private static Scanner s = new Scanner (System.in);
	
	public static void fileRead () {
		try {
			FileReader fr = new FileReader ("marks.txt");
			int c = fr.read();
			String rawText = "";
			while (c != -1) {
				rawText += (char) c;
				c = fr.read();
			}
			String[] students = rawText.split("\n");
			ArrayList<String[]> results = new ArrayList<String[]>();
			for (String student : students) {
				String[] stud = student.split(",");
				boolean isFine = true;
				for (int i = 1; i < stud.length; i++) {
					int x = Integer.parseInt(stud[i]);
					if (x <= 100 && x >= 0) {} else {
						System.err.println("Error parsing exam " + i + " on student " + stud[0] + ": score out of range.");
						isFine = false;
					}
				}
				
				if (isFine)
					results.add(stud);
			}
			System.out.print("Enter the number of an exam (1-4): ");
			String input = s.nextLine();
			
			int exam = Integer.parseInt(input);
			if (exam < 5 && exam > 0) {
				int total = 0;
				int num = results.size();
				for (String[] student : results) {
					int x = Integer.parseInt(student[exam]);
					total += x;
				}
				System.out.println("Average for that exam was: " + (double)total/(double)num);
			} else {
				System.out.println("An exam number between 1 and 4 (inclusive) is needed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void highestAndLowest () {
		int[][] array2d = {
				{80, 59, 34, 89},
				{31, 11, 47, 64},
				{29, 56, 13, 91},
				{55, 61, 48, 0},
				{75, 78, 81, 91}
						  };
		int numItems = 0;
		
		int totalMark = 0;
		int highestMark = 0;
		int lowestMark = 0;
		
		System.out.println ("Please choose from: ");
		System.out.println ("1: Highest mark");
		System.out.println ("2: Lowest mark");
		System.out.println ("3: Average mark");
	
		for (int[] y : array2d) {
			for (int x : y) {
				if (x > highestMark)
					highestMark = x;
				if (x < lowestMark)
					lowestMark = x;
				
				totalMark += x;
				numItems++;
			}
		}
		
		double avg = (double)totalMark/numItems;
		switch (s.nextLine()) {
		case "1":
			System.out.println("Highest mark is " + highestMark);
			return;
		case "2":
			System.out.println("Lowest mark is " + lowestMark);
			return;
		case "3":
			System.out.println("Average is " + avg);
			return;
		}
		System.out.println("That wasn't one of the options.");
	}
	
	
	public static void presenceCheck () {
		Scanner s = new Scanner (System.in);
		String name = "";
		while (name.equals("")) {
			System.out.print("Enter your name: ");
			name = s.nextLine();
		}
		System.out.println("Welcome, " + name);
	}
	
	public static void lengthCheck () {
		System.out.print("Enter a UK postcode (literally any UK postcode): ");
		Scanner s = new Scanner (System.in);
		int leng = s.nextLine().replaceAll(" ", "").length();
		if (leng >= 6 && leng <= 8)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}
	
	public static void optionCheck () {
		List<String> options = Arrays.asList("display average temperature", "display temperature range", "display wind speed", "quit");
		System.out.println(options.toString());
		Scanner s = new Scanner (System.in);
		while (true) {
			String option;
			while (true) {
				System.out.print("Enter an option: ");
				String op = s.nextLine().toLowerCase();
				if (options.contains(op)) {
					option = op;
					break;
				} else {
					System.out.println("Don't be like that.");
				}
			}
			switch (options.indexOf(option)) {
			case 0:
				System.out.println("How should I know the average tempterature?");
				break;
			case 1:
				System.out.println("The what?");
				break;
			case 2:
				System.out.println("Errm... fast-ish I guess...?");
				break;
			case 3:
				System.out.println("Finally!");
				System.exit(0);
				break;
			default:
				System.out.println("Oops.");
				break;
			}
		}
	}

	public static void rangeCheck () {
		Scanner s = new Scanner (System.in);
		int finalV;
		while (true) {
			System.out.print("Please enter a number between 1 and 10 inclusive: ");
			try {
				int val = Integer.parseInt(s.nextLine());
				if (val >= 1 && val <= 10) {
					finalV = val;
					break;
				} else {
					System.out.println("Just follow the instruction I gave you.");
				}
			} catch (NumberFormatException e) {
				System.out.println("That's not a number.");
			}
		}
		System.out.println("Finally, you entered a number between 1 and 10. And it was " + finalV + ".");
		s.close();
	}
	
}
