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
    private ArrayList registrosSensor;
    private ArrayList registrosSismos;
   
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

 
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
            registrosSensor.add(pRegistro);
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
            persistencia.create(pRegistro);
            
            procesamiento.procesarRegistro(pRegistro, persistencia);
            
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
    public void eliminarResgistro(String nId)
    {
       //RegistroSensor m=(RegistroSensor) persistencia.findById(RegistroSensor.class, nId);
        RegistroSensor m = null;
        
        for (int i = 0; i < registrosSismos.size(); i++) 
        {
            m = (RegistroSensor) registrosSismos.get(i);
            if(m.getId().equals(nId))
            {
                registrosSismos.remove(i);
            } 
        }
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
        RegistroSismo m = null;
        for (int i = 0; i < registrosSismos.size(); i++) 
        {
            m = (RegistroSismo) registrosSismos.get(i);
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
    
    

    @Override
    public void eliminarRegistro(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    
    

}
