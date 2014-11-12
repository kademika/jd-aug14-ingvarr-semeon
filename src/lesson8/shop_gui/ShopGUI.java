package lesson8.shop_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		f.setMinimumSize(new Dimension(640, 480));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.getContentPane().add(createSellingPanel());
		
		f.pack();
		f.setVisible(true);
	}
	
	private JPanel createSellingPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		
		JLabel labelName = new JLabel("Customer Name:");		
		panel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		final JTextField textFieldName = new JTextField();
		textFieldName.setColumns(15);
		panel.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelPhoneNumber = new JLabel("Phone number:");
		panel.add(labelPhoneNumber, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		final JTextField textFieldPhoneNumber = new JTextField("+380");
		textFieldPhoneNumber.setColumns(9);
		panel.add(textFieldPhoneNumber, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelDate = new JLabel("Date:");		
		panel.add(labelDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		final JFormattedTextField textFieldDate = new JFormattedTextField(dateFormat.format(today));
		panel.add(textFieldDate, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelCar = new JLabel("Car:");
		panel.add(labelCar, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Car[] products = shop.getGarage();
		JComboBox productsList = new JComboBox(products);
		panel.add(productsList, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		panel.add(buyButton, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer(textFieldName.getText().substring(0, textFieldName.getText().indexOf(" ")), 
						textFieldName.getText().substring(textFieldName.getText().indexOf(" ") + 1, textFieldName.getText().length()), 
						textFieldPhoneNumber.getText());
				//Car car = new Car(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
				
				//shop.sell(textFieldDate, car, customer);
			}
		});
		
		return panel;
	}

}
