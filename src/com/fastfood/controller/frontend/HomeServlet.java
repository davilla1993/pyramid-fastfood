package com.fastfood.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfood.dao.CategoryDao;
import com.fastfood.dao.ItemDao;
import com.fastfood.entities.Category;
import com.fastfood.entities.Items;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("listCategory", listCategory);
		
		int idcategory = 1;
		ItemDao itemDao = new ItemDao();
		List<Items> listFirstCategoryItems = itemDao.listByCategory(idcategory);
		request.setAttribute("listFirstCategoryItems", listFirstCategoryItems);
		
		
		String homePage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
		dispatcher.forward(request, response);
	}

}
