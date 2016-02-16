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
public class RegistroSismo {
    
    private long latitud;
    
    private long longitud;
    
    private String zona;
    
    public RegistroSismo (long pLatitud, long pLongitud, String pZona)
    {
        latitud = pLatitud;
        longitud = pLongitud;
        zona = pZona;
             
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    
    
}
