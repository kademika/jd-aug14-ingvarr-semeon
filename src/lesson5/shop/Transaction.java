package lesson5.shop;

public class Transaction {
	private int id;
	private Customer customer;
	private Car carForSale;
	
	public Transaction() {
	}
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getCustomer() + " " + this.getCarForSale();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCarForSale() {
		return carForSale;
	}

	public void setCarForSale(Car carForSale) {
		this.carForSale = carForSale;
	}
	
	
}
