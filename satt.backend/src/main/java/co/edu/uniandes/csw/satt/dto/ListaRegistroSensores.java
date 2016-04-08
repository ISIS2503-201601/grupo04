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
public class ListaRegistroSensores {
    
    private List<RegistroSensor> regSensores;
	
	
	public ListaRegistroSensores( List<RegistroSensor> reg){
		this.regSensores = reg;
	}

	/**
	 * 
	 */
	public List<RegistroSensor> getRegSensores() {
		return regSensores;
	}

	/**
	 * 
	 */
	public void setRegSensores(List<RegistroSensor> videos) {
		this.regSensores = videos;
	}
    
}
