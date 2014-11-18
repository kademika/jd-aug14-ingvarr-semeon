package lesson8.tanksgame.bf.tanks;

import lesson8.tanksgame.Direction;
import lesson8.tanksgame.bf.Destroyable;
import lesson8.tanksgame.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();
	
	public void turn(Direction direction);

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
