package com.course.repostitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	public List<TodoEntity> findByTitle(String title);
	
	List<TodoEntity> findByTitle(String title, Sort sort);
	
	public List<TodoEntity> findByTitleLike(String title);
	
	public List<TodoEntity> findByTitleAndMemo(String title,String memo);
	
	// SQL語句：select * from todo where due_date between ? and ?
	List<TodoEntity> findByDueDateBetween(Date startDate, Date endDate);
	
	// SQL語句：select * from todo where id in (?, ?, ?);
	List<TodoEntity> findByIdIn(List<Long> ids);
	
	List<TodoEntity> findByTitleOrderByDueDateDesc(String title);
	
	List<TodoEntity> findAllByOrderByDueDate();
	
	//JPQL
	@Query("select t from TodoEntity t where t.title like ?1 order by t.dueDate desc")
	List<TodoEntity> findByCondition(String title);
	
	//JPQL
	@Query(nativeQuery = true, value = "select * from todo where id = ? order by due_date desc")
	List<TodoEntity> findByConditionNative(String title);
	
	@Query("select t from TodoEntity t where t.status = :st and t.title = :tt ")
	List<TodoEntity> findByStatusAndTitle(@Param("st") Integer status, @Param("tt") String title);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update todo set title = ? where id = ? ")
	void updateTodoTitle(String title, Long id);
	
}
