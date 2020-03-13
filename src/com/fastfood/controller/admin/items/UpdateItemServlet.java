package com.fastfood.controller.admin.items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.services.ItemServices;


@WebServlet("/admin/update_item")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,     //10KB
		maxFileSize = 1024 * 300,         //300KB
		maxRequestSize = 1024 * 1024     // 1MB
		)
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateItemServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemServices itemServices = new ItemServices(request, response);
		itemServices.updateItem();
	}

}
