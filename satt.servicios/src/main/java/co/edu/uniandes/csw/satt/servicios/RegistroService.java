/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.satt.servicios;

import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioRegistroMockLocal;
 
@Path("/Registro")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroService {
 
    /**
     * Referencia al Ejb del catalogo encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioRegistroMockLocal registroEjb;
    
    /**
     * Servicio que ofrece una lista JSON con el catálogo de registros de los alpes 
     * @return la lista JSON con los Registros de MDLA.
  
     */
    @GET
    @Path("registros/")
    public List<RegistroSensor> getTodasLasRegistros() {
        return registroEjb.darRegistros();
 
    }
    
    
    /**
     * Servicio que recibe un objeto JSON con una registro que se desea agregar a la lista de registros.
     *
     * @param mb registro en formato JSON, que automáticamente se parsea a un objeto Registro por el API REST.
     */
    @POST
    @Path("agregar/")

    public List<RegistroSensor> agregarRegistros(List<RegistroSensor> mb) {
        for (RegistroSensor registro : mb) {
            registroEjb.agregarRegistro(registro);
        }
        
        return mb;
    }
    
    
    @POST
    @Path("reportarSismo/")
    public List<RegistroSismo> agregarRegistrosSismo(List<RegistroSismo> mb) {
        for (RegistroSismo reg : mb) {
            System.out.println(reg.getId() + reg.getLatitud() + reg.getLongitud());
            registroEjb.agregarRegistroSismo(reg);
        }
        return mb;
    }
 
}
