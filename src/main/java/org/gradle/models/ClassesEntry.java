package org.gradle.models;

public class ClassesEntry {
	
	String name;
    String time;
    String days;

    public ClassesEntry( String name, String time, String days)
    {
        this.name = name;
        this.time = time;
        this.days = days;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
    
    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
    }
        
    public String getDays()
    {
        return days;
    }

    public void setDays( String days )
    {
        this.days = days;
    }
}