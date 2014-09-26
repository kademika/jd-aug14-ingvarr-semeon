package lesson1;


public class HW3_Time {

	public static void main(String[] args) {
		long time = System.currentTimeMillis() / 1000; //convert milliseconds to seconds
		int counter = 60 * 60 * 24; //amount of seconds in 1 day
		
		System.out.print(time / counter + ":"); //the amount of full Days
		
		time %= counter; //the remaining amount of seconds
		counter = 60 * 60; //amount of seconds in 1 hour
		System.out.print(time / counter + ":"); //the amount of full Hours
		
		time %= counter; //the remaining amount of seconds
		counter = 60; //amount of seconds in 1 minute
		System.out.print(time / counter + ":"); //the amount of full Minutes
		
		System.out.println(time % counter); //the amount of Seconds
	}

}
