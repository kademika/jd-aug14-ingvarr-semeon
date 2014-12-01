package lesson9.subscription;

import java.util.Observable;

public class Magazine extends Observable {
	private String title;
	
	public Magazine(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
}
