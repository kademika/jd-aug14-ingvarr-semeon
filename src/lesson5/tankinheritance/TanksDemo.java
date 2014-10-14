package lesson5.tankinheritance;

public class TanksDemo {

	public static void main(String[] args) {
		BT7 bt7 = new BT7(TankColor.BLUE, 3);
		T34 t34 = new T34(TankColor.GREEN, 4);
		Tiger tiger = new Tiger(TankColor.RED, 5);
		WhiteTiger wtiger = new WhiteTiger();
		Tank tank = new Tank();

		tank.move();
		wtiger.move();
		tiger.move();
		t34.move();
		bt7.move();

		System.out.println();
		System.out.println(tank.toString());
		System.out.println(wtiger.toString());
		System.out.println(tiger.toString());
		System.out.println(t34.toString());
		System.out.println(bt7.toString());

		System.out.println();
		System.out.println("Tanks for production:");
		System.out.println("Tiger [" + tiger.getColor() + ", "
				+ tiger.getCrew() + ", " + tiger.getMaxSpeed() + ", " + tiger.getArmor() + "]");
		System.out.println("T34 [" + t34.getColor() + ", " + t34.getCrew()
				+ ", " + t34.getMaxSpeed() + "]");
		System.out.println("BT7 [" + bt7.getColor() + ", " + bt7.getCrew()
				+ ", " + bt7.getMaxSpeed() + "]");
	}

}
