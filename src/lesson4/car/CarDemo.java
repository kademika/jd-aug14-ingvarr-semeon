package lesson4.car;

public class CarDemo {

	public static void main(String[] args) {
		Car car = new Car();
		
		System.out.println("Engine start: " + car.isEngineWorking());
		car.ignitionSwitch(1);
		System.out.println("Engine start: " + car.isEngineWorking());
		System.out.println("Handbrake on: " + car.isHandbrakeSwitchedOn());
		
		System.out.print("Gear position: ");
		if ( car.getGearPositionNumber() == 0 ) { 
			System.out.println("N");
		} else if (car.getGearPositionNumber() == -1 ) {
			System.out.println("R");
		}
	}

}
