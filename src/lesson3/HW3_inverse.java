package lesson3;

public class HW3_inverse {

	public static void main(String[] args) {
		String name1 = "IgoR";
		String name2 = "IngvarR";

		System.out.println(inverse(name1));
		System.out.println(inverseOptimal(name2));

	}

	static String inverse(String str) {
		if (str != null) {
			char[] src = str.toCharArray();
			char[] inv = new char[str.length()];

			for (int i = 0, j = src.length - 1; i < src.length; i++, j--) {
				inv[i] = src[j];
			}

			return new String(inv);
		}
		return null;
	}
	
	static String inverseOptimal(String str) {
		if (str != null) {
			char[] array = str.toCharArray();

			for (int lo = 0, hi = array.length - 1; lo < hi; lo++, hi--) {
				char tmp = array[lo];
				array[lo] = array[hi];
				array[hi] = tmp;
			}

			return new String(array);
		}
		return null;
	}
	
}
