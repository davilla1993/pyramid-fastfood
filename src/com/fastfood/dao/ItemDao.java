package com.fastfood.dao;

import java.util.List;

import com.fastfood.entities.Items;

public class ItemDao extends JpaDao<Items> implements GenericDao<Items>{

	@Override
	public Items create(Items item) {
		return super.create(item);
	}

	@Override
	public Items update(Items item) {
		return super.update(item);
	}

	@Override
	public Items get(Object id) {
		return super.find(Items.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Items.class, id);
	}

	@Override
	public List<Items> listAll() {
		return super.findWithNamedQuery("Items.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Items.countAll");
	}
	
	public Items findByName(String name) {
		List<Items> result = super.findWithNamedQuery("Items.findByName", "name" , name);
		
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	
	public List<Items> listByCategory(int idcategory){
		return super.findWithNamedQuery("Items.findByCategory" , "idcategory", idcategory);
	}
	
	public long countByCategory(int idcategory){
		return super.countWithNamedQuery("Items.countByCategory", "idcategory", idcategory);
	}

}
