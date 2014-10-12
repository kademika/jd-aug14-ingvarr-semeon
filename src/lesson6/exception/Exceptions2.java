package lesson6.exception;

public class Exceptions2 {

	public static void main(String[] args) {
		catcher();
		System.out.println("DONE");
	}
	
	public static void catcher() {
		try {
			throw new Exception();
		} catch (Exception e) {
			throw new IllegalStateException();
		} finally {
			System.out.println("I want to be printed!");
		}
		
	}
}
