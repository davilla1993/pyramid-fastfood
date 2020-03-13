package com.fastfood.controller.admin.items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.services.ItemServices;


@WebServlet("/admin/create_item")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,  //10KB
		maxFileSize = 1024 * 300,      //300KB
		maxRequestSize = 1024 * 1024  // 1MB
		)
public class CreateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateItemServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	ItemServices itemServices = new ItemServices(req, resp);
    	itemServices.showItemForm();
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemServices itemServices = new ItemServices(request, response);
		itemServices.createItem();
		
	}

}
