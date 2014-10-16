package lesson7.classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private List <Student> students;
	
	public Classroom() {
		students = new ArrayList<>();
	}
	
	public void enter(Student s) {
		students.add(s);
	}
	
	public void leave(Student s) {
		students.remove(s);
	}
	
	public int getStudentCount() {
		return students.size();
	}
	
	public boolean isPresent() {
		return false;
	}
	
	public void printStudentInfo() { //All students
		System.out.println(students.toString());
	}

	public List<Student> getStudents() {
		//return students; //Return reference to list
		return new ArrayList<>(students); //A shallow copy of students list (!) As a rule should use this approach
	}
	
}
