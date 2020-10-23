package entrega3.com;

import java.util.ArrayList;

public class Reserva {

	public Evento evento;
	public ArrayList<Evento> reservasEventos;
	public ArrayList<FoodTruck> reservasFood;
	public String estado;


	public Reserva(Evento evento, ArrayList<Evento> reservasEventos, ArrayList<FoodTruck> reservasFood, String estado) {
		this.evento = evento;
		this.reservasEventos = reservasEventos;
		this.reservasFood = reservasFood;
		this.estado = estado;
	}


	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public ArrayList<Evento> getReservasEventos() {
		return reservasEventos;
	}

	public void setReservasEventos(ArrayList<Evento> reservasEventos) {
		this.reservasEventos = reservasEventos;
	}

	public ArrayList<FoodTruck> getReservasFood() {
		return reservasFood;
	}

	public void setReservasFood(ArrayList<FoodTruck> reservasFood) {
		this.reservasFood = reservasFood;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
