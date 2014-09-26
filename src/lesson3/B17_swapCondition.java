package lesson3;

import java.util.Arrays;

public class B17_swapCondition {

	public static void main(String[] args) {
		int[] data1 = { 1, 2, 3, 4, 5 };
		int[] data2 = { 1, 20, 3, 4, 5 };
		int[] data3 = { 11, 20, 3, 4, 5 };

		System.out.println(Arrays.toString(data1));
		swap(data1);
		System.out.println(Arrays.toString(data1));
		System.out.println("");
		
		System.out.println(Arrays.toString(data2));
		swap(data2);
		System.out.println(Arrays.toString(data2));
		System.out.println("");
		
		System.out.println(Arrays.toString(data3));
		swap(data3);
		System.out.println(Arrays.toString(data3));
		System.out.println("");

		swap(null);
		swap(new int[] {});
	}

	static void swap(int[] data) {
		if (data != null) {
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i] > data[i + 1]) {
					int tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				}
			}
		}
	}

}
