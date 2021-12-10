package co.edu.LaTiendaGenerica.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.LaTiendaGenerica.model.Productos;
import co.edu.LaTiendaGenerica.repository.ProductosRepository;


@RestController
@RequestMapping ("productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductosApi {

	
	@Autowired
	private ProductosRepository productos;
	
	
	@PostMapping ("/crear")
	public void registrarProductos(@RequestBody Productos producto) {
		productos.save(producto);
	}
	@GetMapping ("/buscar/{codigo_producto}")
	public Optional<Productos> buscar (@PathVariable ("codigo_producto") long codigo_producto){
		return productos.findById(codigo_producto);
	}
	@GetMapping ("/listar")
	public ArrayList<Productos> listar(){
		return (ArrayList<Productos>) productos.findAll();
	}
	@DeleteMapping ("/eliminar/{codigo_producto}")
		public void eliminarProducto (@PathVariable ("codigo_producto") long codigo_producto) {
			productos.deleteById(codigo_producto);
		}
	@PutMapping ("/actualizar")
	public void actualizar (@RequestBody Productos producto) {
		productos.save(producto);	
	}
	
	
}
