package lesson5.tanksgame;

public class BT7 extends Tank {

	public BT7(ActionField af, BattleField bf) {
		super(af, bf);
		this.speed *= 2;
	}
	
	public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
		super(af, bf, x, y, direction);
		this.speed *= 2;
	}
}
