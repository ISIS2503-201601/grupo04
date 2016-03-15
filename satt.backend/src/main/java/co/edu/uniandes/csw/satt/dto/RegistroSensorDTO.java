/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dto;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.nosql.annotations.Field;

/**
 *
 * @author as.murillo10
 */
public class RegistroSensorDTO {
    private long altura;

    private long velocidad;

    private String idSensor;
    
    public RegistroSensorDTO() 
    {

    }

    public long getAltura() {
        return altura;
    }

    public void setAltura(long altura) {
        this.altura = altura;
    }

    public long getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(long velocidad) {
        this.velocidad = velocidad;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

}