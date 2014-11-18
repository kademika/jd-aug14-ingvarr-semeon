package lesson8.tanksgame.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends SimpleBFObject {

	public Brick(int x, int y) {
		super(x, y);
		color = new Color(0, 0, 255);
		try {
			image = ImageIO.read(new File("bricks.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find brick's image(!)");
		}
	}
}
