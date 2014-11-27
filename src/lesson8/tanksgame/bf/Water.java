package lesson8.tanksgame.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends SimpleBFObject {
	
	public Water(int x, int y) {
		super(x, y);
		try { 
			setImage();
		} catch(IllegalStateException e) {
			color = new Color(0, 0, 255); //blue
		}
	}
	
	private void setImage() {
		try {
			image = ImageIO.read(new File("tanks_img/water_texture.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find brick's image(!)");
		}
	}
}
