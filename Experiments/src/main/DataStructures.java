package main;

import java.util.Scanner;

public class DataStructures {

	private static Scanner s;
	
	public static class Record {
		String name;
		int level;
		int score;
		
		public Record (String n, int l, int s) {
			name = n;
			level = l;
			score = s;
		}
		
		public String toString () {
			return name + " " + level + " " + score;
		}
	}
	
	public static void searchAgain () {
		Record[] records = {
				new Record ("Alex", 1, 19),
				new Record ("Seema", 1, 29),
				new Record ("Seema", 2, 44),
				new Record ("Lois", 1, 10),
				new Record ("Alex", 2, 17),
				new Record ("Alex", 3, 36),
				new Record ("Dion", 1, 23),
				new Record ("Emma", 1, 27),
				new Record ("Emma", 2, 48)
						   };
		
		Record[] highScores = {new Record ("", 1, 0),new Record ("", 2, 0),new Record ("", 3, 0)};
		
		for (Record r : records) {
			if (r.score >= highScores[r.level-1].score) {
				highScores[r.level-1] = r;
			}
		}
		
		for (Record r : highScores)
			System.out.println(r.toString());
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
		System.out.println("Average is " + avg);
		System.out.println("Highest mark is " + highestMark);
		System.out.println("Lowest mark is " + lowestMark);
	}
	
	public static void concatenateArrays () {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {6,7,8,9,10, 11, 12};
		
		int newLength = array1.length + array2.length;
		
		int[] newArray = new int[newLength];
		
		for (int i1 = 0; i1 < array1.length; i1++) {
			newArray[i1] = array1[i1];
		}
		for (int i2 = 0; i2 < array2.length; i2++) {
			newArray[i2 + array1.length] = array2[i2];
		}
		
		for (int i : newArray) {
			System.out.println(i);
		}
	}
	
	
	public static void bubbleSort () {
		int[] results = {65,1,7,2,46,8,3,45};
		
		boolean hasSwapped = true;
		int passes = 0;
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 1; i < results.length; i++) {
				if (results[i-1] < results [i]) {
					hasSwapped = true;
					int tmp = results[i];
					results[i] = results[i-1];
					results[i-1] = tmp;
				}
			}
			passes++;
		}
		
		System.out.println("Bubble sort done in " + passes + " passes.");
		System.out.println("The highest results was " + results[0] + ", and the lowest result was " + results[results.length-1]);
		
	}
	
	
	
	public static void linSearch () {
		String[] firstNames = {"Alex", "Bryn", "Eloise", "Lois", "James", "Sally"};
		s = new Scanner (System.in);
		String searchName = s.nextLine();
		
		boolean found  = false;
		int index = 0;
		
		while (index < firstNames.length) {
			if (searchName.equals(firstNames[index])) {
				found = true;
				break;
			}
			index++;
		}
		
		if (found) {
			System.out.println (searchName + " is at position " + index + " in the array.");
		} else {
			System.out.println(searchName + " is not in the array.");
		}
	}
}
