package lesson3;

public class B3_Arrays {

	public static void main(String[] args) {
		int length = 5;
		int[] dataInt = new int[length];
		double[] dataDouble = new double[length];
		boolean[] dataBoolean = new boolean[length];
		String[] dataString = new String[length];

		int i = 0;
		while (i < length) {
			System.out.println(dataInt[i]);
			i++;
		}

		i = 0;
		while (i < length) {
			System.out.println(dataDouble[i]);
			i++;
		}

		i = 0;
		while (i < length) {
			System.out.println(dataBoolean[i]);
			i++;
		}

		i = 0;
		while (i < length) {
			System.out.println(dataString[i]);
			i++;
		}

	}

}
