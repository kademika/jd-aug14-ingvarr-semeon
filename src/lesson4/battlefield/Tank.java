package lesson4.battlefield;

public class Tank {
	private int tankX;
	private int tankY;
	private int tankDirection; // direction: 1 - up, 2 - down, 3 - left, 4 - right
	private int speed;
	
	public Tank() {
		this(0, 256, 4, 10);
	}
	
	public Tank(int tankX, int tankY, int tankDirection, int speed) {
		this.tankX = tankX;
		this.tankY = tankY;
		this.tankDirection = tankDirection;
		this.speed = speed;
	}
	
	public int getTankX() {
		return tankX;
	}
	public void setTankX(int tankX) {
		this.tankX = tankX;
	}
	public int getTankY() {
		return tankY;
	}
	public void setTankY(int tankY) {
		this.tankY = tankY;
	}
	public int getTankDirection() {
		return tankDirection;
	}
	public void setTankDirection(int tankDirection) {
		this.tankDirection = tankDirection;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
