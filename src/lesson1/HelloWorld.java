package lesson1;

public class HelloWorld {
	 
    public static void main(String[] argvc) {
        String test = new String("Hello World!");
        int vInt = 101;
        
        
        changeIt(test);
        System.out.println("After  change1: " + test);
        
        changeIt2(test);
        System.out.println("After  change2: " + test);
        
        changeIt(vInt);
        System.out.println("After  change int: " + vInt);
    }
 
    static void changeIt(String value) {
    	System.out.println("Before  change: " + value);
    	value = new String("Hello!");
    }
    
    static void changeIt2(String value) {
        value = "Hello!";
    }
    
    static void changeIt(int value) {
        value = 1110111;
    }
    
    
}
