package com.cognizant.academy.model;

public class Objective_model {
  
	private int id;
	private String name;
	private String level;
	private String description;
	private Stack_model stack;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Stack_model getStack() {
		return stack;
	}
	public void setStack(Stack_model stack) {
		this.stack = stack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
