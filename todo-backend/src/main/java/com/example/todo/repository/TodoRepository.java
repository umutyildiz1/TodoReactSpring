package com.example.todo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.TodoItem;

@Repository
public class TodoRepository {
	private int idCounter = 0;
	private List<TodoItem> todoItems = new ArrayList<>();
	
	public List<TodoItem> getAllTodoItems(){
		if(todoItems.size() == 0) {
			
		}
		
		return todoItems;
	}
	
	public TodoItem saveTodo(TodoItem todoItem){
		todoItem.setId(idCounter++);
		todoItems.add(todoItem);
		return todoItem;
	}

	public void delete(int id) {
		todoItems = todoItems.stream().filter(todoItem -> !(todoItem.getId()==(id))).collect(Collectors.toList());
		
	}
}
