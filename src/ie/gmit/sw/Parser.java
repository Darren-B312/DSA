package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Parser {
	
	private Dictionary ignored = new Dictionary();


	public HashMap<String, Integer> parse(InputStream in) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		HashMap<String, Integer> wf = new HashMap<String, Integer>();
		String next = null;

		ignored.load();

		
		while((next = br.readLine()) != null) {
			String[] words = next.replaceAll("[^a-zA-Z ]","").toLowerCase().split(" ");
			
			for (String word : words) {
				if (!ignored.getIgnored().contains(word)) {
					if(wf.containsKey(word)) {
						wf.put(word, wf.get(word) + 1);
					}
					else {
						wf.put(word, 1);
					}
				}
			}
			
		}		
		
		return wf;
		
	}
	
}
