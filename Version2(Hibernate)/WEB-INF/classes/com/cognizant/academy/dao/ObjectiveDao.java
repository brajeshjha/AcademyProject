package com.cognizant.academy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cognizant.academy.entity.Objective;
import com.cognizant.academy.entity.Stack;
import com.cognizant.academy.util.DatabaseUtil;

public class ObjectiveDao {

	public void addObjective(Objective obje, int stack_id) {
		// TODO Auto-generated method stub
		EntityManager em=DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Stack s = em.find(Stack.class,stack_id);
		obje.setStack(s);
		em.persist(obje);
		em.getTransaction().commit();
		em.close();
		DatabaseUtil.closeEntityManager();
	}

	public List<Objective> showObjective(int stack_id) {
		// TODO Auto-generated method stub
		List<Objective> obel = new ArrayList<Objective>();
		EntityManager em = DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Stack s = em.find(Stack.class,stack_id);
		
		
		String hql = "from Objective o where o.stack= :stack";
		Query query = em.createQuery(hql);
		query.setParameter("stack",s);
		obel =(List<Objective>)query.getResultList();
		System.out.println(obel.size());
		em.close();
		DatabaseUtil.closeEntityManager();
		return obel;
	}

	public void removeObjective(Objective obe) {
		// TODO Auto-generated method stub
		EntityManager em=DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Objective ob = em.find(Objective.class,obe.getId());
		em.remove(ob);
		em.getTransaction().commit();
		em.close();
		DatabaseUtil.closeEntityManager();
		
	}

	public void updateObjective(Objective obe) {
		// TODO Auto-generated method stub
		EntityManager em=DatabaseUtil.getEntityManager();
		em.getTransaction().begin();
		Objective ob = em.find(Objective.class,obe.getId());
	
			ob.setLevel(obe.getLevel());

			ob.setName(obe.getName());
	
			ob.setDescription(obe.getDescription());

		em.merge(ob);
		em.getTransaction().commit();
		em.close();
		DatabaseUtil.closeEntityManager();
	}

}
