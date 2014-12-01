package lesson9.subscription;

import java.util.Observable;

public class Newspaper extends Observable {
	private String title;
	
	public Newspaper(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
