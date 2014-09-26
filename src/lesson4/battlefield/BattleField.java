package lesson4.battlefield;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BattleField extends JPanel {
	final int BF_WIDTH = 592;
	final int BF_HEIGHT = 592;
	final boolean COLORDED_MODE = false;
	String[][] battleField = { { "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", "B", "B", "B", "B", "B", "B", "B", " " },
			{ " ", " ", " ", " ", "B", " ", " ", " ", " " },
			{ " ", " ", "B", " ", " ", " ", "B", " ", " " },
			{ " ", " ", "B", "B", " ", "B", "B", " ", " " },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" } };
	
	ActionField af = new ActionField();
	
	public BattleField() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 4");
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
					String coordinates = af.getQuadrantXY(j + 1, k + 1);
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
		g.fillRect(af.tank.getTankX(), af.tank.getTankY(), 64, 64); // ???

		g.setColor(new Color(0, 255, 0));
		if (af.tank.getTankDirection() == 1) {
			g.fillRect(af.tank.getTankX() + 20, af.tank.getTankY(), 24, 34);
		} else if (af.tank.getTankDirection() == 2) {
			g.fillRect(af.tank.getTankX() + 20, af.tank.getTankY() + 30, 24, 34);
		} else if (af.tank.getTankDirection() == 3) {
			g.fillRect(af.tank.getTankX(), af.tank.getTankY() + 20, 34, 24);
		} else {
			g.fillRect(af.tank.getTankX() + 30, af.tank.getTankY() + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(af.bullet.getBulletX(), af.bullet.getBulletY(), 14, 14);
	}
	
}
