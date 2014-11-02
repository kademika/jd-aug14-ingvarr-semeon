package lesson7.tanksgame.bf.tanks;

import java.awt.Color;

import lesson7.tanksgame.Direction;
import lesson7.tanksgame.bf.BattleField;

public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		movePath = 2;
		tankColor = new Color(205, 0, 0); //dark red
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		movePath = 2;
		tankColor = new Color(205, 0, 0); //dark red
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	private Object[] actoins = new Object[] {
			Action.FIRE,
			Action.MOVE,
			Action.FIRE,
			Action.MOVE,
			Action.FIRE
		};
		
	private int step = 0;
		
	@Override
	public Action setUp() {
		if (step >= actoins.length) {
			step = 0;
		}
		if (!(actoins[step] instanceof Action)) {
			turn((Direction) actoins[step++]);
		}
		if (step >= actoins.length) {
			step = 0;
		}
		return (Action) actoins[step++];
	}
}
