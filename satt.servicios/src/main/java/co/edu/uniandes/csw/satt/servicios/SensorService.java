/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.satt.servicios;


import co.edu.uniandes.csw.satt.dto.Sensor;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioSensorMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
@Path("/Sensor")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SensorService {
 
    /**
     * Referencia al Ejb del catalogo encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioSensorMockLocal registroEjb;
   
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de registros de los alpes 
     * @return la lista JSON con los Registros de MDLA.
  
     */
    @GET
    @Path("sensores/")
    public List<Sensor> getTodasLasRegistros() {
        return registroEjb.darSensores();
 
    }
    
    /**
     * Servicio que recibe un objeto JSON con una sensor que se desea agregar a la lista de registros.
     *
     * @param mb registro en formato JSON, que automáticamente se parsea a un objeto Sensor por el API REST.
     */
    @POST
    @Path("agregar/")

    public List<Sensor> agregarRegistros(List<Sensor> mb) {
        for (Sensor sensor : mb) {
            registroEjb.agregarSensor(sensor);
            
        }
        
        return mb;
    }
 
}
