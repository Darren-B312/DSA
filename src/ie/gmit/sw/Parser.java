package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Parser {

	private Dictionary ignored = new Dictionary();
	private HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();

	public void parse(InputStream in) throws Exception {		
		ignored.load();
		
	
		String next = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		while((next = br.readLine()) != null) {
			String[] words = next.replaceAll("[^a-zA-Z ]","").toLowerCase().split(" "); // replaceAll - https://stackoverflow.com/a/18831709
		
			for (String word: words) {
				if (!ignored.getIgnored().contains(word)) {
					//System.out.println(word);
					
					if(wordFreq.containsKey(word)) {
						wordFreq.put(word, wordFreq.get(word) + 1);
					}
					else {
						wordFreq.put(word, 1);
					}
				}
			}
			
		}
		
		System.out.println(wordFreq);
	
		
	}

	
}
