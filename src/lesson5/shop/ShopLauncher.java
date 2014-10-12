package lesson5.shop;

public class ShopLauncher {

	public static void main(String[] args) {
		Shop shop = new Shop(10);
		carsDelivery(shop);
		shop.getPriceList();
		
		Statistic stat = new Statistic();
		stat.inStock(shop);
		
		Customer customer1 = new Customer();
		customer1.setName("Igor");
		customer1.setSurname("Semenov");
		customer1.setPhoneNumber("+380632103895");
		
		Customer customer2 = new Customer();
		customer2.setName("Oleg");
		customer2.setSurname("Yushchenko");
		customer2.setPhoneNumber("+380632103896");
		
		Transaction.transaction(1, 7, customer1, shop.getCarForSale("Ford", "Focus", CarColor.RED, 1.6, GearboxType.DSG));
		Transaction.transaction(2, 8, customer2, shop.getCarForSale("Ford", "Focus", CarColor.SILVER, 1.0, GearboxType.MANUAL));
		
		salesQtyGenerator(stat);
		stat.outLastWeekTransactions();
		
		stat.outTransactionsList();
		
	}
	
	public static void carsDelivery(Shop shop) {
		Hatchback hatch1 = new Hatchback("Ford", "Fiesta", CarColor.BLUE, 1.0, GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatch2 = new Hatchback("Ford", "Fiesta", CarColor.YELLOW, 1.0, GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatch3 = new Hatchback("Ford", "Focus", CarColor.RED, 1.0, GearboxType.MANUAL, 6.3, 316, 25155);
		Hatchback hatch4 = new Hatchback("Ford", "Focus", CarColor.BROWN, 1.0, GearboxType.MANUAL, 6.3, 316, 25155);
		Pickup pickup1 = new Pickup("Ford", "Ranger", CarColor.BLUE, 2.2, GearboxType.CVT, 10.9, 1210, 36000);
		Sedan sedan1 = new Sedan("Ford", "Focus", CarColor.SILVER, 1.0, GearboxType.MANUAL, 6.4, 421, 25546);
		Sedan sedan2 = new Sedan("Ford", "Mondeo", CarColor.BLACK, 2.0, GearboxType.DSG, 10.7, 535, 37615);
		SUV suv1 = new SUV("Ford", "Kuga", CarColor.WHITE, 2.0, GearboxType.DSG, 7.4, 456, 36384);
		Van van1 = new Van("Ford", "S-Max", CarColor.OLIVE_GREEN, 2.0, GearboxType.DSG, 7.4, 1051, 39538);
		Wagon wagon1 = new Wagon("Ford", "Focus", CarColor.RED, 1.6, GearboxType.DSG, 9.3, 476, 25714);
		shop.addToGarage(hatch1);
		shop.addToGarage(hatch2);
		shop.addToGarage(hatch3);
		shop.addToGarage(hatch4);
		shop.addToGarage(pickup1);
		shop.addToGarage(sedan1);
		shop.addToGarage(sedan2);
		shop.addToGarage(suv1);
		shop.addToGarage(van1);
		shop.addToGarage(wagon1);
	}
	
	public static void salesQtyGenerator(Statistic stat) {
		for (int i = 0; i < stat.transactionsCounter.length; i++) {
			stat.addTransactionToCounter((int)(Math.random()*7));
		}
	}
}
