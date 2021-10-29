package dao.impl;

import modelos.Reserva;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import clasesDAO.ReservaDAO;

public class ReservaDAOHibernateJPA extends GenericDAOHibernateJPA<Reserva> implements ReservaDAO {
	public ReservaDAOHibernateJPA() {
		super(Reserva.class);
	}

	@Override
	//Recupera un Reserva, en caso de haber mas de uno con el mismo nombre o de no haber retorna null
	public Reserva recuperarReserva(String reserva) {
		Query consulta = EMF.getEMF().createEntityManager()
				.createQuery("select r from Reserva r where r.nombreEvento =?");
		consulta.setParameter(1, reserva);
		Reserva resultado;
		try {
			resultado = (Reserva) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		}

		return resultado;
	}
}