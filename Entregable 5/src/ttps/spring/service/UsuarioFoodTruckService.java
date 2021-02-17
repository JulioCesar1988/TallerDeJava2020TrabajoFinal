package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.UsuarioFoodTruckDAO;


@Service
public class UsuarioFoodTruckService {
	
	@Autowired
	private UsuarioFoodTruckDAO usuarioFoodTruckDAOHibernateJPA;

	public UsuarioFoodTruckDAO getUsuarioFoodTruckDAOHibernateJPA() {
		return usuarioFoodTruckDAOHibernateJPA;
	}

	public void setUsuarioFoodTruckDAOHibernateJPA(UsuarioFoodTruckDAO usuarioFoodTruckDAOHibernateJPA) {
		this.usuarioFoodTruckDAOHibernateJPA = usuarioFoodTruckDAOHibernateJPA;
	}

}
