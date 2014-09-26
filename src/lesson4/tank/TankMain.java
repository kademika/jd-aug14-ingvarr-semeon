package lesson4.tank;

public class TankMain {

	public static void main(String[] args) {
		Tank tank1 = new Tank();

		Tank tank2 = new Tank();
		tank2.setColor(TankColor.GREEN);
		tank2.setCrew(6);
		tank2.setMaxSpeed(180);

		Tank tank3 = new Tank();
		tank3.setColor(TankColor.RED);
		tank3.setCrew(4);
		tank3.setMaxSpeed(400);

		Tank tank4 = new Tank();
		printTankInfo(tank4);
		tank4.repaint(TankColor.RED);
		printTankInfo(tank4);
		
		Tank[] tanks = { tank1, tank2, tank3, tank4 };
		printTankInfo(tanks);

	}

	static void printTankInfo(Tank tank) {
		System.out.println("Tank info: color = " + tank.getColor()
				+ ", crew = " + tank.getCrew() + ", max speed = "
				+ tank.getMaxSpeed());
	}

	static void printTankInfo(Tank[] tank) {
		if (tank != null) {
			int i = 0;
			for (; i < tank.length; i++) {
				System.out.println("Tank" + (i + 1) + " [color = "
						+ tank[i].getColor() + ", crew = " + tank[i].getCrew()
						+ ", max speed = " + tank[i].getMaxSpeed() + "]");
			}
		}
	}

}
