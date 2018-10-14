package main;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
	public void start () {
		book.put("Bob", "bob@gmail.com");
		book.put("Timmy", "tim.my@gmail.com");
		book.put("John", "john.appleseed@apple.com");
		
		Scanner s = new Scanner (System.in);
		while (true) {
			System.out.print("Enter a name to search for: ");
			String name = s.nextLine();
			if (book.containsKey(name))
				System.out.println("This person's email is " + book.get(name));
			else
				System.out.println("That person was not found in the address book.");
		}
	}
	
	HashMap<String, String> book = new HashMap<String,String>();
}
