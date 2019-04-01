package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.InputStream;
//import java.net.URL;
import java.io.InputStreamReader;
import java.util.Map;

public class Parser {
	
	
	public void parse(InputStream in) throws Exception{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String next = null;
			
			while((next = br.readLine()) != null) {
				String[] words = next.split(" ");
				
				for(String word: words) {
					System.out.println(word); //debug - testing file parser
				}

			}
			br.close();
		}catch (Exception e) {
			throw new Exception("Error - file not found " + e.getMessage());
		}

	}
	
}
