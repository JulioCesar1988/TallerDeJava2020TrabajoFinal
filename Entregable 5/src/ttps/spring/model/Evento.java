package ttps.spring.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "EVENTO")
public class Evento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "EVENTO_ID")
	private Long eventoId;

	@Column(name = "NOMBRE_EVENTO")
	private String nombreEvento;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name = "TIPO_EVENTO")
	private String tipoDeEvento;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "FORMA_PAGO")
	private String formaDePago;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "FECHA_FIN")
	private Date fechaFin;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "GEOLOCALIZACION")
	private Double geolocalizacion;

	@OneToMany(mappedBy = "evento")
	private List<Reserva> Reservas;

	@ManyToOne(optional = false)
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;

	public Evento() {
	}

	public Evento(String nombreEvento, String direccion, String codigoPostal, String tipoDeEvento, String email,
			String descripcion, String formaDePago, String telefono, Date fechaInicio, Date fechaFin, String provincia,
			Double geolocalizacion, Usuario usuario) {
		this.nombreEvento = nombreEvento;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.tipoDeEvento = tipoDeEvento;
		this.email = email;
		this.descripcion = descripcion;
		this.formaDePago = formaDePago;
		this.telefono = telefono;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.provincia = provincia;
		this.geolocalizacion = geolocalizacion;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Evento [eventoId=" + eventoId + ", nombreEvento=" + nombreEvento + ", direccion=" + direccion
				+ ", codigoPostal=" + codigoPostal + ", tipoDeEvento=" + tipoDeEvento + ", email=" + email
				+ ", descripcion=" + descripcion + ", formaDePago=" + formaDePago + ", telefono=" + telefono
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", provincia=" + provincia
				+ ", geolocalizacion=" + geolocalizacion + ", usuario=" + usuario + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getTipoDeEvento() {
		return tipoDeEvento;
	}

	public void setTipoDeEvento(String tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Double getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(Double geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public Long getEventoId() {
		return eventoId;
	}

	public void setEventoId(Long eventoId) {
		this.eventoId = eventoId;
	}
	
	
}
