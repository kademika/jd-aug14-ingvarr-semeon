package lesson5.shop;

public class Shop {
	public Car[] garage;
	public Customer[] customers;
	public Transaction[] transactions;

	public Shop(int shopCapacity) {
		garage = new Car[shopCapacity];
		customers = new Customer[shopCapacity];
		transactions = new Transaction[shopCapacity];
	}

	public void addToGarage(Car car) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] == null) {
				garage[i] = car;
				return;
			}
			if (garage[i] != null && i == garage.length) {
				System.out.println("[Sorry! Garage is full]");
			}
		}
	}
	
	public void salle(int dayNumber, Car car, Customer customer) {
		
	}

	public Car getCarForSale(String brend, String model, CarColor color,
			double capacity, GearboxType gearbox) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i].getBrend() == brend 
					&& garage[i].getModel() == model
					&& garage[i].getColor() == color 
					&& garage[i].getCapacity() == capacity
					&& garage[i].getGearbox() == gearbox) {
				return garage[i];
			}
		}
		return null;
	}
	
	public void customerReqistration(String name, String surname, String phoneNumber) {
		for(int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				customers[i] = new Customer(name, surname, phoneNumber);
				return;
			}
			if (customers[i] != null && i == customers.length) {
				System.out.println("[Sorry! Customers base is full]");
			}
		}
	}

	public void getPriceList() {
		if (garage != null) {
			Car[] list = new Car[garage.length];

			for (int i = 0, j = 0; i < garage.length; i++) {
				boolean foundMarker = false;
				for (Car car : list) {
					if ( garage[i] != null && car != null && car.getPrice() == garage[i].getPrice()) {
						foundMarker = true;
						break;
					}
				}
				if (foundMarker == false) {
					list[j++] = garage[i];
				}
			}
			
			System.out.println("Price list (USD):");
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null && list[i].getPrice() != 0) {
					System.out.println(list[i].getVIN() + " "
							+ list[i].getBodyType() + " " + list[i].getBrend()
							+ " " + list[i].getModel() + " : " + list[i].getPrice());
				}
			}
			System.out.println();
		}
	}
	
}
