package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Calculator {

	Scanner s = new Scanner (System.in);
	
	public String input () {
		return s.nextLine();
	}
	
	public void output (String s) {
		System.out.println (s);
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator ();
		while (true) {
			c.output ("Enter an integer value when prompted, then press enter. If there are no more values to enter, simply press enter.");
			ArrayList<Integer> ints = new ArrayList<Integer> ();
			while (true) {
				System.out.print ("Enter an integer: ");
				String next = c.input();
				if (next.length() < 1) {
					if (ints.size() > 0)
						break;
					else
						c.output("You must enter at least one integer.");
				} else {
					try {
						int newValue = Integer.parseInt(next);
						ints.add(newValue);
					} catch (NumberFormatException e) {
						c.output("Please enter a valid number.");
					}
				}
			}
			int instruction = 0;
			System.out.print ("Please enter one of: 'mean', 'mode', 'median': ");
			while (true) {
				String input = c.input();
				if (input.equals("mean")) {
					instruction = 0;
					break;
				} else if (input.equals("mode")) {
					instruction = 1;
					break;
				} else if (input.equals("median")) {
					instruction = 2;
					break;
				} else {
					c.output("Please enter a valid option.");
				}
			}
			if (instruction == 0) {
				c.mean (ints.toArray(new Integer[]{}));
			} else if (instruction == 1) {
				c.mode (ints.toArray(new Integer[]{}));
			} else if (instruction == 2) {
				c.median (ints.toArray(new Integer[]{}));
			}
		}
	}

	public void mean (Integer[] values) {
		int numValues = values.length;
		int total = 0;
		for (int i : values) {
			total += i;
		}
		double ans = (double)total / (double)numValues;
		output ("The mean of your numbers is " + ans);
	}
	
	public void mode (Integer[] integers) {
		HashMap<Integer, Integer> numOfEach = new HashMap<Integer, Integer> ();
		
		for (int i : integers) {
			if (numOfEach.containsKey(i)) {
				numOfEach.put(i, numOfEach.get(i) + 1);
			} else {
				numOfEach.put(i, 1);
			}
		}
		
		ArrayList<Integer> highestCountedNumbers = new ArrayList<Integer> ();
		int highestCount = 0;
		
		for (Entry<Integer, Integer> i : numOfEach.entrySet()) {
			if (i.getValue() > highestCount) {
				highestCount = i.getValue();
				highestCountedNumbers.clear();
				highestCountedNumbers.add (i.getKey());
			} else if (i.getValue() == highestCount) {
				highestCountedNumbers.add (i.getKey());
			}
		}
		if (highestCountedNumbers.size() == 1) {
			output ("The most common number was " + highestCountedNumbers.get(0) + " and it occurred " + highestCount + " times");
		} else {
			output ("There were several most common numbers. They appeared " + highestCount + " times. They are: ");
			for (int i : highestCountedNumbers) {
				output (Integer.toString(i));
			}
		}
	} 
	
	public void median (Integer[] integers) {
		int numValues = integers.length;
		// bubble sort
		ArrayList<Integer> sorted = new ArrayList<Integer> ();
		for (int val : integers)
			sorted.add(val);
		
		boolean didSwap = true;
		while (didSwap) {
			didSwap = false;
			for (int loc = 1; loc < numValues; loc++) {
				if (sorted.get(loc-1) > sorted.get(loc)) {
					didSwap = true;
					Integer tmp = sorted.get(loc-1);
					sorted.set(loc-1, sorted.get(loc));
					sorted.set(loc, tmp);
				}
			}
		}
		
		if (numValues%2 != 0) {
			output ("The median of your numbers is " + sorted.get((numValues-1)/2));
		} else {
			int num1 = sorted.get((numValues/2) - 1);
			int num2 = sorted.get((numValues/2));
			
			output ("The two medians of your numbers are " + num1 + " and " + num2);
		}
	}
}
