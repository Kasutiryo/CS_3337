package org.gradle.user_interface;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.demo.Demo;
import org.gradle.models.Authenticate;
import org.gradle.models.Class;
import org.gradle.models.User;
import org.gradle.scheduling.Scheduler;

@WebServlet("/student") 
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TO BE: After user has been implemented, this will authenticate the user and keep the user authenticated 
        // as long as their logged in.

     Authenticate user = new Authenticate(request.getSession());

		if (!user.getAuthenticatedUser().isPresent()) {
			response.sendRedirect(request.getContextPath() + "/login");
        }   

        ArrayList<User> users = new Demo().users;
        ArrayList<User> tutors = new ArrayList<>();
        for (int i = 2; i < users.size(); i++) {
            tutors.add(users.get(i));
        }

        Scheduler scheduler = new Scheduler();

        request.setAttribute("scheduler", scheduler);
        request.setAttribute("tutors", tutors);

        request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
		    .forward(request, response);
    }

    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Authenticate user = new Authenticate(request.getSession());

		if (!user.getAuthenticatedUser().isPresent()) {
			response.sendRedirect(request.getContextPath() + "/login");
        }
        
        ArrayList<User> users = new Demo().users;
        ArrayList<User> tutors = new ArrayList<>();
        for (int i = 2; i < users.size(); i++) {
            tutors.add(users.get(i));
        }

        Scheduler scheduler = new Scheduler();

        request.setAttribute("scheduler", scheduler);
        request.setAttribute("tutors", tutors);

        String action = request.getParameter("action");
     

        if (action.equals("find")) {
            request.getRequestDispatcher("/WEB-INF/student-ui-find.jsp").forward(request, response);
        } else 
        request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
            .forward(request, response);
    }
}