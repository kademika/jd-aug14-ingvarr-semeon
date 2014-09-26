package lesson3;

import java.util.Arrays;

public class B19_sort {

	public static void main(String[] args) {
		// int[] data1 = { 4, 0, -6, 5, -2, 3, -4, -99, 66, -7, 1, -3, 2, -8,
		// -1, -5 };
		// int[] data2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		//
		// System.out.println(Arrays.toString(data1));
		// sort(data1);
		// System.out.println(Arrays.toString(data1));
		//
		// System.out.println("");
		//
		// System.out.println(Arrays.toString(data2));
		// sort(data2);
		// System.out.println(Arrays.toString(data2));

		int[] dataK = createArray(1000);
		int[] data10K = createArray(10000);
		int[] data100K = createArray(100000);

		sort(dataK);
		sort(data10K);
		sort(data100K);

	}

	static int[] createArray(int dimension) {
		int[] data = new int[dimension];
		int cValue = dimension;

		for (int i = 0; i < data.length; i++) {
			data[i] = cValue--;
		}
		return data;
	}

	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		if (data != null && data.length > 0) {
			for (int i = 1; i < data.length; i++) {
				for (int j = 0; j < data.length - i; j++) {
					if (data[j] > data[j + 1]) {
						int tmp = data[j];
						data[j] = data[j + 1];
						data[j + 1] = tmp;
					}
				}
			}
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}
