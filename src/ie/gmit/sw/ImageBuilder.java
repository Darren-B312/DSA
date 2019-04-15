package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class ImageBuilder {

	private BufferedImage bi = new BufferedImage(1000, 500, BufferedImage.TYPE_4BYTE_ABGR);
	private static final int WIDTH = 500;
	private static final int HEIGHT = 250;
	
	public void build(Queue<WordFrequency> q, int n, String name) throws IOException {
		placeWords(q, bi.getGraphics(), n);
		
		ImageIO.write(bi, "png", new File(name + ".png"));
	}
	
	public void placeWords(Queue<WordFrequency> q, Graphics g, int n) {
		Iterator<WordFrequency> i = q.iterator();
		int count = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		String[] type = {Font.SERIF, Font.SANS_SERIF};
		int[] style = {Font.PLAIN, Font.BOLD, Font.ITALIC};
		Color[] colours = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN};
		
		while (i.hasNext() && count < n) {
			int j = i.next().getFrequency();
			if (j > max) 
				max = j;
			if (j < min) 
				min = j;
		}
		
		count = 0;
		while (!q.isEmpty() && count < n) {
			WordFrequency wf = q.poll();
			Font font = new Font(type[getRandom(0, type.length-1)], 
					style[getRandom(0, style.length-1)],
					scale(wf.getFrequency(), min, max));
			
			g.setFont(font);		
			g.setColor(colours[getRandom(0, colours.length-1)]);
			g.drawString(wf.getWord(), getRandom(0, WIDTH), getRandom(0, HEIGHT));
			count++;
		}			
	}
	
	public int getRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	
	private int scale(int inVal, int inMin, int inMax) {
		double upperBound = 80;
		double lowerBound = 8;
		
		double value = Double.valueOf(inVal);
		double min = Double.valueOf(inMin);
		double max = Double.valueOf(inMax);
		
		return (int) ((upperBound - lowerBound)*((value-min)/(max-min))+lowerBound);
	}
	
}
