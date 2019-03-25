package ie.gmit.sw;
import java.util.*;

public class Menu {

	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;
	
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
		if(option.equals("4")) {
			keepGoing = false;
		}
		else if(option.equals("1")) {
			System.out.println("you hit 1!");
		}
	}
}