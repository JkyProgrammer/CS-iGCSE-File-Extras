package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sorter extends JFrame {

	private static final long serialVersionUID = 7008094192563588348L;

	public Sorter (String s) {
		super (s);
	}
	
	public static void main(String[] args) {
		Sorter s = new Sorter ("Sorter");
		s.prepare();
		s.setVisible(true);
	}
	
	private static char[] chars = {' ', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
	
	public static int letterIndex (char c) {
		int index = 0;
		for (char character : Sorter.chars) {
			if (character == c) {
				return index;
			}
			index++;
		}
		return index;
	}
	
	public static boolean isLaterThan (String string1, String string2) {
		if (string1.equals(string2)) return false;
		int length1 = string1.length();
		int length2 = string2.length();
		int smallerLength = Math.min(length1, length2);
		
		for (int index = 0; index < smallerLength; index++) {
			int charIndex1 = Sorter.letterIndex(string1.charAt(index));
			int charIndex2 = Sorter.letterIndex(string2.charAt(index));
			if (charIndex1 < charIndex2) {
				return false;
			} else if (charIndex1 > charIndex2) {
				return true;
			}
		}
		if (length1 < length2) return false;
		
		return true;
	}
	
	JButton runButton;
	JCheckBox descendingTick;
	JTextField inputFileField;
	JTextArea instructionArea;
	JTextArea outputLogArea;
	
	long startTime = 0;
	
	private void startSort () {
		output ("Beginning sort algorithm now.");
		
		startTime = System.currentTimeMillis();
		String inputFilePath = inputFileField.getText();
		if (inputFilePath.length() < 1) {
			output ("Error: No file path given. Please enter one and try again.");
			return;
		}
		
		boolean isDescending = descendingTick.isSelected();
		
		output ("Reading input file...");
		try {
			BufferedReader fileScanner = new BufferedReader (new FileReader (inputFilePath));
			output ("File found!");
			
			ArrayList<String> originalItems = new ArrayList<String> ();
			ArrayList<String> sortedItems = new ArrayList<String> ();
			
			while (true) {
				String nextLine = fileScanner.readLine();
				if (nextLine == null) break;
				if (nextLine.length() > 0) {
					originalItems.add(nextLine);
					sortedItems.add(nextLine);
				}
			}
			fileScanner.close();
			
			if (originalItems.size() < 1) { 
				output ("Error: the file you enter must have at least one line of characters.");
				return;
			}
			
			output ("Read all lines from file.");
			output ("Bubble sorting...");
			boolean hasSwapped = true;
			int iterations = 0;
			int swaps = 0;
			
			while (hasSwapped) {
				hasSwapped = false;
				for (int index = 0; index < sortedItems.size()-1; index++) {
					boolean isLater = isLaterThan (sortedItems.get(index), sortedItems.get(index + 1));
					if (!isDescending) {
						if (isLater) {
							String tmp = sortedItems.get(index);
							sortedItems.set(index, sortedItems.get(index+1));
							sortedItems.set(index+1, tmp);
							hasSwapped = true;
							swaps++;
						}
					} else {
						if (!isLater) {
							if (!sortedItems.get(index).equals(sortedItems.get(index+1))) {
								String tmp = sortedItems.get(index);
								sortedItems.set(index, sortedItems.get(index+1));
								sortedItems.set(index+1, tmp);
								hasSwapped = true;
								swaps++;
							}
						}
					}
				}
				iterations++;
			}
			output ("Bubble sort done.");
						
			output ("Writing output to file...");
			File outputFile = new File (inputFilePath);
			String newName = outputFile.getName();
			String suffix  = newName.substring(newName.indexOf("."));
			newName = newName.substring(0, newName.indexOf("."));
			outputFile = new File (outputFile.getParent() + "/" + newName + "-sorted" + suffix);
			outputFile.createNewFile();
			output (outputFile.getPath());
			BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile, false));
			for (String line : sortedItems) {
				writer.write(line + "\n");
			}
			output ("Output file written.");
			output ("Operations finished.");
			writer.close();
			
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime-startTime;
			output ("Calculations took " + elapsed + " milliseconds.");
			
			double secs = elapsed/1000d;
			output ("That's about " + secs + " seconds.");
			output (iterations + " traversals of the data were needed.");
			output (swaps + " swaps were completed.");
			
			
			output ("\nReady!");
		} catch (FileNotFoundException e) {
			output ("Error: Reading/writing failed, file not found.");
			return;
		} catch (IOException e) {
			output ("Error: Reading failed, IOException encountered.");
			return;
		}
	}
	
	public void prepare () {
		this.setSize(500, 300);
		this.setLayout(new GridLayout (2, 1));
		
		JPanel upperPanel = new JPanel ();
		upperPanel.setLayout(new GridLayout (3, 1));
		
		instructionArea = new JTextArea ("Enter a file path to be bubble sorted. The content will be sorted in alphabetical order. Only simple letters and numbers are currently supported, unindexed characters will all be ordered to the end of the output. If you want the output to be in reverse order (i.e. Z-A), tick the 'Sort Descending' box.");
		instructionArea.setEditable(false);
		instructionArea.setLineWrap(true);
		instructionArea.setFocusable(false);
		upperPanel.add(instructionArea);
		
		JPanel settingsPanel = new JPanel ();
		settingsPanel.setLayout(new GridLayout (1, 2));
		
		inputFileField = new JTextField ();
		inputFileField.setText("Enter file path...");
		inputFileField.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSort ();
			}
		});
		settingsPanel.add(inputFileField);
		
		descendingTick = new JCheckBox ("Sort Descending");
		descendingTick.setSelected(false);
		settingsPanel.add(descendingTick);
		
		upperPanel.add(settingsPanel);
		
		runButton = new JButton ("Sort");
		runButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSort ();
			}
		});
		upperPanel.add(runButton);
		
		this.getContentPane().add(upperPanel);
		
		outputLogArea = new JTextArea ("Ready!\n");
		outputLogArea.setEditable(false);
		outputLogArea.setLineWrap(true);
		outputLogArea.setFocusable(false);
		JScrollPane sp = new JScrollPane (outputLogArea);
		this.getContentPane().add(sp);
	}
	
	public void output (String text) {
		System.out.println("Output: " + text);
		outputLogArea.setText(outputLogArea.getText() + text + "\n");
	}
}
