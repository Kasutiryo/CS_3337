package edu.csula.confimation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Day;
import edu.csula.models.User;
import edu.csula.models.UsersDAO;


@WebServlet("/confirm-day")
public class ConfirmDayServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int index = Integer.parseInt(request.getParameter("tutor"));

        UsersDAO users = new UsersDAO(request.getSession());

        users.demo();

        request.setAttribute("name", users.tutors.get(index).getFullName());

        request.getRequestDispatcher("/WEB-INF/confirm-day.jsp")
            .forward(request, response);
    }
}