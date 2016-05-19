/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dao;

import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class DAOTablaBoletinAlerta {
    
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
	public DAOTablaBoletinAlerta() {
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
        
        
        public ArrayList<BoletinDeAlerta> darBoletines() throws SQLException, Exception {
            ArrayList<BoletinDeAlerta> reg = new ArrayList<BoletinDeAlerta>();

            String sql = "SELECT * FROM AS_REGISTRO_SENSOR";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            recursos.add(prepStmt);
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                    long id = rs.getLong("ID");
                    String perfil = rs.getString("PERFIL");
                    String zona = rs.getString("ZONA_GEOGRAFICA");
                    long tiempoLlegada = rs.getLong("TIEMPO_LLEGADA");
                    long alturaOla = rs.getLong("ALTURA_OLA");
                    
                    reg.add(new BoletinDeAlerta(id, perfil, zona, tiempoLlegada, alturaOla));
            }
            return reg;
	}
    
}
