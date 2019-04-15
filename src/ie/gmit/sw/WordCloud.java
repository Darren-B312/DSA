package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WordCloud {
	
	private File wordSrcFile = null;
	private URL wordSrcURL = null;
	private int wordCount;
	private String imageName;
	
	public File getWordSrcFile() {
		return wordSrcFile;
	}

	public void setWordSrcFile(File wordSrcFile) {
		this.wordSrcFile = wordSrcFile;
	}

	public URL getWordSrcURL() {
		return wordSrcURL;
	}

	public void setWordSrcURL(URL wordSrcURL) {
		this.wordSrcURL = wordSrcURL;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public void generateCloud() throws FileNotFoundException, Exception {
		long startTime = System.nanoTime();
		
		Parser p = new Parser();
		HashMap<String, Integer> wf = new HashMap<String, Integer>();
		
		if (wordSrcFile!= null) {
			wf = p.parse(new FileInputStream(this.wordSrcFile));
		}
		else if (wordSrcURL!= null) {
			wf = p.parse(this.wordSrcURL.openStream());
		}
		
		Set<String> keys = wf.keySet();	
		Queue<WordFrequency> q = new PriorityQueue<>();
		
		for (String key:keys) {
			q.offer(new WordFrequency(key, wf.get(key)));
		}
		
		
		new ImageBuilder().build(q, this.getWordCount(), this.getImageName());
		
		System.out.println("\n  Running time (ns): " + (System.nanoTime() - startTime));
	}

}
