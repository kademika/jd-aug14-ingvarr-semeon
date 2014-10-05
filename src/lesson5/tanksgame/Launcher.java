package lesson5.tanksgame;

public class Launcher {

	public static void main(String[] args) throws Exception {
		ActionField af = new ActionField();
		af.runTheGame();

		BT7 bt7 = new BT7(null, null);
		Tiger tiger = new Tiger(null, null);

		System.out.println("BT7 [" + bt7.getSpeed() + ", " + bt7.getX() + ", "
				+ bt7.getY() + ", " + bt7.getDirection() + "]");
		
		System.out.println("Tiger [" + tiger.getSpeed() + ", " + tiger.getX() + ", "
				+ tiger.getY() + ", " + tiger.getDirection() + "]");
	}
}
