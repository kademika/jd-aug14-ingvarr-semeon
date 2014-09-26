package lesson3;

public class B26_getPopulation {

	public static void main(String[] args) {
		String[][] countries = { { "China", "Peking", "1366350000" },
				{ "India", "New Delhi", "1248400000" },
				{ "USA", "Washungton D.C.", "318622000" },
				{ "Indonesia", "Jakarta", "252164800" },
				{ "Brazil", "Brasilia", "203049000" },
				{ "Pakistan", "Islamabad", "188020000" } };

		System.out.println(getPopulation(countries));
	}

	static long getPopulation(String[][] data) {
		long population = 0;
		for (int i = 0; i < data.length; i++) {
			population += Long.parseLong(data[i][2]);
		}
		return population;
	}

}
