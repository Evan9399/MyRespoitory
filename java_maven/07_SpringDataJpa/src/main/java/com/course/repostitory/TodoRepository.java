package com.course.repostitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	public List<TodoEntity> findByTitle(String title);
	
	public List<TodoEntity> findByTitleLike(String title);
	
	public List<TodoEntity> findByTitleAndMemo(String title,String memo);
	
	// SQL語句：select * from todo where due_date between ? and ?
	List<TodoEntity> findByDueDateBetween(Date startDate, Date endDate);
	
	// SQL語句：select * from todo where id in (?, ?, ?);
	List<TodoEntity> findByIdIn(List<Long> ids);
	
	List<TodoEntity> findByTitleOrderByDueDateDesc(String title);
	
	List<TodoEntity> findAllByOrderByDueDate();
}
