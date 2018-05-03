package edu.csula.confimation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Day;
import edu.csula.models.UsersDAO;


@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String day = request.getParameter("day");

        request.setAttribute("name", request.getParameter("tutor"));

        request.setAttribute("day", request.getParameter("day"));
        request.getRequestDispatcher("/WEB-INF/confirmation.jsp")
            .forward(request, response);
    }
}