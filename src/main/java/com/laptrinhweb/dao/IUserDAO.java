package com.laptrinhweb.dao;

import com.laptrinhweb.entity.UserEntity;

public interface IUserDAO {
	UserEntity findOneByUsername(String username);
	Long saveUser(UserEntity user);
	void updateUser(UserEntity user);
}
