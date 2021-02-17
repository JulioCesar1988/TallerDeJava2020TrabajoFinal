package ttps.spring.interfacesDAO;

import java.util.List;

import ttps.spring.model.FoodTruck;


public interface FoodTruckDAO extends GenericDAO<FoodTruck> {
	
	public List<FoodTruck> getFoodTruck(long usuarioId);

	public FoodTruck validarExistencia(String nombre);
	
	public List<FoodTruck> recuperarTodos();
	public List<FoodTruck> recuperarTodosFoodtruck(long usuarioId);
	

}