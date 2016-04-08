/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dao;

import co.edu.uniandes.csw.satt.dto.Sensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class DAOTablaSensor {
    
    /**
	 * Arraylits de recursos que se usan para la ejecuciÃ³n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexiÃ³n a la base de datos
	 */
	private Connection conn;

	/**
	 * MÃ©todo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaSensor() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * MÃ©todo que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * MÃ©todo que inicializa la connection del DAO a la base de datos con la conexiÃ³n que entra como parÃ¡metro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}
        
        public void agregarSensor(Sensor sensor)throws SQLException, Exception
        {
            String sql = "INSERT INTO AS_SENSOR (ID, LATITUD, LONGITID) VALUES (";
            sql += sensor.getId() + ",";
            sql += sensor.getLatitud() + ",";
            sql += sensor.getLongitud() + ")";
            
            System.out.println("SQL stmt:" + sql);

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            recursos.add(prepStmt);
            prepStmt.executeQuery();
        }
        
        public ArrayList<Sensor> darSensores() throws SQLException, Exception {
            ArrayList<Sensor> sensores = new ArrayList<Sensor>();

            String sql = "SELECT * FROM AS_SENSOR";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            recursos.add(prepStmt);
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                    long id = rs.getLong("ID");
                    long latitud = rs.getLong("LATITUD");
                    long longitud = rs.getLong("LONGITID");
                    
                    sensores.add(new Sensor(id, latitud, longitud));
            }
            return sensores;
	}
    
}
