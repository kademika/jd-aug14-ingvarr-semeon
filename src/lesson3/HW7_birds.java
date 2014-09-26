package lesson3;

import java.util.Arrays;

public class HW7_birds {

	public static void main(String[] args) {
		System.out.println("Birds sold: " + birdsSoldTotal());
		System.out.println("Birds in stock: " + birdsInStockTotal());
		System.out.println("Birds less then 3: "+ Arrays.toString(birdsLess3()));
		System.out.println("Bestseller: " + birdsBestSaller());
		
	}

	static String[][] birdsStock = { 
			{ "Eagle", "5", "5 USD", "1" },
			{ "Duck", "3", "2 USD", "15" }, 
			{ "Parrot", "2", "1.5 USD", "13" }, 
			{ "Starling", "1", "1 USD", "14" },
			{ "Owl", "6", "6 USD", "4" }
			};

	static int birdsSoldTotal() {
		int sum = 0;
		for (int i = 0; i < birdsStock.length; i++) {
			sum += Integer.parseInt(birdsStock[i][3]);
		}
		return sum;
	}

	static int birdsInStockTotal() {
		int sum = 0;
		for (int i = 0; i < birdsStock.length; i++) {
			sum += Integer.parseInt(birdsStock[i][1]);
		}
		return sum;
	}

	static String[] birdsLess3() { // !!! Optimization !!!
		String[] less3 = new String[birdsStock.length];
		
		for (int i = 0, j = 0; i < birdsStock.length; i++) {
			if ( Integer.parseInt(birdsStock[i][1]) < 3 ) {
				less3[j] = birdsStock[i][0];
				j++;
			}
		}
		
		for (int i = 0; i < less3.length; i++) {
			if (less3[i] == null) {
				less3[i] = "";
			}
		}
		return less3;
	}
	
	static String birdsBestSaller() {
		String bestSaller = null;
		int maxQty = Integer.parseInt(birdsStock[0][3]);
		
		for (int i = 0; i < birdsStock.length - 1; i++) {
			if ( maxQty < Integer.parseInt(birdsStock[i + 1][3]) ) {
				maxQty = Integer.parseInt(birdsStock[i + 1][3]);
				bestSaller = birdsStock[i + 1][0];
			}
		}
		return bestSaller;
	}
	
	//+ 4 methods
	
}
