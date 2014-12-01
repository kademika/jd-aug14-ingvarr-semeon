package lesson9.subscription;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {
	private String name;
	private String email;
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof PublicationEvent) {
			if (o instanceof Newspaper) {
				System.out.println("The new issue of " + ((Newspaper) o).getTitle() + " was published");
			}
			if (o instanceof Magazine) {
				System.out.println("The new issue of " + ((Magazine) o).getTitle() + " was published");
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
