/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.csw.satt.dto;


public class RegistroSensor {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    private long id;

    private long altura;

    private long velocidad;

    private long idSensor;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public RegistroSensor() {

    }

    public RegistroSensor(long id, long altura, long velocidad, long idSensor) {
        this.id = id;
        this.altura = altura;
        this.velocidad = velocidad;
        this.idSensor = idSensor;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(long idSensor) {
        this.idSensor = idSensor;
    }

}
