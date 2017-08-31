package com.customermanagement.controller;

import com.customermanagement.db.DatabaseHelper;
import com.customermanagment.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*
        Getting Customer Input
        *
         */
        String customerName = request.getParameter("customerName");
        String customerEmail = request.getParameter("customerEmail");
        String customerPassword = request.getParameter("customerPassword");
        String customerAddress = request.getParameter("customerAddress");
        String customerDateOfBirth = request
                .getParameter("customerDateOfBirth");
        /*putting all inputs to customer object*/
        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setEmail(customerEmail);
        customer.setPassword(customerPassword);
        customer.setAddress(customerAddress);
        customer.setDateofBirth(customerDateOfBirth);

        if (customer.getName() == "" || customer.getEmail() == ""
                || customer.getPassword() == ""
                || customer.getAddress() == ""
                || customer.getDateofBirth() == "") {
            response.setContentType("text/html");
            RequestDispatcher dispatcher = request.getRequestDispatcher("NoDetailsEntered.jsp");
            dispatcher.forward(request, response);
        } else {
            DatabaseHelper dHelper = new DatabaseHelper();
            dHelper.openConnection();
            dHelper.registerCustomer(customer);
            Cookie cookie_1 = new Cookie("Cookie_1", customer.getName());
            response.addCookie(cookie_1);
            Cookie[] carr = request.getCookies();

            /*forward request to home page and show username if same user return back*/
            RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("HomeLayout.html");
            requestDispatcher.include(request, response);
            for (Cookie c : carr) {
                if (customer.getName().compareTo(c.getValue()) == 0) {
                    response.getWriter().println(c.getValue());
                }
            }
        }

    }
}
