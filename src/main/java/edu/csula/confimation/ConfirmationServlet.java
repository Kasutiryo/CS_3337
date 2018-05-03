package edu.csula.confimation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {

    private static final long serialVersionUID = -5024269997528631385L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("name", request.getParameter("tutor"));

        request.setAttribute("day", request.getParameter("day"));
        request.getRequestDispatcher("/WEB-INF/confirmation.jsp")
            .forward(request, response);
    }
}