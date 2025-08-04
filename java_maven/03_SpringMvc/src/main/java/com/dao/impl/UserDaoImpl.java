package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.DbConnectionService;

import jakarta.persistence.NoResultException;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private DbConnectionService connectionService;

	@Override
	public UserEntity findByUsernameAndPassword(String username, String password) {
		// 連線取得 DB 資料
		Configuration configuration = new Configuration().configure();
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    Session session = sessionFactory.openSession();
		
	    // JPQL
	    // SQL Injection -> preparestatement
	    String sql = "select u from UserEntity u where u.username = ?1 and u.password = ?2";
	    Query<UserEntity> query = session.createQuery(sql, UserEntity.class);
	    query.setParameter(1, username);
	    query.setParameter(2, password);
	    List<UserEntity> userList = query.getResultList();
	    return userList != null && userList.size() > 0 ? userList.get(0) : null ;
	    //如果userList 不等於 空的 而且 userList的數量大於0 ?(條件是真:假) TRUE就傳出，FALSE就傳空
		
	}

	@Override
	public void addUser(UserEntity userEntity) {
		//連接DB
		Session session=connectionService.getSession();
		//開始交易 transaction
		Transaction transaction=session.beginTransaction();
		//填入資料
		session.persist(userEntity);
		//commit上傳帶入
		transaction.commit();
		session.close();
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		   //  Try With Resource
	    try (Session session = connectionService.getSession();) {
			// 開啟交易/事務
			Transaction transaction = session.beginTransaction();
			
			// Hibernate 6.0 以上
			//update 用merge
			session.merge(userEntity);

			// 提交
			transaction.commit();
	    }
	}

	@Override
	public void delUser(UserEntity userEntity) {
	//  Try With Resource
	    try (Session session = connectionService.getSession();) {
			// 開啟交易/事務
			Transaction transaction = session.beginTransaction();

			// Hibernate 6.0 以上
			//delete 用 remove
			session.remove(userEntity);

			// 提交
			transaction.commit();
	    }
	}

	@Override
	public List<UserEntity> findAll() {
		try (Session session = connectionService.getSession();) {//先連線
			//String sql = "select u from UserEntity u ";
		    //Query<UserEntity> query = session.createQuery(sql, UserEntity.class);
		    
		    
		    String sql = "select * from user ";//原生地SQL寫法
		    Query<UserEntity> query = session.createNativeQuery(sql, UserEntity.class);//因為是原生SQL寫法，所以要加native
		    List<UserEntity> userList = query.getResultList();
		    return userList;
		}
		
		
	}

	@Override
	public UserEntity findById(Long id) {
		try (Session session = connectionService.getSession();) {
		    String sql = "select * from user u where u.id = :id2 ";
		    Query<UserEntity> query = session.createNativeQuery(sql, UserEntity.class);
		    query.setParameter("id2", id);
		   
		    //System.out.println(userList.get(0).getId());
		    List<UserEntity> userList = query.getResultList();
			return userList.get(0);
			
		}
	}
	
	/* List<UserEntity> userList = query.getResultList();
     return userList.get(0);
    UserEntity userEntity;
    try {
    	userEntity = query.getSingleResult();
    } catch (NoResultException e) {
    	return null;
    }
    
    return userEntity;
}*/
	
	
}
