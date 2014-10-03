package lesson5.shop;

public class Shop {
	public Car[] garage;

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

}
