package modelos;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="RESERVAS")
public class Reserva {
	
	@Id @GeneratedValue
	@Column(name="Usuario_ID")
	private Long id;
	private String nombreEvento;
	private String direccion;
	private String codigoPostal;
	private String provincia;
	private String geolocalizacion;
	private String tipoDeEvento;
	private Date fechaHora;
	private String descripcion;
	private Boolean pago;
	private String mail;
	private Integer telefono;
	private String estado;
	
	@OneToOne
	private Puntaje valoracion;
	
	@ManyToOne
	private Servicio servicio;
	
	@ManyToOne
	private Usuario usuario; 
	
	public Reserva() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Reserva(String nombreEvento, String direccion, String codigoPostal, String provincia, String geolocalizacion,
			String tipoDeEvento, Date fechaHora, String descripcion, Boolean pago, String mail, Integer telefono,
			String estado) {
		super();
		this.nombreEvento = nombreEvento;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.geolocalizacion = geolocalizacion;
		this.tipoDeEvento = tipoDeEvento;
		this.fechaHora = fechaHora;
		this.descripcion = descripcion;
		this.pago = pago;
		this.mail = mail;
		this.telefono = telefono;
		this.estado = estado;
	}

	
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public String getTipoDeEvento() {
		return tipoDeEvento;
	}
	public void setTipoDeEvento(String tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public float calcularPromedio () {
		return valoracion.calcularPromedio();
	}
	
	public void guardarValoracion (Puntaje unaValoracion) {
		valoracion = unaValoracion;
	}

}
