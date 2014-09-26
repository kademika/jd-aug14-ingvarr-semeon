package lesson3;

import java.util.Arrays;

public class HW2_copyArray {

	public static void main(String[] args) {
		int[] src = { 2, 0, 1, 4 };
		int[] dest = new int[12];

		copyArray(src, 0, dest, 0, 4);
		//System.arraycopy(src, 0, dest, 0, 4);
		System.out.println(Arrays.toString(dest));

		copyArray(src, 0, dest, 4, 4);
		//System.arraycopy(src, 0, dest, 4, 4);
		System.out.println(Arrays.toString(dest));

		copyArray(src, 0, dest, 8, 4);
		//System.arraycopy(src, 0, dest, 8, 4);
		System.out.println(Arrays.toString(dest));

	}
	
	static void copyArray(int[] src, int srcPos, int[] dest, int destPos, int length) {
		for (int len = length + destPos; destPos < len; destPos++, srcPos++) {
			dest[destPos] = src[srcPos];
		}
	}

}
