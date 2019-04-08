package ie.gmit.sw;

import java.util.*;

public class Menu {

	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = "../" + fileName;
		//this.fileName = "WarAndPeace-LeoTolstoy.txt"; // DEBUG
	}

	public void show() {
		while(keepGoing == true) {
			printMenu();
			option = s.next();
			handle(option);
		}
	}
	
	public void printMenu() {
		System.out.println("This is a menu!");
		System.out.println("  1.Select File or URL");
		System.out.println("  2.Enter number of words to display");
		System.out.println("  3.Enter image name"); 
		System.out.println("  4.Quit");
		System.out.print(">");
	}	
	
	public void handle(String option) {
		if(option.equals("1")) {
			System.out.println("    Select File or URL");
			System.out.print("    Enter filename: ");
			setFileName(s.next() + ".txt");
		}
		else if(option.equals("2")) {
			System.out.println("    Enter number of words to display");
		}
		else if(option.equals("3")) {
			System.out.println("    Enter image name");
		}
		else if(option.equals("4")) {
			System.out.println("    Quitting");
			keepGoing = false;
		}
	}
}