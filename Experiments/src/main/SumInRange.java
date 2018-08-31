package main;

import java.util.Scanner;

public class SumInRange {
	
	public static void mn () {
		Scanner s = new Scanner (System.in);
		System.out.print("Enter the start number: ");
		int start = Integer.parseInt(s.nextLine());
		System.out.print("Enter the end number: ");
		int end = Integer.parseInt(s.nextLine());
		
		int total = 0;
		for (int i = start; i <= end; i++) {
			total += i;
		}
		
		System.out.println ("Total is: " + total);
	}
}
