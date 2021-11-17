package co.edu.LaTiendaGenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.LaTiendaGenerica.model.Administrador;



public interface AdministradorRepository extends MongoRepository<Administrador, String> {

}
