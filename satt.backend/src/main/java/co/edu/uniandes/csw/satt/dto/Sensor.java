/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dto;

/**
 *
 * @author Alejandro
 */
public class Sensor {
    
    private long id;
    
    private long latitud;
    
    private long longitud;
    
    public Sensor(long pId, long pLat, long pLong)
    {
        id = pId;
        latitud = pLat;
        longitud = pLong;
               
                
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }
    
    
    
}
