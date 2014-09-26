package lesson3;

import java.util.Arrays;

public class B16_swap {

	public static void main(String[] args) {
		int[] data1 = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(data1));

		swap(data1);
		System.out.println(Arrays.toString(data1));

		swap(data1);
		System.out.println(Arrays.toString(data1));

		swap(data1);
		System.out.println(Arrays.toString(data1));

		swap(data1);
		System.out.println(Arrays.toString(data1));

		swap(data1);
		System.out.println(Arrays.toString(data1));

		swap(null);
		swap(new int[] {});
	}

	static void swap(int[] data) {
		if (data != null) {
			for (int i = 0; i < data.length - 1; i++) {
				int tmp = data[i];
				data[i] = data[i + 1];
				data[i + 1] = tmp;
			}
		}
	}

}
