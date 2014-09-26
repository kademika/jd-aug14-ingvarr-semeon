/*
 * Copyright (c) 2014 kademika.com
 */
package lesson2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BattleFieldTemplate extends JPanel {

	boolean COLORDED_MODE = true;
	
	int tankX = 0;
	int tankY = 0;
	
	long speed = 380;
	
	/**
	 * Write your code here.
	 */
	void runTheGame() throws Exception {
		
//		moveForwardBackward();
		
//		move(4);
//		move(1);
//		move(2);
//		move(3);
//		move(1);
		
		while (true) {
			moveRandom();
		}
		
//		moveToQuadrant("e", "6");
//		moveToQuadrant("b", "1");
//		moveToQuadrant("b", "2");
//		moveToQuadrant("b", "2");
//		moveToQuadrant("c", "2");
//		moveToQuadrant("i", "2");
//		moveToQuadrant("e", "5");
		
		
	}
	
	/**
	 * - TANKS -
	 * B25: getQuadrant(String v, String h)
	 */
	static String getQuadrant(String v, String h) {
		int vertical = 0;
		int horizontal = Integer.valueOf(h);
		
		if ( horizontal < 1 || horizontal > 9 ) {
			return "-1";
		}
		
		if ( v.equals("a")) {
			vertical = 1;
		} else if ( v.equals("b")) {
			vertical = 2;
		} else if ( v.equals("c")) {
			vertical = 3;
		}  else if ( v.equals("d")) {
			vertical = 4;
		} else if ( v.equals("e")) {
			vertical = 5;
		} else if ( v.equals("f")) {
			vertical = 6;
		} else if ( v.equals("g")) {
			vertical = 7;
		} else if ( v.equals("h")) {
			vertical = 8;
		} else if ( v.equals("i")) {
			vertical = 9;
		} else {
			return "-1";
		}
		
		return  ( horizontal - 1) * 64 + "_" + ( vertical - 1) * 64;
	}
	
	/**
	 * - TANKS -
	 * B39: move(int direction) takes direction:
	 * 1 - up, 2 - down, 3 - left, 4 - right.
	 */
	void move(int direction) throws Exception {
		int stepPixels = 64;
		
		if ( direction == 1 &&  tankY > 0 ) {
			tankY -= stepPixels;
			System.out.println("[" + direction + "]" + "[move up]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 2 && tankY < 512  ) {
			tankY += stepPixels;
			System.out.println("[" + direction + "]" + "[move down]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 3 && tankX > 0  ) {
			tankX -= stepPixels;
			System.out.println("[" + direction + "]" + "[move left]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 4 && tankX < 512  ) {
			tankX += stepPixels;
			System.out.println("[" + direction + "]" + "[move right]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else {
			System.out.println("[" + direction + "]" + "[battle field boundary]: " + "tankX = " + tankX + ", tankY = " + tankY);
		}
		
		repaint();
		Thread.sleep(speed);
	}
	
	void move2(int direction) throws Exception {
		int stepPixels = 64;
		
		if ( ( direction == 1 && tankY == 0 ) 
				|| ( direction == 2 && tankY == 512 ) 
				|| ( direction == 3 && tankX == 0 ) 
				|| ( direction == 4 && tankX == 512) ) {
			System.out.println("[" + direction + "]" + "[battle field boundary]: " + "tankX = " + tankX + ", tankY = " + tankY);
			return;
		}
		
		if ( direction == 1  ) {
			tankY -= stepPixels;
			System.out.println("[" + direction + "]" + "[move up]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 2  ) {
			tankY += stepPixels;
			System.out.println("[" + direction + "]" + "[move down]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 3  ) {
			tankX -= stepPixels;
			System.out.println("[" + direction + "]" + "[move left]: " + "tankX = " + tankX + ", tankY = " + tankY);
		} else if ( direction == 4  ) {
			tankX += stepPixels;
			System.out.println("[" + direction + "]" + "[move right]: " + "tankX = " + tankX + ", tankY = " + tankY);
		}
		
		repaint();
		Thread.sleep(speed);
	}
	
	
	/**
	 * - TANKS -
	 * HW7: moveRandom() 
	 */
	void moveRandom() throws Exception {
		long random = System.currentTimeMillis();
		String randomStr = String.valueOf(random);
		int randomInt = Integer.parseInt(randomStr.substring(randomStr.length() - 4 ));
		
		while ( randomInt > 4) {
			randomInt = randomInt % 4 + 1;
		}
		
		move(randomInt);
	}
	
	/**
	 * - TANKS -
	 * HW8: moveToQuadrant(String v, String h)
	 */
	void moveToQuadrant(String v, String h) throws Exception {
		String targetXY = getQuadrant(v, h);
		int targetX = Integer.parseInt(targetXY.substring(0, targetXY.indexOf("_")));
		int targetY = Integer.parseInt(targetXY.substring(targetXY.indexOf("_") + 1, targetXY.length()));
		int stepPixels = 64;
		int directionX = 0;
		int directionY = 0;
		int stepsXQty = 0;
		int stepsYQty = 0;
		
		System.out.println("[target coordinates]: " + targetX + ", " + targetY);
		
		if ( tankX < targetX ) {
			directionX = 4; // right
			stepsXQty = ( targetX - tankX ) / stepPixels;
		} else if ( tankX > targetX ) {
			directionX = 3; // left
			stepsXQty = ( tankX - targetX ) / stepPixels;
		}
		
		if ( tankY < targetY ) {
			directionY = 2; // down
			stepsYQty = ( targetY - tankY ) / stepPixels;
		} else if ( tankY > targetY ) {
			directionY = 1; // up
			stepsYQty = ( tankY - targetY ) / stepPixels;
		}
		
		if ( directionX > 0 && stepsXQty > 0 ) {
			while ( stepsXQty > 0 ) {
				move(directionX);
				stepsXQty -= 1;
			}
		}
		
		if ( directionY > 0 && stepsYQty > 0 ) {
			while ( stepsYQty > 0 ) {
				move(directionY);
				stepsYQty -= 1;
			}
		}
		
		System.out.println("[current coordinates]: " + "tankX = " + tankX + ", tankY = " + tankY);
		
	}
	
	/**
	 * - Tanks theme -
	 * B38: moveForwardBackward()
	 */
	void moveForwardBackward() throws Exception {
		int shiftPX = 8;
		
		while ( tankX <= 512) {
			if ( tankX == 512 ) {
				while ( tankX > 0) {
					System.out.println(tankX + ", " + tankY);
					tankX -= shiftPX;
					repaint();
					Thread.sleep(speed);
				}
			}
			System.out.println(tankX + ", " + tankY);
			tankX += shiftPX;
			repaint();
			Thread.sleep(speed);
		}
	}
	
	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 592;
	final int BF_HEIGHT = 592;
	
	public static void main(String[] args) throws Exception {
		BattleFieldTemplate bf = new BattleFieldTemplate();
		bf.runTheGame();
	}

	public BattleFieldTemplate() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(500, 150);
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
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, 64, 64);
	}

}
