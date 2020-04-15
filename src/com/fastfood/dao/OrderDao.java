package com.fastfood.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fastfood.entities.Order;

public class OrderDao extends JpaDao<Order> implements GenericDao<Order> {

	@Override
	public Order create(Order order) {
		order.setOrderDate(new Date());
		order.setStatus("Processing...");
		return super.create(order);
	}

	@Override
	public Order update(Order order) {
		return super.update(order);
	}

	@Override
	public Order get(Object id) {
		return super.find(Order.class, id);
	}
	
	public Order get(Integer idorder, Integer idcustomer) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("idorder" , idorder);
		parameters.put("idcustomer", idcustomer);
		List<Order> result = super.findWithNamedQuery("Order.findByIdAndCustomer", parameters);
		
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
		
	}

	@Override
	public void delete(Object id) {
		super.delete(Order.class, id);
	}

	@Override
	public List<Order> listAll() {
		return super.findWithNamedQuery("Order.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Order.countAll");
	}
	
	public List<Order> listByCustomer(Integer idcustomer){
		return super.findWithNamedQuery("Order.findByCustomer", "idcustomer", idcustomer);
	}
	
	public List<Order> listMostRecentSales(){
		return super.findWithNamedQuery("Order.findAll", 0, 10);
	}

}
