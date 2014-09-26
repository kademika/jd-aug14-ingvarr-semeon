package lesson3;

public class B8_swap {

	public static void main(String[] args) {
		int[] data = { 10, -3, 25, 4 };

		int i = 0;
		while (i < data.length - 1) {
			System.out.print(data[i] + " ");
			i++;
		}
		System.out.println(data[i]);

		swap(data, 1, 3);
		swap(data, 1, 4);

		i = 0;
		while (i < data.length - 1) {
			System.out.print(data[i] + " ");
			i++;
		}
		System.out.println(data[i]);

	}

	static void swap(int[] data, int i, int k) {
		if (data == null || (i >= data.length) || (k >= data.length) || i < 0 || k < 0 || i == k) {
			return;
		}

		int temp = data[i];

		data[i] = data[k];
		data[k] = temp;

	}

}
