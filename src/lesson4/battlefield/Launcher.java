package lesson4.battlefield;

public class Launcher {

	public static void main(String[] args) throws Exception {
		runTheGame();
	}
	
	static void runTheGame() throws Exception {
		BattleField bf = new BattleField();
		
		bf.af.moveToQuadrant(8, 5);
		bf.af.moveToQuadrant(5, 5);
		bf.af.moveToQuadrant(5, 6);
		bf.af.moveToQuadrant(5, 4);
		bf.af.moveToQuadrant(5, 5);
		Thread.sleep(3000);
		bf.af.moveToQuadrant(0, 5);
		bf.af.moveToQuadrant(0, 0);

		bf.af.clean();
		
	}

}
