package lesson5.tanksgame;

public class Tank {
	private int x;
	private int y;
	private Direction direction;
	
	protected int speed = 15; // this is delay in milliseconds for method Thread.sleep()
	
	private ActionField actionField;
	private BattleField battleField;
	
	public Tank(ActionField af, BattleField bf) {
		this(af, bf, 0, 256, Direction.RIGHT);
	}
	
	public Tank(ActionField af, BattleField bf, int x, int y, Direction direction) {
		this.actionField = af;
		this.battleField = bf;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Tank(int tankX, int tankY, Direction direction, int speed) {
		this.x = tankX;
		this.y = tankY;
		this.direction = direction;
		this.speed = speed;
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
	
	public void destroy() {
		this.x = -100;
		this.y = -100;
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
