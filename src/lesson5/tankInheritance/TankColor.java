package lesson5.tankInheritance;

public enum TankColor {
	BLACK(0), BLUE(1), GREEN(2), RED(3), WHITE(4);
	
	private int id;
	
	private TankColor(int id) {
		this.id = id;
	}
	
	public static TankColor getDefaultColor() {
		return BLACK;
	}
}
