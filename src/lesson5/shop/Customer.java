package lesson5.shop;

public class Customer {
	private String name;
	private String surname;
	private String phoneNumber;
	
	public Customer() {
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
