package lesson5.shop;

public class Transaction {
	private int id;
	private Customer customerName;
	private Car carForSale;
	
	public Transaction() {
	}
	
	public static void transaction(int dayNumber, int id, Customer customerName, Car carForSale) {
		Statistic.addTransactionToCounter(dayNumber);
		Statistic.addTransactionToList(id, customerName, carForSale);
	}
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getCustomerName() + " " + this.getCarForSale();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Customer customerName) {
		this.customerName = customerName;
	}

	public Car getCarForSale() {
		return carForSale;
	}

	public void setCarForSale(Car carForSale) {
		this.carForSale = carForSale;
	}
	
	
}
