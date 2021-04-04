package com.example.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.TodoItem;
import com.example.todo.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	//GetAllItems
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> getAllTodoItems(){
		List<TodoItem> todoItems = todoService.getAllTodoItems();
		
		return ResponseEntity.ok(todoItems);
	}
	
	//Create Method
	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createNewTodoItems(){
		TodoItem todoItem = todoService.createTodoItem();
		return ResponseEntity.ok(todoItem);
	}
	
	//Put Method
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItem(@PathVariable int id, @RequestBody TodoItem body){
		//call service
		//get data from server
		//send it to frontend
		TodoItem updatedTodoItem = todoService.updateTodoItem(id, body);
		return ResponseEntity.ok(updatedTodoItem);
	}
	@DeleteMapping("/api/todoItems/{id}")
	public ResponseEntity<?> deleteTodoItem(@PathVariable int id){
		todoService.deleteTodoItem(id);
		return ResponseEntity.ok(null);
	}
}

