package dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
//import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import clasesDAO.UsuarioDAO;
import modelos.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	@Override
	//Recupera un Reserva, en caso de haber mas de uno con el mismo nombre o de no haber retorna null
	public Usuario recuperarUsuario(String nombre) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select p from Persona p where p.nombre = ?");
		consulta.setParameter(1, nombre);
		Usuario resultado;
		try {
			resultado = (Usuario) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		}
		return resultado;
	}

}