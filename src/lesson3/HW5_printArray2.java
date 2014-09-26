package lesson3;

public class HW5_printArray2 {

	public static void main(String[] args) {
		printArray2(new String[][] { {""}, {""} });
		printArray2(new String[][] { {"Oleg"}, {"Inna", "Smith", "25"}, {"Irina", "Koval" } });
		printArray2(new String[][] { {""}, {"Oleg", "Kotov", "16" }, {""} });
		printArray2(new String[][] { {"Oleg"}, { "Anton" }, {""}, {"Anna", "25"} });
		printArray(new String[][] { {"Oleg"}, { "Anton" }, {""}, {"Anna", "25"} });
	}
	 // java.lang.ArrayIndexOutOfBoundsException ???
	static void printArray(String[][] data) {
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			System.out.print("[");
			for (int j = 0; j < data.length; j++) {
				if ( data[i][j] != null )
					System.out.print(data[i][j] + " ");
			}
			System.out.print("]");
		}
		System.out.println("]");
	}
	
	static void printArray2(String[][] data) { //For each ???
		System.out.print("[");
		for (String[] cell : data) {
			System.out.print("[");
			for (String s : cell) {
				if ( s != null ) {
					System.out.print(s + " ");
				}
			}
			System.out.print("]");
		}
		System.out.println("]");
	}

}
