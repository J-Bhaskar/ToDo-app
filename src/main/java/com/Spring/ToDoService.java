package com.Spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("todo_serv")
public class ToDoService {
	
	@Autowired
	ToDoRepo todo_repo;
	
	public List<ToDo> getAllTodo()
	{
		return todo_repo.findAll();
	}
	
	public void addTodo(ToDo t)
	{
		todo_repo.saveAndFlush(t);
	}
	
	public void updateTodo(ToDo t)
	{
		todo_repo.saveAndFlush(t);
	}
	/*
	public void deleteTodo(int id)
	{
		todo_repo.deleteById(id);
	}
	
	public ToDo findById(int id)
	{
		return todo_repo.findById(id).get();
	}
	*/

}
