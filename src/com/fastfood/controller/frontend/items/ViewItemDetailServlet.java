package com.fastfood.controller.frontend.items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.services.ItemServices;


@WebServlet("/view_item")
public class ViewItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewItemDetailServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemServices itemServices = new ItemServices(request, response);
		itemServices.viewItemDetail();
	}

}
