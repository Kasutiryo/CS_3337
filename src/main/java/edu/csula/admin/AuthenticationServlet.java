package edu.csula.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.DomainLoadStoreParameter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.UsersDAO;


@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = -5782467606525808080L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doDelete(request, response);
		
		request.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO: handle login
		
		UsersDAO dao = new UsersDAO(request.getSession());

		String username = request.getParameter("username"),
			password = request.getParameter("password");

		dao.authenticate(username, password);
		
		if (dao.authenticate(username, password)) {
			switch (dao.getAuthenticatedUser().get().getUsername()) {
				case "student": 
					request.getRequestDispatcher("/WEB-INF/student-ui.jsp")
						.forward(request, response);
				case "tutor":
					request.getRequestDispatcher("/WEB-INF/tutor-ui.jsp")
						.forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);;
		}
		

	}

    @Override
	public void doDelete( HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO: handle logout
		// UsersDAOImpl dao = new UsersDAOImpl(request.getSession());

        // dao.logout();
        
        request.getSession().invalidate();

		request.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);

    }
}
