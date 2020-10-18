package entrega3.com;

import java.sql.Date;
import java.util.ArrayList;

public class TestDeObjetos {

	public static void main(String[] args) {

		// Creamos el usuario organizador .
		Organizador usuario_organizador = new Organizador("Julio", "Contreras", "33831413",
				"julitoFest@tallerjava2020.com", "123345", "1234clave");

		// creamos un evento , un usuario organizador puede tener 0 o N eventos .
		Evento evento_julito_fest = new Evento("Julito Fest", "Florencio Varela", "1888", "Privado",
				"julitoFest@lalala.com", "Se recibio y hace joda", "Efectivo", "1234", new Date(2020, 10, 17),
				new Date(2020, 10, 17));
		Evento evento_caro_fest = new Evento("Carolina Fest", "Villa Tranquila", "1888", "Privado",
				"julitoFest@lalala.com", "Se recibio y hace joda", "Efectivo", "1234", new Date(2020, 10, 17),
				new Date(2020, 10, 17));
		Evento evento_yamila_fest = new Evento("Yamila Fest", "Chascomus", "1888", "Privado", "julitoFest@lalala.com",
				"Se recibio y hace joda", "Efectivo", "1234", new Date(2020, 10, 17), new Date(2020, 10, 17));

		// agregamos el evento al usuario organizador , para que que tenga guardado su
		// evento.
		usuario_organizador.agregarEvento(evento_julito_fest);
		usuario_organizador.agregarEvento(evento_yamila_fest);
		usuario_organizador.agregarEvento(evento_caro_fest);
		// verificamos si tenemos los eventos guardados .
		usuario_organizador.ver_mis_eventos();

		// vamos a crear el usuario usuarioFoodTruck .
		UsuarioFoodTruck usuarioFoodTruck = new UsuarioFoodTruck("pepe", "Gomez", "234234", "pepe@gomez.com", "234",
				"1234");

		// ahora este usuario , puede cargar FoodTrucks.
		ArrayList<String> zonas = new ArrayList<String>();
		zonas.add("La Plata");
		zonas.add("Quilmes");
		zonas.add("Florencio Varela");
		ArrayList<String> servicios = new ArrayList<String>();
		zonas.add("Pan rellenos");
		zonas.add("Birra");
		zonas.add("Jugos Naturales");
		FoodTruck foodtruck_pan_relleno = new FoodTruck("Pan Relleno", servicios, "Todo tipo de pan relleno",
				"panrelleno@unlp.com", "234", "twitte123", "instagram", "pathImagen", zonas, 0);

		usuarioFoodTruck.agregarFoodTruck(foodtruck_pan_relleno);

		// simulacion de la generacion de la reserva .
		Reserva reserva_julito_fest = new Reserva();
		reserva_julito_fest.setEventos(evento_julito_fest);
		reserva_julito_fest.agregarFoodTruck(foodtruck_pan_relleno);

		Reserva reserva_yamila_fest = new Reserva();
		reserva_yamila_fest.setEventos(evento_yamila_fest);
		reserva_yamila_fest.agregarFoodTruck(foodtruck_pan_relleno);

		Reserva reserva_caro_fest = new Reserva();
		reserva_caro_fest.setEventos(evento_caro_fest);
		reserva_caro_fest.agregarFoodTruck(foodtruck_pan_relleno);

	}

}
