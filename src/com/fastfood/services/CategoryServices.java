package com.fastfood.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fastfood.dao.CategoryDao;
import com.fastfood.dao.ItemDao;
import com.fastfood.entities.Category;
import com.fastfood.utils.TransformUserInputs;

public class CategoryServices {
	
	private CategoryDao categoryDao;
	private TransformUserInputs tr;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.categoryDao = new CategoryDao();
		this.tr = new TransformUserInputs();
	}
	
	public void listCategory() throws ServletException, IOException, NumberFormatException {
		listCategory(null);
	}
	
	public void listCategory(String message) throws ServletException, IOException, NumberFormatException{
		List<Category> listCategory = categoryDao.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		String listPage = "category_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void createCategory() throws ServletException, IOException, NumberFormatException {
		
		String name = tr.transform(request.getParameter("name"));
		Category existCategory = categoryDao.findByName(name);
		
		if(existCategory != null) {
			String message = "Oups... A category with the same name already exists. You can no longer create it";
			
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("category_form.jsp");
			dispatcher.forward(request, response);
		} else {
			Category newCategory = new Category(name);
			categoryDao.create(newCategory);
			String message = "New category created successfully!";
			String type = "alert alert-success alert-dismiss fade=show";
			request.setAttribute("type", type);
			listCategory(message);
		}
	}

	public void editCategory() throws ServletException, IOException, NumberFormatException {
		Integer categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.get(categoryId);
		request.setAttribute("category", category);
		
		String editPage = "category_update_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}
	
	public void updateCategory() throws ServletException, IOException, NumberFormatException {
		Integer idcategory = Integer.parseInt(request.getParameter("idcategory"));
		String categoryName = tr.transform(request.getParameter("name"));
		
		Category categoryById = categoryDao.get(idcategory);
		Category categoryByName = categoryDao.findByName(categoryName);
		
		if(categoryByName != null && categoryById.getIdcategory() != categoryByName.getIdcategory()) {
			String message = "Oups...Could not update category. A category with the same name already exists";
			request.setAttribute("message", message);
			
			String editPage = "category_update_form.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
			dispatcher.forward(request, response);
			
		} else {
			
		   categoryById.setName(categoryName);
		   categoryDao.update(categoryById);
			String message = "The category has been updated successfully.";
			String type = "alert alert-success alert-dismiss fade=show";
			request.setAttribute("type", type);
			listCategory(message);
		}
	}
	
	public void deleteCategory() throws NumberFormatException, ServletException, IOException {
		Integer idcategory = Integer.parseInt(request.getParameter("id"));
		ItemDao itemDao = new ItemDao();
		long numberOfItems = itemDao.countByCategory(idcategory);
		
		if(numberOfItems > 0 ) {
			String message = "Could not delete this category because it currently contains some items.";
			
			String type = "alert alert-danger alert-dismiss fade=show";
			request.setAttribute("type", type);
			listCategory(message);
		} else {
			categoryDao.delete(idcategory);
			String message = "The category has been removed successfully.";
			
			String type = "alert alert-success alert-dismiss fade=show";
			request.setAttribute("type", type);
			listCategory(message);
		}
		
	}
	
	
}
