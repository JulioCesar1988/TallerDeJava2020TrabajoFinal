package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value = "ORGANIZADOR")
public class Organizador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "usuario")
	private List<Evento> eventos;

	public Organizador() {
	}


	public Organizador(String nombre, String apellido, String dni, String email, String telefono, String contrasenia) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		eventos = new ArrayList<Evento>();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
