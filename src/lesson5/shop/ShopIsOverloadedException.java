package lesson5.shop;

public class ShopIsOverloadedException extends RuntimeException {
	
	public ShopIsOverloadedException() {
		System.out.println("(!) Shop is overloaded. Should extend your shop (!)");
	}
}
