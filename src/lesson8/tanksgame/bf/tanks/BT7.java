package lesson8.tanksgame.bf.tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lesson8.tanksgame.Direction;
import lesson8.tanksgame.bf.BattleField;

public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		movePath = 2;
		tankColor = new Color(205, 0, 0); //dark red
		towerColor = new Color(255, 200, 0); //yellow
		setImages();
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		movePath = 2;
		tankColor = new Color(205, 0, 0); //dark red
		towerColor = new Color(255, 200, 0); //yellow
		setImages();
	}
	
	private void setImages() {
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("red-top.png").getAbsoluteFile());
			images[1] = ImageIO.read(new File("red-bottom.png").getAbsoluteFile());
			images[2] = ImageIO.read(new File("red-left.png").getAbsoluteFile());
			images[3] = ImageIO.read(new File("red-right.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find tank's image(!)");
		}	
	}
	
	@Override
	public Action setUp() {
		return Action.MOVETO;
	}
	
}
