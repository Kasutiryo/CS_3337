package org.gradle.confirmation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.demo.Demo;
import org.gradle.models.Authenticate;
import org.gradle.models.User;
import org.gradle.scheduling.Scheduler;;


@WebServlet("/confirm-day")
public class ConfirmDayServlet extends HttpServlet {

    private static final long serialVersionUID = -2654885514033542541L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        Authenticate dao = new Authenticate(request.getSession());

        int index = Integer.parseInt(request.getParameter("tutor"));

        Scheduler scheduler = new Scheduler();
        ArrayList<User> users = new Demo().users;
        User tutor = users.get(index);
        String days = scheduler.find_avaiability(users.get(1), tutor);
        String[] day = days.split(" ");

        request.setAttribute("day", day);
        request.setAttribute("tutor", tutor);

        request.getRequestDispatcher("/WEB-INF/confirm-day.jsp")
            .forward(request, response);
    }
}