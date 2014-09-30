package lesson5.compoundInterest;

public class DepositCalculator {
	
	public static int dreamSumAccumulation(int monthlyPayment, double interest, int dreamSum) {
		double monthlyInterest = interest / 12;
		double balance = 0;
		
		int monthsQty = 0;
		for(; balance < dreamSum; monthsQty++) {
			balance += monthlyPayment + (balance + monthlyPayment) * monthlyInterest / 100;
		}
		System.out.println("Balance (goal)    : " + (int) balance);
		System.out.println("Interest          : " + interest + "%");
		System.out.println("Monthly payment   : " + monthlyPayment);
		System.out.println("Months qty        : " + monthsQty);
		
		return monthsQty / 12;
	}
	
	public static int capitalAccumulation(int monthlyPayment, double interest, int monthsQty) {
		double monthlyInterest = (double) interest / 12;
		double balance = 0;
		
		for(int i = 0; i < monthsQty; i++) {
			balance = balance + monthlyPayment + (balance + monthlyPayment) * monthlyInterest / 100;
		}
		System.out.println("Months qty (gola) : " + monthsQty);
		System.out.println("Years qty         : " + monthsQty / 12);
		System.out.println("Interest          : " + interest + "%");
		System.out.println("Monthly payment   : " + monthlyPayment);
		System.out.println("Net profit        : " + (int) (balance - monthlyPayment * monthsQty));
		
		return (int) balance;
	}
}
