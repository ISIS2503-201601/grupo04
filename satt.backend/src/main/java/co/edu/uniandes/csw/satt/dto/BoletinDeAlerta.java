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

/**
 * Clase que representa la información de un mueble en el sistema
 *
 * @author Juan Sebastián Urrego
 */
public class BoletinDeAlerta {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * id del reporte
     */
    private long id;

    /**
     * Perfil de riesgo
     */
    private String perfil;

    /**
     * Zona Geografica afectada
     */
    private String zonaGeografica;

    /**
     * Hora de llegada en formato militar
     */
    private long tiempoDeLlegada;
    
    /**
     * La altura de la ola en metros
     */
    private long alturaDeLaOla;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public BoletinDeAlerta() {

    }

    public BoletinDeAlerta(long id, String perfil, String zonaGeografica, long tiempoDeLlegada, long alturaDeLaOla) {
        this.id = id;
        this.perfil = perfil;
        this.zonaGeografica = zonaGeografica;
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.alturaDeLaOla = alturaDeLaOla;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public long getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(long tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
    }

    public long getAlturaDeLaOla() {
        return alturaDeLaOla;
    }

    public void setAlturaDeLaOla(long alturaDeLaOla) {
        this.alturaDeLaOla = alturaDeLaOla;
    }
    

}
