package lesson5.tankinheritance;

public class Tiger extends Tank {
	private int armor = 1;

	public Tiger() {
		setMaxSpeed(360);
	}

	public Tiger(TankColor color, int crew) {
		setColor(color);
		setCrew(crew);
		setMaxSpeed(36);
	}

	@Override
	public void move() {
		System.out.println("..Tiger is slowly moving..");
	}

	@Override
	public String toString() {
		return "Tiger [color: " + this.getColor() + ", crew: "
						+ this.getCrew() + ", max speed: "
						+ this.getMaxSpeed() + ", armor: " + this.getArmor() + "]";
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

}
