package entrega3.com;

import java.util.ArrayList;

public class Reserva {
	
	public ArrayList<FoodTruck>  foodTrucks;
	public Evento evento;
	
	
	public ArrayList<FoodTruck> getFoodTruck() {
		return foodTrucks;
	}
	public void setFoodTruck(ArrayList<FoodTruck> foodTrucks) {
		this.foodTrucks = foodTrucks;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEventos(Evento evento) {
		this.evento = evento;
	}
	
	public void agregarFoodTruck(FoodTruck foodTruck) {
	  	this.foodTrucks.add(foodTruck);
	}
	
	
	
	

}
