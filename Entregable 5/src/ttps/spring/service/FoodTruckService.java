package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.interfacesDAO.FoodTruckDAO;

@Service
public class FoodTruckService {
	
	@Autowired
	private FoodTruckDAO foodTruckDAOHibernateJPA;

	public FoodTruckDAO getFoodTruckDAOHibernateJPA() {
		return foodTruckDAOHibernateJPA;
	}

	public void setFoodTruckDAOHibernateJPA(FoodTruckDAO foodTruckDAOHibernateJPA) {
		this.foodTruckDAOHibernateJPA = foodTruckDAOHibernateJPA;
	}

}
