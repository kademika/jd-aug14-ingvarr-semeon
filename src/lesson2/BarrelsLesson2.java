package lesson2;

public class BarrelsLesson2 {

	public static void main(String[] args) {
//		sayHello("Igor");

//		sum(1986, 30);

//		System.out.println(square(2.0));
//
//		System.out.println(square(2));
//
//		System.out.println(square(10d));
//
//		System.out.println(square(22l));

//		System.out.println("I love Java".equals("I love Java"));

//		System.out.println(oldEnought(21));
//
//		System.out.println(oldEnought(19));

//		System.out.println(min(10, 1, -1));

//		System.out.println("Spring? : " + isSpring(3));
//
//		System.out.println("Spring? : " + isSpring(4));
//
//		System.out.println("Spring? : " + isSpring(5));
//
//		System.out.println("Spring? : " + isSpring(1));
//
//		System.out.println("Spring? : " + isSpring(12));
//
//		System.out.println("Spring? : " + isSpring(13));
	
//		int i = 0;
//		while ( i < 15 ) {
//			System.out.println(i++);
//		}
		
//		int j = 0;
//		while ( j < 15 ) {
//			System.out.println(++j);
//		}
	
//		int k = 1;
//		while ( k <= 10) {
//			System.out.println(k);
//			k++;
//		}
		
//		emotions(15, 7, -3);
//		emotions(3, 300, 0);
//		emotions(3, 300, 40);
//		emotions(-47, 74, -4);
		
//		start(7);
//		start(0);
//		start(-7);
		
//		printNumbers(1, 5);
		
		
		
	}

	static void sayHello(String name) {
		System.out.println("Hello " + name);
	}

	static void sum(int num1, int num2) {
		System.out.println(num1 + num2);
		;
	}

	static double square(double number) {
		System.out.println("double square(double number):");
		return number * number;
	}

	static double square(int number) {
		System.out.println("double square(int number):");
		return number * number;
	}

	static boolean oldEnought(int age) {
		if (age >= 21) {
			return true;
		}
		return false;
	}

	static int min(int a, int b, int c) {
		int minValue = a;

		if (b < minValue) {
			minValue = b;
		}

		if (c < minValue) {
			minValue = c;
		}

		return minValue;
	}

	static int isSpring(int month) {
		if (month >= 3 && month <= 5) {
			return 1;
		} else if ((month >= 1 && month <= 2) || (month >= 6 && month <= 12)) {
			return 0;
		} else {
			return -1;
		}
	}
	
	static void emotions(int a, int b, int c) {
		if ( a == 15 || a > c ) {
			if ( a < b ) {
				System.out.print("Heh!");
			} else {
				System.out.print("!!!");
			}
		} else if ( c < 0 && a != 3 ) {
			System.out.print(":)");
		} else {
			System.out.print(":(");
		}
	}
	
	static void start(int number) {
		if ( number <= 0 ) {
			System.out.println("Start failed");
			return;
		}
		
		while ( number > 0 ) {
			System.out.print(number-- + " ");
		}
		System.out.println("Go!");
	}
	
	static void printNumbers(int i, int n) {
		while ( i < n ) {
			n++;
			i += 2;
			System.out.println(i + ", " + n);
		}
	}
	
}
