package lesson7.tanksgame.bf.tanks;

import lesson7.tanksgame.Direction;
import lesson7.tanksgame.bf.Destroyable;
import lesson7.tanksgame.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

}
