package ie.gmit.sw;
import java.io.*;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		Menu m = new Menu();
		m.show();
		
		Parser p = new Parser();
		try {
			p.parse(new FileInputStream(new File(m.getFileName()))); // overload getFileName for dealing with files in project dir?
		} catch (Exception e) {
			throw new Exception("[ERROR] - file not found " + e.getMessage());
			//e.printStackTrace();
		}
	}

}
