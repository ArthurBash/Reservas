package dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import clasesDAO.ServicioDAO;
//import modelos.Reserva;
import modelos.Servicio;

public class ServicioDAOHibernateJPA extends GenericDAOHibernateJPA<Servicio> implements ServicioDAO {
	public ServicioDAOHibernateJPA () {
		super(Servicio.class);
	}

	

	@Override
	//Recupera un servicio, en caso de haber mas de uno con el mismo nombre o de no haber retorna null
	public Servicio recuperarServicio(String servicio) {
		Query consulta = EMF.getEMF().createEntityManager().
				createQuery("select s from Servicio s where s.nombre =?");
				consulta.setParameter(1, servicio);
				Servicio resultado;
			try {
				resultado = (Servicio)consulta.getSingleResult();
			}
			catch (NoResultException e){  
				return null;
			}
			catch (NonUniqueResultException e) { 
				return null; 
			}
			
			return resultado;
	}
	
}
