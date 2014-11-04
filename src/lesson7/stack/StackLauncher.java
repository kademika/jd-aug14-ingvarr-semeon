package lesson7.stack;

public class StackLauncher {

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(42);
		st.push(66);
		st.push(99);
		st.printStack();
		
		st.peak();
		st.printStack();
		
		st.pop();
		st.printStack();
		
	}

}
