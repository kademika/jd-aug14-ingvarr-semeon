package lesson5.shop;

public class Shop {
	public Car[] garage;
	public Transaction[] transactions;
//	public Customer[] customers;

	public Shop(int shopCapacity) {
		garage = new Car[shopCapacity];
		transactions = new Transaction[shopCapacity];
//		customers = new Customer[shopCapacity];
	}

	public void addToGarage(Car car) {
		int i = 0;
		for (; i < garage.length; i++) {
			if (garage[i] == null) {
				garage[i] = car;
				return;
			}
		}
		throw new ShopIsOverloadedException();
	}

	public Car getCar(String brend, String model, CarColor color,
			double capacity, GearboxType gearbox) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i].getBrend() == brend && garage[i].getModel() == model
					&& garage[i].getColor() == color
					&& garage[i].getCapacity() == capacity
					&& garage[i].getGearbox() == gearbox) {
				return garage[i];
			}
		}
		throw new RequestedCarIsAbsentException();
	}
	
	public void sell(String ddmmyyyy, Car car, Customer customer) {
		Car carForSale = this.getCar(car.getBrend(), car.getModel(),
				car.getColor(), car.getCapacity(), car.getGearbox());
		customer.setOwnCar(carForSale);
		this.handOut(carForSale);
		this.registerTransaction(ddmmyyyy, customer, carForSale);
//		this.registerCustomer(customer.getName(), customer.getSurname(), customer.getPhoneNumber());
	}
	
	private void handOut(Car car) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i].getBrend() == car.getBrend() && garage[i].getModel() == car.getModel()
					&& garage[i].getColor() == car.getColor()
					&& garage[i].getCapacity() == car.getCapacity()
					&& garage[i].getGearbox() == car.getGearbox()) {
				garage[i] = null;
				return;
			}
		}
		throw new RequestedCarIsAbsentException();
	}
	
	private void registerTransaction(String ddmmyyyy, Customer customer, Car car) {
		for (int i = 0; i < transactions.length; i++) {
			if (transactions[i] == null) {
				transactions[i] = new Transaction(ddmmyyyy, customer, car);
				return;
			}
		}
		throw new ShopIsOverloadedException();
	}

//	private void registerCustomer(String name, String surname, String phoneNumber) {
//		for (int i = 0; i < customers.length; i++) {
//			if (customers[i] == null) {
//				customers[i] = new Customer(name, surname, phoneNumber);
//				return;
//			}
//		}
//		throw new ShopIsOverloadedException();
//	}

	public void getPriceList() {
		if (garage != null) {
			Car[] list = new Car[garage.length];

			for (int i = 0, j = 0; i < garage.length; i++) {
				boolean foundMarker = false;
				for (Car car : list) {
					if (garage[i] != null && car != null
							&& car.getPrice() == garage[i].getPrice()) {
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
							+ " " + list[i].getModel() + " : "
							+ list[i].getPrice());
				}
			}
			System.out.println();
		}
	}
	
	public void inStock() {
		int counterHatchback = 0;
		int counterPickup = 0;
		int counterSedan = 0;
		int counterSUV = 0;
		int counterVan = 0;
		int counterWagon = 0;

		for (int i = 0; i < garage.length; i++) {
			if (garage[i] != null) {
				if (garage[i].getBodyType() == "Hatchback") {
					counterHatchback += 1;
				} else if (garage[i].getBodyType() == "Pickup") {
					counterPickup += 1;
				} else if (garage[i].getBodyType() == "Sedan") {
					counterSedan += 1;
				} else if (garage[i].getBodyType() == "SUV") {
					counterSUV += 1;
				} else if (garage[i].getBodyType() == "Van") {
					counterVan += 1;
				} else if (garage[i].getBodyType() == "Wagon") {
					counterWagon += 1;
				}
			}
		}
		System.out.println();
		System.out.println("In stock (qty):" + "\n Hetchback: "
				+ counterHatchback + "\n Pickup: " + counterPickup
				+ "\n Sedan: " + counterSedan + "\n SUV: " + counterSUV
				+ "\n Van: " + counterVan + "\n Wagon: " + counterWagon);
		System.out.println();
	}
	
	public void outTransactionsList() {
		for (int i = 0; i < transactions.length; i++) {
			if (transactions[i] != null) {
				System.out.println(transactions[i]);
			}
		}
	}
	
}
