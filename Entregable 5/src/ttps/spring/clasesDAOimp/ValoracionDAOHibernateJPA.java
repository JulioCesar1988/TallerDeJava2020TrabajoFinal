package ttps.spring.clasesDAOimp;

import org.springframework.stereotype.Repository;

import ttps.spring.model.Valoracion;
import ttps.spring.interfacesDAO.*;

@Repository 
public class ValoracionDAOHibernateJPA extends GenericDAOHibernateJPA<Valoracion> implements ValoracionDAO {
	public ValoracionDAOHibernateJPA() {
		super(Valoracion.class);
	}

}
