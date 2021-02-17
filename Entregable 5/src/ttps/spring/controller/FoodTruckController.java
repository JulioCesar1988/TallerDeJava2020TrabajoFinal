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
		System.out.println("Creando el FoodTruck" + foodTruck.getNombre());
		if (foodTruckService.validarExistencia(foodTruck.getNombre()) != null) {
			System.out.println("Ya existe un foodTruck con ese nombre " + foodTruck.getNombre());
			return new ResponseEntity<FoodTruck>(HttpStatus.CONFLICT); // C�digo de respuesta 409
		}
		Usuario usuarioporID = usuarioService.recuperarUsuarioPorId(foodTruck.getUsuario().getUsuarioId()); 
		foodTruck.setUsuario(usuarioporID);
		foodTruckService.persistir(foodTruck);
		return new ResponseEntity<FoodTruck>(HttpStatus.CREATED);
	}

	
	// Recupero todos los usuarios
	@GetMapping("/getfoodtruckId/{id}")
	public ResponseEntity<List<FoodTruck>> getfoodtruckId(@PathVariable("id") long id) {
		//List<FoodTruck> FoodTrucks = foodTruckService.recuperarTodos();
		List<FoodTruck> FoodTrucks = foodTruckService.recuperarTodosFoodtruck(id);
		return new ResponseEntity<List<FoodTruck>>(FoodTrucks, HttpStatus.OK);
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
