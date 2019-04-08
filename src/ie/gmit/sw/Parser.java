package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser {
		
	private Blacklist bl = new Blacklist();
	
	public void parse(InputStream in) throws Exception{
		bl.load();
			
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String next = null;
			long startTime = System.nanoTime();
			while((next = br.readLine()) != null) {
				String[] words = next.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" "); // replaceAll - https://stackoverflow.com/a/18831709
				
				
				for(String word: words) {					
					if (!bl.getBlacklist().contains(word)) {
						//System.out.println(word); //debug - testing file parser
					}
					
				}

			}
			System.out.println("Running time (ns): " + (System.nanoTime() - startTime));
			br.close();
		}catch (Exception e) {
			throw new Exception("Error - file not found " + e.getMessage());
		}

	}
	
}
