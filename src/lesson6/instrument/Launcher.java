package lesson6.instrument;

public class Launcher {

	public static void main(String[] args) {
		Instrument i = new Instrument();
		Flute f = new Flute();
		Guitar g = new Guitar();
		Musician m = new Musician();
		
		m.play(i);
		m.play(f);
		m.play(g);

	}

}
