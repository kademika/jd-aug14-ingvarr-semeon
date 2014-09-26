/*
 * Copyright (c) 2013 midgardabc.com
 */
package lesson3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.0
 */
public class BattleFieldTemplate2 extends JPanel {

	final boolean COLORDED_MODE = false;

	final int BF_WIDTH = 592;
	final int BF_HEIGHT = 592;

	// direction: 1 - up, 2 - down, 3 - left, 4 - right
	int tankDirection = 4;

	int tankX = 0;
	int tankY = 256;

	int bulletX = -100;
	int bulletY = -100;

	int speed = 10;
	int bulletSpeed = 5;

	// String[][] battleField = {
	// {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
	// {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
	// {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
	// {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
	// {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
	// {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
	// {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
	// {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
	// {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
	// };
	String[][] battleField = { { "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", "B", "B", "B", "B", "B", "B", "B", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" } };

	/**
	 * Write your code here.
	 */
	void runTheGame() throws Exception {

		moveToQuadrant(8, 5);
		moveToQuadrant(5, 5);
		moveToQuadrant(5, 6);
		moveToQuadrant(5, 4);
		moveToQuadrant(5, 5);
		Thread.sleep(3000);
		moveToQuadrant(0, 5);
		moveToQuadrant(0, 0);

		clean();

//		System.out.println(getQuadrant(0, 60));
//		System.out.println(getQuadrant(0, 64));
//		System.out.println(getQuadrant(0, 96));
//		System.out.println(getQuadrant(0, 192));
//		System.out.println(getQuadrant(192, 0));

//		System.out.println(processInterception());
//		System.out.println(Arrays.toString(battleField[0]));
//		bulletX = 25;
//		bulletY = 25;
//		System.out.println(processInterception());
//		System.out.println(Arrays.toString(battleField[0]));

	}

	/**
	 * - TANKS - HW9: void clean()
	 */
	void clean() throws Exception {
		tankX = 0;
		tankY = 0;
		speed = 1;
		
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

	/**
	 * - TANKS - B34: boolean processInterception()
	 */
	boolean processInterception() {
		String coordinates = getQuadrant(bulletX, bulletY);
		int y = Integer.parseInt(coordinates.substring(0,
				coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(
				coordinates.indexOf("_") + 1, coordinates.length()));
		// int y = Integer.parseInt(coordinates.split("_")[0]); // ??? //
		// int x = Integer.parseInt(coordinates.split("_")[1]); // ??? //

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (battleField[y][x] != " " && battleField[y][x] != "") {
				battleField[y][x] = " ";
				return true;
			}
		}
		return false;

		// if (y >= 0 && y < 9 && x >= 0 && x < 9) {
		// if (!battleField[y][x].trim().isEmpty()) { // ??? //
		// battleField[y][x] = " ";
		// return true;
		// }
		// }
		// return false;

	}

	/**
	 * - TANKS - HW8: boolean processInterceptionMove() for identification of interceptions
	 */
	boolean processInterceptionMove(int tankXMove, int tankYMove) {
		String coordinates = getQuadrant(tankXMove, tankYMove);
		int y = Integer.parseInt(coordinates.substring(0,
				coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(
				coordinates.indexOf("_") + 1, coordinates.length()));

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (battleField[y][x] != " " && battleField[y][x] != "") {
				battleField[y][x] = " ";
				return true;
			}
		}
		return false;
	}

	/**
	 * - TANKS - B33: String getQuadrant(int x, int y) returns string quadrant "y_x"
	 */
	String getQuadrant(int x, int y) {
		return y / 64 + "_" + x / 64;
	}

	String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	void turn(int direction) {
		if (tankDirection != direction) {
			tankDirection = direction; // 1 - up, 2 - down, 3 - left, 4 - right
		}
	}

	/**
	 * - TANKS - B32,35: void fire()
	 */
	void fire() throws Exception {
		bulletX = tankX + 25; // 0 + 25
		bulletY = tankY + 25; // 256 + 25

		int step = 1;
		while ((bulletX > -14 && bulletX < 592)
				&& (bulletY > -14 && bulletY < 592)) {
			if (tankDirection == 1) {
				bulletY -= step;
			} else if (tankDirection == 2) {
				bulletY += step;
			} else if (tankDirection == 3) {
				bulletX -= step;
			} else {
				bulletX += step;
			}

			if (processInterception()) {
				bulletY = -100;
				bulletX = -100;
				System.out.println("[Direct Hit]");
			}

			repaint();
			Thread.sleep(bulletSpeed);
		}

	}

	/**
	 * - TANKS - HW8: Improved method move() for removal of interceptions
	 */
	void move(int direction) throws Exception {
		int stepPixels = 1;
		int covered = 0;
		int tankXMove = tankX;
		int tankYMove = tankY;

		turn(direction); // 1 - up, 2 - down, 3 - left, 4 - right

		while (covered < 64) {
			if (direction == 1 && tankY > 0) {
				if (processInterceptionMove(tankXMove, tankYMove - 64)) {
					fire();
					System.out.println("[Interception]");
				}
				tankY -= stepPixels;
				System.out.println("[" + direction + "]" + "[move up]: "
						+ "tankX = " + tankX + ", tankY = " + tankY);
			} else if (direction == 2 && tankY < 512) {
				if (processInterceptionMove(tankXMove, tankYMove + 64)) {
					fire();
					System.out.println("[Interception]");
				}
				tankY += stepPixels;
				System.out.println("[" + direction + "]" + "[move down]: "
						+ "tankX = " + tankX + ", tankY = " + tankY);
			} else if (direction == 3 && tankX > 0) {
				if (processInterceptionMove(tankXMove - 64, tankYMove)) {
					fire();
					System.out.println("[Interception]");
				}
				tankX -= stepPixels;
				System.out.println("[" + direction + "]" + "[move left]: "
						+ "tankX = " + tankX + ", tankY = " + tankY);
			} else if (direction == 4 && tankX < 512) {
				if (processInterceptionMove(tankXMove + 64, tankYMove)) {
					fire();
					System.out.println("[Interception]");
				}
				tankX += stepPixels;
				System.out.println("[" + direction + "]" + "[move right]: "
						+ "tankX = " + tankX + ", tankY = " + tankY);
			} else {
				System.out.println("[" + direction + "]"
						+ "[battle field boundary]: " + "tankX = " + tankX
						+ ", tankY = " + tankY);
			}
			covered += stepPixels;

			repaint();
			Thread.sleep(speed);
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

		if (tankX < targetX) {
			directionX = 4; // right
			stepsXQty = (targetX - tankX) / stepPixels;
		} else if (tankX > targetX) {
			directionX = 3; // left
			stepsXQty = (tankX - targetX) / stepPixels;
		}

		if (tankY < targetY) {
			directionY = 2; // down
			stepsYQty = (targetY - tankY) / stepPixels;
		} else if (tankY > targetY) {
			directionY = 1; // up
			stepsYQty = (tankY - targetY) / stepPixels;
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

		System.out.println("[current coordinates]: " + "tankX = " + tankX
				+ ", tankY = " + tankY);

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

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
		BattleFieldTemplate2 bf = new BattleFieldTemplate2();
		bf.runTheGame();
	}

	public BattleFieldTemplate2() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 3");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (battleField[j][k].equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, 64, 64);

		g.setColor(new Color(0, 255, 0));
		if (tankDirection == 1) {
			g.fillRect(tankX + 20, tankY, 24, 34);
		} else if (tankDirection == 2) {
			g.fillRect(tankX + 20, tankY + 30, 24, 34);
		} else if (tankDirection == 3) {
			g.fillRect(tankX, tankY + 20, 34, 24);
		} else {
			g.fillRect(tankX + 30, tankY + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bulletX, bulletY, 14, 14);
	}

}
