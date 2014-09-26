package lesson3;

import java.util.Arrays;

public class B22_sortSwapNotOptimal {

	public static void main(String[] args) {
		// int[] data1 = { 4, 0, -6, 5, -2, 3, -4, -99, 66, -7, 1, -3, 2, -8,
		// -1, -5 };
		// int[] data2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

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

	static void swap(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) {
				int tmp = data[i];
				data[i] = data[i + 1];
				data[i + 1] = tmp;
			}
		}
	}

	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		if (data != null && data.length > 0) {
			for (int i = 0; i < data.length - 1; i++) {
				swap(data);
			}
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}
