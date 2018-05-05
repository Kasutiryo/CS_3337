package org.gradle.main_control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.demo.Demo;
import org.gradle.models.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainServlet", urlPatterns = {"/main"}, loadOnStartup = 1) 
public class MainServlet extends HttpServlet {
    
    private static final long serialVersionUID = 5736844113933764478L;
    private Demo DATA = new Demo();
    ArrayList<User> users = DATA.users;
    private final String LOGIN = "LOGIN",
        STUDENT_UI = "STUDENT_UI";

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("Hello, World!");  
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String actionName = request.getParameter("actionName");

        switch (actionName) {
            case LOGIN: 
                request.getRequestDispatcher("/login").forward(request, response);
        }

        
        String name = request.getParameter("name");
        if (name == null) name = "World";
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response); 
    }
}