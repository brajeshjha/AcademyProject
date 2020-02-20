package com.cognizant.academy.entity;

import javax.persistence.*;

import com.cognizant.academy.model.Stack_model;
@Entity
public class Objective {
  
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String level;
	private String description;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="stack_id")
	private Stack stack;
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
	public Stack getStack() {
		return stack;
	}
	public void setStack(Stack stack) {
		this.stack = stack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
