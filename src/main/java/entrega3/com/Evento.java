package entrega3.com;

import java.sql.Date;
import java.util.ArrayList;

public class Evento {

	public String nombreEvento;
	public String direccion;
	public String codigoPostal;
	public String tipoDeEvento;
	public String email;
	public String descripcion;
	public String formaDePago;
	public String telefono;
	public Date fechaInicio;
	public Date fechaFin;
	public String provincia;
	public Double geolocalizacion;


	public Evento(String nombreEvento, String direccion, String codigoPostal, String tipoDeEvento, String email, String descripcion, String formaDePago, String telefono, Date fechaInicio, Date fechaFin, String provincia, Double geolocalizacion) {
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
}
