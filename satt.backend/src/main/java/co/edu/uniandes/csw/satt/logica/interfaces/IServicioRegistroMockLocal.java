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


import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import java.util.List;
import javax.ejb.Local;


@Local
public interface IServicioRegistroMockLocal
{

    /**
     * Agrega un registro al sistema
     * @param registro Nuevo oferta
     */
    public void agregarRegistro(RegistroSismo registro);

    /**
     * Elimina un oferta del sistema
     * @param id Identificador único del oferta a eliminar
     */
    public void eliminarRegistro(long id);

    /**
     * Devuelve todos los registro del sistema
     * @return regsitro Lista de ofertas
     */
    public List<RegistroSensor> darRegistros();
    
    public List<RegistroSensor> darRegistrosPosibleTsunami();

}
