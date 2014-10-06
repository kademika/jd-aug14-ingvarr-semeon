package lesson5.tanksgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {
	private boolean COLORDED_MODE = false;

	private BattleField battleField;
	private Tank defender;
	private Tank aggressor;
	private Bullet bullet;

	public void runTheGame() throws Exception {
		defender.fire();
		defender.fire();
		defender.move();
		defender.move();
		defender.turn(Direction.DOWN);
		defender.move();
		defender.turn(Direction.RIGHT);
		defender.move();
		defender.turn(Direction.DOWN);
		defender.move();
		defender.turn(Direction.RIGHT);
		defender.move();
		defender.move();
		defender.turn(Direction.UP);
		defender.move();
		defender.turn(Direction.RIGHT);
		defender.move();
		defender.move();
		defender.move();
		defender.turn(Direction.UP);
		defender.move();
		defender.turn(Direction.LEFT);
		defender.fire();
		defender.fire();
	}

	public void processTurn(Tank tank) throws Exception {
		repaint();
	}

	public void processMove(Tank tank) throws Exception {
		this.defender = tank;
		Direction direction = tank.getDirection();
		int stepPixels = 1;
		int covered = 0;

		tank.turn(direction);

		while (covered < 64) {
			if (direction == Direction.UP && tank.getY() > 0) {
				tank.updateY(-stepPixels);
				System.out
						.println("[" + direction + "]" + "[move up]: "
								+ "tankX = " + tank.getX() + ", tankY = "
								+ tank.getY());
			} else if (direction == Direction.DOWN && tank.getY() < 512) {
				tank.updateY(stepPixels);
				System.out
						.println("[" + direction + "]" + "[move down]: "
								+ "tankX = " + tank.getX() + ", tankY = "
								+ tank.getY());
			} else if (direction == Direction.LEFT && tank.getX() > 0) {
				tank.updateX(-stepPixels);
				System.out
						.println("[" + direction + "]" + "[move left]: "
								+ "tankX = " + tank.getX() + ", tankY = "
								+ tank.getY());
			} else if (direction == Direction.RIGHT && tank.getX() < 512) {
				tank.updateX(stepPixels);
				System.out
						.println("[" + direction + "]" + "[move right]: "
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
			if (bullet.getDirection() == Direction.UP) {
				bullet.updateY(-step);
			} else if (bullet.getDirection() == Direction.DOWN) {
				bullet.updateY(step);
			} else if (bullet.getDirection() == Direction.LEFT) {
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
		int y = Integer.parseInt(coordinates.substring(0,
				coordinates.indexOf("_")));
		int x = Integer.parseInt(coordinates.substring(
				coordinates.indexOf("_") + 1, coordinates.length()));

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			if (battleField.scanQuadrant(y, x) != " "
					&& battleField.scanQuadrant(y, x) != "") {
				battleField.updateQuadrant(y, x, " ");
				return true;
			}
			
			//check aggressor
			if (checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
				aggressor.destroy();
				return true;
			}
			
			//check defender
			if (checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
				defender.destroy();
				return true;
			}
		}
		return false;
	}
	
	private boolean checkInterception(String object, String quadrant) {
		int oy = Integer.parseInt(object.split("_")[0]);
		int ox = Integer.parseInt(object.split("_")[1]);
		
		int qy = Integer.parseInt(quadrant.split("_")[0]);
		int qx = Integer.parseInt(quadrant.split("_")[1]);
		
		if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
			if (oy == qy && ox == qx) {
				return true;
			}
		}
		return false;
	}

	public ActionField() throws Exception {
		battleField = new BattleField();
		defender = new Tank(this, battleField); // this = ActionField

		String location = battleField.getAggressorLocation();
		aggressor = new Tiger(this, battleField, 
				Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.UP);

		bullet = new Bullet(-100,-100, Direction.NONE);

		JFrame frame = new JFrame("BATTLE FIELD, DAY 5");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBfWidth(),
				battleField.getBfHeight() + 22));
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
		
		//defender
		g.setColor(new Color(0, 255, 0));
		g.fillRect(defender.getX(), defender.getY(), 64, 64);

		g.setColor(new Color(255, 0, 0));
		if (defender.getDirection() == Direction.UP) {
			g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
		} else if (defender.getDirection() == Direction.DOWN) {
			g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
		} else if (defender.getDirection() == Direction.LEFT) {
			g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
		} else {
			g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
		}
		
		//aggressor
		g.setColor(new Color(255, 0, 0));
		g.fillRect(aggressor.getX(), aggressor.getY(), 64, 64);

		g.setColor(new Color(0, 255, 0));
		if (aggressor.getDirection() == Direction.UP) {
			g.fillRect(aggressor.getX() + 20, aggressor.getY(), 24, 34);
		} else if (aggressor.getDirection() == Direction.DOWN) {
			g.fillRect(aggressor.getX() + 20, aggressor.getY() + 30, 24, 34);
		} else if (aggressor.getDirection() == Direction.LEFT) {
			g.fillRect(aggressor.getX(), aggressor.getY() + 20, 34, 24);
		} else {
			g.fillRect(aggressor.getX() + 30, aggressor.getY() + 20, 34, 24);
		}
		
		//bullet
		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

}
