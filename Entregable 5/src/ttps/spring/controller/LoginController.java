package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.interfacesDAO.UsuarioDAO;
import ttps.spring.model.Credentials;
import ttps.spring.model.UsernaneAndPassword;
import ttps.spring.model.Usuario;
import ttps.spring.service.TokenServices;

@RestController
public class LoginController {

	
	@Autowired
	private UsuarioDAO usuarioService;
		
		
	@Autowired
    private TokenServices tokenServices;
	
	// un dia
    private final int EXPIRATION_IN_SEC = 100;
    
    
    @PostMapping(path = "/auth")
	public ResponseEntity<?> authenticate(@RequestBody UsernaneAndPassword userpass) {
		System.out.print("informacion que viene del post : " + userpass.getUsername() + userpass.getPassword());
		// agregar un metodo para obtener el id de usuario
		
		if (isLoginSuccess(userpass.getUsername(), userpass.getPassword())) {
			
			
			// se lo agrego aca para poder usarlo en el controller 
			String token = tokenServices.generateToken(userpass.getUsername(), EXPIRATION_IN_SEC);
			System.out.print(" token : " + token);
			return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userpass.getUsername()));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
		}

	}
	
    private boolean isLoginSuccess(String email, String contrasenia) {
        // recupero el usuario de la base de usuarios
        Usuario u = usuarioService.autenticar(email, contrasenia);
        // chequeo que el usuario exista y el password sea correcto
        return (u != null && u.getContrasenia().equals(contrasenia));
    }
	

    
    
    
	
}
