package lesson4.tanksgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import lesson4.tanksgame.BattleField;
import lesson4.tanksgame.Tank;
import lesson4.tanksgame.Bullet;

public class ActionField extends JPanel {
	private boolean COLORDED_MODE = false;
	
	private BattleField battleField;
	private Tank tank;
	private Bullet bullet;
	
	public void runTheGame() throws Exception {		
		tank.fire();
		tank.fire();
		tank.move();
		tank.move();
		tank.turn(2);
		tank.move();
		tank.turn(4);
		tank.move();
		tank.turn(2);
		tank.move();
		tank.turn(4);
		tank.move();
		tank.move();
		tank.turn(1);
		tank.move();
		tank.turn(4);
		tank.move();
		tank.move();
		tank.move();
		tank.turn(1);
		tank.move();
		tank.turn(3);
		tank.fire();
		tank.fire();
	}
	
	public void processTurn(Tank tank) throws Exception {
		repaint();
	}
	
	public void processMove(Tank tank) throws Exception {
		this.tank = tank;
		int direction = tank.getDirection(); // 1 - up, 2 - down, 3 - left, 4 - right
		
		int stepPixels = 1;
		int covered = 0;
		
		tank.turn(direction); // 1 - up, 2 - down, 3 - left, 4 - right

		while (covered < 64) {
			if (direction == 1 && tank.getY() > 0) {
				tank.updateY(-stepPixels);
				System.out.println("[" + direction + "]" + "[move up]: "
						+ "tankX = " + tank.getX() + ", tankY = "
						+ tank.getY());
			} else if (direction == 2 && tank.getY() < 512) {
				tank.updateY(stepPixels);
				System.out.println("[" + direction + "]" + "[move down]: "
						+ "tankX = " + tank.getX() + ", tankY = "
						+ tank.getY());
			} else if (direction == 3 && tank.getX() > 0) {
				tank.updateX(-stepPixels);
				System.out.println("[" + direction + "]" + "[move left]: "
						+ "tankX = " + tank.getX() + ", tankY = "
						+ tank.getY());
			} else if (direction == 4 && tank.getX() < 512) {
				tank.updateX(stepPixels);
				System.out.println("[" + direction + "]" + "[move right]: "
						+ "tankX = " + tank.getX() + ", tankY = "
						+ tank.getY());
			} else {
				System.out.println("[" + direction + "]"
						+ "[battle field boundary]: " + "tankX = "
						+ tank.getX() + ", tankY = " + tank.getY());
			}
			covered += stepPixels;

			repaint();
			Thread.sleep(tank.getSpeed());
		}
	}
	
	public void processFire(Bullet bullet) throws Exception {
		this.bullet = bullet;
		int step = 1;
		
		while ((bullet.getX() > -14 && bullet.getX() < 592)
				&& (bullet.getY() > -14 && bullet.getY() < 592)) {
			if (bullet.getDirection() == 1) {
				bullet.updateY(-step);
			} else if (bullet.getDirection() == 2) {
				bullet.updateY(step);
			} else if (bullet.getDirection() == 3) {
				bullet.updateX(-step);
			} else {
				bullet.updateX(step);
			}

			if (processInterception()) {
				bullet.destroy();
				System.out.println("[Direct Hit]");
			}

			repaint();
			Thread.sleep(bullet.getSpeed());
		}
	}
	
	public String getQuadrant(int x, int y) {
		return y / 64 + "_" + x / 64;
	}

	public String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	public boolean processInterception() {
		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int y = Integer.parseInt(coordinates.substring(0, coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(coordinates.indexOf("_") + 1, coordinates.length()));
		
		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (battleField.scanQuadrant(y, x) != " " && battleField.scanQuadrant(y, x) != "") {
				battleField.updateQuadrant(y, x, " ");
				return true;
			}
		}
		return false;
	}
	
	public ActionField() throws Exception {
		battleField = new BattleField();
		tank = new Tank(this, battleField); //this = ActionField
		bullet = new Bullet(-100, 100, -1);
		
		JFrame frame = new JFrame("BATTLE FIELD, DAY 4");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBfWidth(), battleField.getBfHeight() + 22));
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

		for (int j = 0; j < battleField.getDimentionY(); j++) {
			for (int k = 0; k < battleField.getDimentionX(); k++) {
				if (battleField.scanQuadrant(j, k).equals("B")) {
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
		g.fillRect(tank.getX(), tank.getY(), 64, 64);

		g.setColor(new Color(0, 255, 0));
		if (tank.getDirection() == 1) {
			g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
		} else if (tank.getDirection() == 2) {
			g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
		} else if (tank.getDirection() == 3) {
			g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
		} else {
			g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}
	
}
