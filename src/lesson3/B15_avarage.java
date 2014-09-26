package lesson3;

public class B15_avarage {

	public static void main(String[] args) {
		int[] data1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] data2 = { 5, 4, 3, 2, 1, 0 };
		int[] data3 = { 0 };
		int[] data4 = { 9, -9, 9 };
		int[] data5 = { -7, -8, -9, -11, -12 };

		System.out.println(avarage(data1));
		System.out.println(avarage(data2));
		System.out.println(avarage(data3));
		System.out.println(avarage(data4));
		System.out.println(avarage(data5));

		System.out.println(avarage(null));
		System.out.println(avarage(new int[0]));
	}

	static double avarage(int[] data) {
		if (data != null && data.length > 0) {
			double sum = 0;

			for (int i : data) {
				sum += i;
			}
			return sum / data.length;
		}
		return -1;
	}

}
