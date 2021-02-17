package ttps.spring.model;

import javax.persistence.*;


import java.util.Date;

@Entity
@Table(name = "VALORACION")
public class Valoracion implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "VALORACION_ID")
	private Long valoracionId;

	@Column(name = "LIMPIEZA")
	private int limpieza;

	@Column(name = "SIMPATIA")
	private int simpatia;

	@Column(name = "CALIDAD")
	private int calidad;

	@Column(name = "PRECIO")
	private int precio;

	@Column(name = "SABOR")
	private int sabor;

	@Column(name = "DISENIO")
	private int disenio;

	@Column(name = "FECHA_VALORACION")
	private Date fechaValoracion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "foodTruckId")
	private FoodTruck foodTruck;

	@ManyToOne(optional = false)
	@JoinColumn(name = "eventoId")
	private Evento evento;

	public Valoracion() {
	}

	public Valoracion(int limpieza, int simpatia, int calidad, int precio, int sabor, int disenio, Date fechaValoracion,
			FoodTruck foodTruck, Evento evento) {
		this.limpieza = limpieza;
		this.simpatia = simpatia;
		this.calidad = calidad;
		this.precio = precio;
		this.sabor = sabor;
		this.disenio = disenio;
		this.fechaValoracion = fechaValoracion;
		this.foodTruck = foodTruck;
		this.evento = evento;

	}

	public Long getValoracionId() {
		return valoracionId;
	}

	public void setValoracionId(Long valoracionId) {
		this.valoracionId = valoracionId;
	}

	public FoodTruck getFoodTruck() {
		return foodTruck;
	}

	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}

	public int getSimpatia() {
		return simpatia;
	}

	public void setSimpatia(int simpatia) {
		this.simpatia = simpatia;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getSabor() {
		return sabor;
	}

	public void setSabor(int sabor) {
		this.sabor = sabor;
	}

	public int getDisenio() {
		return disenio;
	}

	public void setDisenio(int disenio) {
		this.disenio = disenio;
	}

	public Date getFechaValoracion() {
		return fechaValoracion;
	}

	public void setFechaValoracion(Date fechaValoracion) {
		this.fechaValoracion = fechaValoracion;
	}

}
