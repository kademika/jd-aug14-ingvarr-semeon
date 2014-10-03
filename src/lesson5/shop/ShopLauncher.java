package lesson5.shop;

public class ShopLauncher {

	public static void main(String[] args) {
		Shop shop = new Shop(10);
		carsDelivery(shop);
		
		System.out.println(shop.garage[0]);// @Override toString() method is calling automatic. How???
		System.out.println(shop.garage[1]);
		
		Statistic stat = new Statistic(shop);
		stat.salesStat();
		stat.stockStat();
		
	}
	
	public static void carsDelivery(Shop shop) {
		Hatchback hatch1 = new Hatchback("Ford", "Fiesta", CarColor.BLUE, 1.0, GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatch2 = new Hatchback("Ford", "Focus", CarColor.RED, 1.0, GearboxType.MANUAL, 6.3, 316, 25155);
		Sedan sedan1 = new Sedan("Ford", "Focus", CarColor.SILVER, 1.0, GearboxType.MANUAL, 6.4, 421, 25546);
		Wagon wagon1 = new Wagon("Ford", "Focus", CarColor.RED, 1.6, GearboxType.DSG, 9.3, 476, 25714);
		Pickup pickup1 = new Pickup("Ford", "Ranger", CarColor.BLUE, 2.2, GearboxType.CVT, 10.9, 1210, 36000);
		shop.addToGarage(hatch1);
		shop.addToGarage(hatch2);
		shop.addToGarage(sedan1);
		shop.addToGarage(sedan1);
		shop.addToGarage(wagon1);
		shop.addToGarage(pickup1);
	}

}
