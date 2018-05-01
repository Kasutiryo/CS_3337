package edu.csula.user_interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Class;
import edu.csula.models.User;
import edu.csula.models.UsersDAO;

@WebServlet("/student") 
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TO BE: After user has been implemented, this will authenticate the user and keep the user authenticated 
        // as long as their logged in.

        UsersDAO user = new UsersDAO(request.getSession());

		if (!user.getAuthenticatedUser().isPresent()) {
			response.sendRedirect(request.getContextPath() + "/login");
        }   

        request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
		    .forward(request, response);
    }

    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;

        request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
            .forward(request, response);
    }
}