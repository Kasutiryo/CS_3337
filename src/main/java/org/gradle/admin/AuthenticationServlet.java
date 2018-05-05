package org.gradle.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.models.Authenticate;


@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = -5782467606525808080L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doDelete(request, response);
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Authenticate dao = new Authenticate(request.getSession());

		String username = request.getParameter("username").toLowerCase(),
			password = request.getParameter("password");
		
		if (dao.authenticate(username, password)) {

            redirect(username, request, response);

		} else {

            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
    
    private void redirect(String username, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        switch (username) {
            case "tutor":
                request.getRequestDispatcher("/tutor").forward(request, response);
            case "student": 
                request.getRequestDispatcher("/student?action=none").forward(request, response);
        }
    }
    @Override
	public void doDelete( HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
        
        request.getSession().invalidate();

		request.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);

    }
}
