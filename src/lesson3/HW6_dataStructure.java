package lesson3;

public class HW6_dataStructure {

	public static void main(String[] args) {
		printStudentsDB();
	}
	
	static String[][] students = {
			{"Andrey", "Shevchenko", "Kyiv", ":"},
			{"Oleg", "Kotov", "Lviv", ":"},
			{"Inna", "Smith", "Chernivtsi", ":"},
			{"Irina", "Koval", "Odesa", ":"}
	};
	
	static String[][] disciplines = {
			{"Informatics", "540", ":"},
			{"Math", "480", ":"},
			{"English", "460", ":"},
			{"Spain", "420", ":"}
	};
	
	static int[] scores = {1, 2, 3, 4, 5};
	
	static int[][] studentsDB = {
			{0, 0, 2},
			{0, 1, 3},
			{0, 2, 3},
			{0, 3, 1},
			{1, 0, 4},
			{1, 1, 3},
			{1, 2, 3},
			{1, 3, 2},
			{2, 0, 2},
			{2, 1, 3},
			{2, 2, 4},
			{2, 3, 4},
			{3, 0, 3},
			{3, 1, 3},
			{3, 2, 4},
			{3, 3, 3}
	};
	
	static void printStudentsDB() { // For each ???
		for (int[] data : studentsDB) {
			for (String s : disciplines[data[0]]) {
				if ( s != null ) {
					System.out.print(s + " ");
				}
			}
			
			for (String s : students[data[1]]) {
				if ( s != null ) {
					System.out.print(s + " ");
				}
			}
			
			System.out.println(scores[data[2]]);
		}
	};

}
