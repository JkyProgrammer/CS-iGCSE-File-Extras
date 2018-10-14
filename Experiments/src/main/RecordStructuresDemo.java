package main;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordStructuresDemo {
	
	ArrayList<Album> albums = new ArrayList<Album> ();
	Scanner s = new Scanner (System.in);
	
	
	public void createNewRecord () {
		System.out.print("Please enter the title of the new record: ");
		String newTitle = s.nextLine();
		
		System.out.print("Please enter the artist of the new record: ");
		String newArtist = s.nextLine();
		
		System.out.print("Please enter the year the record was released: ");
		int newYear = Integer.parseInt(s.nextLine());
		
		System.out.print("Please enter the genre of the new record: ");
		String newGenre = s.nextLine();
		
		System.out.println("Creating your record...");
		albums.add(new Album (newTitle, newArtist, newYear, newGenre));
		System.out.println("Done.");
	}
	
	public void findRecord () {
		System.out.println("Enter the record's title: ");
		String name = s.nextLine();
		
		for (Album a : albums) {
			if (a.albumTitle.equals(name)) {
				System.out.println("Found album with that name!");
				System.out.println(a.toString());
				return;
			}
		}
		
		System.out.println ("The record you searched for could not be found.");
	}
	
	public void begin () {
		System.out.println("Commands are: find, add, list");
		while (true) {
			System.out.print("Enter a command: ");
			String command = s.nextLine();
			if (command.toLowerCase().equals("find")) {
				findRecord();
			} else if (command.toLowerCase().equals("add")) {
				createNewRecord();
			} else if (command.toLowerCase().equals("list")) {
				for (Album a : albums)
					System.out.println(a.toString());
			} else {
				System.out.println("Unrecognised command.");
			}
		}
	}
	
	public static class Album {
		String albumTitle;
		String artistName;
		int releaseYear;
		String genre;
		
		public Album (String t, String a, int y, String g) {
			albumTitle = t;
			artistName = a;
			releaseYear = y;
			genre = g;
		}
		
		public String toString () {
			return new String (albumTitle + " : " + artistName + " : " + releaseYear + " : " + genre);
		}
	}
}
