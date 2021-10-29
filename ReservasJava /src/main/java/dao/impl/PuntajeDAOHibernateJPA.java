package dao.impl;

import clasesDAO.PuntajeDAO;
//import clasesDAO.UsuarioDAO;
import modelos.Puntaje;
//import modelos.Usuario;

public class PuntajeDAOHibernateJPA  extends GenericDAOHibernateJPA<Puntaje> implements PuntajeDAO {
		public PuntajeDAOHibernateJPA() 		{
			super(Puntaje.class);
		}

		@Override
		public Puntaje recuperarPuntaje(Integer puntaje) {
			return null;
		}	
}


