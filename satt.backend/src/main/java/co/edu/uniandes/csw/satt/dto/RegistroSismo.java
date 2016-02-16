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
    private ArrayList registros;
   
    public RegistroSismo (long pLatitud, long pLongitud, String pZona)
    {
        latitud = pLatitud;
        longitud = pLongitud;
        registros = new ArrayList<RegistroSensor>();
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

    public void agregarRegistro()
    {
        Procesamiento p =  new Procesamiento();
        RegistroSensor nuevo = new RegistroSensor();
        registros.add(nuevo);
        p.procesarRegistro(nuevo);
    }
    
    public void eliminarResgistro(long nId)
    {
        RegistroSensor m = null;
        for (int i = 0; i < registros.size(); i++) 
        {
            m = (RegistroSensor) registros.get(i);
            if(m.getId()==id)
            {
                registros.remove(i);
            } 
        }
    }
    
    public ArrayList darRegistros()
    {
        return registros;
    }
    
}
