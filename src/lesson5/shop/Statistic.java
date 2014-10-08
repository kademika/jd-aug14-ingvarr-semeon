package lesson5.shop;

public class Statistic {
	public static int[] transactionsCounter;
	public static Transaction[] transactionsList;

	public Statistic() {
		transactionsCounter = new int[7];
		transactionsList = new Transaction[10];
	}

	public void inStock(Shop shop) {
		Car[] cars = shop.garage;
		int counterHatchback = 0;
		int counterPickup = 0;
		int counterSedan = 0;
		int counterSUV = 0;
		int counterVan = 0;
		int counterWagon = 0;

		for (int i = 0; i < cars.length; i++) {
			if (shop.garage[i] != null) {
				if (shop.garage[i].getBodyType() == "Hatchback") {
					counterHatchback += 1;
				} else if (shop.garage[i].getBodyType() == "Pickup") {
					counterPickup += 1;
				} else if (shop.garage[i].getBodyType() == "Sedan") {
					counterSedan += 1;
				} else if (shop.garage[i].getBodyType() == "SUV") {
					counterSUV += 1;
				} else if (shop.garage[i].getBodyType() == "Van") {
					counterVan += 1;
				} else if (shop.garage[i].getBodyType() == "Wagon") {
					counterWagon += 1;
				}
			}
		}
		System.out.println("In stock (qty):" + "\n Hetchback: "
				+ counterHatchback + "\n Pickup: " + counterPickup
				+ "\n Sedan: " + counterSedan + "\n SUV: " + counterSUV
				+ "\n Van: " + counterVan + "\n Wagon: " + counterWagon);
		System.out.println();
	}
	
	public static void addTransactionToCounter(int dayNumber) {
		if (dayNumber >= 1 && dayNumber <= 7) {
			transactionsCounter[dayNumber - 1] += 1;
		}
	}
	
	public static void addTransactionToList(int id, Customer customerName, Car carForSale) {
		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setCustomerName(customerName);
		transaction.setCarForSale(carForSale);
		for (int i = 0; i < transactionsList.length; i++) {
			if (transactionsList[i] == null) {
				transactionsList[i] = transaction;
				return;
			}
		}
	}
	
	public void outTransactionsList() {
		for (int i = 0; i < transactionsList.length; i++) {
			if (transactionsList[i] != null) {
				System.out.println(transactionsList[i]);
			}
		}
	}
	
	public void outLastWeekTransactions() {
		int last = transactionsCounter.length - 1;
		System.out.print("Last week transactions: [" + transactionsCounter[0]  + ", ");
		for(int i = 1; i < last; i++) {
			System.out.print(transactionsCounter[i]  + ", ");
		}
		System.out.println(transactionsCounter[last]  + "]");
	}
}
