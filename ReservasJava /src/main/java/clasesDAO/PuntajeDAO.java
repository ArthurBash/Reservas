package clasesDAO;

import modelos.Puntaje;


public interface PuntajeDAO extends GenericDAO<Puntaje>{	
	public Puntaje recuperarPuntaje (Integer Puntaje);
	
	
}
