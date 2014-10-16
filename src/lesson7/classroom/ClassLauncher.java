package lesson7.classroom;

public class ClassLauncher {

	public static void main(String[] args) {
		Classroom classroom = new Classroom();
		
		classroom.enter(new Student("Oleg", "Yushchenko"));
		classroom.enter(new Student("Igor", "Semenov"));
		classroom.enter(new Student("Vadim", "Dovbysh"));
		classroom.enter(new Student("Sergey", "Nikolaev"));
		classroom.enter(new Student("Igor", "Demchenko"));
		classroom.enter(new Student("Alex", "Havaldzhy"));
		
		classroom.printStudentInfo();
	}

}
