//import javax.persistence.Query;

//import dao.impl.EMF;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.impl.UsuarioDAOHibernateJPA;
import modelos.Usuario;

public class test {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("Juan","123","email@email.com");
		
		// controlador
		UsuarioDAOHibernateJPA usuarioDAO = new UsuarioDAOHibernateJPA();
		
		

		// guarda un cliente a través del controlador
		usuarioDAO.persistir(usuario);

		// ver Usuario
		//Usuario usuario_recuperado = usuarioDAO.recuperarUsuario(usuario.getNombre());
		//String email = 	usuario_recuperado.getMail();
		System.out.println("Daleeeeeeeeee perrro");
		//System.out.println(email);
		// editar un cliente por medio del id

		}
}