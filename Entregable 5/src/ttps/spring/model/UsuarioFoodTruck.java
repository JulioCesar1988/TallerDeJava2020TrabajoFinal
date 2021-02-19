package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "USUARIOFOODTRUCK")
public class UsuarioFoodTruck extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fetch = FetchType.EAGER, mappedBy = "topic", cascade = CascadeType.ALL
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = CascadeType.ALL)
	@OneToMany( mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<FoodTruck> FoodTrucks;

	public UsuarioFoodTruck() {
	}

	public UsuarioFoodTruck(String nombre, String apellido, String dni, String email, String telefono,
			String contrasenia) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		// creacion de la lista de foodTruck
		FoodTrucks = new ArrayList<FoodTruck>();

	}

	public List<FoodTruck> getFoodTrucks() {
		return FoodTrucks;
	}

	public void setFoodTrucks(List<FoodTruck> foodTrucks) {
		FoodTrucks = foodTrucks;
	}

}
