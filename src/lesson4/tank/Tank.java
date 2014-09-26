package lesson4.tank;

public class Tank {
	private TankColor color;
	private int crew;
	private int maxSpeed;
	
	public Tank() {
		this(TankColor.BLACK, 4, 200);
	}
	
	public Tank(TankColor color, int crew, int maxSpeed) {
		this.color = color;
		this.crew = crew;
		setMaxSpeed(maxSpeed);
		System.out.println("Tank was constructed!");
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
	
	public void repaint(TankColor color) {
		this.setColor(color);
		System.out.println("~Tank was repainted~");
	}
	
}
