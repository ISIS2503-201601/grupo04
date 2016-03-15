/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioCatalogoMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.satt.logica.interfaces;


import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import java.util.List;
import javax.ejb.Local;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 * @author Juan Sebastián Urrego
 */
@Local
public interface IServicioBoletinDeAlertaMockLocal
{

    /**
     * Agrega un registro al sistema
     * @param boletin Nuevo Boletin
     */
    public void agregarBoletinDeAlerta(BoletinDeAlerta begistro);

    /**
     * Devuelve todos los registro del sistema
     * @return Lista de boletines
     */
    public List<BoletinDeAlerta> darBoletinesDeAlerta();
    
    /**
     * Devuelve un boletin de alerta a partir de su id
     * @param id del boletin buscado
     * @return El boletin buscado, null si no existe
     */
    public BoletinDeAlerta getBoletinDeAlertaPorId(long id);    
    
    /**
     * Envia un correo de alerta a dgr
     */
    public void enviarBoletin(BoletinDeAlerta boletin);
    
    /**
     * Genera un nuevo boletin de alerta
     */
    public void generarBoletin(long longitud, long latitud, long altura, long velocidad);

}
