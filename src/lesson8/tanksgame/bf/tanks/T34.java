package lesson8.tanksgame.bf.tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lesson8.tanksgame.Direction;
import lesson8.tanksgame.bf.BattleField;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 128, 512, Direction.UP);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
		setImages();
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
		setImages();
	}
	
	private void setImages() {
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("green-top.png").getAbsoluteFile());
			images[1] = ImageIO.read(new File("green-bottom.png").getAbsoluteFile());
			images[2] = ImageIO.read(new File("green-left.png").getAbsoluteFile());
			images[3] = ImageIO.read(new File("green-right.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find tank's image(!)");
		}	
	}

	private Object[] actoins = new Object[] {
		Direction.RIGHT,
		Action.FIRE,
		Action.MOVE,
		Action.FIRE,
		Action.MOVE,
		Action.FIRE,
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
