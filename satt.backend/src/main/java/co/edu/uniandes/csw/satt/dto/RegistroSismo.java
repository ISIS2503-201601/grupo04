/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dto;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;

import java.util.ArrayList;
/**
 *
 * @author Alejandro
 */
public class RegistroSismo {
    
    private long id;
    private long latitud;
    private long longitud;
    
   
    public RegistroSismo (long pid, long pLatitud, long pLongitud)
    {
        latitud = pLatitud;
        longitud = pLongitud;
        id = pid;
    }

    public long getId() 
    {
        return id;
    }
    
    public void setId(long nId)
    {
        this.id = nId;
    }
        
    public long getLatitud() 
    {
        return latitud;
    }

    public void setLatitud(long latitud) 
    {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }
}
