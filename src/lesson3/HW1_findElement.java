package lesson3;

public class HW1_findElement {

	public static void main(String[] args) {
		System.out.println(findElement(new double[] { 1.2, 24.1, 0, 5.0, 11.1 }, 5.0));
		System.out.println(findElement(new double[] { 1.2, 24.1, 0, 5, 11.1 }, 5.0));
		System.out.println(findElement(new double[] { 1.2, 24.1, 0, 5, 11.1 }, 7.0));
		System.out.println(findElement(new double[] {}, 1.0));

	}

	static int findElement(double[] numbers, double el) {
		if (numbers != null) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == el) {
					return i;
				}
			}
		}
		return -1;
	}
}
