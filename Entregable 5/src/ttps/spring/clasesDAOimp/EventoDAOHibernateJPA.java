package ttps.spring.clasesDAOimp;


import org.springframework.stereotype.Repository;

import ttps.spring.model.Evento;
import ttps.spring.interfacesDAO.EventoDAO;

@Repository
public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {
	public EventoDAOHibernateJPA() {
		super(Evento.class);
	}

}