package CS3337.servlet;

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

import CS3337.model.ForumEntry;
import CS3337.model.AnswerEntry;

@WebServlet(urlPatterns = "/Forum")
public class Forum extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Forum()
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
        List<ForumEntry> question = new ArrayList<ForumEntry>();
        List<AnswerEntry> answer = new ArrayList<AnswerEntry>();
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu28";
            String username = "cs3220stu28";
            String password = "3KKc!FRw";
            
        	/*String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu07";
            String username = "cs3337stu07";
            String password = "WFcy!P#!";*/

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "select * from question" );
            while( rs.next() )
            	question.add( new ForumEntry( rs.getInt( "id" ), rs.getString( "name" ),
                		rs.getString( "message" )));
            
            ResultSet cl = stmt.executeQuery( "select * from answer" );
            while( cl.next() )
            	answer.add( new AnswerEntry( cl.getInt( "id" ), cl.getString( "name" ),
            			cl.getString( "message" )));

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

        request.setAttribute( "question", question );
        request.setAttribute( "answer", answer );
        request.getRequestDispatcher( "/WEB-INF/forums.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}