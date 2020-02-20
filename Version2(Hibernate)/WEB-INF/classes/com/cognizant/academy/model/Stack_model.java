package com.cognizant.academy.model;

import java.util.*;

public class Stack_model {

	private int id;
	private String name;
	private List<Objective_model> objective= new ArrayList<Objective_model>();
	private int  count;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Objective_model> getObjective() {
		return objective;
	}
	public void setObjective(List<Objective_model> objective) {
		this.objective = objective;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
