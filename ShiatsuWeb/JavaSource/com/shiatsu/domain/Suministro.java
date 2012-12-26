/**
 * 
 */
package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author omonge
 *
 */
public class Suministro implements Serializable  {

	private static final long serialVersionUID = 7187844110408404568L;
	public static final Integer DEFAULT   = new Integer(0);
	public static final String ESTADO_DEFAULT	= new String("");
	public static final String ESTADO_ACTIVO   	= new String("A");
	public static final String ESTADO_INACTIVO 	= new String("I");
	public static final String ESTADO_ACTIVO_DESCRIPCION   	= new String("ACTIVO");
	public static final String ESTADO_INACTIVO_DESCRIPCION 	= new String("INACTIVO");
	
	private Usuario pvUsUsuario;
	private Date pvDafechaModificacion;
	private Integer pvInCodigo;
	private String pvStEstado;
	
	/**
	 * 
	 */
	public Suministro() {
		this.pvDafechaModificacion = new Date();
		this.pvUsUsuario = new Usuario(); 
	}
	/** @return regresa el pvStEstadoDescripcion*/
	public String getPvStEstadoDescripcion() { 
		if(Cliente.ESTADO_ACTIVO.equals(this.pvStEstado)){
			return ESTADO_ACTIVO_DESCRIPCION;
		}
		if(Cliente.ESTADO_INACTIVO.equals(this.pvStEstado)){ 
			return ESTADO_INACTIVO_DESCRIPCION;
		}
		return null;
	}	
	/**
	 * @return the pvStEstado
	 */
	public String getPvStEstado() {
		return pvStEstado;
	}
	/**
	 * @param pvStEstado the pvStEstado to set
	 */
	public void setPvStEstado(String pvStEstado) {
		this.pvStEstado = pvStEstado;
	}
	private String pvStDescripcion;
	
	
	/**
	 * @return the pvInCodigo
	 */
	public Integer getPvInCodigo() {
		return pvInCodigo;
	}
	/**
	 * @param pvInCodigo the pvInCodigo to set
	 */
	public void setPvInCodigo(Integer pvInCodigo) {
		this.pvInCodigo = pvInCodigo;
	}
	/**
	 * @return the pvStDescripcion
	 */
	public String getPvStDescripcion() {
		if(this.pvStDescripcion!=null){
			return this.pvStDescripcion.toUpperCase();
		}
		
		return pvStDescripcion;
	}
	/**
	 * @param pvStDescripcion the pvStDescripcion to set
	 */
	public void setPvStDescripcion(String pvStDescripcion) {
		this.pvStDescripcion = pvStDescripcion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pvInCodigo == null) ? 0 : pvInCodigo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Suministro)) {
			return false;
		}
		Suministro other = (Suministro) obj;
		if (pvInCodigo == null) {
			if (other.pvInCodigo != null) {
				return false;
			}
		} else if (!pvInCodigo.equals(other.pvInCodigo)) {
			return false;
		}
		return true;
	}
	/**
	 * @return the pvUsUsuario
	 */
	public Usuario getPvUsUsuario() {
		return pvUsUsuario;
	}
	/**
	 * @param pvUsUsuario the pvUsUsuario to set
	 */
	public void setPvUsUsuario(Usuario pvUsUsuario) {
		this.pvUsUsuario = pvUsUsuario;
	}
	/**
	 * @return the pvDafechaModificacion
	 */
	public Date getPvDafechaModificacion() {
		return pvDafechaModificacion;
	}
	/**
	 * @param pvDafechaModificacion the pvDafechaModificacion to set
	 */
	public void setPvDafechaModificacion(Date pvDafechaModificacion) {
		this.pvDafechaModificacion = pvDafechaModificacion;
	}
	

}
