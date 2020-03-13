package com.fastfood.controller.frontend.shoppingCart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fastfood.entities.Items;

public class ShoppingCart {
	
	private Map<Items, Integer> cart = new HashMap<>();
	
	public void addItem(Items item) {
		if(cart.containsKey(item)) {
			Integer quantity = cart.get(item) + 1;
			cart.put(item, quantity);
			
		} else {
			cart.put(item, 1);
		}
	}
	
	public int getTotalQuantity() {
		int total = 0;
		
		Iterator<Items> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Items next = iterator.next();
			Integer quantity = cart.get(next);
			total+= quantity;
		}
		
		return total;
	}
	
	public float getTotalAmount() {
		float total = 0.0f;
		
		Iterator<Items> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Items item = iterator.next();
			Integer quantity = cart.get(item);
			double subTotal = quantity * item.getPrice();
			total+= subTotal;
		}
		
		return total;
	}
	
	public void updateCart(int[] itemIds, int[] quantities) {
		for(int i = 0; i<itemIds.length; i++) {
			Items key = new Items(itemIds[i]);
			Integer value = quantities[i];
			cart.put(key, value);
		}
	}
	
	public void clear() {
		cart.clear();
	}
	
	public int getTotalItems() {
		return cart.size();
	}
	
	public void removeItem(Items item) {
		cart.remove(item);
	}
	
	public Map<Items, Integer> getItems(){
		return this.cart;
	}
}
