package com.customermanagement.controller;

import com.customermanagement.db.DatabaseHelper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "CheckOut")
public class CheckOut extends HttpServlet {
    private  String email;
    private String password;


    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        DatabaseHelper helper = new DatabaseHelper();
        helper.openConnection();
        try {
            Statement statement = helper.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("Select Email,Password from customersdata");
            HttpSession httpSession = req.getSession();
            String emailValue = (String) httpSession.getAttribute("emailCookie");
            String passwordValue = (String) httpSession.getAttribute("passCookie");
            if (emailValue == null && passwordValue == null) {
                writer.println("You need to login or register first");
            }
            while (resultSet.next()) {
                email = resultSet.getString(1);
                password = resultSet.getString(2);
                if (emailValue.equals(email) && passwordValue.equals(password)) {
                    writer.println("Item purchased successfully...");
                    resp.setHeader("Refresh","5;url=gstInvoice.jsp");
                }
            }

            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
