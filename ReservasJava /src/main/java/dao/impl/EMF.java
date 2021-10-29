package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory em =
	 Persistence.createEntityManagerFactory("reservas");
	
	 public static EntityManagerFactory getEMF() {
		 return em;
	 }
	 
	 //Podriamos crear el entityManager y devolverlo para modularizar
	 public static EntityManager getEM() {
		 return em.createEntityManager();
	 }
	}
