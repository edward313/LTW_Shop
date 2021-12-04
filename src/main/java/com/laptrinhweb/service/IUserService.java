package com.laptrinhweb.service;

import com.laptrinhweb.entity.UserEntity;

public interface IUserService {
	UserEntity findOneByUserName(String email);
	Long saveUser(UserEntity user);
	void updateUser(UserEntity user);
}
