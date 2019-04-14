package ie.gmit.sw;

public class WordFrequency implements Comparable<WordFrequency>{

	private String word;
	private int frequency;
	
	public WordFrequency(String word, int frequency) {
		this.setWord(word);
		this.setFrequency(frequency);
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int compareTo(WordFrequency other) {
		if (this.frequency < other.frequency) {
			return 1;
		}
		else if (this.frequency > other.frequency) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return (this.word + ": " + this.frequency);
	}
	
	
}
