package com.fastfood.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fastfood.entities.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {
	
	@Override
	public Users create(Users user) {
		
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		
		return super.update(user);
	}

	@Override
	public Users get(Object iduser) {
		
		return super.find(Users.class, iduser);
	}

	@Override
	public void delete(Object iduser) {
		super.delete(Users.class, iduser);
		
	}

	@Override
	public List<Users> listAll() {
		
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Users.countAll");
	}
	
	public Users findByEmail(String email) {
		
		List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail" , "email" , email);
		
		if(listUsers != null && listUsers.size() > 0 ) {
			
			return listUsers.get(0);
		}
		
		return null;
	}
	
	public boolean checkLogin(String email, String password) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email" , email);
		parameters.put("password" , password);
		
		List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
		
		if(listUsers.size() == 1) {
			return true;
		}
		return false;
	}
	

}
