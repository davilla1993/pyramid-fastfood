package com.fastfood.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastfood.dao.UserDao;
import com.fastfood.entities.Users;
import com.fastfood.security.HashGenerationException;
import com.fastfood.security.HashGeneratorUtils;
import com.fastfood.utils.TransformUserInputs;

public class UserServices {
	
	private UserDao userDao;
	private TransformUserInputs tr;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		this.userDao = new UserDao();
		this.tr = new TransformUserInputs();
	}

	public void login() throws ServletException, IOException, HashGenerationException {
		
		String email = request.getParameter("email");
		String input = request.getParameter("password");
		String password = HashGeneratorUtils.generateSHA256(input);
		
		boolean loginResult = userDao.checkLogin(email, password);
		
		if(loginResult) {
			
			request.getSession().setAttribute("useremail", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
			
		} else {
			
			String message = "Login failed - Email or password incorrect";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {
		
		List<Users> listUsers = userDao.listAll();
		
		request.setAttribute("listUsers", listUsers);
		
		if(message != null) {
			
			request.setAttribute("message", message);
		}
		
		String listPage = "user_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}

	public void createUser() throws ServletException, IOException, HashGenerationException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String fullname = tr.transform(request.getParameter("fullname"));
		
		Users existUser = userDao.findByEmail(email);
		
		if(existUser != null) {
			String message = "A user with same e-mail already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
			
		} else {
		
			String password = HashGeneratorUtils.generateSHA256(pass);
			
			Users newUser = new Users(email, password, fullname);
			userDao.create(newUser);
			listUser("New user created successfully !!");
		}
		
		
	}

	public void logout() throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("useremail");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}

	public void editUser() throws ServletException, IOException {
	
		Integer iduser = Integer.parseInt(request.getParameter("id"));
		Users user = userDao.get(iduser);
		
		String editPage = "user_update_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}

	public void updateUser() throws ServletException, IOException {
		int iduser = Integer.parseInt(request.getParameter("iduser"));
		String fullname = tr.transform(request.getParameter("fullname"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Users userById = userDao.get(iduser);
		Users userByEmail = userDao.findByEmail(email);
		
		if(userByEmail != null && userByEmail.getIduser() != userById.getIduser()) {
			String message = "Oops... A user with this email already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_update_form.jsp");
			dispatcher.forward(request, response);
		} else {
			
			Users user = new Users(iduser, email, password, fullname);
			userDao.update(user);
			
			String message = "User has been updated succesfully";
			listUser(message);
		}
	}

	public void deleteUser() throws ServletException, IOException {
		Integer iduser = Integer.parseInt(request.getParameter("id"));
		userDao.delete(iduser);
		
		String message = "User has been deleted succesfullly";
		listUser(message);
		
	}
	
	
	

}
