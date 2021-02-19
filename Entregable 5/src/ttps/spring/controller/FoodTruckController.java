package ttps.spring.controller;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.interfacesDAO.FoodTruckDAO;
import ttps.spring.interfacesDAO.UsuarioDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.Organizador;
import ttps.spring.model.Usuario;
import ttps.spring.model.UsuarioFoodTruck;
import ttps.spring.service.FoodTruckService;
import ttps.spring.service.UsuarioService;

@RestController
@RequestMapping(value = "/foodtruck", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodTruckController {

	@Autowired
	private FoodTruckDAO foodTruckService;

	@Autowired
	private UsuarioDAO usuarioService;

    // CREATE	
	@PostMapping("/crearFood")
	public ResponseEntity<FoodTruck> createFood(@RequestBody FoodTruck foodTruck) {
		
		System.out.println("Creando el FoodTruck getNombre: " + foodTruck.getNombre());
		System.out.println("Creando el FoodTruck getDescripcion: " + foodTruck.getDescripcion());
		System.out.println("Creando el FoodTruck getZonas: " + foodTruck.getZonas());
		System.out.println("Creando el FoodTruck getServicios: " + foodTruck.getServicios());
		System.out.println("Creando el FoodTruck getUrl: " + foodTruck.getUrl());
		System.out.println("Creando el FoodTruck getWhatsApp: " + foodTruck.getWhatsApp());
		System.out.println("Creando el FoodTruck getTwitter: " + foodTruck.getTwitter());
		System.out.println("Creando el FoodTruck getInstagram: " + foodTruck.getInstagram());
		System.out.println("Creando el FoodTruck getPathImagenes: " + foodTruck.getPathImagenes());
		System.out.println("Creando el FoodTruck getUsuarioId: " + foodTruck.getUsuario().getUsuarioId() );
		
		
		if (foodTruckService.validarExistencia(foodTruck.getNombre()) != null) {
			System.out.println("Ya existe un foodTruck con ese nombre " + foodTruck.getNombre());
			return new ResponseEntity<FoodTruck>(HttpStatus.CONFLICT); // C�digo de respuesta 409
		}
		Usuario usuarioporID = usuarioService.recuperarUsuarioPorId(foodTruck.getUsuario().getUsuarioId()); 
		foodTruck.setUsuario(usuarioporID);
		foodTruckService.persistir(foodTruck);
		return new ResponseEntity<FoodTruck>(HttpStatus.CREATED);
	}

	
	// Recupero todos los un  usuarios  ESTE ES EL MIO
//	@GetMapping("/getfoodtruckId/{id}")
//	public ResponseEntity<List<FoodTruck>> getfoodtruckId(@PathVariable("id") long id) {
//		//List<FoodTruck> FoodTrucks = foodTruckService.recuperarTodos();
//		List<FoodTruck> FoodTrucks = foodTruckService.recuperarTodosFoodtruck(id);
//		return new ResponseEntity<List<FoodTruck>>(FoodTrucks, HttpStatus.OK);
//	}

	// Listado de todos los Food Trucks de un Food Trucker particular.
	    @GetMapping("/food/{id}")
	    public ResponseEntity<List<FoodTruck>> getFoodUser(@PathVariable("id") long id) {
	   	 List<FoodTruck> foodTrucks = foodTruckService.recuperarTodos();
	   	 List<FoodTruck> aux = new ArrayList<FoodTruck>();
	   	 System.out.println("Buscando foodTruck para el usuario " + id);
//	   	 if(foodTrucks == null) {
//	   		 System.out.println("No hay foodTrucks para este usuario");
//	   		 return new ResponseEntity<List<FoodTruck>>(HttpStatus.NOT_FOUND);
//	   	 }
	   	 for (FoodTruck foodTruck : foodTrucks) {
//	   		 foodTruck.setUsuario(null);
	   		 if (foodTruck.getUsuario().getUsuarioId() == id) {
	   			 foodTruck.setUsuario(null);
	   			 foodTruck.setReservas(null);
	   			 foodTruck.setValoracion(null);
	   			 foodTruck.setValoraciones(null);
	   			 aux.add(foodTruck);
	   		 }
	   	 }
	   	 System.out.println("Listado de FoodTrucks " + aux.size());
	   	 return new ResponseEntity<List<FoodTruck>>(aux, HttpStatus.OK);
	    }

	    
	    
		// GET USER ID
	    @GetMapping("/{id}")
	    public ResponseEntity<FoodTruck> getFood(@PathVariable("id") long id) {
	   	FoodTruck food = foodTruckService.recuperar(id);
	   	 if (food == null) {
	   		 return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
	   	 }
//	   	 if (usuario instanceof UsuarioFoodTruck) {
//	   		 ((UsuarioFoodTruck) usuario).setFoodTrucks(null);
//	   	 }
//	   	 if (usuario instanceof Organizador) {
//	   		 ((Organizador) usuario).setEventos(null);
//	   	 }
	   	 System.out.println("Usuario: " + id);
	   	 food.setUsuario(null);
	   	 food.setReservas(null);
	   	 food.setValoraciones(null);
	   	 return new ResponseEntity<FoodTruck>(food, HttpStatus.OK);
	    }
	

	    // Recupero todos los food
	    @GetMapping("/todosfood")

	    public ResponseEntity<List<FoodTruck>> listAllFoods() {
	   	 System.out.println("Obteniendo todos los food");
	   	 List<FoodTruck> foodTruck = foodTruckService.recuperarTodos();
	   	List<FoodTruck> foodTruck_aux = new ArrayList<FoodTruck>();
	   	
	   	 for (int i = 0; i < foodTruck.size(); i++) {
	   		 System.out.println(foodTruck.get(i).getNombre());
			foodTruck.get(i).setUsuario(null);
			foodTruck.get(i).setReservas(null);
			//foodTruck.get(i).setUsuario(null);
			FoodTruck fo = new FoodTruck();
			fo.setFoodTruckId(foodTruck.get(i).getFoodTruckId());
			fo.setNombre(foodTruck.get(i).getNombre());
            fo.setDescripcion(foodTruck.get(i).getDescripcion());
            fo.setUrl(foodTruck.get(i).getUrl());
            fo.setUsuario((foodTruck.get(i).getUsuario()));
          
			foodTruck_aux.add(fo);
		}
	
	   	 
	   	 if (foodTruck.isEmpty()) {
	   		 return new ResponseEntity<List<FoodTruck>>(HttpStatus.NO_CONTENT);
	   	 }
	   	 return new ResponseEntity<List<FoodTruck>>(foodTruck_aux, HttpStatus.OK);
	    }
	

	    
	    
	    

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<FoodTruck> updateFood(@PathVariable("id") long id, @RequestBody FoodTruck foodTruck) {
		System.out.println("Actualizando el FoodTruck" + id);
		FoodTruck currentFood = foodTruckService.recuperar(id);
		if (currentFood == null) {
			System.out.println("FoodTruck con id " + id + " not found");
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		
		
		currentFood.actualizar(foodTruck);
		foodTruckService.actualizar(currentFood);
		return new ResponseEntity<FoodTruck>(currentFood, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTruck> deleteFood(@PathVariable("id") long id) {
		System.out.println("Obteniendo y eliminando el FoodTruck con id " + id);
		FoodTruck foodTruck = foodTruckService.recuperar(id);
		if (foodTruck == null) {
			System.out.println("No es posible eliminar, no se encuentra el FoodTruck con id " + id);
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		foodTruckService.borrar(id);
		

		return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
	}
	



}
