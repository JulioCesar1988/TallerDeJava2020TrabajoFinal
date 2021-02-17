package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "FOODTRUCK")
public class FoodTruck implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "FOODTRUCK_ID")
	private Long foodTruckId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "SERVICIOS")
	private ArrayList<String> servicios;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "URL")
	private String url;

	@Column(name = "WHATSAPP")
	private String whatsApp;

	@Column(name = "TWITTER")
	private String twitter;

	@Column(name = "INSTRAGRAM")
	private String instagram;

	@Column(name = "ZONAS")
	private ArrayList<String> zonas;

	@Column(name = "IMAGENES")
	private ArrayList<String> pathImagenes;

	@ManyToOne(optional = false)
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;

	@OneToMany(mappedBy = "foodTruck")
	private List<Reserva> reservas;

	@Column(name = "VALORACION")
	private Valoracion valoracion;

	@OneToMany(mappedBy = "foodTruck")
	private List<Valoracion> valoraciones;

	public FoodTruck() {

	}

	public FoodTruck(String nombre, ArrayList<String> servicios, String descripcion, String url,
			String whatsApp, String twitter, String instagram, ArrayList<String> zonas, ArrayList<String> pathImagenes,
			Usuario usuario) {
		this.nombre = nombre;
		this.servicios = servicios;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsApp = whatsApp;
		this.twitter = twitter;
		this.instagram = instagram;
		this.zonas = zonas;
		this.pathImagenes = pathImagenes;
		this.usuario = usuario;

	}

	@Override
	public String toString() {
		return "FoodTruck [foodTruckId=" + foodTruckId + ", nombre=" + nombre + ", servicios=" + servicios
				+ ", descripcion=" + descripcion + ", url=" + url + ", whatsApp=" + whatsApp
				+ ", twitter=" + twitter + ", instagram=" + instagram + ", zonas=" + zonas + ", pathImagenes="
				+ pathImagenes + ", usuario=" + usuario + ", valoracion=" + valoracion +"]";
	}

	public Long getFoodTruckId() {
		return foodTruckId;
	}

	public void setFoodTruckId(Long foodTruckId) {
		this.foodTruckId = foodTruckId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<String> servicios) {
		this.servicios = servicios;
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

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public ArrayList<String> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<String> zonas) {
		this.zonas = zonas;
	}

	public ArrayList<String> getPathImagenes() {
		return pathImagenes;
	}

	public void setPath_imagenes(ArrayList<String> pathImagenes) {
		this.pathImagenes = pathImagenes;
	}
	
	
	public void actualizar(FoodTruck foodtruck) {
		this.nombre = foodtruck.getNombre();
		this.servicios = foodtruck.getServicios();
		this.descripcion = foodtruck.getDescripcion();
		this.url  = foodtruck.getUrl();
		this.whatsApp = foodtruck.getWhatsApp();
		this.twitter= foodtruck.getTwitter();
		this.instagram = foodtruck.getInstagram();
		this.zonas = foodtruck.getZonas();
	
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public void setPathImagenes(ArrayList<String> pathImagenes) {
		this.pathImagenes = pathImagenes;
	}
	
	
	
	
	
}
