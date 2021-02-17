package ttps.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_USUARIO")
public class Usuario implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "USUARIO_ID")
	private Long usuarioId;

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", telefono=" + telefono + ", contrasenia=" + contrasenia + "]";
	}

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO")
	private String apellido;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEFONO")
	private String telefono;


	@Column(name = "CONTRASENIA")
	private String contrasenia;

	
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String apellido, String dni, String email, String telefono, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getContrasenia() {
		return contrasenia;
	}
	

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	

	public void actualizar(Usuario usuario) {
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.dni = usuario.getDni();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.contrasenia =  usuario.getContrasenia();
		
	}
	
	
}
