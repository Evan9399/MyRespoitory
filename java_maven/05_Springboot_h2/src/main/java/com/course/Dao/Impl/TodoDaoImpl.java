package com.course.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.course.Dao.TodoDao;
import com.course.model.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(TodoDto dto) {
		String sql="insert into todo (title, duedate, status) values (?,?,?)";
		jdbcTemplate.update(sql, dto.getTitle(), dto.getDueDate(), dto.getStatus());
		
	}

	@Override
	public void update(TodoDto dto) {
		String sql = "UPDATE TODO SET TITLE = ?, DUEDATE = ?, STATUS = ? WHERE ID = ?";
		jdbcTemplate.update(sql, dto.getTitle(), dto.getDueDate(), dto.getStatus(), dto.getId());
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoDto> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
