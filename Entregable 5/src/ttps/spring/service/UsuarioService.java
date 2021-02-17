package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.UsuarioDAO;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAOHibernateJPA;

	public UsuarioDAO getUsuarioDAOHibernateJPA() {
		return usuarioDAOHibernateJPA;
	}

	public void setUsuarioDAOHibernateJPA(UsuarioDAO usuarioDAOHibernateJPA) {
		this.usuarioDAOHibernateJPA = usuarioDAOHibernateJPA;
	}
}
