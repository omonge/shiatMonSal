package com.shiatsu.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.shiatsu.web.bundles.Bundle;


public class Cliente implements Serializable {

	private static final long serialVersionUID = 4655663135297201540L;
	
	public static final Integer ACTIVO   = new Integer(1);
	public static final Integer INACTIVO = new Integer(0);
	
	public static final Integer CODIGO_LONGITUD     = new Integer(10);
	public static final Integer LONGITUD_COMENTARIO = new Integer(100);
	public static final Integer LONGITUD_DIRECCION  = new Integer(100);
	
	private Long 	pvLoCodigo;//CODIGO
	private Integer pvInEstado;//ESTADO
	private String 	pvStNombre;//NOMBRE
	private String 	pvStDireccion;//DIRECCION
	private String 	pvStEmail1;//EMAIL1
	private String 	pvStEmail2;//EMAIL2
	private Long 	pvLoFax;//FAX
	private Long 	pvLoTelefono1;//TELEFONO1
	private Long 	pvLoTelefono2;//TELEFONO2
	private String  pvStComentario;//COMENTARIO
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
	 * @return the pvStNombre
	 */
	public String getPvStNombre() {
		if(this.pvStNombre !=null){
			return this.pvStNombre.toUpperCase();
		}
		return pvStNombre;
	}

	/** @param pvStNombre el pvStNombre a establecer */
	public void setPvStNombre(String pvStNombre) {
		this.pvStNombre = pvStNombre;
	}

	/**
	 * @return the pvStDireccion
	 */
	public String getPvStDireccion() {
		if(this.pvStDireccion !=null){
			return this.pvStDireccion.toUpperCase();
		}
		return pvStDireccion;
	}

	/** @param pvStDireccion el pvStDireccion a establecer */
	public void setPvStDireccion(String pvStDireccion) {
		this.pvStDireccion = pvStDireccion;
	}

	/**
	 * @return the pvStEmail1
	 */
	public String getPvStEmail1() {
		if(this.pvStEmail1 !=null){
			return this.pvStEmail1.toUpperCase();
		}
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
		if(this.pvStEmail2 !=null){
			return this.pvStEmail2.toUpperCase();
		}
		return pvStEmail2;
	}

	/** @param pvStEmail2 el pvStEmail2 a establecer */
	public void setPvStEmail2(String pvStEmail2) {
		this.pvStEmail2 = pvStEmail2;
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
	 * @return the pvStComentario
	 */
	public String getPvStComentario() {
		if(this.pvStComentario !=null){
			return this.pvStComentario.toUpperCase();
		}
		return pvStComentario;
	}

	/** @param pvStComentario el pvStComentario a establecer */
	public void setPvStComentario(String pvStComentario) {
		this.pvStComentario = pvStComentario;
	}

	/**
	 * Comment for equals
	 * @param obj
	 * @return resultado
	 */
	public boolean equals(Object obj) {
		boolean resultado;
		if (!(obj instanceof Cliente)) {
			resultado = false;
		} else {
			Cliente cliente = (Cliente) obj;
			resultado = new EqualsBuilder()
			.append(this.pvLoCodigo, cliente.getPvLoCodigo())
			.isEquals();	
		}	
		return resultado;
	}
	/** @return regresa el pvStEstadoDescripcion*/
	public String getPvStEstadoDescripcion() {
		if(this.pvInEstado.equals(Cliente.ACTIVO)){
			return Bundle.rcs.getString("activo");
		}else{return Bundle.rcs.getString("inactivo");}
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
