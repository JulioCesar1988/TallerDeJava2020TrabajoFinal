package ttps.spring.clasesDAOimp;

import org.springframework.stereotype.Repository;

import ttps.spring.model.Reserva;
import ttps.spring.interfacesDAO.ReservaDAO;

@Repository
public class ReservaDAOHibernateJPA extends GenericDAOHibernateJPA<Reserva> implements ReservaDAO {
	public ReservaDAOHibernateJPA() {
		super(Reserva.class);
	}

}