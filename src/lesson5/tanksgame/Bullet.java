package lesson5.tanksgame;

public class Bullet {
	private int x;
	private int y;
	private Direction direction;
	private int speed = 10; // this is delay in milliseconds for method Thread.sleep()
	
	public Bullet(int x, int y, Direction direction) {
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
	
	public Direction getDirection() {
		return direction;
	}
	
}
