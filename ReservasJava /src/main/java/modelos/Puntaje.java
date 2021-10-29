package modelos;
import javax.persistence.*;

@Entity
@Table(name="PUNTAJES")
public class Puntaje {
	
	@Id @GeneratedValue
	@Column(name="Usuario_ID")
	private Long id;
	private Integer puntajeLimpieza;
	private Integer puntajeSimpatia;
	private Integer puntajeCalidadPrecio;
	private Integer puntajeSabor;
	private Integer puntajeDisenio;
	
	public Puntaje(){		
	}
	
	//Le dice que la informacion la va tener valoracion e ingresa una variable de instancia para conocer a la reserva
	@OneToOne
	private Reserva reserva;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Puntaje(Integer puntajeLimpieza, Integer puntajeSimpatia, Integer puntajeCalidadPrecio, Integer puntajeSabor,
			Integer puntajeDisenio) {
		super();
		this.puntajeLimpieza = puntajeLimpieza;
		this.puntajeSimpatia = puntajeSimpatia;
		this.puntajeCalidadPrecio = puntajeCalidadPrecio;
		this.puntajeSabor = puntajeSabor;
		this.puntajeDisenio = puntajeDisenio;
	}
	
	public Integer getPuntajeLimpieza() {
		return puntajeLimpieza;
	}
	public void setPuntajeLimpieza(Integer puntajeLimpieza) {
		this.puntajeLimpieza = puntajeLimpieza;
	}
	public Integer getPuntajeSimpatia() {
		return puntajeSimpatia;
	}
	public void setPuntajeSimpatia(Integer puntajeSimpatia) {
		this.puntajeSimpatia = puntajeSimpatia;
	}
	public Integer getPuntajeCalidadPrecio() {
		return puntajeCalidadPrecio;
	}
	public void setPuntajeCalidadPrecio(Integer puntajeCalidadPrecio) {
		this.puntajeCalidadPrecio = puntajeCalidadPrecio;
	}
	public Integer getPuntajeSabor() {
		return puntajeSabor;
	}
	public void setPuntajeSabor(Integer puntajeSabor) {
		this.puntajeSabor = puntajeSabor;
	}
	public Integer getPuntajeDisenio() {
		return puntajeDisenio;
	}
	public void setPuntajeDisenio(Integer puntajeDisenio) {
		this.puntajeDisenio = puntajeDisenio;
	}
	
	public float calcularPromedio () {
		return (getPuntajeCalidadPrecio() + getPuntajeDisenio() + getPuntajeLimpieza() + getPuntajeSabor() + getPuntajeSimpatia())/5;
	}
}
