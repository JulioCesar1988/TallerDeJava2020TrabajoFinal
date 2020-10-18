package entrega3.com;

import java.util.ArrayList;

public class Organizador extends Usuario {
	
	public ArrayList<Evento> eventos;

	public Organizador(String nombre, String apellido, String dni, String email, String telefono, String contrasenia) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		// genero mi lista de eventos . 
		this.eventos =  new ArrayList<Evento>();
	}

	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	// Agrega un evento a mi lista de eventos.
	public void agregarEvento(Evento evento ) {
		this.eventos.add(evento);
	}
	
	
	public void ver_mis_eventos() {
		
		for (int i = 0; i < this.getEventos().size(); i++) {
			
		    this.getEventos().get(i).detalle();
		}
	}

	




}
