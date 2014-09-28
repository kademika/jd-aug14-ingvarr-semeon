package lesson5.instrument;

public class Launcher {

	public static void main(String[] args) {
//		Instrument i = new Instrument();
//		Flute f = new Flute();
//		Musician m = new Musician();
//		
//		m.play(i);
//		m.play(f); //Upcasting
		
//		System.out.println(Instrument.PRODUCER); //Static variable
		Instrument i1 = new Instrument();
		Instrument i2 = new Instrument();
		
		System.out.println(i1.PRODUCER);
		System.out.println(i2.PRODUCER);
		
		i1.PRODUCER = "new producer";
		
		System.out.println(i1.PRODUCER);
		System.out.println(i2.PRODUCER);
	}

}
