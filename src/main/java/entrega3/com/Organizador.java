package entrega3.com;

import java.util.ArrayList;

public class Organizador extends Usuario {
	
	public ArrayList<Evento> eventos;

	public Organizador(String nombre, String apellido, String dni, String email, String telefono, String contrasenia) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		// genero mi lista de eventos . 
		this.eventos =  new ArrayList<Evento>();
	}




}
