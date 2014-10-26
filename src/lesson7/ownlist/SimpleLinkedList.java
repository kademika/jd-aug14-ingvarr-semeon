package lesson7.ownlist;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {
	private Node root;
	private int size;
	
	public SimpleLinkedList() {
		size = 0;
	}
	
	private class Node {
		private Object obj;
		private Node ref;
	}
	
	@Override
	public Iterator<Object> iterator() {
		return new SLLIterator();
	}
	
	private class SLLIterator implements Iterator<Object> {
		private Node prev;
		private Node current;
		
		public SLLIterator() {
		}

		@Override
		public void remove() {
			if (!hasNext() && prev == null ) {
				//only one element
				current = null;
				root = null;
			} else if (!hasNext() && prev != null) {
				//last element
				prev.ref = null;
				current = null;
			} else if (hasNext() && prev == null) {
				//first element
				root = current.ref;
				current = root;
			} else {
				//middle element
				prev.ref = current.ref;
				current = current.ref;
			}
			size--;
		}
		
		@Override
		public boolean hasNext() {
			return (current == null && root != null) || (current != null && current.ref != null);
		}

		@Override
		public Object next() {
			if (current == null && root != null) {
				//first
				current = root;
				return current.obj;
			}
			if (hasNext()) {
				prev = current;
				current = current.ref; //cp gets next element
				return current.obj;
			}
			throw new IllegalStateException("List has no more elements");
		}
	}
	
	public void addFirst(Object obj) {
		Node node = new Node();
		node.obj = obj;
		
		if (root != null) {
			node.ref = root;
		}
		root = node;
		size++;
	}
	
	public void addLast(Object obj) {
		Node node = new Node();
		node.obj = obj;
		
		if (root == null) {
			root = node;
		} else {
			Node last = root;
			Node cp = root;
			while (cp.ref != null) { //what about array step???
				last = cp;
				cp = cp.ref;
			}
			last.ref = node;
		}
		size++;
	}
	
	public void addAfter(Object obj, Object prev) {
		Node node = new Node();
		node.obj = obj;
		Node prevPointer = null;
		Node cp = root;
		
		do {
			if (cp.obj == prev) {
				prevPointer = cp;
				break;
			}
			cp = cp.ref;
		} while (cp != null && cp.ref != null); //what about array step???
			
		if (prevPointer == null) {
			throw new IllegalStateException("List does not contain prev object.");
		}
		
		if (prevPointer.ref != null) {
			node.ref = prevPointer.ref;
		}
		prevPointer.ref = node;
		
		size++;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void printList() {
		if (size == 0) {
			System.out.println("List is empty");
		}
		
		System.out.print("{");
		Node cp = root;
		while (cp.ref != null) {
			System.out.print(cp.obj + ", ");
			cp = cp.ref;		
		}
		System.out.println(cp.obj + "}");
	}
	
}
