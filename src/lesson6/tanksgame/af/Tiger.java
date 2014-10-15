package lesson6.tanksgame.af;

import java.awt.Color;

public class Tiger extends AbstractTank {
	private int armor;
	
	public Tiger(ActionField af) {
		super(af);
		this.armor = 1;
		tankColor = new Color(255, 0, 0); 
		towerColor = new Color(0, 255, 0);
	}
	
	public Tiger(ActionField af, int x, int y, Direction direction) {
		super(af, x, y, direction);
		this.armor = 1;
		tankColor = new Color(205, 0, 0); //dark red
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	public int getArmor() {
		return armor;
	}
	
	@Override
	public void destroy() {
		if (this.armor > 0) {
			this.armor--;
		} else {
			super.destroy();
//			this.setX(-100);
//			this.setY(-100);
		}
	}
}
