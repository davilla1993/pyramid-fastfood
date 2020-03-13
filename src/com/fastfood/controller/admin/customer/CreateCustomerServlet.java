package com.fastfood.controller.admin.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.security.HashGenerationException;
import com.fastfood.services.CustomerServices;


@WebServlet("/admin/create_customer")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateCustomerServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String customerForm = "customer_register.jsp";
    	RequestDispatcher dispatcher = req.getRequestDispatcher(customerForm);
    	dispatcher.forward(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices = new CustomerServices(request, response);
		try {
			customerServices.createCustomer();
		} catch (HashGenerationException e) {
		System.out.println("Problem from createCustomerServlet");
			e.printStackTrace();
		}
	}

}
