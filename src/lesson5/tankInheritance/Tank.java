package lesson5.tankInheritance;

public class Tank {
	private TankColor color;
	private int crew;
	private int maxSpeed;

	public Tank() {
		// this.color.getDefaultColor(); //Return null and do not work via inheritance in child class ???
		this.color = TankColor.BLACK;
		this.crew = 1;
		setMaxSpeed(40);
	}

	public Tank(TankColor color, int crew, int maxSpeed) {
		this.color = color;
		this.crew = crew;
		setMaxSpeed(maxSpeed);
	}

	public void move() {
		System.out.println(".Tank can move.");
	}

	@Override
	public String toString() {
		return "Tank template [color: " + this.getColor() + ", crew: "
						+ this.getCrew() + ", max speed: "
						+ this.getMaxSpeed() + "]";
	}

	public TankColor getColor() {
		return color;
	}

	public void setColor(TankColor color) {
		this.color = color;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed > 200) {
			this.maxSpeed = 200;
		} else {
			this.maxSpeed = maxSpeed;
		}
	}
}
