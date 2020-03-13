package com.fastfood.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.security.HashGenerationException;
import com.fastfood.services.CustomerServices;


@WebServlet("/admin/update_customer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCustomerServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices = new CustomerServices(request, response);
		try {
			customerServices.updateCustomer();
		} catch (HashGenerationException e) {
			System.out.println("Problem from updateCustomerServlet");
			e.printStackTrace();
		}
	}

}
