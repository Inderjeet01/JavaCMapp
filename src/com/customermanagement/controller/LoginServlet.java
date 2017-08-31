package com.customermanagement.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.customermanagement.db.DatabaseHelper;

@WebServlet({"/LoginServlet", "/Login"})
public class LoginServlet extends HttpServlet {
    private Statement statement;
    private Cookie emailCookie;
    private Cookie passCookie;
    private String email;
    private String passwordString;
    /**
     * This method lets user to fill his login details and enter into our website, if he already registered. Otherwise prompt
     * him to register. Details given by user, should be correct otherwise user cannot access to his profile.
     *
     * @param request  request made by user
     * @param response response given by servlet
     * @throws ServletException
     * @throws IOException
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerEmail = request.getParameter("customerEmail");
        String customerPassword = request.getParameter("customerPassword");
        if (customerEmail == "" || customerPassword == "") {
            RequestDispatcher dispatcher = request.getRequestDispatcher("NoDetailsEntered.jsp");
            dispatcher.forward(request, response);
        } else {
            DatabaseHelper dHelper = new DatabaseHelper();
            dHelper.openConnection();
            try {
                statement = dHelper.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT Email,Password from customersdata");

                while (resultSet.next()) {
                     email = resultSet.getString(1);
                     passwordString = resultSet.getString(2);
                    if (email.equals(customerEmail) && passwordString.equals(customerPassword)) {
                        response.setContentType("text/html");
                        response.getWriter().println("You are successfully login...redirecting to home page ");
                        response.setHeader("Refresh", "5;url=HomeLayout.html");
                        emailCookie = new Cookie("Email", email);
                        passCookie = new Cookie("Password", passwordString);

                        HttpSession session=request.getSession();
                        session.setAttribute("emailCookie",emailCookie.getValue());
                        session.setAttribute("passCookie",passCookie.getValue());

                    }
                }


                if( !email.equals(customerEmail) || !passwordString.equals(customerPassword) ) {
                     response.setContentType("text/html");
                        response.getWriter().print("You need to <a href='Registration.jsp'>Register</a> first");


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
