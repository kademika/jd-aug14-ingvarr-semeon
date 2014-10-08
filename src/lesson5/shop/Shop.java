package lesson5.shop;

public class Shop {
	public Car[] garage;
	//public Transaction[] transactions; //should realize array of transactions and supported functional 

	public Shop(int garageCapacity) {
		garage = new Car[garageCapacity];
	}

	public void addToGarage(Car car) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] == null) {
				garage[i] = car;
				return;
			}
			if (garage[i] != null && i == garage.length) {
				System.out.println("[Garage is full]");
			}
		}
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
							+ " " + list[i].getModel() + " "
							+ list[i].getColor() + " : " + list[i].getPrice());
				}
			}
			System.out.println();
		}
	}
}
