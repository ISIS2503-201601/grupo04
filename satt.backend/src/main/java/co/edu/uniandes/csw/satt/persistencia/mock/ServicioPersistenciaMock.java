/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.csw.satt.persistencia.mock;

import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import co.edu.uniandes.csw.satt.dto.Sensor;

import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockRemote;

import java.util.ArrayList;
import java.util.List;


public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Lista con los registros de ventas
     */
    private static ArrayList<RegistroSensor> registrosSensores;
    
    private static ArrayList<RegistroSismo> registrosSismo;
    
    private static ArrayList<Sensor> sensores;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock() {

        
        registrosSensores = new ArrayList<RegistroSensor>();
        registrosSensores.add(new RegistroSensor(0, 0, 0, 0));
        registrosSensores.add(new RegistroSensor(1, 1, 1, 1));
        registrosSensores.add(new RegistroSensor(2, 2, 2, 2));
        
        sensores = new ArrayList<Sensor>();
        sensores.add(new Sensor(0, 10, 10));
        sensores.add(new Sensor(1, 10, 10));
        sensores.add(new Sensor(2, 10, 10));
        
        registrosSismo = new ArrayList<RegistroSismo>();
        registrosSismo.add(new RegistroSismo(1, 5, 5));
        

    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     *
     * @param obj Objeto que representa la instancia de la entidad que se quiere
     * crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException {
        if (obj instanceof RegistroSensor) {

            RegistroSensor o = (RegistroSensor) obj;
            o.setId(registrosSensores.size() + 1);
            registrosSensores.add(o);
        }
        
        else if(obj instanceof RegistroSismo)
        {
            RegistroSismo a = (RegistroSismo) obj;
            a.setId(registrosSismo.size() + 1);
            registrosSismo.add(a);
        }
        
        else if(obj instanceof Sensor)
        {
            Sensor s = (Sensor)obj;
            s.setId(sensores.size() + 1);
            sensores.add(s);
        }
    }
    
    

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     *
     * @param obj Objeto que representa la instancia de la entidad que se quiere
     * modificar.
     */
    @Override
    public void update(Object obj) {
        /**
         * if (obj instanceof Mueble) { Mueble editar = (Mueble) obj; Mueble
         * mueble; for (int i = 0; i < muebles.size(); i++) { mueble =
         * muebles.get(i); if (mueble.getReferencia() == editar.getReferencia())
         * { muebles.set(i, editar); break; } } }
         */

    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     *
     * @param obj Objeto que representa la instancia de la entidad que se quiere
     * borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException {
        /**
         * if (obj instanceof Mueble) { Mueble mueble; Mueble eliminar =
         * (Mueble) obj; for (int i = 0; i < muebles.size(); i++) { mueble =
         * muebles.get(i); if (eliminar.getReferencia() ==
         * mueble.getReferencia()) { muebles.remove(i); break; }
         *
         * }
         *
         * }
         */
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se
     * encuentran en el sistema.
     *
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se
     * encuentran en el sistema.
     */
    @Override
    public List findAll(Class c) {
        if (c.equals(RegistroSensor.class)) {
            return registrosSensores;
        } else {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de
     * la entidadi.
     *
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id) {
        /**
         * if (c.equals(Mueble.class)) { for (Object v : findAll(c)) { Mueble
         * mue = (Mueble) v; if (Long.parseLong(id.toString()) ==
         * mue.getReferencia()) { return mue; } } } return null;
        *
         */
        return null;

    }
}
