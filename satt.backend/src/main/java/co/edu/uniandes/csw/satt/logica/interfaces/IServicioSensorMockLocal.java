/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.logica.interfaces;

import co.edu.uniandes.csw.satt.dto.Sensor;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Alejandro
 */
public interface IServicioSensorMockLocal {
    
    public void agregarSensor(Sensor s);
    
    
    public List<Sensor> darSensores();
    
    
}
