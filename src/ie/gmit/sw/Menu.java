package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	
	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;

	
	public void show() throws FileNotFoundException, Exception {
		while(keepGoing == true) {
			printMenu();
			option = s.next();
			handle(option);
		}
	}
	
	public void printMenu() {
		System.out.println("\nA Word Cloud Generator!");
		System.out.println("1.Select File or URL");
		System.out.println("2.Set Number of Words");
		System.out.println("3.Set Image Name"); 
		System.out.println("4.Create Image");
		System.out.println("X.EXIT");
		System.out.print(">");
	}	
	
	public void handle(String option) {
		
		if (option.equals("1")) { // new Parser
			System.out.print("  Enter filename: ");
			Parser p = new Parser();
			try {
				p.parse(new FileInputStream(new File(s.next())));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (option.equals("2")) {
			
		}
		else if (option.equals("3")) {
			
		}
		else if (option.equals("4")) { // new BufferedImage
			
		}
		else if (option.equalsIgnoreCase("x")) { // quit
			System.out.println("  Exiting...");
			keepGoing = false;
		}

	}
}