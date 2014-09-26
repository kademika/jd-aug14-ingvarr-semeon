package lesson3;

public class B13_oddElementSum {

	public static void main(String[] args) {
		int[] data1 = {1, 2, 3, 4, 5};
		int[] data2 = {-1, -10, 8, -1, 7};
		int[] data3 = {0};
		int[] data4 = {};
		int[] data5 = {9, -9, 9};
		
		System.out.println(oddElementSum(data1));
		System.out.println(oddElementSum(data2));
		System.out.println(oddElementSum(data3));
		System.out.println(oddElementSum(data4));
		System.out.println(oddElementSum(data5));

	}
	
	static long oddElementSum(int[] data) {
		if ( data != null && data.length > 0 ) {
			long oddSum = 0;
			
			for ( int i = 0; i < data.length; i++ ) {
				if ( i % 2 != 0 ) {
					oddSum += data[i];
				}
			}
			return oddSum;
		}
		return -1;
	}

}
