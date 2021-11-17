package co.edu.LaTiendaGenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.LaTiendaGenerica.model.Productos;

public interface ProductosRepository extends MongoRepository<Productos, Long>{
	
}