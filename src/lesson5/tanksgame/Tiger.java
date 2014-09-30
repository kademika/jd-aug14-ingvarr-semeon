package lesson5.tanksgame;

public class Tiger extends Tank {
	private int armor;
	
	public Tiger(ActionField af, BattleField bf) {
		super(af, bf);
		this.armor = 1;
	}
	
	public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
		super(af, bf, x, y, direction);
		this.armor = 1;
	}
}
