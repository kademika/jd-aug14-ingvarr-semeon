package lesson4.objects;

public class ObjectReference {
	private String name;
	private ObjectReference reference;

	public ObjectReference(String name) {
		this.name = name;
	}

	public ObjectReference getReference() {
		return reference;
	}

	public void setReference(ObjectReference reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void printReference() {
		System.out.println(name + " -> " + reference.getName());
	}
}
