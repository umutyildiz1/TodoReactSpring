package com.example.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.domain.TodoItem;
import com.example.todo.domain.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;

@Service
public class TodoService {
	@Autowired //injection
	private TodoRepository todoRepo;
	@Autowired
	private UserRepository userRepo;
	public List<TodoItem> getAllTodoItems(){
		return todoRepo.getAllTodoItems();
	}

	public TodoItem updateTodoItem(int id, TodoItem body) {
		Optional <TodoItem> todoOpt = todoRepo.getAllTodoItems()
									  .stream()
									  .filter(item -> item.getId() == id)
									  .findAny();
		if(todoOpt.isPresent()){//if value exist
			TodoItem item = todoOpt.get();
			item.setDone(body.isDone());
			item.setTask(body.getTask());
			return item;
		}
		return null;
	}

	public TodoItem createTodoItem() {
		TodoItem todoItem = new TodoItem();
		todoItem.setDone(false);
		todoItem = todoRepo.saveTodo(todoItem);
		todoItem.setTask("Task #" + todoItem.getId());
		save();
		return todoItem;
		
	}

	public void deleteTodoItem(int id) {
		todoRepo.delete(id);
		
	}
	public void save() {
		User u1 = createUser( "umut");
        userRepo.save(u1);
        Optional<User> user = userRepo.findById("umut");
        System.out.println("User found = "+user.get().getMail());
	}
	public static User createUser(String email) {
	User user = new User();
	user.setMail(email);
	return user;
}
	
}
