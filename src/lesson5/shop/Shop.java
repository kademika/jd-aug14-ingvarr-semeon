package lesson5.shop;

import lesson4.library.Book;

public class Shop {
	private Car[] garage;

	public Shop(int garageCapacity) {
		garage = new Car[garageCapacity];
		this.createGarage(garage);
	}
	
	private void createGarage(Car[] garage) {
		for (int i = 0; i < garage.length; i++) {
			garage[i] = new Car(null, null, null, 0, null, 0, 0, 0);
		}
	}

	public void addToGarage(Car[] garage, Car car) {
	for (int i = 0; i < garage.length; i++) {
		if (garage[i] == null) {
			garage[i] = car;
			return;
		}
	}
}

}
