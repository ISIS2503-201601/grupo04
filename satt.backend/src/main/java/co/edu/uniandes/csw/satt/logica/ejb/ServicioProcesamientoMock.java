/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.logica.ejb;

import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import co.edu.uniandes.csw.satt.dto.Sensor;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioBoletinDeAlertaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioProcesamientoMockLocal;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Alejandro
 */
@Stateless
public class ServicioProcesamientoMock implements IServicioProcesamientoMockLocal{
    
    private IServicioPersistenciaMockLocal persistencia;
    
    private IServicioBoletinDeAlertaMockLocal servicioBoletin;
    
    private RegistroSismo registroSismo;
    
    public ServicioProcesamientoMock()
    {
        
       
    }
    
    public void procesarRegistro (RegistroSismo r)
    {
        registroSismo = r;
        
        List<RegistroSensor> registrosSensores = persistencia.findAll(RegistroSensor.class);
        List<Sensor> sensores = persistencia.findAll(Sensor.class);
        Iterator<RegistroSensor> it1 = registrosSensores.iterator();
        Iterator<Sensor> it2 = sensores.iterator();
        
        while(it1.hasNext())
        {
            //RegistroSensor registroActual = it1.next();
            //if(registroActual)
        }
        
        servicioBoletin = new ServicioBoletinDeAlertaMock();
        //servicioBoletin.agregarBoletinDeAlerta(begistro);
    }
    
}
