package com.webApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private UserValidationService userValidationService = new UserValidationService();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


        httpServletRequest.setAttribute("name", httpServletRequest.getParameter("name"));
        httpServletRequest.setAttribute("password", httpServletRequest.getParameter("password"));

        httpServletRequest.getRequestDispatcher("WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");

        boolean isUserValid = userValidationService.isUserValid(name, password);

        if (isUserValid) {
            httpServletRequest.setAttribute("name", httpServletRequest.getParameter("name"));
            httpServletRequest.setAttribute("password", httpServletRequest.getParameter("password"));
            httpServletRequest.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(httpServletRequest, httpServletResponse);
        } else {

            httpServletRequest.setAttribute("errorMessage", "invalid credintials");
            httpServletRequest.getRequestDispatcher("WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }
}