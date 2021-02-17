package ttps.spring.clasesDAOimp;

import org.springframework.stereotype.Repository;

import ttps.spring.model.Organizador;
import ttps.spring.interfacesDAO.OrganizadorDAO;

@Repository
public class OrganizadorDAOHibernateJPA extends GenericDAOHibernateJPA<Organizador> implements OrganizadorDAO {
	public OrganizadorDAOHibernateJPA() {
		super(Organizador.class);
	}

}