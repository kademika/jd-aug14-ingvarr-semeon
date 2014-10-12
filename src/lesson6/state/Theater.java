package lesson6.state;

public class Theater {
	
	private Actor actor;

	public static void main(String[] args) {
		Theater t = new Theater();
		t.actor = new HappyActor();
		t.actor.act();
		
		t.intermission();
		
		t.actor.act();
	}
	
	public void intermission() {
		getSalLary();
	}
	
	private void getSalLary() {
		actor = new SadActor();
	}

}
