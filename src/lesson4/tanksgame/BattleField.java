package lesson4.tanksgame;

public class BattleField {
	private int bfWidth = 592;
	private int bfHeight = 592;
	
	String[][] battleField = { { "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", "B", "B", "B", "B", "B", "B", "B", " " },
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
