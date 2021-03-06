package lesson8.tanksgame.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Eagle extends SimpleBFObject {

	public Eagle(int x, int y) {
		super(x, y);
		try { 
			setImage();
		} catch(IllegalStateException e) {
			color = new Color(255, 255, 0); //yellow
		}
	}
	
	private void setImage() {
		try {
			image = ImageIO.read(new File("tanks_img/eagle_texture.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find tank's image(!)");
		}	
	}
}
