package dao.impl;

import java.io.Serializable;
import java.util.List;



	

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
//import javax.persistence.Persistence;
import javax.persistence.Query;

import clasesDAO.GenericDAO;


public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass= clase;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	

	@Override
	public T persistir(T entity) {
		System.out.println("Entro Al persistir");
		EntityManager emf = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		System.out.println("creo el emf");

		try {
			tx = emf.getTransaction();
			tx.begin();
			emf.persist(entity);
			tx.commit();
			}
		catch (RuntimeException e) {

			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			emf.close();
		}
		return entity;
	}
	public T actualizar(T entity) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		EntityTransaction tx = emf.getTransaction();
	
		tx.begin();
		T entityGenerico = emf.merge(entity);
		tx.commit();
		emf.close();
		return entityGenerico;
	}
	@Override
	public void borrar(T entity) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = emf.getTransaction();
			tx.begin();
			emf.remove(entity);
			tx.commit();
			}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
			}
		finally {
			emf.close();
		}
	}

	@Override
	public T borrar(Serializable id) {
		/*T entity=Conection.getEntityManagerFactory().createEntityManager().find(this.getPersistentClass(), id);
		 if (entity != null) {
		 this.borrar(entity);
		 }
		 return entity;
		 emf.close();*/
		return null; //esto no va
	}

	@Override
	public boolean existe(Serializable id) {
		Query consulta = 
				EMF.getEMF().createEntityManager().createQuery("select e from "
		+ this.getPersistentClass().getSimpleName() +
		"WHERE id = " + id);   //Preguntar que significa getSimpleName()
		
		try {
			consulta.getSingleResult();
		}
		catch (NoResultException e){  //Si no devuelve ningun elemento 
			return true;
		}
		catch (NonUniqueResultException e) { // Si devuelve mas de 1 elementos
			return false;
		}
		return false;
		
	
	}

	@Override
	public T recuperar(Serializable id) {
		Query consulta=
		EMF.getEMF().createEntityManager().createQuery("select e from "
				 + this.getPersistentClass().getSimpleName()+
				 " e order bye.“+columnOrder");
		T entityGenerico;
		try {
			entityGenerico =  (T)consulta.getSingleResult();    //Nose si hay que castearlo o no
		}
		catch (NoResultException e){  //Si no devuelve ningun elemento 
			return null;
		}
		catch (NonUniqueResultException e) { // Si devuelve mas de 1 elementos
			return null; //ACA NOSE SI DEVOLVER NULL O DEVOLVER UN STIRNG, HABRIA QUE VERLO
		}
		return entityGenerico;
}

		
	@Override
	public List<T> recuperarTodos(String column) {
		 Query consulta=
				 EMF.getEMF().createEntityManager().createQuery("select e from "
						 + this.getPersistentClass().getSimpleName()+
						 " e order bye.“+columnOrder");
				 List<T> resultado = (List<T>)consulta.getResultList();
				 return resultado;
				}

	
	}
