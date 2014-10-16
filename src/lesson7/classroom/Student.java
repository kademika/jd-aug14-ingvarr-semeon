package lesson7.classroom;

/**
 * JavaBean
 * 1. All properties private (use getters/setters)
 * 2. A public no-argument constructor
 * 3. Implements Serializable
 */

public class Student {
	private String name;
	private String surname;
	
	public Student() {
	}
	
	public Student(String name, String surname) {
		this.setName(name);
		this.setSurname(surname);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.surname + "\n";
	}
}
