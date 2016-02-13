/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioRegistroMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.satt.logica.ejb;

import co.edu.uniandes.csw.satt.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioRegistroMockLocal;

@Stateless
public class ServicioRegistroMock implements IServicioRegistroMockLocal
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioRegistroMock()
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los registros
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un registro al sistema
     * @param registro Nuevo registro
     */
 
    @Override
    public void agregarRegistro(RegistroSensor registro)
    {
        try
        {
            persistencia.create(registro);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioRegistroMock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Se elimina un registro del sistema dado su identificador único
     * @param id Identificador único del registro
     */
    @Override
    public void eliminarRegistro(long id)
    {
        RegistroSensor m=(RegistroSensor) persistencia.findById(RegistroSensor.class, id);
        try
        {
            persistencia.delete(m);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioRegistroMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Devuelve los registros del sistema
     * @return registros Arreglo con todos los registros del sistema
     */
    public List<RegistroSensor> darRegistros()
    {
        return persistencia.findAll(RegistroSensor.class);
    }

    


}
