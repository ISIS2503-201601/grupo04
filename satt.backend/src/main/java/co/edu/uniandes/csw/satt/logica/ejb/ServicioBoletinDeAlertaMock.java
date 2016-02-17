/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioRegistroMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.satt.logica.ejb;

import co.edu.uniandes.csw.satt.dto.BoletinDeAlerta;
import co.edu.uniandes.csw.satt.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.satt.dto.RegistroSensor;
import co.edu.uniandes.csw.satt.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioBoletinDeAlertaMockLocal;
import co.edu.uniandes.csw.satt.logica.interfaces.IServicioPersistenciaMockLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;

/**
 * Implementacion de los servicios del catálogo de registros que se le prestan al sistema.
 * @author Juan Sebastián Urrego
 */
@Stateless
public class ServicioBoletinDeAlertaMock implements IServicioBoletinDeAlertaMockLocal
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioBoletinDeAlertaMock()
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los registros
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un registro al sistema
     * @param registro Nuevo registro
     */
 
    @Override
    public void agregarBoletinDeAlerta(BoletinDeAlerta boletin)
    {
        try
        {
            persistencia.create(boletin);
            enviarBoletin(boletin);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioBoletinDeAlertaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


    /**
     * Devuelve los registros del sistema
     * @return registros Arreglo con todos los registros del sistema
     */
    public List<BoletinDeAlerta> darBoletinesDeAlerta()
    {
        return persistencia.findAll(RegistroSensor.class);
    }
    
    public void enviarBoletin(BoletinDeAlerta boletin)
    {
        System.out.println("Enviando");
      // Recipient's email ID needs to be mentioned.
      String to = "f.cueto10@uniandes.edu.co";

      // Sender's email ID needs to be mentioned
      String from = "f.cueto10@uniandes.edu.co";

      // Assuming you are sending email from localhost
      String host = "localhost";
    
      Properties properties = System.getProperties();
      
      
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Boletin de Alerta #" + boletin.getId());

         // Now set the actual message
         message.setText(boletin.toString());

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
      
    }
    
    public void generarBoletin(long longitud, long latitud)
    {
        
    }

    


}
