package com.course.Dao;

import java.util.List;

import com.course.model.TodoDto;

public interface TodoDao {
	
	/**
	 * 新增
	 */
	void add(TodoDto dto);
	/**
	 * 修改
	 * @param dto
	 */
	void update(TodoDto dto);
	/**
	 * 刪除
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * 查詢
	 */
	List<TodoDto> findAll();
	/**
	 * 依標題查詢
	 * @param title
	 * @return
	 */
	List<TodoDto> findByTitle(String title);
	
}
