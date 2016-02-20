/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.logica.ejb;

import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
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
    
    public void procesarRegistro (RegistroSismo r, IServicioPersistenciaMockLocal p)
    {
        registroSismo = r;
        persistencia = p;
        List<RegistroSensor> registrosSensores = persistencia.findAll(RegistroSensor.class);
        List<Sensor> sensores = persistencia.findAll(Sensor.class);
        Iterator<RegistroSensor> it1 = registrosSensores.iterator();
        Iterator<Sensor> it2 = sensores.iterator();
        boolean termino = false;
        long lat = new Long(0);
        long longi = new Long(0);
        long alt = new Long(0);
        long vel = new Long(0);
                
        while(it2.hasNext() && !termino)
        {
            
            Sensor sensorActual = it2.next();
            if((sensorActual.getLatitud() == registroSismo.getLatitud()) && (sensorActual.getLongitud() == registroSismo.getLongitud()))
            {
                while(it1.hasNext() && !termino)
                {
                    RegistroSensor registroActual = it1.next();
                    if(registroActual.getIdSensor() == sensorActual.getId() && registroActual.getAltura() == 10)
                    {
                        termino = true;
                        lat = sensorActual.getLatitud();
                        longi = sensorActual.getLongitud();
                        alt = registroActual.getAltura();
                        vel = registroActual.getVelocidad();
                    }
                }
            }
        }
        System.out.println("FUNCIONO, aca esta la info :" + lat+ longi +alt +vel);
        servicioBoletin = new ServicioBoletinDeAlertaMock();
        servicioBoletin.generarBoletin(lat, longi, alt, vel);
        servicioBoletin.enviarBoletin(new BoletinDeAlerta(1, "blabla", "mi casa", vel, alt));
    }
    
}
