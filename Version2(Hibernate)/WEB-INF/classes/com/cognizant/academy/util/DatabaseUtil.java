package com.cognizant.academy.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtil {

	static EntityManagerFactory emf= null;
	public static EntityManager getEntityManager()
	{
		System.out.println("DBUtil");
		EntityManager em =null;
		
		emf = Persistence.createEntityManagerFactory("persistence");
		em  = emf.createEntityManager();
		return em;
		
	}
	public static void closeEntityManager()
	{
		emf.close();
	}
}
