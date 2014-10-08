package lesson6.exception;

public class TryBlock {

	public static void main(String[] args) {
		try {
			TryBlock.doThisForMe();
		} catch (MyPersonalException e) {
			System.out.println("I catched MyPersonalException :)");
		} finally {
			System.out.println("(!) Should deallocate resource");
		}
	}
	
	public static void doThisForMe() throws MyPersonalException {
		throw new MyPersonalException();
	}
	
}
