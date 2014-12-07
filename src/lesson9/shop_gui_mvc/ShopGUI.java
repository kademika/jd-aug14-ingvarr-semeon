package lesson9.shop_gui_mvc;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ShopGUI {

	private Shop shop;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldPhoneNumber;
	private JFormattedTextField textFieldDate;
	private JComboBox productsList;
//	private JPanel TransactionsListTablePanel;
	

	public ShopGUI(Shop shop) {
		this.shop = shop;

		JFrame frame = new JFrame("Car Shop 2.0");

		frame.setLocation(100, 100);
		frame.setMinimumSize(new Dimension(240, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(createSellingPanel());

		frame.pack();
		frame.setVisible(true);
	}
	
	private void showTransactionsListTablePanelGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Transactions List");
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //Create and set up the content pane.
        JPanel tableContentPane = createTransactionsListTablePanel();
        frame.setContentPane(tableContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	private JPanel createTransactionsListTablePanel() {
		JPanel TLTPanel = new JPanel();
		String[] columnNames = {"ID"
								, "Date"
								, "Name"
								, "Surname"
								, "Phone"
								, "Body Type"
								, "Brend"
								, "Model"
								, "Price"};
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		
		Object[][] data = {
				{"001", dateFormat.format(new Date()), "Name", "Surname", "Phone"
					, "Body Type", "Brend", "Model", "Price"}
		};
		
		JTable transactionsTable = new JTable(data, columnNames);
		transactionsTable.getColumnModel().getColumn(1).setPreferredWidth(140);
		
		 //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(transactionsTable);
        
        //Add the scroll pane to this panel.
        TLTPanel.add(scrollPane);
        
        return TLTPanel;
	}

	private JPanel createSellingPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		JLabel labelName = new JLabel("Customer Name:");
		panel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldName = new JTextField(); //////////////////////////////////////// final ??? //should be global var
		textFieldName.setColumns(11);
		panel.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelSurame = new JLabel("Customer Surname:");
		panel.add(labelSurame, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldSurname = new JTextField(); ///////////////////////////////////// final ??? //should be global var
		textFieldSurname.setColumns(11);
		panel.add(textFieldSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelPhoneNumber = new JLabel("Phone number:");
		panel.add(labelPhoneNumber, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldPhoneNumber = new JTextField("+380"); /////////////////////////// final ??? //should be global var
		textFieldPhoneNumber.setColumns(11);
		panel.add(textFieldPhoneNumber, new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelDate = new JLabel("Date:");
		panel.add(labelDate, new GridBagConstraints(0, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		textFieldDate = new JFormattedTextField(dateFormat.format(today)); // final ???
		textFieldDate.setColumns(11);
		panel.add(textFieldDate, new GridBagConstraints(1, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		
		JLabel labelCar = new JLabel("Car:");
		panel.add(labelCar, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		final Car[] products = shop.getGarage(); //////////////////////////////////// should be final or global var
		productsList = new JComboBox(products); ////////////////////////////////// final ??? //should be global var
		panel.add(productsList, new GridBagConstraints(1, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		panel.add(buyButton, new GridBagConstraints(1, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 5, 5));
		
		JButton transListButton = new JButton("See transactions");
		panel.add(transListButton, new GridBagConstraints(1, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton inStockButton = new JButton("In Stock");
		panel.add(inStockButton, new GridBagConstraints(2, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton priceListButton = new JButton("Price List");
		panel.add(priceListButton, new GridBagConstraints(3, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText(); //////////////////////////// Change modifier to final
				String surname = textFieldSurname.getText(); ////////////////////// Change modifier to final
				String phone = textFieldPhoneNumber.getText(); //////////////////// Change modifier to final
				
				Customer customer = new Customer(name, surname, phone);
				
				Car car = products[productsList.getSelectedIndex()]; ////////////// Change modifier to final
				
				String date = textFieldDate.getText(); //////////////////////////// Change modifier to final

				shop.sell(date, car, customer);
			}
		});
		
		transListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.outTransactionsList();
				showTransactionsListTablePanelGUI();
			}
		});
		
		inStockButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.inStock();
			}
		});
		
		priceListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.getPriceList();
			}
		});
		
		return panel;
	}

}
