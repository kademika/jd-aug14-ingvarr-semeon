package lesson6.tanksgame.bf;

import java.awt.Color;
import java.awt.Graphics;

import lesson6.tanksgame.interfaces.IDestroyable;
import lesson6.tanksgame.interfaces.IDrawable;

public class Brick implements IDrawable, IDestroyable {
	private int x;
	private int y;
	private Color color;
	
	public Brick() {
		this.setColor(new Color(0, 0, 255)); //blue
	}
	
	public Brick(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setColor(new Color(0, 0, 255)); //blue
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 64, 64);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
