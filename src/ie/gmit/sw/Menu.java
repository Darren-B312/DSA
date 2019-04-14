package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	
	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;
	Controller controller = new Controller();

	
	
	public void show() throws FileNotFoundException, Exception {
		while(keepGoing == true) {
			printMenu();
			option = s.next();
			handle(option);
		}
	}
	
	public void printMenu() {
		System.out.println("\nA Word Cloud Generator!");
		System.out.println("1.File Name");
		System.out.println("2.URL");
		System.out.println("3.Word Count");
		System.out.println("4.Image Name"); 
		System.out.println("5.Output Image");
		System.out.println("X.EXIT");
		System.out.print(">");
	}	
	
	public void handle(String option) throws FileNotFoundException, Exception {		
		
		if (option.equals("1")) { 
			System.out.print("  Enter filename: ");
			controller.setWordSource(s.next());

		}
		else if (option.equals("2")) {
			System.out.println("URL - NYI");
		}
		else if (option.equals("3")) {
			System.out.print("  Enter word count: ");
			controller.setWordCount((Integer.parseInt(s.next())));
		}
		else if (option.equals("4")) { 
			System.out.println("  Enter image name: ");
			controller.setImageName(s.next());
		}
		else if (option.contentEquals("5")) {
			System.out.println("  Generating word cloud...");
			controller.generateCloud();
		}
		else if (option.equalsIgnoreCase("x")) { // quit
			System.out.println("  Exiting...");
			keepGoing = false;
		}

	}
}