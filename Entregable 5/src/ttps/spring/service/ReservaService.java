package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.ReservaDAO;


@Service
public class ReservaService {
	
	@Autowired
	private ReservaDAO reservaDAOHibernateJPA;

	public ReservaDAO getReservaDAOHibernateJPA() {
		return reservaDAOHibernateJPA;
	}

	public void setReservaDAOHibernateJPA(ReservaDAO reservaDAOHibernateJPA) {
		this.reservaDAOHibernateJPA = reservaDAOHibernateJPA;
	}

}
