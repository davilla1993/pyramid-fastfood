package com.fastfood.controller.frontend.shoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.dao.ItemDao;
import com.fastfood.entities.Items;

@WebServlet("/add_to_cart")
public class AddItemToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ItemDao itemDao;
    public AddItemToCartServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer iditem = Integer.parseInt(request.getParameter("iditem"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		
		if(cartObject != null && cartObject instanceof ShoppingCart) {
			shoppingCart = (ShoppingCart) cartObject;
			
		}else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		
		ItemDao itemDao = new ItemDao();
		Items item = itemDao.get(iditem);
		
		shoppingCart.addItem(item);
		
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
