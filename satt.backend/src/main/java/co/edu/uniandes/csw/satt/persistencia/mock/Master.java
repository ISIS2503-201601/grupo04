/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.persistencia.mock;

import co.edu.uniandes.csw.satt.dao.DAOTablaBoletinAlerta;
import co.edu.uniandes.csw.satt.dao.DAOTablaRegistroSensor;
import co.edu.uniandes.csw.satt.dao.DAOTablaRegistroSismico;
import co.edu.uniandes.csw.satt.dao.DAOTablaSensor;
import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import co.edu.uniandes.csw.satt.dto.ListaBoletines;
import co.edu.uniandes.csw.satt.dto.ListaRegistroSensores;
import co.edu.uniandes.csw.satt.dto.ListaSensores;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.dto.RegistroSismo;
import co.edu.uniandes.csw.satt.dto.Sensor;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



/**
 * Fachada en patron singleton de la aplicaciÃ³n
 * @author Juan
 */
public class Master {


	/**
	 * Atributo estÃ¡tico que contiene el path relativo del archivo que tiene los datos de la conexiÃ³n
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo estÃ¡tico que contiene el path absoluto del archivo que tiene los datos de la conexiÃ³n
	 */
	private  String connectionDataPath;

	/**
	 * Atributo que guarda el usuario que se va a usar para conectarse a la base de datos.
	 */
	private String user;

	/**
	 * Atributo que guarda la clave que se va a usar para conectarse a la base de datos.
	 */
	private String password;

	/**
	 * Atributo que guarda el URL que se va a usar para conectarse a la base de datos.
	 */
	private String url;

	/**
	 * Atributo que guarda el driver que se va a usar para conectarse a la base de datos.
	 */
	private String driver;
	
	/**
	 * ConexiÃ³n a la base de datos
	 */
	private Connection conn;


	/**
	 * 
	 */
	public Master(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/*
	 * MÃ©todo que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexiÃ³n a la base de datos.
	 */
	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MÃ©todo que  retorna la conexiÃ³n a la base de datos
	 * @return Connection - la conexiÃ³n a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexiÃ³n a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}
        
        public void agregarSensor(Sensor sensor) throws Exception {
		DAOTablaSensor daoSensor = new DAOTablaSensor();
		try 
		{
			
                        //////TransacciÃ³n
			this.conn = darConexion();
			daoSensor.setConn(conn);
                        conn.setAutoCommit(false);
			daoSensor.agregarSensor(sensor);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
                                
				daoSensor.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}}
		}
        
        public List<Sensor> darSensores()throws Exception
        {
            ArrayList<Sensor> sensores;
		DAOTablaSensor daoSensor = new DAOTablaSensor();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoSensor.setConn(conn);
                        conn.setAutoCommit(false);
			sensores = daoSensor.darSensores();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoSensor.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		ListaSensores l = new ListaSensores(sensores);
                return l.getSensores();
        }
        
        
        public void agregarRegistroSismico(RegistroSismo reg) throws Exception {
		DAOTablaRegistroSismico daoRegSismico = new DAOTablaRegistroSismico();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoRegSismico.setConn(conn);
                        conn.setAutoCommit(false);
			daoRegSismico.agregarRegistroSismico(reg);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRegSismico.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}}
		}
        
        
        public void agregarRegistroSensor(RegistroSensor reg) throws Exception {
		DAOTablaRegistroSensor daoRegSensor = new DAOTablaRegistroSensor();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoRegSensor.setConn(conn);
                        conn.setAutoCommit(false);
			daoRegSensor.agregarRegistroSensor(reg);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRegSensor.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}}
		}
        
        
        public List<RegistroSensor> darRegistrosSensores()throws Exception
        {
            ArrayList<RegistroSensor> reg;
		DAOTablaRegistroSensor daoRegSensor = new DAOTablaRegistroSensor();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoRegSensor.setConn(conn);
                        conn.setAutoCommit(false);
			reg = daoRegSensor.darRegistrosSensores();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRegSensor.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		ListaRegistroSensores l = new ListaRegistroSensores(reg);
                return l.getRegSensores();
        }
        
        
        public List<BoletinDeAlerta> darBoletines()throws Exception
        {
            ArrayList<BoletinDeAlerta> reg;
		DAOTablaBoletinAlerta daoBoletin = new DAOTablaBoletinAlerta();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoBoletin.setConn(conn);
                        conn.setAutoCommit(false);
			reg = daoBoletin.darBoletines();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoBoletin.cerrarRecursos();
				if(this.conn!=null)
                                {
                                    conn.setAutoCommit(false);
                                    this.conn.close();
                                }
					
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		          ListaBoletines l = new ListaBoletines(reg);
                return l.getBoletines();
        }
}
