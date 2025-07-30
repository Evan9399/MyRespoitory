package com.dao;

import java.util.Date;

import com.entity.UserEntity;

public interface UserDao {
	public UserEntity findByUsernameAndPassword(String username, String password);	
	//create
	public void addUser(UserEntity userEntity);
	//update
	public void updateUser(UserEntity userEntity);
	//delete
	public void delUser(UserEntity userEntity);
}
