package lesson5.shop;

public class CarShopDemo {

	public static void main(String[] args) {
		Hatchback hatchback1 = new Hatchback("Ford", "Fiesta", CarColor.BLUE, 1.0, GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatchback2 = new Hatchback("Ford", "Focus", CarColor.RED, 1.0, GearboxType.MANUAL, 6.3, 316, 25155);
		Sedan sedan = new Sedan("Ford", "Focus", CarColor.SILVER, 1.0, GearboxType.MANUAL, 6.4, 421, 25546);
		Wagon wagon = new Wagon("Ford", "Focus", CarColor.RED, 1.6, GearboxType.DSG, 9.3, 476, 25714);
		Pickup pickup = new Pickup("Ford", "Ranger", CarColor.BLUE, 2.2, GearboxType.CVT, 10.0, 1000, 40000);
		
		
		
//		System.out.println(hatchback1.toString());
//		System.out.println(hatchback2.toString());
//		System.out.println(sedan.toString());
//		System.out.println(wagon.toString());
//		System.out.println(pickup.toString());
		
		
	}
	
	public void goodsDelivery(Car car) {
		
	}

}
