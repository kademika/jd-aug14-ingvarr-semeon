package lesson4.objects;

public class ComputerDemo {

	public static void main(String[] args) {
		Computer pc = new Computer();
		
		System.out.println("My Computer:\n" 
							+ pc.type + "\n" 
							+ pc.brand + "\n" 
							+ pc.model + "\n" 
							+ pc.CPUName + " " 
							+ pc.CPUClockGHz + "GHz\n"
							+ pc.display
							);
		
	}

}
