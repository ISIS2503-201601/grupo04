/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.satt.dto;

import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ListaSensores {
    
    
	 
	private List<Sensor> sensores;
	
	
	public ListaSensores( List<Sensor> sensores){
		this.sensores = sensores;
	}

	/**
	 * 
	 */
	public List<Sensor> getSensores() {
		return sensores;
	}

	/**
	 * 
	 */
	public void setSensores(List<Sensor> videos) {
		this.sensores = videos;
	}
    
}
