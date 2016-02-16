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

}
