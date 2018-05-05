package org.gradle.user_interface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.models.UserEntry;
import org.gradle.models.ClassesEntry;
import org.gradle.models.TutorEntry;

@WebServlet(urlPatterns = "/student/directory")
public class Directory extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Directory()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        List<UserEntry> entries = new ArrayList<UserEntry>();
        List<ClassesEntry> classes = new ArrayList<ClassesEntry>();
        List<TutorEntry> tutor = new ArrayList<TutorEntry>();
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu28";
            String username = "cs3220stu28";
            String password = "3KKc!FRw";
            
        	/*String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu07";
            String username = "cs3337stu07";
            String password = "WFcy!P#!";*/
            String Days = "";
            String Schedule = "";
            String Name = "";
            String Time = "";
            String Mon = "";
            String Tue = "";
            String Wed = "";
            String Thr = "";
            String Fri = "";
            String Sat = "";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "select * from students" );
            while( rs.next() )
                entries.add( new UserEntry( rs.getInt( "id" ), rs.getString( "name" ),
                		rs.getString( "email" ), rs.getString( "class1" ),
                		rs.getString( "class2" ), rs.getString( "class3" ), 
                		rs.getString( "class4" ), rs.getString( "class5" ),
                		rs.getString( "class6" )));
            
            ResultSet cl = stmt.executeQuery( "select * from classes" );
            while( cl.next() )
            {
            	Name = cl.getString( "name" );
            	Time = cl.getString( "start" ) + "-" + cl.getString( "end" );
            	Days = "{";
            	if(cl.getBoolean("monday")) Days = Days + "Mon ";
            	if(cl.getBoolean("tuesday")) Days = Days + "Tue ";
            	if(cl.getBoolean("wednesday")) Days = Days + "Wed ";
            	if(cl.getBoolean("thursday")) Days = Days + "Thr ";
            	if(cl.getBoolean("friday")) Days = Days + "Fri ";
            	if(cl.getBoolean("saturday")) Days = Days + "Sat ";
            	Days = Days + "}";
            	classes.add( new ClassesEntry( Name, Time, Days));
            }
            
            ResultSet tu = stmt.executeQuery( "select * from tutor" );
            while( tu.next() )
            {
            	Schedule = "";            	
            	Mon = "Mon " + tu.getString( "mondaystart" ) + "-" + tu.getString( "mondayend" ) + " ";
            	if(Mon.length() > 15 ) Schedule = Schedule + Mon;
            	Tue = "Tue " + tu.getString( "tuesdaystart" ) + "-" + tu.getString( "tuesdayend" ) + " ";
            	if(Tue.length() > 15 ) Schedule = Schedule + Tue;
            	Wed = "Wed " + tu.getString( "wednesdaystart" ) + "-" + tu.getString( "wednesdayend" ) + " ";
            	if(Wed.length() > 15 ) Schedule = Schedule + Wed; 
            	Thr	= "Thr " + tu.getString( "thursdaystart" ) + "-" + tu.getString( "thursdayend" ) + " ";
            	if(Thr.length() > 15 ) Schedule = Schedule + Thr;
            	Fri = "Fri " + tu.getString( "fridaystart" ) + "-" + tu.getString( "fridayend" ) + " ";
            	if(Fri.length() > 15 ) Schedule = Schedule + Fri;
            	Sat = "Sat " + tu.getString( "saturdaystart" ) + "-" + tu.getString( "saturdayend" ) + " ";
            	if(Sat.length() > 15 ) Schedule = Schedule + Sat;
            	
            	tutor.add( new TutorEntry( tu.getInt( "id" ), tu.getString( "name" ),
            			tu.getString( "email" ), tu.getString( "subjects" ), Schedule));
            }

            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        request.setAttribute( "entries", entries );
        request.setAttribute( "classes", classes );
        request.setAttribute( "tutor", tutor );
        request.getRequestDispatcher( "/WEB-INF/directory.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}