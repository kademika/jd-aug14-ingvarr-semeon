package lesson4.car;

public class Car {
	private String type;
	private String brend;
	private String model;
	private Colors color;
	private String VIN;
	
	private double capacity;
	private int maxSpeed;
	private double fuelConsumption;
	private double tankVolume;
	private double fuelAmount;
	
	private boolean isEngineWorking;
	private boolean isHandbrakeSwitchedOn;
	private int gearPositionNumber;
	private boolean isHeadlightsSwitchedOn;
	

	public Car() {
		type = "4-door sedan";
		brend = "Citroen";
		model = "C-Elysee";
		color = color.LIGHT_BLUE;
		VIN = "VF7DDNFP0DJ595201";
		capacity = 1.6;
		maxSpeed = 188;
		fuelConsumption = 6.5;
		tankVolume  = 50.0;
		fuelAmount = 50.0;
		isEngineWorking = false;
		isHandbrakeSwitchedOn = true;
		gearPositionNumber = 0;
		isHeadlightsSwitchedOn = false;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
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
	
	public Colors getColor() {
		return color;
	}
	
	public void setColor(Colors color) {
		this.color = color;
	}
	
	public String getVIN() {
		return VIN;
	}
	
	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}
	
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	public double getTankVolume() {
		return tankVolume;
	}
	
	public void setTankVolume(double tankVolume) {
		this.tankVolume = tankVolume;
	}
	
	public double getFuelAmount() {
		return fuelAmount;
	}
	
	public int getFuelDistanceEndurance() {
		return (int) (fuelAmount / fuelConsumption * 100);
	}
	
	public void refill(double fuelAmount) {
		if ( ( this.fuelAmount + fuelAmount ) > this.tankVolume ) {
			this.fuelAmount += this.tankVolume - this.fuelAmount;
			System.out.println("Enough! Tank is full!");
		} else {
			this.fuelAmount += fuelAmount;
			System.out.println("Fuel Amount = " + this.fuelAmount);
		}
	}
	
	public boolean isEngineWorking() {
		return isEngineWorking;
	}

	public boolean isHandbrakeSwitchedOn() {
		return isHandbrakeSwitchedOn;
	}

	public int getGearPositionNumber() {
		return gearPositionNumber;
	}

	public boolean isHeadlightsSwitchedOn() {
		return isHeadlightsSwitchedOn;
	}

	public void ignitionSwitch(int position) { // 1 = On, 0 = Off
		if ( position == 1 ) {
			isEngineWorking = true;
		} else if ( position == 0 ) {
			isEngineWorking = false;
		} else {
			System.out.println("Incorrect input of ignition switch");
		}
	}
	
	public void handbrakeSwitch(int position) { // 1 = On, 0 = Off
		if ( position == 1 ) {
			isHandbrakeSwitchedOn = true;
		} else if ( position == 0 ) {
			isHandbrakeSwitchedOn = false;
		} else {
			System.out.println("Incorrect input of handbrake switch");
		}
	}
	
	public void gearPositionNumberSwitch(int position) { // -1 = R, 0 = N, 1..5
		if ( position >= -1 && position <= 5 ) {
			gearPositionNumber = position;
		} else {
			System.out.println("Incorrect input of gear position number");
		}
	}
	
	public void headlightsSwitcht(int position) {
		if ( position == 1 ) {
			isHeadlightsSwitchedOn = true;
		} else if ( position == 0 ) {
			isHeadlightsSwitchedOn = false;
		}
	}
}
