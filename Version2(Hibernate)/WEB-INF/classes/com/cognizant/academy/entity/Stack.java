package com.cognizant.academy.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Stack {
    @Id
    @GeneratedValue
	private int stack_id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="stack")
	private List<Objective> objective= new ArrayList<Objective>();
    public int getId() {
		return stack_id;
	}
	public void setId(int id) {
		this.stack_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Objective> getObjective() {
		return objective;
	}
	public void setObjective(List<Objective> objective) {
		this.objective = objective;
	}
	
	
}
