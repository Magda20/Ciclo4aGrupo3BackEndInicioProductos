package co.edu.LaTiendaGenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class Administrador {
	
	@Id
	
	private String id;
	private String usuario;
	private String contrasena;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Administrador(String id, String usuario, String contrasena) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	
	
	
	

}
