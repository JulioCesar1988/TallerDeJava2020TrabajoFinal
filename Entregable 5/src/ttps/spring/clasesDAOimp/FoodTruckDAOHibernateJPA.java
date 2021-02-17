package ttps.spring.clasesDAOimp;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.FoodTruck;
import ttps.spring.model.Usuario;
import ttps.spring.interfacesDAO.FoodTruckDAO;

@Repository
public class FoodTruckDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTruck> implements FoodTruckDAO {
	public FoodTruckDAOHibernateJPA() {
		super(FoodTruck.class);
	}
	
	

	@Override
	public List<FoodTruck> getFoodTruck(long usuarioId) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		try {
			Query consulta = this.getEntityManager().createQuery("select u from FoodTruck u ");
		
			return (List<FoodTruck>) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
		
	}


	@Override
	public FoodTruck validarExistencia(String nombre) {
		// TODO Auto-generated method stub
		try {
			Query consulta = this.getEntityManager().createQuery("select u from FoodTruck u where u.nombre =?1");
			consulta.setParameter(1, nombre);
			FoodTruck resultado = (FoodTruck) consulta.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
		
	}


	@Override
	public List<FoodTruck> recuperarTodosFoodtruck(long usuarioId ) {
		try {
			Query consulta = this.getEntityManager().createQuery("select u from FoodTruck u ");
			//consulta.setParameter(1, usuarioId);
			List<FoodTruck> resultado = (List<FoodTruck>) consulta.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	
	}





}