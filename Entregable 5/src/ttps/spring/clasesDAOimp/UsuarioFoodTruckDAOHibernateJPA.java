package ttps.spring.clasesDAOimp;

import org.springframework.stereotype.Repository;

import ttps.spring.model.UsuarioFoodTruck;
import ttps.spring.interfacesDAO.UsuarioFoodTruckDAO;

@Repository
public class UsuarioFoodTruckDAOHibernateJPA extends GenericDAOHibernateJPA<UsuarioFoodTruck>
		implements UsuarioFoodTruckDAO {

	public UsuarioFoodTruckDAOHibernateJPA() {
		super(UsuarioFoodTruck.class);
	}

}
