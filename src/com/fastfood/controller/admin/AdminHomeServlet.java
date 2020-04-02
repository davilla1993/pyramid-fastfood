
package com.fastfood.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fastfood.dao.OrderDao;
import com.fastfood.entities.Order;

@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderDao orderDao;
	
	public AdminHomeServlet() {
		super();
		orderDao = new OrderDao();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Order> listOrder = orderDao.listAll();
		request.setAttribute("listOrder", listOrder);
		
		String homePage = "index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
		dispatcher.forward(request, response);
	}

}
