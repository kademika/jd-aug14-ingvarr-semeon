package lesson5.shop;

public class Transaction {
	private int id;
	private String customerName;
	private Car carForSale;
	
	public Transaction() {
	}
	
	public static void transaction(int dayNumber, int id, String customerName, Car carForSale) {
		Statistic.addTransactionToCounter(dayNumber);
		Statistic.addTransactionToList(id, customerName, carForSale);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Car getCarForSale() {
		return carForSale;
	}

	public void setCarForSale(Car carForSale) {
		this.carForSale = carForSale;
	}
	
	
}
