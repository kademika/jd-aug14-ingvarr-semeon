package lesson6.exception;

public class Exceptions {
	
	public static void main(String[] args) throws Exception {
		catcher();
		System.out.println("DONE");
	}
	
	public static void catcher() {
		try {
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("I want to be executed!");
		}
		
	}
}
