package org.gradle.models;

public class UserEntry {

    Integer id;
    String name;
    String email;

    String class1;
    String class2;
    String class3;
    String class4;
    String class5;
    String class6;

    public UserEntry( Integer id, String name, String email, String class1, 
    		String class2, String class3, String class4, String class5, 
    		String class6)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class4 = class4;
        this.class5 = class5;
        this.class6 = class6;
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
    
    public String getClass1()
    {
        return class1;
    }

    public void setClass1( String class1 )
    {
        this.class1 = class1;
    }
    
    public String getClass2()
    {
        return class2;
    }

    public void setClass2( String class2 )
    {
        this.class2 = class2;
    }
        
    public String getClass3()
    {
        return class3;
    }

    public void setClass3( String class3 )
    {
        this.class3 = class3;
    }
            
    public String getClass4()
    {
        return class4;
    }

    public void setClass4( String class4 )
    {
        this.class4 = class4;
    }
        
    public String getClass5()
    {
        return class5;
    }

    public void setClass5( String class5 )
    {
        this.class5 = class5;
    }
        
    public String getClass6()
    {
        return class6;
    }

    public void setClass6( String class6 )
    {
        this.class6 = class6;
    }
}