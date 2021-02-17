package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.OrganizadorDAO;

@Service
public class OrganizadorService {
	
	@Autowired
	private OrganizadorDAO organizadorDAOHibernateJPA;

	public OrganizadorDAO getOrganizadorDAOHibernateJPA() {
		return organizadorDAOHibernateJPA;
	}

	public void setOrganizadorDAOHibernateJPA(OrganizadorDAO organizadorDAOHibernateJPA) {
		this.organizadorDAOHibernateJPA = organizadorDAOHibernateJPA;
	}

}
