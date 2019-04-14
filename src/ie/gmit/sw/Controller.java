package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class Controller {

	// Variables ================================================================================
	private String wordSource;
	private String imageName;
	private int wordCount;
	
	
	// Constructors ================================================================================
	public Controller() {
		
	}
	
	public Controller(String ws, String in, int wc) { // todo: getter/setters
		this.wordSource = ws;
		this.imageName = in;
		this.wordCount = wc;
	}
	

	// Accessor & Mutator methods ================================================================================
	public String getWordSource() {
		return wordSource;
	}

	public void setWordSource(String wordSource) {
		this.wordSource = wordSource;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
	
	 
	// Other methods ================================================================================
	public void buildImage(Queue<WordFrequency> q, Graphics g, int n) {
		Iterator<WordFrequency> i = q.iterator();
		int count = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		String[] type = {Font.SERIF, Font.SANS_SERIF};
		int[] style = {Font.PLAIN, Font.BOLD, Font.ITALIC};
		Color[] colours = {Color.RED, Color.GREEN, Color.BLUE};
		
		while(i.hasNext() && count < n) {
			int j = i.next().getFrequency();
			if(j > max) max = j;
			if(j < min) min = j;
			count++;
		}
		
		count = 0;
		
		while (!q.isEmpty() && count < n) {
			WordFrequency wf = q.poll();
			Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);// todo: random style, font and size
			g.setColor(Color.black);
			g.drawString(wf.getWord(), getRandom(0, 600), getRandom(0, 300)); //todo: variables for height/width
			count++;
		}
	}	
	
	public void generateCloud() throws FileNotFoundException, Exception {
		//long startTime = System.nanoTime();

		Dictionary iw = new Dictionary();
		iw.load();

		Parser p = new Parser();
		HashMap<String, Integer> wf = p.parse(new FileInputStream(new File(this.wordSource)));
				
		Set<String> keys = wf.keySet();	
		Queue<WordFrequency> q = new PriorityQueue<>();
		
		for (String key:keys) {
			q.offer(new WordFrequency(key, wf.get(key)));
		}
		
//		for(int i = 0; i < 10; i++) { 
//			System.out.println(q.poll().toString()); 
//		}
//		System.out.println("Running time (ns): " + (System.nanoTime() - startTime));
		
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
		buildImage(q, image.getGraphics(), this.wordCount);
		
		
		ImageIO.write(image, "png", new File(this.imageName + ".png"));
		
		
		
//		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
//		Graphics graphics = image.getGraphics();
//		graphics.setColor(Color.RED);
//		graphics.setFont(font);
//		graphics.drawString("TEST STRING", 0, 100);
//		
//		graphics.dispose();
//		
//		ImageIO.write(image, "png", new File(this.imageName + ".png"));

	}
	
	public int getRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}

}
