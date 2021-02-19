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
@RequestMapping(value = "/ejemplo", produces = MediaType.APPLICATION_JSON_VALUE)

public class EjemploController {
	
	
	
	
	
	
}
