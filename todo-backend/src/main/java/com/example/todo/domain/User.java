package com.example.todo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;



@Document
public class User {
	@Id
	private String mail;
	private String password;
	private List<TodoItem> todoItems = new ArrayList<>();;
	
	public List<TodoItem> getTodoItems() {
		return todoItems;
	}
	public void setTodoItems(List<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
