package edu.csula.user_interface;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.UsersDAO;

@WebServlet("/tutor") 
public class TutorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        UsersDAO user = new UsersDAO(request.getSession());

        if (!user.getAuthenticatedUser().isPresent()) {
            response.sendRedirect(request.getContextPath() + "/login");
        } 
        request.getRequestDispatcher("/WEB-INF/tutor-ui.jsp")
            .forward(request, response);
     }

     @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/tutor_ui.jsp")
            .forward(request, response);
        
     }
}