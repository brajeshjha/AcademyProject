package com.cognizant.academy.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cognizant.academy.entity.Stack;
import com.cognizant.academy.model.Stack_model;
import com.cognizant.academy.util.DatabaseUtil;

public class StackDao {

	public void addStack(Stack s)
	{
		System.out.println("addStackDao");
		EntityManager em = DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		System.out.println("eaddStackDao");
		em.close();
		DatabaseUtil.closeEntityManager();
		
	}

	public List<Stack> showStack() {
		// TODO Auto-generated method stub
		List<Stack> s = new ArrayList<Stack>();
		
		System.out.println("showstackDao");
		EntityManager em = DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("from Stack");
		s = (List<Stack>)q.getResultList();
		
		for(Stack st :s)
		{
			System.out.println(st.getId()+" "+st.getName()+" "+st.getObjective().size());
			
		}
		
		em.close();
		DatabaseUtil.closeEntityManager();
		return s;
	}

	public void removeStack(Stack stack) {
		// TODO Auto-generated method stub
		EntityManager em = DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
	    stack = em.find(Stack.class,stack.getId());
	    em.remove(stack);
	    em.getTransaction().commit();
	    em.close();
		DatabaseUtil.closeEntityManager();
	}

	public void updateStack(Stack stack) {
		// TODO Auto-generated method stub
		EntityManager em = DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Stack s = new Stack();
		s = em.find(Stack.class,stack.getId());
	    s.setName(stack.getName());
	    em.merge(s);
	    em.getTransaction().commit();
	    em.close();
		DatabaseUtil.closeEntityManager();
	}

}
