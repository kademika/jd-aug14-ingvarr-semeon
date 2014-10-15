package lesson6.tanksgame.bf;

import java.awt.Graphics;

import lesson6.tanksgame.interfaces.IDrawable;

public class BattleField implements IDrawable {
	private int bfWidth = 592;
	private int bfHeight = 592;
	
	private Brick brick;
	
	String[][] battleField = { { "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", "B", "B", " ", "B", "B", "B", "B", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" } };
	
	public BattleField() {
		brick = new Brick();
	}
	
	public BattleField(String[][] battleField) {
		this.battleField = battleField;
	}
	
	public String scanQuadrant(int v, int h) {
		return battleField[v][h];
	}
	
	public void updateQuadrant(int v, int h, String object) {
		battleField[v][h] = object;
	}
	
	public String getQuadrant(int x, int y) {
		return y / 64 + "_" + x / 64;
	}

	public String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	public String getAggressorLocation() {
//		int randomLocation = ((int)(Math.random()*2) + 1); //0..2 (+1) => 1..3
//		
//		if (randomLocation == 1) {
//			return "128_192";
//		} else if (randomLocation == 2) {
//			return "128_320";
//		} else {
//			return "320_320";
//		}
		return "256_192";
	}
	
	public int getDimentionX() {
		return battleField.length; //9
	}
	
	public int getDimentionY() {
		return battleField.length; //9
	}

	public int getBfWidth() {
		return bfWidth;
	}

	public int getBfHeight() {
		return bfHeight;
	}

	public Brick getBrick() {
		return brick;
	}

	public void setBrick(Brick brick) {
		this.brick = brick;
	}

	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < getDimentionY(); j++) {
			for (int k = 0; k < getDimentionX(); k++) {
				if (scanQuadrant(j, k).equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					brick = new Brick(x, y);
					brick.draw(g);
				}
			}
		}
		
	}
	
}
