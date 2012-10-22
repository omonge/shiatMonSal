/**
 * 
 */
package com.shiatsu.domain;

import java.io.Serializable;

/**
 * @author oscar.monge
 *
 */
public class Cita implements Serializable {
	private static final long serialVersionUID = 7129844110408404138L;

	public static final Integer SEMANAL   	= new Integer(1);
	public static final Integer QUINCENAL 	= new Integer(2);
	public static final Integer MENSUAL 	= new Integer(3);
	
	public Cita() {
		// TODO Auto-generated constructor stub
	}

}
