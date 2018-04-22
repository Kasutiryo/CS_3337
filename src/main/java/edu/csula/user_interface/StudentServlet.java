package edu.csula.user_interface;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student") 
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TO BE: After user has been implemented, this will authenticate the user and keep the user authenticated 
        // as long as their logged in.

        // UsersDAOImpl user = new UsersDAOImpl(request.getSession());

		// if (!user.getAuthenticatedUser().isPresent()) {
		// 	response.sendRedirect(request.getContextPath() + "/admin/auth");
        // }
        
        request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
            .forward(request, response);
    }

    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}