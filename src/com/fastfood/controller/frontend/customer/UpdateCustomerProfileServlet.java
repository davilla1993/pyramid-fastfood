package com.fastfood.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.security.HashGenerationException;
import com.fastfood.services.CustomerServices;


@WebServlet("/update_profile")
public class UpdateCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateCustomerProfileServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices = new CustomerServices(request, response);
		try {
			customerServices.updateCustomerProfile();
		} catch (ArrayIndexOutOfBoundsException | HashGenerationException e) {
			System.out.println("Problem from updateCustomerProfileServlet");
			e.printStackTrace();
		}
	}

}
