package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Blacklist { // ref: DSA-Lab1: ie.gmit.sw.Dictionary.java

	private List<String> blacklist = new ArrayList<String>(); //Consider: array instead of arraylist? ignored words list lenght is fixed once loaded
	private final String BLACKLIST_FILE = "../ignorewords.txt";
	
	public void load() throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(BLACKLIST_FILE)));
			String next = null;
			
			while ((next = br.readLine()) != null) {
				getBlacklist().add(next);
			}
			br.close();
		} catch (Exception e) {
			throw new Exception("[ERROR] - could not find ignored words file " + e.getMessage());
		}
	}

	public List<String> getBlacklist() {
		return blacklist;
	}

}
