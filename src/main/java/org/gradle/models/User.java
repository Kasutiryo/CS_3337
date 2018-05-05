package org.gradle.models;

import java.time.LocalTime;
import java.util.ArrayList;

public class User {
	private final int id;
	private final String username;
	private final String password;
	private final String first_name;
	private final String last_name;
	private final String major;
	private Class[] list_of_classes;
	private Day[] schedule;
	private String[] subjects;

	public User(int id, String username, String password, String first_name, 
		String last_name, String major, String[] subjects, Class[] list_of_classes) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.major = major;
		this.subjects = subjects;
		this.list_of_classes = list_of_classes;
		this.schedule = composeList(list_of_classes);
}

	private Day[] composeList(Class[] list) {

		if(list == null) {
			return null;
		}

		Day[] toReturn = new Day[5];

		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = new Day(determineDay(i), new ArrayList<LocalTime>());
		}

		for (int i = 0; i < list.length; i++) {

			Day[] class_days = list[i].getSchedule();

			for (int j = 0; j < class_days.length; j++) {

				int input_day = determineDay(class_days[j].getDay());
				if(input_day == -1) {continue;}

				ArrayList<LocalTime> time = toReturn[input_day].getIntervals();
				for(LocalTime item: class_days[j].getIntervals()) {
					time.add(item);
				}

				toReturn[input_day].setIntervals(time);

			}
		}


		return toReturn;
	}

	private int determineDay(String day) {
		switch (day) {
			case "MONDAY": return 0; 
			case "TUESDAY": return 1;
			case "WEDNESDAY": return 2; 
			case "THURSDAY": return 3;
			case "FRIDAY": return 4;
			default: return -1;
		}
	}

	private String determineDay(int index) {
		switch (index) {
			case 0: return Day.MONDAY;
			case 1: return Day.TUESDAY;
			case 2: return Day.WEDNESDAY;
			case 3: return Day.THURSDAY;
			case 4: return Day.FRIDAY;
			default: return "";
		}
	}
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public String getFullName() {
		return first_name + " " + last_name;
	}

	public String getMajor() {
		return major;
	}

	public Class[] getClasses() {
		return list_of_classes;
	}

	public Day[] getSchedule() {
		return schedule;
	}

	public String getStringSubjects() {
		String toReturn = "";
		for(String item: subjects) {
			toReturn += item;
		}

		return toReturn;
	}

	public String[] getArraySubjects() {
		return subjects;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		final User user = (User) obj;
		return this.id == user.id && this.username.equals(user.username) &&
			this.password.equals(user.password);
	}

	@Override
	public int hashCode() {
		return this.id;
	}
}
