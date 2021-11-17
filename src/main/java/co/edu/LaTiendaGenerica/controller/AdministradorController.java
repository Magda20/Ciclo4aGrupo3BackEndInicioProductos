package co.edu.LaTiendaGenerica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.LaTiendaGenerica.model.Administrador;
import co.edu.LaTiendaGenerica.repository.AdministradorRepository;




@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Administrador")
public class AdministradorController {
	
	@Autowired
	AdministradorRepository AdministradorRepository;
	
	  @PostMapping("/Usuarios")
	  public ResponseEntity<Administrador> createTutorial(@RequestBody Administrador administrador) {
		  try {
			    Administrador _administrador = AdministradorRepository.save(new Administrador(administrador.getId() ,administrador.getUsuario(),administrador.getContrasena()));
			    return new ResponseEntity<>(_administrador, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  } 

}
