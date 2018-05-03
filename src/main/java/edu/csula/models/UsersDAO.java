package edu.csula.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import edu.csula.models.User;
import edu.csula.scheduling.Scheduler;

/**
 * To abstract the storage access from the business layer using HttpSession
 */
public class UsersDAO {

	private final HttpSession context;
	protected static final String CONTEXT_NAME = "users";
	private User admin = new User(0, "admin", "cs3220password", "ATS", "Admin", "", null, null);
	private User tutor = new User(0, "tutor", "", "Tutor", "Account", "tutoring", null, null);
	private User student;
	public ArrayList<User> tutors = new ArrayList<>();


	public void demo() {

		ArrayList<LocalTime> class_1 = new ArrayList<>();
		class_1.add(LocalTime.of(15, 05));
		class_1.add(LocalTime.of(16, 45));

		ArrayList<LocalTime> class_2 = new ArrayList<>();
		class_2.add(LocalTime.of(9, 50));
		class_2.add(LocalTime.of(12, 00));

		ArrayList<LocalTime> class_3 = new ArrayList<>();
		class_3.add(LocalTime.of(11, 05));
		class_3.add(LocalTime.of(14, 00));

		ArrayList<LocalTime> class_4 = new ArrayList<>();
		class_4.add(LocalTime.of(16, 00));
		class_4.add(LocalTime.of(20, 10));

		Class[] list_of_classes_1 = {
			new Class("CS", 4440, "Introduction to Operating Systems", 
				new Day[]{
					new Day(Day.MONDAY, class_1), 
					new Day(Day.WEDNESDAY, class_1)
				}),
			new Class("CS", 3112, "Analysis of Algorithms", 
				new Day[]{
					new Day(Day.TUESDAY, class_2),
					new Day(Day.THURSDAY, class_2)
				}),		
			new Class("CS", 3220, "Web and Internet Programming", 
				new Day[]{
					new Day(Day.SATURDAY, class_3)
				}),
			new Class("CS", 33337, "Software Engineering", 
				new Day[]{
					new Day(Day.SATURDAY, class_4)
				})};
				
		String[] subjects_1 = {"CS", "MATH"};

		student = new User(0, "student", "", "Enrique", "Castillo", "Computer Science", subjects_1, list_of_classes_1);

	// <------------------------------------------------------------------------------------------------------------------------------->

		ArrayList<LocalTime> class_5= new ArrayList<>();
		class_5.add(LocalTime.of(15, 00));
		class_5.add(LocalTime.of(17, 00));

		Class[] list_of_classes_2 = {
			new Class("CS", 2013, "Data Structures and Algorithms", 
				new Day[]{
					new Day(Day.MONDAY, class_5),
					new Day(Day.WEDNESDAY, class_5)
				})};

		String[] subjects_2 = {"CS"};

		tutors.add(new User(0, "", "", "Joanna", "Smith", "Computer Science", subjects_2, list_of_classes_2));

	// <------------------------------------------------------------------------------------------------------------------------------->

		ArrayList<LocalTime> class_6 = new ArrayList<>();
		class_6.add(LocalTime.of(8, 00));
		class_6.add(LocalTime.of(17, 30));

		ArrayList<LocalTime> class_7 = new ArrayList<>();
		class_7.add(LocalTime.of(8, 00));
		class_7.add(LocalTime.of(17, 30));

		Class[] list_of_classes_3 = {
			new Class("CS", 3186, "Introduction to Automata Theory", 
				new Day[] {
					new Day(Day.TUESDAY, class_6),
					new Day(Day.THURSDAY, class_6)
				}),
			new Class("CS", 3035, "Programming Language Paradigms", 
				new Day[] {
					new Day(Day.FRIDAY, class_7)
				})};
			
		String[] subjects = {"CS"};
		tutors.add(new User(1, "", "", "John", "Smith", "Computer Science", subjects, list_of_classes_3));

		// <------------------------------------------------------------------------------------------------------------------------------->

		
	}

	public UsersDAO(HttpSession context) {
		this.context = context;
		demo();
	}


	public boolean authenticate(String username, String password) {

		if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			context.setAttribute(CONTEXT_NAME, admin);
			return true;
		} else if (student.getUsername().equals(username)) {
			context.setAttribute(CONTEXT_NAME, student);
			context.setAttribute("student", student);
			context.setAttribute("tutors", tutors);
			context.setAttribute("scheduler", new Scheduler());
			return true;
		} else if (tutor.getUsername().equals(username)) {
			context.setAttribute(CONTEXT_NAME, tutor);
			context.setAttribute("tutor", tutor);
			return true;
		}
		return false;
	}

	public Optional<User> getAuthenticatedUser() {
		if (context.getAttribute(CONTEXT_NAME) == null) {
			return Optional.empty();
		} else if (context.getAttribute(CONTEXT_NAME) == student) {
			return Optional.of(student);
		} else if (context.getAttribute(CONTEXT_NAME) == tutor) {
			return Optional.of(student);
		} 
		return Optional.of(admin);
	}

	public void logout() {
		// TOOD: log user out using `invalidate`
		context.invalidate();
	}
}
