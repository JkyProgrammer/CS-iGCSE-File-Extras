package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeStorage {
	public static class EmployeeRecord {
		public String toString() {
			return "EmployeeRecord [number=" + number + ", name=" + name + ", department=" + department + "]";
		}

		int number;
		String name;
		String department;

		public EmployeeRecord (int num, String n, String d) {
			number = num;
			name = n;
			department = d;
		}


	}

	public static List<String> departments = Arrays.asList("Management", "Groceries", "Technology", "Clothes", "Sanitation");
	
	public static void main (String[] args) {
		Scanner fileScanner;
		try {
			fileScanner = new Scanner (new File ("employees.txt"));
			Scanner inputScanner = new Scanner (System.in);
			ArrayList<String> lines = new ArrayList<String>();
			while (fileScanner.hasNext())
				lines.add(fileScanner.nextLine());

			fileScanner.close();
			// Load employees
			ArrayList<EmployeeRecord> employees = new ArrayList<EmployeeRecord>();
			for (String line : lines) {
				String[] parts = line.split(",");
				try {
					int num = Integer.parseInt(parts[0]);

					if (departments.contains(parts[2])) {
						EmployeeRecord er = new EmployeeStorage.EmployeeRecord (num, parts[1], parts[2]);
						employees.add(er);
						System.out.println(er.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// Search for commands
			System.out.println("Enter a command from the list below: ");
			System.out.println("add");
			System.out.println("find");
			System.out.println("save");
			
			while (true) {
				System.out.print("-> ");
				String input = inputScanner.nextLine();
				
				if (input.equals ("add")) { // Add an employee to the database
					EmployeeRecord e = add();
					if (e != null)
						employees.add(e);
				} else if (input.equals ("find")) { // Find an employee in the database
					find(employees);
				} else if (input.equals("save")) { // Save the database again
					try {
						PrintWriter writer = new PrintWriter("employees.txt");
						for (EmployeeRecord e : employees) {
							writer.println(e.number + "," + e.name + "," + e.department);
						}
						
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Invalid command.");
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void find (ArrayList<EmployeeRecord> employees) {
		Scanner inputScanner = new Scanner (System.in);
		System.out.print("Enter the name of the employee you want to find: ");
		String name = inputScanner.nextLine();
		for (EmployeeRecord e : employees) {
			if (e.name.equalsIgnoreCase(name)) {
				System.out.println("Employee found!");
				System.out.println(e.toString());
				return;
			}
		}
		System.out.println("No employee found with that name.");
	}
	
	public static EmployeeRecord add () {
		try {
			Scanner inputScanner = new Scanner (System.in);
			System.out.print("Enter number: ");
			int number = Integer.parseInt(inputScanner.nextLine());
			if (number < 0) {
				System.out.println("Error! Employee number must be more than -1!");
				return null;
			}
			
			System.out.print("Enter name: ");
			String name = inputScanner.nextLine();
			
			System.out.print("Enter department: ");
			String department = inputScanner.nextLine();
			if (!departments.contains(department)) {
				System.out.println("Error! Invalid department name!");
				return null;
			}
			
			return new EmployeeRecord (number, name, department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
