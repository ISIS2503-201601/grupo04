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

import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import co.edu.uniandes.csw.satt.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioBoletinDeAlertaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del catálogo de registros que se le prestan al sistema.
 * @author Juan Sebastián Urrego
 */
@Stateless
public class ServicioBoletinDeAlertaMock implements IServicioBoletinDeAlertaMockLocal
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
    public ServicioBoletinDeAlertaMock()
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
    public void agregarBoletinDeAlerta(BoletinDeAlerta boletin)
    {
        try
        {
            persistencia.create(boletin);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioBoletinDeAlertaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


    /**
     * Devuelve los registros del sistema
     * @return registros Arreglo con todos los registros del sistema
     */
    public List<BoletinDeAlerta> darBoletinesDeAlerta()
    {
        return persistencia.findAll(RegistroSensor.class);
    }

    


}
