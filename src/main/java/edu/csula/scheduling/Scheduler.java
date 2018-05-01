package edu.csula.scheduling;

import edu.csula.models.Day;
import edu.csula.models.User;

public class Scheduler {

    /**
     * Finds the interval of time between two time intervals where the student
     * and tutor have hours in common throughout the day (8 AM - 5 PM).
     */
    public String find_avaiability(User student, User tutor) {
        
        Day[] student_schedule = student.getSchedule();
        Day[] tutor_schedule = tutor.getSchedule();

        String toReturn = "";
        for (int i = 0; i < student_schedule.length; i++) {
            if (student_schedule[i].getIntervals().isEmpty() || tutor_schedule[i].getIntervals().isEmpty()) {
                toReturn += student_schedule[i].getDay() + " ";
            } else {
                    toReturn += student_schedule[i].equals(tutor_schedule[i]) + " ";
            }
        }        


        return toReturn;
    }
}