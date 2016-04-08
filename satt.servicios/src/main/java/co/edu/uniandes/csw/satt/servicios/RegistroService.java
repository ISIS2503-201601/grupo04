/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.satt.servicios;

import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.satt.persistencia.mock.Master;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
 
@Path("/Registro")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroService {
 
    /**
	 * Atributo que usa la anotaciÃ³n @Context para tener el ServletContext de la conexiÃ³n actual.
	 */
	@Context
	private ServletContext context;

	/**
	 * MÃ©todo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de registros de los alpes 
     * @return la lista JSON con los Registros de MDLA.
  
     */
    @GET
    @Path("registros/")
    public List<RegistroSensor> getTodasLasRegistros() {
        Master tm = new Master(getPath());
        
        try {
                return tm.darRegistrosSensores();
        } catch (Exception e) {
            return null;
        }
 
    }
    
    
    /**
     * Servicio que recibe un objeto JSON con una registro que se desea agregar a la lista de registros.
     *
     * @param mb registro en formato JSON, que automáticamente se parsea a un objeto Registro por el API REST.
     */
    @POST
    @Path("agregar/")

    public List<RegistroSensor> agregarRegistros(List<RegistroSensor> mb) {
        Master tm = new Master(getPath());
        
        for (RegistroSensor reg : mb) {
            
            try 
            {
                tm.agregarRegistroSensor(reg);
            } catch (Exception e) {
                System.out.println("co.edu.uniandes.csw.satt.servicios.RegistroService.agregarRegistrosSismo()");
            }
	}
        
        return mb;
    }
    
    
    @POST
    @Path("reportarSismo/")
    public List<RegistroSismo> agregarRegistrosSismo(List<RegistroSismo> mb) {
        Master tm = new Master(getPath());
        
        for (RegistroSismo reg : mb) {
            
            try 
            {
                tm.agregarRegistroSismico(reg);
            } catch (Exception e) {
                System.out.println("co.edu.uniandes.csw.satt.servicios.RegistroService.agregarRegistrosSismo()");
            }
	}
        
        return mb;
    }
 
}
