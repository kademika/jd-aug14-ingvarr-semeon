package lesson5.tankInheritance;

public class BT7 extends Tank {
	public BT7() {
		setMaxSpeed(72);
	}

	public BT7(TankColor color, int crew) {
		setColor(color);
		setCrew(crew);
		setMaxSpeed(72);
	}

	@Override
	public void move() {
		System.out.println("..BT7 is rapidly moving..");
	}

	@Override
	public String toString() {
		return "BT7 " + super.toString();
	}

}
