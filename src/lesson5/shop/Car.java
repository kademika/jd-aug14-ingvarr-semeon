package lesson5.shop;

public class Car {
	private String brend;
	private String model;
	private CarColor color;
	private double capacity;
	private GearboxType gearbox;
	private double fuelConsumption;
	private int trunkVolume;
	private int price;

	public Car(String brend, String model, CarColor color, double capacity,
			GearboxType gearbox, double fuelConsumption, int trunkVolume, int price) {
		this.brend = brend;
		this.model = model;
		this.setGearbox(gearbox);
		this.color = color;
		this.capacity = capacity;
		this.fuelConsumption = fuelConsumption;
		this.trunkVolume = trunkVolume;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.getBrend() + " " + this.getModel() + "\n" + "color: "
				+ this.getColor() + "\n" + "capacity: " + this.getCapacity()
				+ "\n" + "gearbox: " + this.getGearbox() + "\n"
				+ "fuel consumption: " + this.getFuelConsumption() + "\n"
				+ "trunk volume: " + this.getTrunkVolume() + "\n"
				+ "price: $" + this.getPrice() + "\n";

	}

	public String getBrend() {
		return brend;
	}

	public void setBrend(String brend) {
		this.brend = brend;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarColor getColor() {
		return color;
	}

	public void setColor(CarColor color) {
		this.color = color;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public GearboxType getGearbox() {
		return gearbox;
	}

	public void setGearbox(GearboxType gearbox) {
		this.gearbox = gearbox;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getTrunkVolume() {
		return trunkVolume;
	}

	public void setTrunkVolume(int trunkVolume) {
		this.trunkVolume = trunkVolume;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
