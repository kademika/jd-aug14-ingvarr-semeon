package lesson8.shop_gui;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShopGUI {
	
	private Shop shop;
	
	public ShopGUI(Shop shop) {
		this.shop = shop;
		
		JFrame f = new JFrame("Car Shop 1.0");
		
		f.setLocation(100, 100);
		f.setMinimumSize(new Dimension(600, 400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.getContentPane().add(createSellingPanel());
		
		f.pack();
		f.setVisible(true);
	}
	
	private JPanel createSellingPanel() {
		JPanel panel = new JPanel();
		
		JLabel labelName = new JLabel("Customer Name:");		
		panel.add(labelName);
		
		JTextField textFieldName = new JTextField("Name Surname");
		panel.add(textFieldName);
		
		JLabel labelDate = new JLabel("Date:");		
		panel.add(labelDate);
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		JFormattedTextField textFieldDate = new JFormattedTextField(dateFormat.format(today));
		panel.add(textFieldDate);
		
		JLabel labelCar = new JLabel("Car:");
		panel.add(labelCar);
		
		Car[] products = shop.getGarage();
		JComboBox productsList = new JComboBox(products);
//		productsList.setSelectedIndex(0);
		panel.add(productsList);
		
		JButton buyButton = new JButton("Buy");
		panel.add(buyButton);
		
		return panel;
	}

}
