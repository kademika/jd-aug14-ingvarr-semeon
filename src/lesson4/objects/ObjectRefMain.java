package lesson4.objects;

public class ObjectRefMain {

	public static void main(String[] args) {
		ObjectReference ref1 = new ObjectReference("reference1");
		ObjectReference ref2 = new ObjectReference("reference2");
		ObjectReference ref3 = new ObjectReference("reference3");
		
		ref1.setReference(ref2);
		ref2.setReference(ref3);
		ref3.setReference(ref1);
		
		ref1.printReference();
		ref2.printReference();
		ref3.printReference();
	}

}
