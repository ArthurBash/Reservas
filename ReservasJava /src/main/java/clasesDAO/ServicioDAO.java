package clasesDAO;

import modelos.Servicio;

public interface ServicioDAO extends GenericDAO<Servicio> {
	public  Servicio recuperarServicio (String servicio);
}
