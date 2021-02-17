package ttps.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttps.spring.interfacesDAO.*;
import ttps.spring.model.*;

public class TestGlobal {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// registra una o m�s componentes que ser�n procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
		// Busca clases anotadas en el paquete base pasado por par�metro
		ctx.scan("ttps.spring.clasesDAOimp");
		ctx.refresh();

		// creo usuarios food
		UsuarioFoodTruckDAO usuarioFTDAO1 = ctx.getBean("usuarioFoodTruckDAOHibernateJPA", UsuarioFoodTruckDAO.class);
		usuarioFTDAO1.persistir(new UsuarioFoodTruck("food", "33333", "sdfsdf", "julinchy@mail.com", "0303456", "123"));

		UsuarioFoodTruckDAO usuarioFTDAO2 = ctx.getBean("usuarioFoodTruckDAOHibernateJPA", UsuarioFoodTruckDAO.class);
		usuarioFTDAO2.persistir(new UsuarioFoodTruck("food2", "3423", "rtteert", "5seee@mail.com", "0777456", "123"));

		// recupero todos los usuarios food
		List<UsuarioFoodTruck> lista = usuarioFTDAO1.recuperarTodos();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(" Informacion de usuarios food:" + lista.get(i));
		}

		// creo usuario organizador
		OrganizadorDAO orgDAO = ctx.getBean("organizadorDAOHibernateJPA", OrganizadorDAO.class);
		orgDAO.persistir(new Organizador("organizador", "111111", "22222", "44444@mail.com", "0303456", "123"));

		// recupero todos los usuarios organizador
		List<Organizador> listaorg = orgDAO.recuperarTodos();
		for (int i = 0; i < listaorg.size(); i++) {
			System.out.println(" Informacion de usuarios org:" + listaorg.get(i));
		}

		// Actualizo usuario organizador
		Organizador o = orgDAO.recuperar(3L);
		o.setApellido("modificado");
		orgDAO.actualizar(o);
		System.out.print("actualizado:" + o.toString());

		// Elimino usuario food2
		UsuarioFoodTruck u = usuarioFTDAO2.recuperar(2L);
		usuarioFTDAO2.borrar(2L);
		System.out.println("borrado:" + u.toString());

		// recupero el email de todos los usuarios
		UsuarioDAO usuarioDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		List<Usuario> lista_usuario = usuarioDAO.recuperarTodos();
		for (int i = 0; i < lista_usuario.size(); i++) {
			System.out.println(" Informacion de usuarios :" + lista_usuario.get(i));
		}

		// creacion de un FoodTruck
		FoodTruckDAO foodDAO = ctx.getBean("foodTruckDAOHibernateJPA", FoodTruckDAO.class);
		ArrayList<String> imagenes_paths = new ArrayList<String>();
		imagenes_paths.add("/imagenes/imagen_1");
		imagenes_paths.add("/imagenes/imagen_2");
		imagenes_paths.add("/imagenes/imagen_3");
		ArrayList<String> servicios = new ArrayList<String>();
		servicios.add("Cerveza");
		servicios.add("Gaseosas");
		ArrayList<String> zonas = new ArrayList<String>();
		zonas.add("Florencio Varela");
		zonas.add("La Plata");
		zonas.add("Quilmes");
		foodDAO.persistir(new FoodTruck("PAPAS CON QUESO ", servicios, "PAPAS CON QUESO", "www.panchosLaPlata.com",
				"1234whasap", "twitter", "instagram", zonas, imagenes_paths, lista_usuario.get(0)));

		// creacion de evento .
		EventoDAO eventoDAO = ctx.getBean("eventoDAOHibernateJPA", EventoDAO.class);
		eventoDAO.persistir(new Evento("Julio Fest", "Florencio Varela", "6542", "Casamiento", "juli@lala.com",
				"se recibio", "efectivo", "321654", new Date(), new Date(), "Buenos Aires", new Double(12514),
				lista_usuario.get(0)));

//        eventoDAO.setCodigoPostal("1895");  
//        eventoDAO.setDescripcion("JULIO FEST");
//        eventoDAO.setUsuario(listaorg.get(1));

		// Alta de una reserva .
		ReservaDAO reservaDAO = ctx.getBean("reservaDAOHibernateJPA", ReservaDAO.class);

		// Recupero todos los foodTrucks
		List<FoodTruck> foodTrucks = foodDAO.recuperarTodos();
		for (FoodTruck foodTruck : foodTrucks) {
			System.out.println(" foodTruck : " + foodTruck.toString());
		}

		// Recupero todos los eventos
		List<Evento> eventos = eventoDAO.recuperarTodos();
		for (Evento evento2 : eventos) {
			System.out.println(" Evento : " + evento2.toString());
		}

		// como ya tenemos un evento y foodtruck vamos a generar una reserva
		Reserva reserva = new Reserva(eventos.get(0), foodTrucks.get(0), "nuevo");
		reservaDAO.persistir(reserva);

		// una vez que la reserva se toma por algun usuario foodtruck y el mismo despues
		// del evento cambia su estado a finalizado , el organizador puede dar un
		// puntaje.
		ValoracionDAO valDAO = ctx.getBean("valoracionDAOHibernateJPA", ValoracionDAO.class);
		Valoracion val = new Valoracion(3, 4, 6, 7, 3, 2, new Date(), foodTrucks.get(0), eventos.get(0));
		valDAO.persistir(val);
		// si verificas la base de datos ..todas las tablas existe datos + las
		// cadinalidades .
		
		ctx.close();
	}

}
