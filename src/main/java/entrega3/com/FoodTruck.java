package entrega3.com;

import java.util.ArrayList;

public class FoodTruck  {
	
	public String nombre;
	public ArrayList<String> servicios;
	public String descripcion;
	public String url_pagina_web;
	public String whataApp;
	public String Twitter;
	public String instagram;
	public String pathImagen;
	public ArrayList<String> zonas;
	public String Estado;// aceptado , rechazado. 
    public int valoracion;// limpieza , simpatia , calidad , precio , sabor , diseño.
	
	public FoodTruck(String nombre, ArrayList<String> servicios, String descripcion, String url_pagina_web,
			String whataApp, String twitter, String instagram, String pathImagen, ArrayList<String> zonas , int valoracion) {
		super();
		this.nombre = nombre;
		this.servicios = servicios;
		this.descripcion = descripcion;
		this.url_pagina_web = url_pagina_web;
		this.whataApp = whataApp;
		Twitter = twitter;
		this.instagram = instagram;
		this.pathImagen = pathImagen;
		this.zonas = zonas;
		this.valoracion = valoracion;
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

	public String getWhataApp() {
		return whataApp;
	}

	public void setWhataApp(String whataApp) {
		this.whataApp = whataApp;
	}

	public String getTwitter() {
		return Twitter;
	}

	public void setTwitter(String twitter) {
		Twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public ArrayList<String> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<String> zonas) {
		this.zonas = zonas;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

}
