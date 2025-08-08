package com.course.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.Dao.TodoDao;
import com.course.model.TodoDto;

@Service
public class TodoService {
	
	@Autowired
	private TodoDao todoDao;

	public void addTodo() {
		TodoDto dto = new TodoDto();
		dto.setTitle("吃飯2");
		dto.setDueDate(new Date());
		dto.setStatus(0);
		todoDao.add(dto);
	}
	
	public void updateTodo() {
		TodoDto dto= new TodoDto();
		dto.setTitle("不吃");
		dto.setDueDate(new Date());
		dto.setStatus(3);
		dto.setId(4);
		todoDao.update(dto);	
	}
	
	public void deleteById(Integer id) {
		todoDao.delete(id);
	}
	
	public List<TodoDto> findAllTodo() {
		List<TodoDto> dtoList = todoDao.findAll();
		for (TodoDto dto : dtoList) {
			System.out.println(dto);
		}
		return dtoList;
	}
	
	
	public List<TodoDto> findByTitle(String title) {
		List<TodoDto> dtoList = todoDao.findByTitle(title);

		return dtoList;
	}
}