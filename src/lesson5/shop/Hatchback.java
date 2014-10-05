package lesson5.shop;

public class Hatchback extends Car {
	
	public Hatchback(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType("Hatchback");
		super.setVIN((int)(Math.random()*998) + 1001); //1001..1999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
