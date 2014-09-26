package lesson4.tanksgame;

public class Bullet {
	private int x;
	private int y;
	private int speed = 5;
	private int direction;
	
	public Bullet(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void updateX(int value) {
		this.x += value;
	}
	
	public void updateY(int value) {
		this.y += value;
	}
	
	public void destroy() {
		this.x = -100;
		this.y = -100;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDirection() {
		return direction;
	}
	
}
