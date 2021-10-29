package modelos;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name="SERVICIOS")
public class Servicio {
	
	@Id @GeneratedValue
	@Column(name="Usuario_ID")
	private Long id;
	private String nombre;
	private String tipo;
	private String descripcion;
	private String url;
	private String redesSociales;
	private Integer telefono;
	//private List<byte[]> galeria;
	
	@OneToOne 
	private Usuario duenio;
	
	@OneToMany 
	private List<Reserva> reservas;
	
	public Servicio() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Servicio(String nombre, String tipo, String descripcion, String url, String redesSociales, Integer telefono,
			List<byte[]> galeria, Usuario duenio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.url = url;
		this.redesSociales = redesSociales;
		this.telefono = telefono;
		//this.galeria = galeria;
		this.duenio = duenio;
		//this.galeria = new ArrayList<byte[]>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRedesSociales() {
		return redesSociales;
	}
	public void setRedesSociales(String redesSociales) {
		this.redesSociales = redesSociales;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	/*public List<byte[]> getGaleria() {
		return galeria;
	}
	public void setGaleria(List<byte[]> galeria) {
		this.galeria = galeria;
	}*/
	public Usuario getduenio() {
		return duenio;
	}
	public void setduenio(Usuario duenio) {
		this.duenio = duenio;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public Reserva reservar (String nombreEvento, String direccion, String codigoPostal, String provincia, String geolocalizacion,
			String tipoDeEvento, Date fechaHora, String descripcion, Boolean pago, String mail, Integer telefono,
			String estado) {
		
		Reserva res = new Reserva(nombreEvento, direccion, codigoPostal, provincia, geolocalizacion, tipoDeEvento, fechaHora, descripcion, pago, mail, telefono, estado);
		reservas.add(res);
		return res;
	}
	
	public void cambiarEstadoDeReserva (String unEstado, Reserva unaReserva) {
		unaReserva.setEstado(unEstado);
	}
	
	public void guardarValoracion (Reserva unaReserva, Puntaje unaValoracion) {
		unaReserva.guardarValoracion(unaValoracion);
	}
	
	public void confirmarPrestacion (Reserva unaReserva) {
		this.cambiarEstadoDeReserva("Confirmada", unaReserva);
		//Habilita la valoracion
	}
	
	public float calcularPromedio () {
		Integer result = 0;
		Integer cant = 0;
		Iterator<Reserva> it = reservas.iterator();
	    while(it.hasNext()) {
	      Reserva res = it.next();
	      result = (int) (result + res.calcularPromedio());
	      cant++;
	    }
	    return result/cant;
	}

}
