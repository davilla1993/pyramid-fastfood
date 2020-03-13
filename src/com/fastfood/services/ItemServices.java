package com.fastfood.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fastfood.dao.CategoryDao;
import com.fastfood.dao.ItemDao;
import com.fastfood.entities.Category;
import com.fastfood.entities.Items;
import com.fastfood.utils.TransformUserInputs;

public class ItemServices {
	
	private ItemDao itemDao;
	private CategoryDao categoryDao;
	private TransformUserInputs tr;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ItemServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		itemDao = new ItemDao();
		categoryDao = new CategoryDao();
		tr = new TransformUserInputs();
	}
	
	public void listItem() throws ServletException, IOException {
		listItem(null);
	}

	public void listItem(String message) throws ServletException, IOException {
		List<Items> listItems = itemDao.listAll();
		request.setAttribute("listItems", listItems);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "item_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void showItemForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String newPage = "item_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}
	
	public void createItem() throws IOException, ServletException {
		String name = request.getParameter("name");
		
		Items existItem = itemDao.findByName(name);
		
		if(existItem != null) {
			String message = "Oups... An item with the same name already exists.";
			request.setAttribute("message", message);
		} else {
			Items newItem = new Items();
			readItemFields(newItem);
			Items createdItem = itemDao.create(newItem);
			
			if(createdItem.getIditem() > 0) {
				String message = "A new item has been added successfully.";
				listItem(message);
			}
			
		}
	}
	
	public void readItemFields(Items item) throws IOException, ServletException {
		String name = tr.transform(request.getParameter("name"));
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		Integer idcategory = Integer.parseInt(request.getParameter("category"));
		
		item.setName(name);
		item.setDescription(description);
		item.setPrice(price);
		
		Category category = categoryDao.get(idcategory);
		item.setCategory(category);
		
		Part part = request.getPart("itemImage");
		if(part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			item.setImage(imageBytes);
			
		}
		
	}

	public void editItem() throws ServletException, IOException {
		Integer iditem = Integer.parseInt(request.getParameter("id"));
		Items item = itemDao.get(iditem);
		List<Category> listCategory = categoryDao.listAll();
		
		request.setAttribute("item", item);
		request.setAttribute("listCategory", listCategory);
		
		String editPage = "item_update_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}
	
	public void updateItem() throws ServletException, IOException {
		Integer iditem = Integer.parseInt(request.getParameter("iditem"));
		String name = request.getParameter("name");
		
		Items itemById = itemDao.get(iditem);
		Items itemByName = itemDao.findByName(name);
		
		if(itemByName != null && !itemById.equals(itemByName)) {
			String message = "Oups... Could not update. An item with the same name already exists.";
			listItem(message);
			
		} else {
			
			readItemFields(itemById);
			itemDao.update(itemById);
			
			String message = "The item has been updated successfully.";
			listItem(message);
		}
	}

	public void deleteItem() throws ServletException, IOException {
		Integer iditem = Integer.parseInt(request.getParameter("id"));
		
		itemDao.delete(iditem);
		
		String message ="The item has been deleted successfully.";
		listItem(message);
		
	}

	public void listItemByCategory() throws ServletException, IOException {
		Integer idcategory = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.get(idcategory);
		
		List<Items> listItems = itemDao.listByCategory(idcategory);
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> listCategory = categoryDao.listAll();
		
		request.setAttribute("category", category);
		request.setAttribute("listItems", listItems);
		request.setAttribute("listCategory", listCategory);
		
		String listPage = "frontend/items_list_by_category.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
		
	}

}
