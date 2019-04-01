package ie.gmit.sw;
import java.io.*;

public class Runner {

	public static void main(String[] args) {
		
		Menu m = new Menu();
		m.show();
		
		Parser p = new Parser();
		try {
			p.parse(new FileInputStream(new File(m.getFileName())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
