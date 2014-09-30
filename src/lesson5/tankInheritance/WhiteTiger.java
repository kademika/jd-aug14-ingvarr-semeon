package lesson5.tankInheritance;

public class WhiteTiger extends Tiger {

	public WhiteTiger() {
		super(TankColor.WHITE, 5); //Constructor Tiger(TankColor color, int crew)  call
		//super(); //Constructor Tiger() and Tank() call by chain (!)
		super.setArmor(1);
	}
	
	@Override
	public void move() {
		System.out.println("..White Tiger is moving quietly..");
	}

	@Override
	public String toString() {
		return "White " + super.toString();
	}
}
