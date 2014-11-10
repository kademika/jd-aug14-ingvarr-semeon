package lesson8.shop_gui;

public class Transaction {
	private int id;
	private String ddmmyyyy;
	private Customer customer;
	private Car car;
	
	public Transaction(String ddmmyyyy, Customer customer, Car car) {
		this.setDate(ddmmyyyy);
		this.setCustomer(customer);
		this.setCar(car);
		this.setId((int)(Math.random()*98) + 201); //201..299
	}
	
	@Override
	public String toString() {
		return this.getId() + " " 
				+ this.getDate() + " " 
				+ this.customer.getName() + " " 
				+ this.customer.getSurname() + " " 
				+ this.car.getBodyType() + " " 
				+ this.car.getBrend() + " " 
				+ this.car.getModel() + " " 
				+ this.car.getPrice() ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return ddmmyyyy;
	}

	public void setDate(String ddmmyyyy) {
		this.ddmmyyyy = ddmmyyyy;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
