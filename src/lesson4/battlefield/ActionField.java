package lesson4.battlefield;

import java.util.Random;

/**
 * Rendering and interaction of objects: Tank movement, Bullet flight, including
 * the destruction of objects on the BattleField
 * 
 * @author isemenov
 *
 */
public class ActionField {
	BattleField bf; // = new BattleField(); // (?) public class BattleField extends JPanel
	Tank tank = new Tank();
	Bullet bullet = new Bullet();

	String getQuadrant(int x, int y) {
		return y / 64 + "_" + x / 64;
	}

	String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	void turn(int direction) {
		if (tank.getTankDirection() != direction) {
			tank.setTankDirection(direction); // 1 - up, 2 - down, 3 - left, 4 - right
		}
	}

	boolean processInterceptionMove(int tankXMove, int tankYMove) {
		String coordinates = getQuadrant(tankXMove, tankYMove);
		int y = Integer.parseInt(coordinates.substring(0,
				coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(
				coordinates.indexOf("_") + 1, coordinates.length()));

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (bf.battleField[y][x] != " " && bf.battleField[y][x] != "") { // (?) java.lang.NullPointerException
				bf.battleField[y][x] = " ";
				return true;
			}
		}
		return false;
	}

	void move(int direction) throws Exception {
		int stepPixels = 1;
		int covered = 0;
		int tankXMove = tank.getTankX();
		int tankYMove = tank.getTankY();

		turn(direction); // 1 - up, 2 - down, 3 - left, 4 - right

		while (covered < 64) {
			if (direction == 1 && tank.getTankY() > 0) {
				if (processInterceptionMove(tankXMove, tankYMove - 64)) {
					fire();
					System.out.println("[Interception]");
				}
				tank.setTankY(tank.getTankY() - stepPixels);
				System.out.println("[" + direction + "]" + "[move up]: "
						+ "tankX = " + tank.getTankX() + ", tankY = "
						+ tank.getTankY());
			} else if (direction == 2 && tank.getTankY() < 512) {
				if (processInterceptionMove(tankXMove, tankYMove + 64)) {
					fire();
					System.out.println("[Interception]");
				}
				tank.setTankY(tank.getTankY() + stepPixels);
				System.out.println("[" + direction + "]" + "[move down]: "
						+ "tankX = " + tank.getTankX() + ", tankY = "
						+ tank.getTankY());
			} else if (direction == 3 && tank.getTankX() > 0) {
				if (processInterceptionMove(tankXMove - 64, tankYMove)) {
					fire();
					System.out.println("[Interception]");
				}
				tank.setTankX(tank.getTankX() - stepPixels);
				System.out.println("[" + direction + "]" + "[move left]: "
						+ "tankX = " + tank.getTankX() + ", tankY = "
						+ tank.getTankY());
			} else if (direction == 4 && tank.getTankX() < 512) {
				if (processInterceptionMove(tankXMove + 64, tankYMove)) {
					fire();
					System.out.println("[Interception]");
				}
				tank.setTankX(tank.getTankX() + stepPixels);
				System.out.println("[" + direction + "]" + "[move right]: "
						+ "tankX = " + tank.getTankX() + ", tankY = "
						+ tank.getTankY());
			} else {
				System.out.println("[" + direction + "]"
						+ "[battle field boundary]: " + "tankX = "
						+ tank.getTankX() + ", tankY = " + tank.getTankY());
			}
			covered += stepPixels;

			bf.repaint();
			Thread.sleep(tank.getSpeed());
		}
	}

	void moveToQuadrant(int v, int h) throws Exception {
		String targetXY = getQuadrantXY(v, h);
		int targetX = Integer.parseInt(targetXY.substring(0,
				targetXY.indexOf("_")));
		int targetY = Integer.parseInt(targetXY.substring(
				targetXY.indexOf("_") + 1, targetXY.length()));
		int stepPixels = 64;
		int directionX = 0;
		int directionY = 0;
		int stepsXQty = 0;
		int stepsYQty = 0;

		System.out.println("[target coordinates]: " + targetX + ", " + targetY);

		if (tank.getTankX() < targetX) {
			directionX = 4; // right
			stepsXQty = (targetX - tank.getTankX()) / stepPixels;
		} else if (tank.getTankX() > targetX) {
			directionX = 3; // left
			stepsXQty = (tank.getTankX() - targetX) / stepPixels;
		}

		if (tank.getTankY() < targetY) {
			directionY = 2; // down
			stepsYQty = (targetY - tank.getTankY()) / stepPixels;
		} else if (tank.getTankY() > targetY) {
			directionY = 1; // up
			stepsYQty = (tank.getTankY() - targetY) / stepPixels;
		}

		if (directionX > 0 && stepsXQty > 0) {
			while (stepsXQty > 0) {
				move(directionX);
				stepsXQty -= 1;
			}
		}

		if (directionY > 0 && stepsYQty > 0) {
			while (stepsYQty > 0) {
				move(directionY);
				stepsYQty -= 1;
			}
		}

		System.out.println("[current coordinates]: " + "tankX = "
				+ tank.getTankX() + ", tankY = " + tank.getTankY());

	}

	void moveRandom() throws Exception {
		Random r = new Random();
		int i;
		while (true) {
			i = r.nextInt(5);
			if (i > 0) {
				move(i);
			}
		}
	}

	boolean processInterception() {
		String coordinates = getQuadrant(bullet.getBulletX(),
				bullet.getBulletY());
		int y = Integer.parseInt(coordinates.substring(0,
				coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(
				coordinates.indexOf("_") + 1, coordinates.length()));

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (bf.battleField[y][x] != " " && bf.battleField[y][x] != "") {
				bf.battleField[y][x] = " ";
				return true;
			}
		}
		return false;
	}

	void fire() throws Exception {
		bullet.setBulletX(tank.getTankX() + 25); // 0 + 25
		bullet.setBulletY(tank.getTankY() + 25); // 256 + 25

		int step = 1;
		while ((bullet.getBulletX() > -14 && bullet.getBulletX() < 592)
				&& (bullet.getBulletY() > -14 && bullet.getBulletY() < 592)) {
			if (tank.getTankDirection() == 1) {
				bullet.setBulletY(bullet.getBulletY() - step);
			} else if (tank.getTankDirection() == 2) {
				bullet.setBulletY(bullet.getBulletY() + step);
			} else if (tank.getTankDirection() == 3) {
				bullet.setBulletX(bullet.getBulletX() - step);
			} else {
				bullet.setBulletX(bullet.getBulletX() + step);
			}

			if (processInterception()) {
				bullet.setBulletY(-100);
				bullet.setBulletX(-100);
				System.out.println("[Direct Hit]");
			}

			bf.repaint();
			Thread.sleep(bullet.getBulletSpeed());
		}

	}

	void clean() throws Exception {
		tank.setSpeed(0);
		tank.setTankY(1);
		tank.setSpeed(1);

		fire();
		moveToQuadrant(0, 9);
		moveToQuadrant(2, 0);
		moveToQuadrant(3, 9);
		moveToQuadrant(4, 0);
		moveToQuadrant(5, 9);
		moveToQuadrant(6, 0);
		moveToQuadrant(7, 9);
		moveToQuadrant(8, 0);
		moveToQuadrant(9, 9);
		moveToQuadrant(5, 5);
	}

}
