package lesson7.tanksgame.bf.tanks;

import java.awt.Color;

import lesson7.tanksgame.Direction;
import lesson7.tanksgame.bf.BattleField;

public class Tiger extends AbstractTank {
	
	private int armor;
	
	public Tiger(BattleField bf) {
		super(bf);
		this.armor = 1;
		tankColor = new Color(125, 0, 0); //wine red
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	public Tiger(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		this.armor = 1;
		tankColor = new Color(125, 0, 0); //wine red
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	@Override
	public void destroy() {
		if (armor > 0) {
			armor--;
		} else {
			super.destroy();
		}
	}
	
	@Override
	public Action setUp() {
		return Action.FIRE;
	}
}
