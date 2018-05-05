package org.gradle.models;

public class Class {

    private String subject; 
    private String name; 
    private int class_number;
    Day[] class_schedule;

    public Class(String subject, int class_number, String name,
         Day[] class_schedule) {

        this.subject = subject;
        this.class_number = class_number;
        this.name = name;
        this.class_schedule = class_schedule;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getClass_number() {
        return class_number;
    }

    public String getName() {
        return name;
    }

    public Day[] getSchedule() {

        return class_schedule;
    }

    // public String getClass_time() {
    //     return formatTime(class_time);
    // }

    // private String formatTime(String time) {

    //     int hr_1 = Integer.parseInt(time.substring(0, 2)), 
    //         min_1 = Integer.parseInt(time.substring(2, 4)),
    //         hr_2 = Integer.parseInt(time.substring(5, 7)),
    //         min_2 = Integer.parseInt(time.substring(7, 9));

    //     if (min_1 < 10 && min_2 < 10) {
    //         return ("" + hr_1 + ":0" + min_1 + " - " + hr_2 + ":0" + min_2);
    //     } else if (min_1 < 10 && min_2 >= 10) {
    //         return ("" + hr_1 + ":0" + min_1 + " - " + hr_2 + ":" + min_2);
    //     } else if (min_1 >= 10 && min_2 < 10) {
    //         return ("" + hr_1 + ":" + min_1 + " - " + hr_2 + ":0" + min_2);
    //     } 
    //     return ("" + hr_1 + ":" + min_1 + " - " + hr_2 + ":" + min_2);
        

    // }


}