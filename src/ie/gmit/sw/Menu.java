package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Menu {
	
	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;
	private WordCloud wc = new WordCloud();
	
	public void show() throws FileNotFoundException, Exception {
		
		while(keepGoing == true) {
			printMenu();
			option = s.next();
			handle(option);
		}	
	}
	
	public void printMenu() {
		
		System.out.println("\nWord Cloud Generator!");
		System.out.println("1.File");
		System.out.println("2.URL");
		System.out.println("3.Word Count");
		System.out.println("4.Image Name"); 
		System.out.println("5.Output Image");
		System.out.println("X.EXIT");
		System.out.print(">");
	}	
	
	public void handle(String option) throws FileNotFoundException, Exception {		
		
		if (option.equals("1")) { 
			System.out.print("  Enter file name: ");
			wc.setWordSrcFile(new File(s.next())); 
		}
		else if (option.equals("2")) {
			System.out.print("  Enter URL: ");
			wc.setWordSrcURL(new URL(s.next()));
		}
		else if (option.equals("3")) {
			System.out.print("  Enter word count: ");
			wc.setWordCount(s.nextInt());
		}
		else if (option.equals("4")) { 
			System.out.print("  Enter image name: ");
			wc.setImageName(s.next());
		}
		else if (option.contentEquals("5")) {
			System.out.println("\n  Generating word cloud...");
//			wc.setWordSrc(new File("../WarAndPeace-LeoTolstoy.txt")); //DEBUG - HARDCODED FILENAME FOR FASTER TESTING
//			wc.setWordCount(20); //DEBUG - HARDCODED COUNT FOR FASTER TESTING
//			wc.setImageName("test"); //DEBUG - HARDCODED NAME FOR FASTER TESTING
			wc.generateCloud();
		}
		else if (option.equalsIgnoreCase("x")) { 
			System.out.println("\n  Exiting...");
			keepGoing = false;
		}

	}
}