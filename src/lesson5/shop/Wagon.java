package lesson5.shop;

public class Wagon extends Car {
	
	public Wagon(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType("Wagon");
		super.setVIN((int)(Math.random()*998) + 6001); //6001..6999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
