package com.fastfood.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastfood.controller.frontend.shoppingCart.ShoppingCart;
import com.fastfood.dao.ItemDao;
import com.fastfood.dao.OrderDao;
import com.fastfood.entities.Customer;
import com.fastfood.entities.Items;
import com.fastfood.entities.Order;
import com.fastfood.entities.OrderDetail;

public class OrderServices {
	
	private OrderDao orderDao;
	private ItemDao itemDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.orderDao = new OrderDao();
		this.itemDao = new ItemDao();
		
	}
	
	public void listAllOrder() throws ServletException, IOException {
		listAllOrder(null);
	}
	
	public void listAllOrder(String message) throws ServletException, IOException {
		List<Order> listOrder = orderDao.listAll();
		
		if(message != null) {
			request.setAttribute("message", message);
			
		}
		request.setAttribute("listOrder", listOrder);
		
		String listPage = "order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void addItemToOrder() throws ServletException, IOException {
		int iditem = Integer.parseInt(request.getParameter("iditem"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Items item = itemDao.get(iditem);
		
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		
		float subtotal = quantity * item.getPrice();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setItems(item);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubtotal(subtotal);
		
		float newTotal = order.getTotal() + subtotal;
		order.setTotal(newTotal);
		
		order.getOrderDetails().add(orderDetail);
		
		request.setAttribute("item", item);
		request.setAttribute("NewItemPendingToAddToOrder", true);
		String resultPage = "add_book_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
		
		
		
	}

	public void showCheckOutForm() throws ServletException, IOException {
		String checkOutPage = "frontend/checkout.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkOutPage);
		dispatcher.forward(request, response);
		
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String shippingAddress = address + "," + city + "," + zipcode + "," + country;
		
		Order order = new Order();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Items, Integer> items = shoppingCart.getItems();
		
		Iterator<Items> iterator = items.keySet().iterator();
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		while(iterator.hasNext()) {
			Items item = iterator.next();
			Integer quantity = items.get(item);
			float subtotal = quantity * item.getPrice();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setItems(item);
			orderDetail.setOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			
			orderDetails.add(orderDetail);
		}
		
		order.setOrderDetails(orderDetails);
		order.setTotal(shoppingCart.getTotalAmount());
		
		orderDao.create(order);
		
		shoppingCart.clear();
		
		String message = "Thank you. Your order has been received. We will deliver you within a few days.";
		request.setAttribute("message", message);
		String messagePage = "frontend/message.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
		
	}

}
