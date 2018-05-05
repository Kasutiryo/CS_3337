package org.gradle.models;

public class TutorEntry {

    Integer id;
    String name;
    String email;    
    String subjects;    
    String schedule;

    public TutorEntry( Integer id, String name, String email, String subjects, String schedule)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subjects = subjects;
        this.schedule = schedule;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
    
    public String getSubjects()
    {
        return subjects;
    }

    public void setSubjects( String subjects )
    {
        this.subjects = subjects;
    }
    
    public String getSchedule()
    {
        return schedule;
    }

    public void setSchedule( String schedule )
    {
        this.schedule = schedule;
    }
}