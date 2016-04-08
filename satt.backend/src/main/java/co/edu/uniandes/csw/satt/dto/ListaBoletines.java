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
public class ListaBoletines {
        
    private List<BoletinDeAlerta> regBoletines;
	
	
	public ListaBoletines( List<BoletinDeAlerta> reg){
		this.regBoletines = reg;
	}

	/**
	 * 
	 */
	public List<BoletinDeAlerta> getBoletines() {
		return regBoletines;
	}

	/**
	 * 
	 */
	public void setBoletines(List<BoletinDeAlerta> videos) {
		this.regBoletines = videos;
	}
}
