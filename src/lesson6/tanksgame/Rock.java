package lesson6.tanksgame;

import java.awt.Color;
import java.awt.Graphics;

public class Rock implements IDrawable, IDestroyable {
	private int x;
	private int y;
	private Color color;
	
	private ActionField actionField;
	private BattleField battleField;
	
	public Rock(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setColor(new Color(120, 120, 120)); //grey
	}
	
	public Rock(ActionField af, BattleField bf) {
		this.actionField = af;
		this.battleField = bf;
		this.setColor(new Color(120, 120, 120)); //grey
	}
	
	@Override
	public void destroy() {
		battleField.updateQuadrant(y, x, " ");
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
