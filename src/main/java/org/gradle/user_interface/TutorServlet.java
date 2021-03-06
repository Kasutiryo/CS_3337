package org.gradle.user_interface;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tutor") 
public class TutorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/tutor-ui.jsp")
            .forward(request, response);
     }

     @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/tutor-ui.jsp")
            .forward(request, response);
        
     }
}