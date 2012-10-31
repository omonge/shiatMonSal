package com.shiatsu.domain;

import java.io.Serializable;

public class TipoAlopecia  implements Serializable{

	private static final long serialVersionUID = 4655663135297201540L;
	private Integer pvInCodigo;
	private String pvStDescripcion;
	
	public TipoAlopecia(){
		this.pvInCodigo = null;
		this.pvStDescripcion = null;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAlopecia other = (TipoAlopecia) obj;
		if (pvInCodigo == null) {
			if (other.pvInCodigo != null)
				return false;
		} else if (!pvInCodigo.equals(other.pvInCodigo))
			return false;
		return true;
	}
 
	
}
