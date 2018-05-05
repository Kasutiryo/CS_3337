package org.gradle.demo;

import java.time.LocalTime;
import java.util.ArrayList;
import org.gradle.models.Class;
import org.gradle.models.Day;
import org.gradle.models.User;
import org.gradle.scheduling.*;

public class Demo {
	
	public ArrayList<User> users = new ArrayList<>();

	public Demo() {
		init();
	}

    public void init() {

		users.add(new User(0, "admin", "cs3220password", "ATS", "Admin", "", null, null));

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

		users.add(new User(1, "student", "", "Enrique", "Castillo", "Computer Science", subjects_1, list_of_classes_1));

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

		users.add(new User(2, "tutor", "", "Joanna", "Smith", "Computer Science", subjects_2, list_of_classes_2));

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
			
		String[] subjects_3 = {"CS"};
		users.add(new User(3, "", "", "John", "Smith", "Computer Science", subjects_3, list_of_classes_3));

		// <------------------------------------------------------------------------------------------------------------------------------->

		ArrayList<LocalTime> class_8 = new ArrayList<>();
		class_8.add(LocalTime.of(8, 00));
		class_8.add(LocalTime.of(17, 30));

		Class[] list_of_class_4 = {
			new Class("CS", 2012, "Java Programming II",
				new Day[] {
					new Day(Day.TUESDAY, class_8),
					new Day(Day.THURSDAY, class_8),
					new Day(Day.WEDNESDAY, class_8),
					new Day(Day.FRIDAY, class_8)
				})};
		
		String[] subjects_4 = {"CS"};
		users.add(new User(4, "", "", "Christine", "Robinson", "Computer Science", subjects_4, list_of_class_4));

		// <-------------------------------------------------------------------------------------------------------------------------------->

		ArrayList<LocalTime> class_9 = new ArrayList<>();
		class_9.add(LocalTime.of(8, 00));
		class_9.add(LocalTime.of(17, 30));

		Class[] list_of_class_5 = {
			new Class("CS", 2012, "Java Programming II",
				new Day[] {
					new Day(Day.MONDAY, class_9),
					new Day(Day.TUESDAY, class_9),
					new Day(Day.THURSDAY, class_9),
					new Day(Day.WEDNESDAY, class_9),
					new Day(Day.FRIDAY, class_9)
				})};
		
		String[] subjects_5 = {"CS"};
		users.add(new User(5, "", "", "Edwardo", "Gomez", "Computer Science", subjects_5, list_of_class_5));
		
    }
}