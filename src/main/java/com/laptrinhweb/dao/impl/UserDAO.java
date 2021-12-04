package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.IUserDAO;
import com.laptrinhweb.entity.UserEntity;

public class UserDAO extends AbstractDAO<UserEntity> implements IUserDAO{

	@Override
	public UserEntity findOneByUsername(String email) {
		String sql = "SELECT u FROM UserEntity u " + "WHERE u.email = ?1";
		List<UserEntity> users = query(sql, email);
		if(users==null) 
			return null;
		return users.get(0);
	}

	@Override
	public Long saveUser(UserEntity user) {
		return insert(user).getId();
	}

	@Override
	public void updateUser(UserEntity user) {
		update(user);
	}
	
}
