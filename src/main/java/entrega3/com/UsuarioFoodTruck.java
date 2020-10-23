package entrega3.com;
import java.util.ArrayList;
public class UsuarioFoodTruck extends Usuario {
	public ArrayList<FoodTruck> foodTrucks;


	public UsuarioFoodTruck(String nombre, String apellido, String dni, String email, String telefono, String contrasenia, ArrayList<FoodTruck> foodTrucks) {
		super(nombre, apellido, dni, email, telefono, contrasenia);
		this.foodTrucks = foodTrucks;
	}
}
