package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.UserEntity;

public interface UserDao {
	public UserEntity findByUsernameAndPassword(String username, String password);	
	//create
	public void addUser(UserEntity userEntity);
	//update
	public void updateUser(UserEntity userEntity);
	//delete
	public void delUser(UserEntity userEntity);
	
	//查詢全部資料
	public List<UserEntity> findAll();
	//findById
	public UserEntity findById(Long id);//只找一筆 所以不用List
}
