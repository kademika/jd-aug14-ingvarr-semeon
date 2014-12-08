package lesson9.shop_gui_mvc;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ShopGUI {

	private Shop shop;
	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldPhoneNumber;
	private JFormattedTextField textFieldDate;
	private JComboBox<Object> productsList;
	private JTable transactionsTable;
	
	public ShopGUI(Shop shop) {
		this.shop = shop;
		
		//Create and set up the window
		frame = new JFrame("Car Shop 2.0");
		frame.setLocation(100, 100);
		frame.setMinimumSize(new Dimension(1040, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create and set up the menu items
		JMenuItem menuItemBuyCar = new JMenuItem("Buy Car");
		menuItemBuyCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showSellingPanel();
			}
		});
		
		JMenuItem menuItemSeeTransactions = new JMenuItem("See transactions");
		menuItemSeeTransactions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showTransactionsListTablePanel();
			}
		});
		
		//Create and set up the menu
		JMenu menuActions = new JMenu("Actions");
		menuActions.add(menuItemBuyCar);
		menuActions.add(menuItemSeeTransactions);
		
		//Create and set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuActions);
		
		frame.getRootPane().setJMenuBar(menuBar);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void showTransactionsListTablePanel() {
//        //Create and set up the window
//        JFrame frame = new JFrame("Transactions List");
//        frame.setLocation(100, 100);
//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//
//        //Create and set up the content pane
//        JPanel tableContentPane = createTransactionsListTablePanel();
//        frame.setContentPane(tableContentPane);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(createTransactionsListTablePanel());

        //Display the window
        frame.pack();
        frame.setVisible(true);
	}
	
	private void showSellingPanel() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(createSellingPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	private JPanel createTransactionsListTablePanel() {
		JPanel tPanel = new JPanel();
//		tPanel.setLayout(new GridBagLayout());
		
		String[] columnNames = {"ID"
								, "Date"
								, "Name"
								, "Surname"
								, "Phone"
								, "Body Type"
								, "Brend"
								, "Model"
								, "Price"};
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		
		ArrayList<Transaction> transactions = shop.getAllTransactions();
		
		Object[][] data = new Object[transactions.size()][];
		for (int i = 0; i < transactions.size(); i++ ) {
			Transaction t = transactions.get(i);
			Object[] co = new Object[] {t.getId(), t.getDate(), t.getCustomer().getName()
					, t.getCustomer().getSurname(), t.getCustomer().getPhoneNumber()
					, t.getCar().getBodyType(), t.getCar().getModel(), t.getCar().getPrice()};
			data[i] = co;
		}
		
		transactionsTable = new JTable(data, columnNames);
		transactionsTable.setPreferredScrollableViewportSize(new Dimension(700, 70));
		transactionsTable.getColumnModel().getColumn(1).setPreferredWidth(130);
		
		 //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(transactionsTable);
        
        //Add the scroll pane to this panel.
        tPanel.add(scrollPane);
        
        return tPanel;
	}

	private JPanel createSellingPanel() {
		JPanel sPanel = new JPanel();
		sPanel.setLayout(new GridBagLayout());

		JLabel labelName = new JLabel("Customer Name:");
		sPanel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldName = new JTextField(); //////////////////////////////////////// final ??? //should be global var
		textFieldName.setColumns(11);
		sPanel.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelSurame = new JLabel("Customer Surname:");
		sPanel.add(labelSurame, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldSurname = new JTextField(); ///////////////////////////////////// final ??? //should be global var
		textFieldSurname.setColumns(11);
		sPanel.add(textFieldSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelPhoneNumber = new JLabel("Phone number:");
		sPanel.add(labelPhoneNumber, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldPhoneNumber = new JTextField("+380"); /////////////////////////// final ??? //should be global var
		textFieldPhoneNumber.setColumns(11);
		sPanel.add(textFieldPhoneNumber, new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelDate = new JLabel("Date:");
		sPanel.add(labelDate, new GridBagConstraints(0, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		textFieldDate = new JFormattedTextField(dateFormat.format(today)); // final ???
		textFieldDate.setColumns(11);
		sPanel.add(textFieldDate, new GridBagConstraints(1, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		
		JLabel labelCar = new JLabel("Car:");
		sPanel.add(labelCar, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		final Car[] products = shop.getGarage(); //////////////////////////////////// should be final or global var
		productsList = new JComboBox<Object>(products); ////////////////////////////////// final ??? //should be global var
		sPanel.add(productsList, new GridBagConstraints(1, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		sPanel.add(buyButton, new GridBagConstraints(1, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 5, 5));
		
		JButton transListButton = new JButton("See transactions");
		sPanel.add(transListButton, new GridBagConstraints(1, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton inStockButton = new JButton("In Stock");
		sPanel.add(inStockButton, new GridBagConstraints(2, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton priceListButton = new JButton("Price List");
		sPanel.add(priceListButton, new GridBagConstraints(3, 6, 1, 1, 0, 0,
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
				
				try {
					shop.sell(date, car, customer);
				} catch (NullPointerException exception) {
					System.out.println("(!) Requested car is absent (!)");
				}
			}
		});
		
		transListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.outTransactionsList();
				showTransactionsListTablePanel();
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
		
		return sPanel;
	}

}
