package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;

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

	private String 	pvStDireccion;//DIRECCION
	private Integer pvInEstado;//ESTADO
	private String 	pvStEmail1;//EMAIL1
	private String 	pvStEmail2;//EMAIL2
	private String  pvStFacturaNombre;
	private	Integer pvStFrecuenciaCita;
	private String  pvStLugarProfesion;
	private Date	pvDaNacimiento;
	private Integer pvInNacionalidad;
	private String 	pvStNombre;//NOMBRE
	private Integer pvInProfesion;
	private Integer pvInSexo;
	private Long 	pvLoTelefonoCasa;//TELEFONO1
	private Long 	pvLoTelefonoCelular;//TELEFONO2
	private	Integer pvInTipoAlopecia;

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
	/**
	 * @return the pvLoCodigo
	 */
	public Long getPvLoCodigo() {
		return pvLoCodigo;
	}
	/**
	 * @param pvLoCodigo the pvLoCodigo to set
	 */
	public void setPvLoCodigo(Long pvLoCodigo) {
		this.pvLoCodigo = pvLoCodigo;
	}
	/**
	 * @return the pvStDireccion
	 */
	public String getPvStDireccion() {
		return pvStDireccion;
	}
	/**
	 * @param pvStDireccion the pvStDireccion to set
	 */
	public void setPvStDireccion(String pvStDireccion) {
		this.pvStDireccion = pvStDireccion;
	}
	/**
	 * @return the pvInEstado
	 */
	public Integer getPvInEstado() {
		return pvInEstado;
	}
	/**
	 * @param pvInEstado the pvInEstado to set
	 */
	public void setPvInEstado(Integer pvInEstado) {
		this.pvInEstado = pvInEstado;
	}
	/**
	 * @return the pvStEmail1
	 */
	public String getPvStEmail1() {
		return pvStEmail1;
	}
	/**
	 * @param pvStEmail1 the pvStEmail1 to set
	 */
	public void setPvStEmail1(String pvStEmail1) {
		this.pvStEmail1 = pvStEmail1;
	}
	/**
	 * @return the pvStEmail2
	 */
	public String getPvStEmail2() {
		return pvStEmail2;
	}
	/**
	 * @param pvStEmail2 the pvStEmail2 to set
	 */
	public void setPvStEmail2(String pvStEmail2) {
		this.pvStEmail2 = pvStEmail2;
	}
	/**
	 * @return the pvStFacturaNombre
	 */
	public String getPvStFacturaNombre() {
		return pvStFacturaNombre;
	}
	/**
	 * @param pvStFacturaNombre the pvStFacturaNombre to set
	 */
	public void setPvStFacturaNombre(String pvStFacturaNombre) {
		this.pvStFacturaNombre = pvStFacturaNombre;
	}
	/**
	 * @return the pvStFrecuenciaCita
	 */
	public Integer getPvStFrecuenciaCita() {
		return pvStFrecuenciaCita;
	}
	/**
	 * @param pvStFrecuenciaCita the pvStFrecuenciaCita to set
	 */
	public void setPvStFrecuenciaCita(Integer pvStFrecuenciaCita) {
		this.pvStFrecuenciaCita = pvStFrecuenciaCita;
	}
	/**
	 * @return the pvStLugarProfesion
	 */
	public String getPvStLugarProfesion() {
		return pvStLugarProfesion;
	}
	/**
	 * @param pvStLugarProfesion the pvStLugarProfesion to set
	 */
	public void setPvStLugarProfesion(String pvStLugarProfesion) {
		this.pvStLugarProfesion = pvStLugarProfesion;
	}
	/**
	 * @return the pvDaNacimiento
	 */
	public Date getPvDaNacimiento() {
		return pvDaNacimiento;
	}
	/**
	 * @param pvDaNacimiento the pvDaNacimiento to set
	 */
	public void setPvDaNacimiento(Date pvDaNacimiento) {
		this.pvDaNacimiento = pvDaNacimiento;
	}
	/**
	 * @return the pvInNacionalidad
	 */
	public Integer getPvInNacionalidad() {
		return pvInNacionalidad;
	}
	/**
	 * @param pvInNacionalidad the pvInNacionalidad to set
	 */
	public void setPvInNacionalidad(Integer pvInNacionalidad) {
		this.pvInNacionalidad = pvInNacionalidad;
	}
	/**
	 * @return the pvStNombre
	 */
	public String getPvStNombre() {
		return pvStNombre;
	}
	/**
	 * @param pvStNombre the pvStNombre to set
	 */
	public void setPvStNombre(String pvStNombre) {
		this.pvStNombre = pvStNombre;
	}
	/**
	 * @return the pvInProfesion
	 */
	public Integer getPvInProfesion() {
		return pvInProfesion;
	}
	/**
	 * @param pvInProfesion the pvInProfesion to set
	 */
	public void setPvInProfesion(Integer pvInProfesion) {
		this.pvInProfesion = pvInProfesion;
	}
	/**
	 * @return the pvInSexo
	 */
	public Integer getPvInSexo() {
		return pvInSexo;
	}
	/**
	 * @param pvInSexo the pvInSexo to set
	 */
	public void setPvInSexo(Integer pvInSexo) {
		this.pvInSexo = pvInSexo;
	}
	/**
	 * @return the pvLoTelefonoCasa
	 */
	public Long getPvLoTelefonoCasa() {
		return pvLoTelefonoCasa;
	}
	/**
	 * @param pvLoTelefonoCasa the pvLoTelefonoCasa to set
	 */
	public void setPvLoTelefonoCasa(Long pvLoTelefonoCasa) {
		this.pvLoTelefonoCasa = pvLoTelefonoCasa;
	}
	/**
	 * @return the pvLoTelefonoCelular
	 */
	public Long getPvLoTelefonoCelular() {
		return pvLoTelefonoCelular;
	}
	/**
	 * @param pvLoTelefonoCelular the pvLoTelefonoCelular to set
	 */
	public void setPvLoTelefonoCelular(Long pvLoTelefonoCelular) {
		this.pvLoTelefonoCelular = pvLoTelefonoCelular;
	}
	/**
	 * @return the pvInTipoAlopecia
	 */
	public Integer getPvInTipoAlopecia() {
		return pvInTipoAlopecia;
	}
	/**
	 * @param pvInTipoAlopecia the pvInTipoAlopecia to set
	 */
	public void setPvInTipoAlopecia(Integer pvInTipoAlopecia) {
		this.pvInTipoAlopecia = pvInTipoAlopecia;
	}

	
}
