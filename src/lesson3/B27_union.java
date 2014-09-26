package lesson3;

import java.util.Arrays;

public class B27_union {

	public static void main(String[] args) {
		int[] data1 = { 1, 2, 3 };
		int[] data2 = { 4, 5, 6, 7 };

		System.out.println(Arrays.toString(union(data1, data2)));

	}

	static int[] union(int[] data1, int[] data2) {
		int[] data = new int[data1.length + data2.length];

		for (int i = 0; i < data1.length; i++) {
			data[i] = data1[i];
		}
		for (int i = data1.length, j = 0; j < data2.length; i++, j++) {
			data[i] = data2[j];
		}

		return data;

	}
}
