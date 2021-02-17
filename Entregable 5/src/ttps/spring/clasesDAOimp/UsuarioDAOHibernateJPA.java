package ttps.spring.clasesDAOimp;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.Usuario;
import ttps.spring.interfacesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	@Override
	public Usuario recuperarUsuarioPorEmail(String email) {

		try {
			Query consulta = this.getEntityManager().createQuery("select u from Usuario u where u.email =?1");
			consulta.setParameter(1, email);
			Usuario resultado = (Usuario) consulta.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}

	}
	
	
	@Override
	public Usuario recuperarUsuarioPorTipo(String TIPO_USUARIO) {
		Query consulta = this.getEntityManager().createQuery("select u from usuario u where u.TIPO_USUARIO =?1");
		consulta.setParameter(1, TIPO_USUARIO);
		Usuario resultado = (Usuario) consulta.getSingleResult();
		return resultado;
	}

	@Override
	public void test(String TIPO_USUARIO) {
		System.out.println("TIPO DE USUARIO : " + TIPO_USUARIO);
	}

	@Override
	public Usuario autenticar(String email, String contrasenia) {
		Usuario user = recuperarUsuarioPorEmail(email);
		if (email.equals(user.getEmail())) {
			if (contrasenia.equals(user.getContrasenia())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}

	@Override
	public Usuario recuperarUsuarioPorId(Long usuarioId) {
		// TODO Auto-generated method stub
		try {
			Query consulta = this.getEntityManager().createQuery("select u from Usuario u where u.usuarioId =?1");
			consulta.setParameter(1, usuarioId);
			Usuario resultado = (Usuario) consulta.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
		
	}

}