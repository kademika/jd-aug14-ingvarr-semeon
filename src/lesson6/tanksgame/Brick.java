package lesson6.tanksgame;

import java.awt.Color;
import java.awt.Graphics;

public class Brick implements IDrawable, IDestroyable {
	private int x;
	private int y;
	private Color color;
	
	private ActionField actionField;
	private BattleField battleField;
	
	public Brick(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setColor(new Color(0, 0, 255));
	}
	
	public Brick(ActionField af, BattleField bf, int x, int y) {
		this.actionField = af;
		this.battleField = bf;
		this.setX(x);
		this.setY(y);
		this.setColor(new Color(0, 0, 255));
	}
	
	@Override
	public void destroy() {
		this.setX(-100);
		this.setY(-100);	
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 64, 64);
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
	
}
