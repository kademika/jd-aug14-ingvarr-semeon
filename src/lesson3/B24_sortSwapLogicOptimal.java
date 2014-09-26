package lesson3;

import java.util.Arrays;
import java.util.Random;

public class B24_sortSwapLogicOptimal {

	public static void main(String[] args) {
//		int[] data1 = { 4, 0, -6, 5, -2, 3, -4, -99, 66, -7, 1, -3, 2, -8, -1,
//				-5 };
//		int[] data2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		int[] data3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//
//		System.out.println(Arrays.toString(data1));
//		sort(data1);
//		System.out.println(Arrays.toString(data1));
//
//		System.out.println("");
//
//		System.out.println(Arrays.toString(data2));
//		sort(data2);
//		System.out.println(Arrays.toString(data2));
//
//		System.out.println("");
//
//		System.out.println(Arrays.toString(data3));
//		sort(data3);
//		System.out.println(Arrays.toString(data3));

		 int[] dataK = createArray(1000);
		 int[] data10K = createArray(10000);
		 int[] data100K = createArray(100000);
		 int[] data1M = createArray(1000000);
		 int[] data1MR = createRandomArray(1000000);
		
//		 sort(dataK);
//		 sort(data10K);
//		 sort(data100K);
		 
		 long time1 = System.currentTimeMillis();
		 Arrays.sort(dataK);
		 System.out.println(System.currentTimeMillis() - time1);
		 
		 long time2 = System.currentTimeMillis();
		 Arrays.sort(data10K);
		 System.out.println(System.currentTimeMillis() - time2);
		 
		 long time3 = System.currentTimeMillis();
		 Arrays.sort(data100K);
		 System.out.println(System.currentTimeMillis() - time3);
		 
		 long time4 = System.currentTimeMillis();
		 Arrays.sort(data1M);
		 System.out.println(System.currentTimeMillis() - time4);
		 
		 long time5 = System.currentTimeMillis();
		 Arrays.sort(data1MR);
		 System.out.println(System.currentTimeMillis() - time5);
		 
	}

	static int[] createArray(int dimension) {
		int[] data = new int[dimension];
		int cValue = dimension;

		for (int i = 0; i < data.length; i++) {
			data[i] = cValue--;
		}
		return data;
	}
	
	static int[] createRandomArray(int dimension) {
		int[] data = new int[dimension];
		Random r = new Random();
		
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(dimension);
		}
		return data;

	}

	static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		if (data != null && data.length > 0) {
			for (int i = 1; i < data.length; i++) {
				for (int j = 0; j < data.length - i; j++) {
					if (data[j] > data[j + 1]) {
						swap(data, j, j + 1);
					}
				}
			}
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}
