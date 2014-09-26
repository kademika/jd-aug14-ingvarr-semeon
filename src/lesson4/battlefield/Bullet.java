package lesson4.battlefield;

public class Bullet {
	private int bulletX = -100;
	private int bulletY = -100;
	private int bulletSpeed = 5;
	
	public Bullet() {
		this(-100, -100, 5);
	}
	
	public Bullet(int bulletX, int bulletY, int bulletSpeed) {
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.bulletSpeed = bulletSpeed;
	}
	
	public int getBulletX() {
		return bulletX;
	}
	public void setBulletX(int bulletX) {
		this.bulletX = bulletX;
	}
	public int getBulletY() {
		return bulletY;
	}
	public void setBulletY(int bulletY) {
		this.bulletY = bulletY;
	}
	public int getBulletSpeed() {
		return bulletSpeed;
	}
	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
}
