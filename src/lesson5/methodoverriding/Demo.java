package lesson5.methodoverriding;

public class Demo {

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.toString());

	}
	
//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }
    
    @Override
    public String toString() {
    	return "Hi! My name is Demo.";
    }
}
