package co.edu.LaTiendaGenerica.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import co.edu.LaTiendaGenerica.model.*;
import co.edu.LaTiendaGenerica.repository.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("productos")
public class ProductosController {
	@Autowired
	ProductosRepository productosRepository;
	
	@PostMapping("/subirArchivoCSV")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		try {			
			List<Productos> misProductos =  new ArrayList<Productos>();
		      List<String[]> datos = ConvertidorCSV.convertir(file.getInputStream());//convierte el archivo a csv  
		      Productos p;
		      for(String[] s: datos) {
		    	  StringTokenizer token = new StringTokenizer(s[0], ";");//separa archivo por punto y coma
                  String[] datosProductos =  new String[6];
                  int i = 0;
                  while(token.hasMoreTokens()){// mientras mas registros
                	  String resultado=token.nextToken();// obtiene los datos del csv
                	  if (resultado != null) {
                		  datosProductos[i] = resultado;
                	  }else {
                		  throw new RuntimeException("Error datos leidos invalidos"); 
                	  }
                		
                	  i++;
                  }
		    	   
                  p =  new Productos(Long.parseLong(datosProductos[0]),Double.parseDouble(datosProductos[1]),Long.parseLong(datosProductos[2]) ,(datosProductos[3]) ,Double.parseDouble(datosProductos[4]),Double.parseDouble(datosProductos[5]));
                  misProductos.add(p);
		      }
		
				productosRepository.deleteAll();
			    for(Productos prod:misProductos) {
			    	
			    	boolean opcion = productosRepository.save(prod) != null;
			    	
			    	  if(opcion) { 
			    		  model.addAttribute("cargaArchivo", "Productos Guardados");
			    	  }else {
			    		  model.addAttribute("errorCargaArchivo", "No se puedo guardar el producto");
			    	  }
			      }
		    } catch (Exception e) {
		      throw new RuntimeException("Error Fatal" + e.getMessage()); 
		    } 
	   	   
	   	    return "Archivos subido exitosamente";
	}
}



