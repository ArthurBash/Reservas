package dao.impl;
import clasesDAO.ReservaDAO;
import clasesDAO.UsuarioDAO;
//import dao.*;
//import dao.impl.*;

public class DaoFactory {
	 public static UsuarioDAO getUsuarioDAO() {
		 return new UsuarioDAOHibernateJPA();
		 }
	 
	 public static ReservaDAO getReservaDAO() {
		 return new ReservaDAOHibernateJPA();
	 }
}
 	// Falta implementar de PUNTAJE Y DE USUARIO , AL igual que los daos y las implementaciones.




