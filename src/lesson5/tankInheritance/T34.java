package lesson5.tankInheritance;

public class T34 extends Tank {
	public T34() {
		setMaxSpeed(50);
	}

	public T34(TankColor color, int crew) {
		super(color, crew, 50); //Calling constructor of the base class
	}

	@Override
	public void move() {
		System.out.println("..T34 is moving..");
	}

	@Override
	public String toString() {
		return "T34 " + super.toString();
	}
}
