package lesson4;

public class GreetingService {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("Hello " + args[0] + " " + args[1]);
		} else {
			System.out.println("Please input two arguments <Name> <Surname> after command GreetingService through the space character");
		}
	}
}
