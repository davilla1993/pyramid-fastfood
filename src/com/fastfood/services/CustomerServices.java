package com.fastfood.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastfood.dao.CategoryDao;
import com.fastfood.dao.CustomerDao;
import com.fastfood.entities.Category;
import com.fastfood.entities.Customer;
import com.fastfood.security.HashGenerationException;
import com.fastfood.security.HashGeneratorUtils;
import com.fastfood.utils.TransformUserInputs;

public class CustomerServices {
	
	private CustomerDao customerDao;
	private CategoryDao categoryDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private TransformUserInputs tr;

	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDao = new CustomerDao();
		this.categoryDao = new CategoryDao();
		this.tr = new TransformUserInputs();
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	
	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> listCustomers = customerDao.listAll();
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		request.setAttribute("listCustomers", listCustomers);
		
		String listPage = "customer_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	private void updateCustomerFieldsFromForm(Customer customer) throws HashGenerationException, ArrayIndexOutOfBoundsException {
		
		String email = request.getParameter("email");
		String fullname = tr.transform(request.getParameter("fullname"));
		String address = request.getParameter("address");
		String city = tr.transform(request.getParameter("city"));
		String phone = request.getParameter("phone");
		String pass = request.getParameter("password");
		
		if(email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		
		if(pass != null && !pass.equals("")) {
			String password = HashGeneratorUtils.generateSHA256(pass);
			customer.setPassword(password);
		}
		customer.setFullname(fullname);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPhone(phone);
	}
	
	public void createCustomer() throws ServletException, IOException, HashGenerationException {
		String email = request.getParameter("email");
		
		Customer existCustomer = customerDao.findByEmail(email);
		
		if(existCustomer != null) {
			String message = "The email you enter is already registred";
			listCustomers(message);
			
		} else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
			customerDao.create(newCustomer);
			
			String message = "New customer has been created successfully.";
			listCustomers(message);
		}
	}

	public void editCustomer() throws ServletException, IOException {
		Integer idcustomer = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDao.get(idcustomer);
		
		request.setAttribute("customer", customer);
		
		String editPage = "customer_update_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateCustomer() throws HashGenerationException, ServletException, IOException {
		Integer idcustomer = Integer.parseInt(request.getParameter("idcustomer"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerDao.findByEmail(email);
		
		if(customerByEmail != null && customerByEmail.getIdcustomer() != idcustomer) {
			String message = "Oups... A customer with same email already exists.";
			
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_update_form.jsp");
			dispatcher.forward(request, response);
		}else {
			Customer customerById = customerDao.get(idcustomer);
			updateCustomerFieldsFromForm(customerById);
			customerDao.update(customerById);
			
			String message = "The customer have been updated successfully.";
			listCustomers(message);
		}
		
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		customerDao.delete(customerId);
		
		String message = "The customer has been deleted successfully.";
		listCustomers(message);
		
		
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage = "frontend/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
		
	}

	public void showRegister() throws ServletException, IOException {
		String registerForm = "frontend/register.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws HashGenerationException, ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String password = HashGeneratorUtils.generateSHA256(pass);
		
		Customer customer = customerDao.checkLogin(email, password);
		if(customer == null) {
			String message = "Login Failed... Incorrects email or password.";
			request.setAttribute("message", message);
			showLogin();
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			Object objRedirectURL = session.getAttribute("redirectURL");
			
			if(objRedirectURL != null) {
				String redirectURL = (String) objRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
				
			}else {
				showCustomerProfile();
			}
		}
		
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("listCategory", listCategory);
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void updateCustomerProfile() throws ArrayIndexOutOfBoundsException, HashGenerationException, ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerDao.update(customer);
		showCustomerProfile();
		
		
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage = "frontend/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}
	

}
