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
		
		ItemDao itemDao = new ItemDao();
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
		String resultPage = "add_item_result.jsp";
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
		String shippingAddress = address + "," + city;
		
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
		
		String message = "Thank you. Your order has been received. We will deliver you within one hour.";
		String type = "alert alert-success alert-dismiss fade=show";
		
		request.setAttribute("message", message);
		request.setAttribute("type", type);
		
		String messagePage = "frontend/message.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
		
	}

	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		List<Order> listOrders = orderDao.listByCustomer(customer.getIdcustomer());
		request.setAttribute("listOrders", listOrders);
		
		String historyPage = "frontend/order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(historyPage);
		dispatcher.forward(request, response);
		
	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int idorder = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		
		Order order = orderDao.get(idorder, customer.getIdcustomer());
		request.setAttribute("order", order);
		
		String detailPage = "frontend/order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int idorder = Integer.parseInt(request.getParameter("id"));
		Order order = orderDao.get(idorder);
		
		request.setAttribute("order", order);
		
		String detailPage = "order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}

	public void showEditOrderForm() throws ServletException, IOException {
			Integer idorder = Integer.parseInt(request.getParameter("id"));
			
			HttpSession session = request.getSession();
			Object isPendingItem = session.getAttribute("NewItemPendingToAddToOrder");
			
			if(isPendingItem == null) {
				
				Order order = orderDao.get(idorder);
				session.setAttribute("order", order);
				
			} else {
				session.removeAttribute("NewItemPendingToAddToOrder");
				
			}
			
			String editPage = "order_form.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
			dispatcher.forward(request, response);
			
		
	}

	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String shippingAddress = request.getParameter("shippingAddress");
		String orderStatus = request.getParameter("orderStatus");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setStatus(orderStatus);
		
		String[] arrayItemId = request.getParameterValues("iditem");
		String[] arrayPrice = request.getParameterValues("price");
		String[] arrayQuantity = new String[arrayItemId.length];
		
		for(int i=1; i<=arrayQuantity.length; i++) {
			arrayQuantity[i-1] = request.getParameter("quantity" + i);
		}
		
		Set<OrderDetail> orderDetails = order.getOrderDetails();
		orderDetails.clear();
		
		float totalAmount = 0.0f;
		
		for(int i=0; i<arrayItemId.length; i++) {
			
			int iditem = Integer.parseInt(arrayItemId[i]);
			int quantity = Integer.parseInt(arrayQuantity[i]);
			float price = Float.parseFloat(arrayPrice[i]);
			float subtotal = price * quantity;
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setItems(new Items(iditem));
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			orderDetail.setOrder(order);
			
			orderDetails.add(orderDetail);
			
			totalAmount += subtotal;
		}
		
		order.setTotal(totalAmount);
		orderDao.update(order);
		
		String message = "The order has been update successfully !!";
		listAllOrder(message);
		
		
	}

	public void deleteOrder() throws ServletException, IOException {
		Integer idorder = Integer.parseInt(request.getParameter("id"));
		orderDao.delete(idorder);
		
		String message = "The order has been deleted sucessfully !!!";
		listAllOrder(message);
	}

	public void removeItemFromOrder() throws ServletException, IOException {
		int iditem = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		
		Set<OrderDetail> orderDetails = order.getOrderDetails();
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		
		while(iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if(orderDetail.getItems().getIditem() == iditem) {
				float newTotal = order.getTotal() - orderDetail.getSubtotal();
				order.setTotal(newTotal);
				iterator.remove();
			}
		}
		
		String editOrderFormPage = "order_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editOrderFormPage);
		dispatcher.forward(request, response);
		
	}

	public void showAddItemForm() throws ServletException, IOException {
		List<Items> listItems = itemDao.listAll();
		request.setAttribute("listItems", listItems);
		
		String addFormPage = "add_item_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(addFormPage);
		dispatcher.forward(request, response);
		
	}

}
