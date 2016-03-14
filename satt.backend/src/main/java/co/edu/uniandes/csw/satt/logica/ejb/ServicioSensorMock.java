/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.logica.ejb;

import co.edu.uniandes.csw.satt.dto.Sensor;
import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioSensorMockLocal;
import javax.ejb.Stateless;
/**
 *
 * @author Alejandro
 */
@Stateless
public class ServicioSensorMock implements IServicioSensorMockLocal{
    
    private IServicioPersistenciaMockLocal persistencia;
    
    private ArrayList<Sensor> sensores;
    
    public ServicioSensorMock()
    {
      
        sensores = new ArrayList<Sensor>();
    }
    
    public void agregarSensor(Sensor s)
    {
        try
        {
            
            persistencia.create(s);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioRegistroMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Sensor> darSensores()
    {
        return persistencia.findAll(Sensor.class);
    }
    
}
