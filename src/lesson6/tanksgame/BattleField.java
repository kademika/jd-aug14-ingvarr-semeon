package lesson6.tanksgame;

public class BattleField {
	private int bfWidth = 592;
	private int bfHeight = 592;
	
	String[][] battleField = { { "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", "B", "B", " ", "B", "B", "B", "B", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" } };
	
	public BattleField() {}
	
	public BattleField(String[][] battleField) {
		this.battleField = battleField;
	}
	
	public String scanQuadrant(int v, int h) {
		return battleField[v][h];
	}
	
	public void updateQuadrant(int v, int h, String object) {
		battleField[v][h] = object;
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
	
	int getDimentionX() {
		return battleField.length; //9
	}
	
	int getDimentionY() {
		return battleField.length; //9
	}

	public int getBfWidth() {
		return bfWidth;
	}

	public int getBfHeight() {
		return bfHeight;
	}
	
}
