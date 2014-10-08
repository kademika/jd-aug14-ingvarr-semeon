package lesson6.exception;

public class MyPersonalException extends RuntimeException {
	
	public MyPersonalException() {
		System.out.println("I'm MyPersonalException, you should catch me :)");
	}
}
