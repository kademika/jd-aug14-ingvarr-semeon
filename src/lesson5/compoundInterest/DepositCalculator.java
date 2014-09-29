package lesson5.compoundInterest;

public class DepositCalculator {
	
	public static int darkZone(int monthlyPayment, int interest, int dreamSum) {
		double monthlyInterest = (double) interest / 12; // interest = 12, monthlyInterest = 1.00
		double balance = 0;
		
		int monthsQty = 0;
		for(; balance < dreamSum; monthsQty++) {
			balance = balance + monthlyPayment + (balance + monthlyPayment) * monthlyInterest / 100;
		}
//		System.out.println("balance = " + (int) balance);
//		System.out.println("months qty = " + monthsQty);
		
		return monthsQty / 12;
	}
}
