/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.satt.servicios;

import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSensorDTO;
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
import co.edu.uniandes.csw.satt.persistencia.mock.PersistenceManager;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

 
@Path("/Registro")
@Produces(MediaType.APPLICATION_JSON)
public class RegistroServiceMongo {
 
    @PersistenceContext(unitName = "mongoPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    @GET
    @Path("registros/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        Query q = entityManager.createQuery("select u from Competitor u order by u.surname ASC");
        List<RegistroSensor> registrosSensores = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(registrosSensores).build();
    }
    
    
    /**
     * Servicio que recibe un objeto JSON con una registro que se desea agregar a la lista de registros.
     *
     * @param mb registro en formato JSON, que automáticamente se parsea a un objeto Registro por el API REST.
     */
         
    @POST
    @Path("agregarmongo/")
    @Produces(MediaType.APPLICATION_JSON)    
    public Response agregarRegistros(RegistroSensorDTO sensor) {
        RegistroSensor c = new RegistroSensor();
        JSONObject rta = new JSONObject();
        c.setAltura(sensor.getAltura());
        c.setVelocidad(sensor.getVelocidad());
        c.setIdSensor(sensor.getIdSensor());

       try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
            entityManager.refresh(c);
            rta.put("registroSensor_id", c.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            c = null;
        } finally {
        	entityManager.clear();
        	entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();

    }

      @OPTIONS
      public Response cors(@javax.ws.rs.core.Context HttpHeaders requestHeaders) {
        return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS").header("Access-Control-Allow-Headers", "AUTHORIZATION, content-type, accept").build();
      } 
    
    
    @POST
    @Path("reportarSismo/")
    public List<RegistroSismo> agregarRegistrosSismo(List<RegistroSismo> mb) {
        for (RegistroSismo reg : mb) {
            System.out.println(reg.getId() + reg.getLatitud() + reg.getLongitud());
            //registroEjb.agregarRegistroSismo(reg);
        }
        return mb;
    }
 
}
