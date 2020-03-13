package com.fastfood.controller.admin.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.security.HashGenerationException;
import com.fastfood.services.UserServices;


@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreateUserServlet() {
        super();
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userForm = "user_register.jsp";
    	RequestDispatcher dispatcher = req.getRequestDispatcher(userForm);
    	dispatcher.forward(req, resp);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userServices = new UserServices(request, response);
		try {
			userServices.createUser();
		} catch (HashGenerationException e) {
			System.out.println("Error from createUserServlet");
			e.printStackTrace();
		}
		
	}

}
