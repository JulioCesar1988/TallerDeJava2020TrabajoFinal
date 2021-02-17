package ttps.spring.model;

import javax.persistence.*;


@Entity
@Table(name = "RESERVA")
public class Reserva implements java.io.Serializable {

	/**
	 * 
	 */

	public enum Estado {
		PENDIENTE, CANCELADO, ACEPTADO, FINALIZADO;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "RESERVA_ID")
	private Long reservaId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "eventoId")
	private Evento evento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "foodTruckId")
	private FoodTruck foodTruck;

	@Column(name = "ESTADO")
	private Estado estado;

	public Reserva() {
	}

	public Reserva(Evento evento, FoodTruck foodTruck, String estado) {
		super();
		this.evento = evento;
		this.foodTruck = foodTruck;
		this.estado = Estado.PENDIENTE;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Long getReservaId() {
		return reservaId;
	}

	public void setReservaId(Long reservaId) {
		this.reservaId = reservaId;
	}

}
