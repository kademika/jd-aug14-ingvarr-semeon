package lesson6.tanksgame.af;

import java.awt.Color;

public class T34 extends AbstractTank {
	
	public T34(ActionField af) {
		super(af);
		tankColor = new Color(0, 255, 0); 
		towerColor = new Color(255, 0, 0);
	}
	
	public T34(ActionField af, int x, int y, Direction direction) {
		super(af, x, y, Direction.RIGHT);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
	}
	
}
