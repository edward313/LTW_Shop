package com.laptrinhweb.service.impl;

import javax.inject.Inject;

import com.laptrinhweb.dao.IUserDAO;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserEntity findOneByUserName(String email) {
		return userDAO.findOneByUsername(email);
	}

	@Override
	public Long saveUser(UserEntity user) {
		return userDAO.saveUser(user);
	}

	@Override
	public void updateUser(UserEntity user) {
		userDAO.updateUser(user);
	}
	
}
