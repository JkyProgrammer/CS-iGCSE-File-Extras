package main;

import java.util.ArrayList;

public class Subprograms {

	public static void main(String[] args) {
		
		ArrayList<Integer> ints = new ArrayList<Integer> ();
		for (int i = 0; i < 10; i++) {
			int a = ParkCharge.randomInt(-100, 100);
			System.out.println(a);
			ints.add(a);
		}
		int[] tings = highestAndLowest (ints.toArray(new Integer[0]));
		System.out.println("Highest: " + tings[0]);
		System.out.println("Lowest: " + tings[1]);
//		averageScore (ints.toArray(new Integer[0]));
		
//		Subprograms s = new Subprograms ();
//		s.cubeSurfaceArea (10, 5);
//		System.out.println(s.cubeSurfaceArea);
	}

	public static void averageScore (Integer[] scores) {
		double total = 0d;
		for (int i : scores)
			total += i;
		double average = total / scores.length;
		System.out.println (average);
	}
	
	public static int die () {
		int dieResult = ParkCharge.randomInt(1, 6);
		return dieResult;
	}
	
	int cubeSurfaceArea = 0;
	
	public void cubeSurfaceArea (int sideWidth, int sideHeight) {
		int sideFaceArea = sideWidth * sideHeight;
		int endFaceArea = sideWidth * sideWidth;
		int totalArea = (sideFaceArea * 4) + (endFaceArea * 2);
		
		cubeSurfaceArea = totalArea;
	}
	
	public static int[] highestAndLowest (Integer[] ints) {
		int highest = ints[0];
		int lowest = ints[0];
		
		for (int i : ints) {
			if (i > highest)
				highest = i;
			if (i < lowest)
				lowest = i;
		}
		
		int[] ret = {highest, lowest};
		
		return ret;
	}
}
