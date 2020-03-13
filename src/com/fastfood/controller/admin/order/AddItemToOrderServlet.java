package com.fastfood.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.services.OrderServices;

@WebServlet("/add_item_to_order")
public class AddItemToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddItemToOrderServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices orderServices = new OrderServices(request, response);
		orderServices.addItemToOrder();
	}

}
