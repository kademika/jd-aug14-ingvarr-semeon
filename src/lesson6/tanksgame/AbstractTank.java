package lesson6.tanksgame;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractTank implements IDrawable, IDestroyable {
	private int x;
	private int y;
	private Direction direction;
	
	private int speed = 15; // this is delay in milliseconds for method Thread.sleep()
	
	protected Color tankColor;
	protected Color towerColor;
	
	private ActionField actionField;
	private BattleField battleField;
	
	public AbstractTank(ActionField af, BattleField bf) {
		this(af, bf, 0, 0, Direction.RIGHT);
	}
	
	public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {
		this.actionField = af;
		this.battleField = bf;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public AbstractTank(int tankX, int tankY, Direction direction, int speed) {
		this.x = tankX;
		this.y = tankY;
		this.direction = direction;
		this.speed = speed;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(tankColor); //new Color(0, 255, 0)
		g.fillRect(this.getX(), this.getY(), 64, 64);

		g.setColor(towerColor); //new Color(255, 0, 0)
		if (this.getDirection() == Direction.UP) {
			g.fillRect(this.getX() + 20, this.getY(), 24, 34);
		} else if (this.getDirection() == Direction.DOWN) {
			g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
		} else if (this.getDirection() == Direction.LEFT) {
			g.fillRect(this.getX(), this.getY() + 20, 34, 24);
		} else {
			g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
		}
	}
	
	@Override
	public void destroy() {
		this.setX(-100);
		this.setY(-100);		
	}
	
	public void turn(Direction direction) throws Exception {
		this.direction = direction;
		actionField.processTurn(this);
	}
	
	public void move() throws Exception {
		actionField.processMove(this);
	}
	
	public void fire() throws Exception {
		Bullet bullet = new Bullet((x + 25), (y + 25), direction);
		actionField.processFire(bullet);
	}
	
	public void updateX(int value) {
		this.x += value;
	}
	
	public void updateY(int value) {
		this.y += value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
