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
	
	@Override
	public void destroy() {
		if (this.armor > 0) {
			this.armor--;
		} else {
			super.destroy();
		}
	}
}
