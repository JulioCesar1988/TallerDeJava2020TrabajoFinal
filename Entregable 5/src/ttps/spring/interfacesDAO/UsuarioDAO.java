package ttps.spring.interfacesDAO;

import ttps.spring.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario recuperarUsuarioPorEmail(String email);
	public Usuario recuperarUsuarioPorId(Long usuarioId);
	public Usuario recuperarUsuarioPorTipo(String TIPO_USUARIO);
	public void test(String TIPO_USUARIO);
	public Usuario autenticar(String email, String contrasenia);
	
}
