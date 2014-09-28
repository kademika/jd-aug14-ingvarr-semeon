package lesson5.tankInheritance;

public enum TankColor {
	BLACK(0), BLUE(1), GREEN(2), RED(3);
	
	private int id;
	
	private TankColor(int id) {
		this.id = id;
	}
	
	TankColor getDefaultColor() {
		return BLACK;
	}
}
