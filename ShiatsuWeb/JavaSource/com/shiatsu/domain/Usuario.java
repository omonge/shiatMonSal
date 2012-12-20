/**
 * 
 */
package com.shiatsu.domain;

/**
 * @author omonge
 *
 */
public class Usuario {
	
	private Integer pvInCodigo;
	private String pvStDescripcion;
	
	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
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
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (pvInCodigo == null) {
			if (other.pvInCodigo != null) {
				return false;
			}
		} else if (!pvInCodigo.equals(other.pvInCodigo)) {
			return false;
		}
		return true;
	}
	

}
