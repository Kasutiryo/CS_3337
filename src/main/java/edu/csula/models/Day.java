package edu.csula.models;

import java.time.LocalTime;
import java.util.ArrayList;

public class Day {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";

    public static final LocalTime start_of_work_day = LocalTime.of(8, 00);
    public static final LocalTime end_of_work_day = LocalTime.of(17, 30);

    private String day_of_the_week;
    ArrayList<LocalTime> intervals;

    public Day(String day_of_the_week, ArrayList<LocalTime> intervals) {
        this.day_of_the_week = day_of_the_week;
        this.intervals = intervals;
    }

    public String getDay() {
        return day_of_the_week;
    }

    public ArrayList<LocalTime> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<LocalTime> time) {
        this.intervals = time;
    }

    public String equals(Day day) {
        if (!day_of_the_week.equals(day.day_of_the_week)) {
            //STOP
        } 

        for (int i = 0; i < this.intervals.size(); i+=2) {

            LocalTime a_1 = intervals.get(i);
            LocalTime a_2 = intervals.get(i + 1);
            
            for (int j = 0; j < day.getIntervals().size(); j+=2) {

                LocalTime b_1 = day.getIntervals().get(j);
                LocalTime b_2 = day.getIntervals().get(j + 1);

                if (compare(a_1, a_2, b_1, b_2)) {
                    return day_of_the_week;
                }
            }
        }

        return "";
    }
    
    private boolean compare(LocalTime a_start, LocalTime a_end, LocalTime b_start, 
        LocalTime b_end) {

            // |-----------------------------------------------------------| 
            //      a_start                             a_end                       a_start                               a_end
            //          |--------------------------------|                  OR          |-----------------------------------|
            //                  |---------------|                                 |-------------------------------------------------|          
            //              b_start           b_end                             b_start                                            b_end
            boolean a_is_busy = a_start.isBefore(b_start) && a_end.isAfter(b_end);
            boolean b_is_busy = b_start.isBefore(a_start) && b_end.isAfter(a_end);
            //If both intervals overlap, then one party cannot meet
            if(a_is_busy || b_is_busy) {
                return false;
            }
            //else 
            return true;
        }
}