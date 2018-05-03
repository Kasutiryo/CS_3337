package edu.csula.user_interface;

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

import edu.csula.models.UserEntry;

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
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu07";
            String username = "cs3337stu07";
            String password = "WFcy!P#!";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from students" );

            while(rs.next()) {
                entries.add( new UserEntry( rs.getInt( "id" ),
                                            rs.getString( "name" ), 
                                            rs.getString( "email" ),
                                            rs.getString( "date" )));
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
        request.getRequestDispatcher( "/WEB-INF/directory.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}