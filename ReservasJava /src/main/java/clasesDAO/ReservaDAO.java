package clasesDAO;

import modelos.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva>{
	public Reserva recuperarReserva(String reserva);
		
}