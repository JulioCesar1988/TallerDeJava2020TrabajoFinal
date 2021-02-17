package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.EventoDAO;

@Service
public class EventoService {

	@Autowired
	private EventoDAO eventoDAOHibernateJPA;

	public EventoDAO getEventoDAOHibernateJPA() {
		return eventoDAOHibernateJPA;
	}

	public void setEventoDAOHibernateJPA(EventoDAO eventoDAOHibernateJPA) {
		this.eventoDAOHibernateJPA = eventoDAOHibernateJPA;
	}

	
}
