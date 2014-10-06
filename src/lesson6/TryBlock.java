package lesson6;

public class TryBlock {

	public static void main(String[] args) throws InterruptedException {
		TryBlock.doThisForMe();

	}
	
	public static void doThisForMe() throws InterruptedException {
		Thread.sleep(1000);
	}
	
}
