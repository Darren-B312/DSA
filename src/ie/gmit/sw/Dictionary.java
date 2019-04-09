package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	private final String IGNORED_WORDS_FILE = "../ignorewords.txt";
	private Set<String> ignored = new HashSet<String>();
	
	public Set<String> getIgnored() {
		return ignored;
	}

	public void load() throws Exception{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(IGNORED_WORDS_FILE)));
			String next = null;
			
			while((next = br.readLine()) != null) {
				ignored.add(next);
			}
			br.close(); 
		} catch (Exception e) {
			throw new Exception("[ERROR] - ignorewords.txt file not found " + e.getMessage());
		}
	}
	
}
