package clasesDAO;
import modelos.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario recuperarUsuario(String usuario);
	
}
