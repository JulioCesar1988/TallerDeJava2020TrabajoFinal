package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import entidadesDTO.RequestUsuarioDTO;
import ttps.spring.interfacesDAO.UsuarioDAO;
import ttps.spring.model.Organizador;
import ttps.spring.model.Usuario;
import ttps.spring.model.UsuarioFoodTruck;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class UsuarioRestController {

	@Autowired
	private UsuarioDAO usuarioService;
		
	@PostMapping("/crearUsuario")
	public ResponseEntity<Usuario> crearUsuario(@RequestBody RequestUsuarioDTO usuarioDTO) {
		if (!usuarioDTO.getTipoUsuario().equals("ORG")) {
			usuarioService.persistir(new UsuarioFoodTruck(usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getDni(),usuarioDTO.getEmail(),usuarioDTO.getTelefono(),usuarioDTO.getContrasenia()));
			return new ResponseEntity<Usuario>(HttpStatus.CREATED);
		}else 
		{
			usuarioService.persistir(new Organizador(usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getDni(),usuarioDTO.getEmail(),usuarioDTO.getTelefono(),usuarioDTO.getContrasenia()));
			return new ResponseEntity<Usuario>(HttpStatus.CREATED);
		}
	}
	
	// CREATE
	@PostMapping("/crearUsuarioFood")
	@CrossOrigin
	public ResponseEntity<UsuarioFoodTruck> createUserFood(@RequestBody UsuarioFoodTruck usuarioFood) {

		System.out.println("Creando el usuario FoodTruck" + usuarioFood.getEmail());
		if (usuarioService.recuperarUsuarioPorEmail(usuarioFood.getEmail()) != null) {
			System.out.println("Ya existe un usuario con email " + usuarioFood.getEmail());
			return new ResponseEntity<UsuarioFoodTruck>(HttpStatus.CONFLICT); // C�digo de respuesta 409
		}
		usuarioService.persistir(usuarioFood);
		return new ResponseEntity<UsuarioFoodTruck>(HttpStatus.CREATED);
	}

	// Registraci�n de usuario Organizador 
		@PostMapping("/crearUsuarioOrg")
		public ResponseEntity<Organizador> createUserOrg(@RequestBody Organizador usuarioOrg) {

			System.out.println("Creando el usuario Organizador" + usuarioOrg.getEmail());
			if (usuarioService.recuperarUsuarioPorEmail(usuarioOrg.getEmail()) != null) {
				System.out.println("Ya existe un usuario con email " + usuarioOrg.getEmail());
				return new ResponseEntity<Organizador>(HttpStatus.CONFLICT); // C�digo de respuesta 409
			}
			usuarioService.persistir(usuarioOrg);
			return new ResponseEntity<Organizador>(HttpStatus.CREATED);
		}
		
		

	
//	@GetMapping("/{id}")
//	public ResponseEntity<Usuario> getUser(@PathVariable("id") long id) {
//
//		System.out.println("Obteniendo usuario con id " + id);
//		Usuario usuario = usuarioService.recuperar(id);
//		if (usuario == null) {
//			System.out.println("Usuario con id " + id + " no encontrado");
//			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
//	}
	
	

		// GET USER ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable("id") long id) {
   	 System.out.println("Obteniendo usuario con id " + id);
   	 Usuario usuario = usuarioService.recuperar(id);
   	 if (usuario == null) {
   		 System.out.println("Usuario con id " + id + " no encontrado");
   		 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
   	 }
   	 if (usuario instanceof UsuarioFoodTruck) {
   		 ((UsuarioFoodTruck) usuario).setFoodTrucks(null);
   	 }
   	 if (usuario instanceof Organizador) {
   		 ((Organizador) usuario).setEventos(null);
   	 }
   	 System.out.println("Usuario: " + id);
   	 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

	
	
	
	
	
	
	
	

	// UPDATE USER
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateUser(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		System.out.println("Actualizando el usuario " + id);
		Usuario currentUser = usuarioService.recuperar(id);
		if (currentUser == null) {
			System.out.println("Usuario con id " + id + " not found");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		currentUser.actualizar(usuario);
		usuarioService.actualizar(currentUser);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	// Login del sistema debe responder a los perfiles de usuarios definidos en su
	// prototipo  
	@PostMapping("/autenticar")
	public ResponseEntity<Usuario> autenticateUsuario(@RequestBody Usuario usuario) {
		Usuario user = usuarioService.autenticar(usuario.getEmail(), usuario.getContrasenia());
		if (user == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	// Recupero todos los usuarios
	@GetMapping("/todosusuarios")
    @CrossOrigin
	public ResponseEntity<List<Usuario>> listAllUsers() {

		List<Usuario> usuarios = usuarioService.recuperarTodos();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		for (Usuario u : usuarios) {
			if (u instanceof UsuarioFoodTruck) {
				((UsuarioFoodTruck) u).setFoodTrucks(null);
			}
			if (u instanceof Organizador) {
				((Organizador) u).setEventos(null);
			}
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteUser(@PathVariable("id") long id) {
		System.out.println("Obteniendo y eliminando el usuario con id " + id);
		Usuario usuario = usuarioService.recuperar(id);
		if (usuario == null) {
			System.out.println("No es posible eliminar, no se encuentra el usuario con id " + id);
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuarioService.borrar(id);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

}
