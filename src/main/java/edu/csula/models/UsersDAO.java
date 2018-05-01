package edu.csula.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.CSS;

import edu.csula.models.User;
import edu.csula.scheduling.Scheduler;

/**
 * To abstract the storage access from the business layer using HttpSession
 */
public class UsersDAO {

	private final HttpSession context;
	protected static final String CONTEXT_NAME = "users";
	private User admin = new User(0, "admin", "cs3220password", "ATS", 
		"Admin", "", null);
	private User student;
	private User tutor;


	public void demo() {
		Class[] list_of_classes = new Class[2]; 
		ArrayList<LocalTime> class_1 = new ArrayList<>();
		class_1.add(LocalTime.of(15, 05));
		class_1.add(LocalTime.of(16, 45));
		list_of_classes[0] = 
			new Class("CS", 4440, "Introduction to Operating Systems", 
				new Day[]{
					new Day(Day.MONDAY, class_1), 
					new Day(Day.WEDNESDAY, class_1)
				});

		ArrayList<LocalTime> class_2 = new ArrayList<>();
		class_2.add(LocalTime.of(9, 50));
		class_2.add(LocalTime.of(12, 00));
		list_of_classes[1] = 
			new Class("CS", 3112, "Analysis of Algorithms", 
				new Day[]{
					new Day(Day.TUESDAY, class_2),
					new Day(Day.WEDNESDAY, class_2)
				});

		student = new User(1, "student", "student", "Enrique", "Castillo", "Computer Science", list_of_classes);

		Class[] loc = new Class[2];

		ArrayList<LocalTime> class_3 = new ArrayList<>();
		class_3.add(LocalTime.of(10, 50));
		class_3.add(LocalTime.of(11, 45));
		loc[0] =
			new Class("CS", 2013, "Data Structures and Algorithms", 
				new Day[]{
					new Day(Day.MONDAY, class_3),
					new Day(Day.WEDNESDAY, class_3)
				});

		ArrayList<LocalTime> class_4 = new ArrayList<>();
		class_4.add(LocalTime.of(11, 05));
		class_4.add(LocalTime.of(14, 00));
		loc[1] =
			new Class("CS", 3220, "Web and Internet Programming", 
				new Day[]{
					new Day(Day.MONDAY, class_4),
					new Day(Day.WEDNESDAY, class_4)
				});

		tutor = new User(2, "tutor", "tutor", "Eduardo", "Panfilo", "Computer Science", loc);
	}



	public UsersDAO(HttpSession context) {
		this.context = context;
		demo();
	}

	public User getStudent() {
		return student;
	}

	public boolean authenticate(String username, String password) {
		// TODO: check if username/password combination is valid and store the
		//       username/password into the session

		if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			context.setAttribute(CONTEXT_NAME, admin);
			return true;
		} else if (student.getUsername().equals(username)) {
			context.setAttribute(CONTEXT_NAME, student);
			context.setAttribute("student", student);
			context.setAttribute("tutor", tutor);
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
		// TODO: return the authenticated user if there is any
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
