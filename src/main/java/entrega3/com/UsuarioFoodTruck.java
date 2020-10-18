package entrega3.com;

import java.util.ArrayList;

public class UsuarioFoodTruck extends Usuario {
   // bueno esta clase tiene los foodtruck y fotos .
	public ArrayList<FoodTruck> FoodTrucks;
	public ArrayList<String> galeria_fotos;
	
	
	
	public UsuarioFoodTruck(String nombre, String apellido, String dni, String email, String telefono,
			String contrasenia) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		// generamos la lista de foodTrucks .
	   this.FoodTrucks =  new ArrayList<FoodTruck>() ;	
		
	}

	public ArrayList<FoodTruck> getFoodTrucks() {
		return FoodTrucks;
	}

	public void setFoodTrucks(ArrayList<FoodTruck> foodTrucks) {
		FoodTrucks = foodTrucks;
	}
	
	
	public void agregarFoodTruck(FoodTruck foodTruck) {
		this.FoodTrucks.add(foodTruck);
	}


	
	
	
}
