package lesson5.instrument;

public class Musician {
	
	public void play(Instrument i) {
		if ( i instanceof Flute) {
			Flute f = (Flute) i;
			f.test();
		}
		
		i.sound();
	}

}
