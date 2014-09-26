package lesson3;

import java.util.Arrays;

public class B9_printArray {

	public static void main(String[] args) {
		printArray(new int[] { 1, 10, 5, 7, 6 });
		printArray(new int[] { 0 });
		printArray(new int[] {});
		printArray(new int[] { 0, 0, 15, 25, 16 });
		printArray(new int[] { -3, 25, 2 });

		int[] dataNull = null;
		printArray(dataNull);

		System.out.println(Arrays.toString(new int[] { 1, 2, 3, 4, 5 }));

	}

	static void printArray(int[] data) {
		if (data != null) {
			int i = 0;
			if (data.length == 0) {
				System.out.println("[]");
				return;
			}
			System.out.print("[");
			while (i < data.length - 1) {
				System.out.print(data[i] + " ");
				i++;
			}
			System.out.println(data[i] + "]");
		}
	}

}
