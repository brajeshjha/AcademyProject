package com.cognizant.academy.bo;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.academy.dao.StackDao;
import com.cognizant.academy.entity.Objective;
import com.cognizant.academy.entity.Stack;
import com.cognizant.academy.model.Objective_model;
import com.cognizant.academy.model.Stack_model;

public class StackBo {

	public void addStack(Stack_model s)
	{
		System.out.println("addStackbo");
		Stack stack = new Stack();
		
		stack.setName(s.getName());
		
		StackDao db = new StackDao();
		db.addStack(stack);
		System.out.println("eAddStackbo");
	}

	public List<Stack_model> showStack() {
		// TODO Auto-generated method stub
		
		List<Stack> stack = new ArrayList<Stack>();
		List<Stack_model> s = new ArrayList<Stack_model>();
		
		 StackDao db = new StackDao();
		 stack = db.showStack();
		 System.out.println(stack.size()+"stacklist size");
		 for(Stack sl:stack)
		 {
		    Stack_model sm = new Stack_model();
		    sm.setId(sl.getId());
		    sm.setName(sl.getName());
		    List<Objective_model> obml=new ArrayList<Objective_model>();
		    for(Objective ob :sl.getObjective())
		    {
		    	Objective_model obm = new Objective_model();
		    	obm.setId(ob.getId());
		    	obm.setDescription(ob.getDescription());
		    	obm.setLevel(ob.getLevel());
		    	obm.setName(ob.getName());
		    	obml.add(obm);
		    	
		    }
		    sm.setObjective(obml);
		    sm.setCount(obml.size());
		    for(Objective_model ob:obml)
		    {
		    	ob.setStack(sm);
		    }
		    s.add(sm);
		 }
		
		return s;
	}

	public void removeStack(Stack_model sm) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.setId(sm.getId());
		StackDao db = new StackDao();
		db.removeStack(stack);
	}

	public void updateStack(Stack_model sm) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.setId(sm.getId());
		stack.setName(sm.getName());
		StackDao db = new StackDao();
		db.updateStack(stack);
	}
}
