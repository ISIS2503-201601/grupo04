/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.satt.servicios;

import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioBoletinDeAlertaMockLocal;
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
import javax.ws.rs.QueryParam;
 
@Path("/Boletin")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoletinDeAlertaService {
 
    /**
     * Referencia al Ejb del catalogo encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioBoletinDeAlertaMockLocal boletinesEjb;
   
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de registros de los alpes 
     * @return la lista JSON con los Registros de MDLA.
     */
    @GET
    @Path("boletines/")
    public List<BoletinDeAlerta> getTodosLosBoletines() {
        return boletinesEjb.darBoletinesDeAlerta();
 
    }
    
    /**
     * Servicio que recibe un objeto JSON con una registro que se desea agregar a la lista de registros.
     *
     * @param mb registro en formato JSON, que automáticamente se parsea a un objeto BoletinDeAlerta por el API REST.
     */
    @POST
    @Path("agregar/")
    public List<BoletinDeAlerta> agregarBoletines(List<BoletinDeAlerta> mb) {
        for (BoletinDeAlerta boletin : mb) {
            boletinesEjb.agregarBoletinDeAlerta(boletin);
        }
        
        return mb;
    }
    
    
     
    /**
     * Servicio que ofrece un JSON con el boletin buscado por id
     * @return el bojeto json apropiado
     */
    @GET
    @Path("boletin/")
    public BoletinDeAlerta getUnRegistro(@QueryParam("id") long id) {
        return boletinesEjb.getBoletinDeAlertaPorId(id);
    }
 
}
