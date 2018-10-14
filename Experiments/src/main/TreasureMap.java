package main;

import java.util.Scanner;

public class TreasureMap {
	
	public static void main (String[] args) {
		TreasureMap t = new TreasureMap ();
		t.start();
	}
	
	public void start () {
		treasureX = ParkCharge.randomInt(0, 3);
		treasureY = ParkCharge.randomInt(0, 3);
		
		Scanner s = new Scanner (System.in);
		
		while (true) {
			System.out.println("Enter an x coordinate: ");
			int xc = Integer.parseInt(s.nextLine());
			
			System.out.println("Enter a y coordinate: ");
			int yc = Integer.parseInt(s.nextLine());
			
			if (treasureX == xc && treasureY == yc) {
				System.out.println("Congratulations! You found the treasure!");
				System.out.println("It was buried under " + grid[yc][xc]);
				break;
			} else if (xc < 4 && yc < 4 && xc > -1 && yc > -1) {
				System.out.println("Not here... just " + grid[yc][xc]);
				int dist = Math.abs(treasureX-xc) + Math.abs(treasureY-yc);
				System.out.println("You're only " + dist + " squares away though!");
			} else {
				System.out.println("Obviously not.");
			}
		}
	}
	
	int treasureX;
	int treasureY;
	
	String grid[][] = {
			{"Sand",  "Sand",  "Sand",  "Sand"},
			{"Sand",  "Grass", "Grass", "Grass"},
			{"Grass", "Grass", "Tree",  "Grass"},
			{"Tree",  "Grass", "Grass", "Grass"}
	};
}
