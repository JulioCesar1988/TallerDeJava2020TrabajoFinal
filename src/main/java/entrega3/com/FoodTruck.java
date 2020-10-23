package entrega3.com;
import java.util.ArrayList;
public class FoodTruck  {
	
	public String nombre;
	public ArrayList<String> servicios;
	public String descripcion;
	public String url_pagina_web;
	public String whatsApp;
	public String twitter;
	public String instagram;
	public ArrayList<String> zonas;
	public ArrayList<String> path_imagenes;

	public FoodTruck(String nombre, ArrayList<String> servicios, String descripcion, String url_pagina_web, String whatsApp, String twitter, String instagram, ArrayList<String> zonas, ArrayList<String> path_imagenes) {
		this.nombre = nombre;
		this.servicios = servicios;
		this.descripcion = descripcion;
		this.url_pagina_web = url_pagina_web;
		this.whatsApp = whatsApp;
		this.twitter = twitter;
		this.instagram = instagram;
		this.zonas = zonas;
		this.path_imagenes = path_imagenes;
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

	public String getUrl_pagina_web() {
		return url_pagina_web;
	}

	public void setUrl_pagina_web(String url_pagina_web) {
		this.url_pagina_web = url_pagina_web;
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

	public ArrayList<String> getPath_imagenes() {
		return path_imagenes;
	}

	public void setPath_imagenes(ArrayList<String> path_imagenes) {
		this.path_imagenes = path_imagenes;
	}
}
