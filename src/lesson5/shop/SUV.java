package lesson5.shop;

public class SUV extends Car {
	private static final String bodyType = "Sports Utility Vehicle";
	
	public SUV(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
	}
	
	public String getBodyType() {
		return bodyType;
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
