package modelos;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id @GeneratedValue
	@Column(name="Usuario_ID")
	private Long id;
	
	private String nombre;
	private String password;
	private String mail;
	
	@OneToOne 
	private Servicio servicoBrindado;
	
	@OneToMany
	private List<Reserva> reservas;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String password, String mail) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.mail = mail;
		this.reservas = new ArrayList<Reserva>();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void guardarReserva(Reserva unaReserva) {
		this.reservas.add(unaReserva);
	}

}
