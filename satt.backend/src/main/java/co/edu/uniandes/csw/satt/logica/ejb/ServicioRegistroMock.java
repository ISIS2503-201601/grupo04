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
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioProcesamientoMockLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioRegistroMockLocal;
import java.util.Iterator;

/**
 *
 * @author ta.barbosa10
 */
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
    private IServicioProcesamientoMockLocal procesamiento;
    
   private ArrayList registrosSismos;
   
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioRegistroMock()
    {
        persistencia = new ServicioPersistenciaMock();
        procesamiento =  new ServicioProcesamientoMock();
        registrosSismos  = new ArrayList<RegistroSismo>();
   }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un registro al sistema
     * @param registro Nuevo registro
     */
 
    public void agregarRegistro(RegistroSensor pRegistro)
    {
        try
        {
            persistencia.create(pRegistro);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioRegistroMock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void agregarRegistroSismo(RegistroSismo pRegistro)
    {
        try
        {
            registrosSismos.add(pRegistro);
            procesamiento.procesarRegistro(pRegistro);
            persistencia.create(pRegistro);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioRegistroMock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Se elimina un registro de sismo del sistema dado su identificador único
     * @param id Identificador único del registro
     */
    public void eliminarResgistro(long nId)
    {
       RegistroSensor m=(RegistroSensor) persistencia.findById(RegistroSensor.class, nId);
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
     * Se elimina un registro de sismo del sistema dado su identificador único
     * @param id Identificador único del registro
     */
    public void eliminarRegistroSismo(long id)
    {
        RegistroSensor m = null;
        for (int i = 0; i < registrosSismos.size(); i++) 
        {
            m = (RegistroSensor) registrosSismos.get(i);
            if(m.getId()==id)
            {
                registrosSismos.remove(i);
            } 
        }
    }

    /**
     * Devuelve los registros de sismo del sistema
     * @return registros Arreglo con todos los registros del sistema
     */
    public List<RegistroSismo> darRegistrosSismo()
    {
        return registrosSismos;
    }
    
    /**
     * Devuelve los registros del sistema
     * @return registros Arreglo con todos los registros del sistema
     */
    public List<RegistroSensor> darRegistros()
    {
        return persistencia.findAll(RegistroSensor.class);
    }
    
    public List<RegistroSensor> darRegistrosPosibleTsunami()
    {
        List a = persistencia.findAll(RegistroSensor.class);
        List<RegistroSensor> b = new ArrayList<RegistroSensor>();
        Iterator<RegistroSensor> i = a.iterator();
        while(i.hasNext())
        {
            RegistroSensor actual = i.next();
            if(actual.getAltura() > 0)
                b.add(actual);
            
        }
        return b;
    }

    @Override
    public void eliminarRegistro(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    
    

}
