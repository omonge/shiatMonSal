package com.vvs.chrono.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.vvs.chrono.web.bundles.Bundle;

public class Contacto implements Serializable{
	
	public static final Integer ACTIVO   = new Integer(1);
	public static final Integer INACTIVO = new Integer(0);
	
	public static final Integer CODIGO_LONGITUD     = new Integer(10);
	public static final Integer LONGITUD_COMENTARIO = new Integer(100);
	public static final Integer LONGITUD_DIRECCION  = new Integer(100);
	
	private static final long serialVersionUID = 7909545494328973522L;
	
	private Long 	pvLoCodigo;
	private Long    pvLoCliente;
	private Long    pvLoProyecto;
	private Integer pvInEstado;
	private String  pvStCargo;
	private String 	pvStNombre;
	private String  pvStApellido;
	private String 	pvStEmail1;
	private String 	pvStEmail2;
	private Long    pvLoTelefono1;
	private Long  	pvLoTelefono2;
	private Long  	pvLoFax;
	private String  pvStComentario;
	/**
	 * @return the pvLoCodigo
	 */
	public Long getPvLoCodigo() {
		return pvLoCodigo;
	}
	/** @param pvLoCodigo el pvLoCodigo a establecer */
	public void setPvLoCodigo(Long pvLoCodigo) {
		this.pvLoCodigo = pvLoCodigo;
	}
	/**
	 * @return the pvLoCliente
	 */
	public Long getPvLoCliente() {
		return pvLoCliente;
	}
	/** @param pvLoCliente el pvLoCliente a establecer */
	public void setPvLoCliente(Long pvLoCliente) {
		this.pvLoCliente = pvLoCliente;
	}
	/**
	 * @return the pvInEstado
	 */
	public Integer getPvInEstado() {
		return pvInEstado;
	}
	/** @param pvInEstado el pvInEstado a establecer */
	public void setPvInEstado(Integer pvInEstado) {
		this.pvInEstado = pvInEstado;
	}
	/**
	 * @return the pvStCargo
	 */
	public String getPvStCargo() {
		return pvStCargo;
	}
	/** @param pvStCargo el pvStCargo a establecer */
	public void setPvStCargo(String pvStCargo) {
		this.pvStCargo = pvStCargo;
	}
	/**
	 * @return the pvStNombre
	 */
	public String getPvStNombre() {
		return pvStNombre;
	}
	/** @param pvStNombre el pvStNombre a establecer */
	public void setPvStNombre(String pvStNombre) {
		this.pvStNombre = pvStNombre;
	}
	/**
	 * @return the pvStApellido
	 */
	public String getPvStApellido() {
		return pvStApellido;
	}
	/** @param pvStApellido el pvStApellido a establecer */
	public void setPvStApellido(String pvStApellido) {
		this.pvStApellido = pvStApellido;
	}
	/**
	 * @return the pvStEmail1
	 */
	public String getPvStEmail1() {
		return pvStEmail1;
	}
	/** @param pvStEmail1 el pvStEmail1 a establecer */
	public void setPvStEmail1(String pvStEmail1) {
		this.pvStEmail1 = pvStEmail1;
	}
	/**
	 * @return the pvStEmail2
	 */
	public String getPvStEmail2() {
		return pvStEmail2;
	}
	/** @param pvStEmail2 el pvStEmail2 a establecer */
	public void setPvStEmail2(String pvStEmail2) {
		this.pvStEmail2 = pvStEmail2;
	}
	/**
	 * @return the pvLoTelefono1
	 */
	public Long getPvLoTelefono1() {
		return pvLoTelefono1;
	}
	/** @param pvLoTelefono1 el pvLoTelefono1 a establecer */
	public void setPvLoTelefono1(Long pvLoTelefono1) {
		this.pvLoTelefono1 = pvLoTelefono1;
	}
	/**
	 * @return the pvLoTelefono2
	 */
	public Long getPvLoTelefono2() {
		return pvLoTelefono2;
	}
	/** @param pvLoTelefono2 el pvLoTelefono2 a establecer */
	public void setPvLoTelefono2(Long pvLoTelefono2) {
		this.pvLoTelefono2 = pvLoTelefono2;
	}
	/**
	 * @return the pvLoFax
	 */
	public Long getPvLoFax() {
		return pvLoFax;
	}
	/** @param pvLoFax el pvLoFax a establecer */
	public void setPvLoFax(Long pvLoFax) {
		this.pvLoFax = pvLoFax;
	}
	/**
	 * @return the pvStComentario
	 */
	public String getPvStComentario() {
		return pvStComentario;
	}
	/** @param pvStComentario el pvStComentario a establecer */
	public void setPvStComentario(String pvStComentario) {
		this.pvStComentario = pvStComentario;
	}
	/** @return regresa el pvStEstadoDescripcion*/
	public String getPvStEstadoDescripcion() {
		if(this.pvInEstado.equals(Cliente.ACTIVO)){
			return Bundle.rcs.getString("activo");
		}else{return Bundle.rcs.getString("inactivo");}
	}	
	/** @return regresa el pvLoProyecto*/
	public Long getPvLoProyecto() {
		return pvLoProyecto;
	}
	/** @param pvLoProyecto el pvLoProyecto a establecer */
	public void setPvLoProyecto(Long pvLoProyecto) {
		this.pvLoProyecto = pvLoProyecto;
	}
	/**
	 * Comment for equals
	 * @param obj
	 * @return resultado
	 */
	public boolean equals(Object obj) {
		boolean resultado;
		if (!(obj instanceof Contacto)) {
			resultado = false;
		} else {
			Contacto contacto = (Contacto) obj;
			resultado = new EqualsBuilder()
			.append(this.pvLoCodigo, contacto.getPvLoCodigo())
			.isEquals();	
		}	
		return resultado;
	}

	 /**
     * @see java.lang.Object#hashCode()
     * @return int
     */
    public int hashCode() {
        return new HashCodeBuilder()
        .append(this.pvLoCodigo)
        .toHashCode();
    }
}
