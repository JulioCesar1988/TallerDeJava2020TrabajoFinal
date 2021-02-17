package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.ValoracionDAO;


@Service
public class ValoracionService {
	
	@Autowired
	private ValoracionDAO valoracionDAOHibernateJPA;

	public ValoracionDAO getValoracionDAOHibernateJPA() {
		return valoracionDAOHibernateJPA;
	}

	public void setValoracionDAOHibernateJPA(ValoracionDAO valoracionDAOHibernateJPA) {
		this.valoracionDAOHibernateJPA = valoracionDAOHibernateJPA;
	}

}
