package lesson7.stack;

//LIFO (Last In First Out)

public class Stack {
	private Node root;
	private int size;
	
	private class Node {
		private Object obj;
		private Node ref;
	}
	
	public Stack() {
		this.size = 0;
	}
	
	public void push(Object obj) {
		Node node = new Node();
		node.obj = obj;
		
		if (root == null) {
			root = node;
		} else {
			Node last = root;
			Node current = root;
			while (current.ref != null) {
				last = current;
				current = current.ref;
			}
			last.ref = node;
		}
		size++;
	}
	
	public Object pop() {
		
		return null;
	}
	
	public Object peak() {
		
		return null;
	}
	
	public void printStack() {
		if (size == 0) {
			System.out.println("Stack is empty");
		}
		
		System.out.print("{");
		Node current = root;
		while (current.ref != null) {
			System.out.print(current.obj + ", ");
			current = current.ref;		
		}
		System.out.println(current.obj + "}");
	}
}
