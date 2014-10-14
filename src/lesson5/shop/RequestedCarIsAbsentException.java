package lesson5.shop;

public class RequestedCarIsAbsentException extends RuntimeException {
	
	public RequestedCarIsAbsentException() {
		System.out.println("(!) Requested car is absent (!)");
	}
}
