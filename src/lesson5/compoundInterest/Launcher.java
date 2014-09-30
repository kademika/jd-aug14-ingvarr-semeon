package lesson5.compoundInterest;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("=> Years qty      : " + DepositCalculator.dreamSumAccumulation(5200, 10.75, 1000000));
		System.out.println("============================");
		System.out.println("=> Balance        : " + DepositCalculator.capitalAccumulation(400, 3.50, 120 + 60));
	}

}
