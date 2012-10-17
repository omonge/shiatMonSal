/**
 * PopUpDetalleContacto.java
 */
package com.vvs.chrono.web.controller;

import com.vvs.chrono.domain.Contacto;
import com.vvs.jsf.AbstractFacesController;

/**Clase com.vvs.chrono.web.controller.PopUpDetalleContacto
 * Sistema:  ChronoManager 
 * Descripcion: TODO
 * @author omonge@vistaverde.com
 * Creada el 12/01/2010 
 */
public class PopUpDetalleContactoController extends AbstractFacesController {

	private Contacto contacto;
	
	/**Constructor de la clase PopUpDetalleContacto
	 */
	public PopUpDetalleContactoController() {
		this.contacto = new Contacto();
	}

	/** vea @see com.vvs.jsf.AbstractFacesController#getPropertyFieldName(java.lang.String)*/
	@Override
	protected String getPropertyFieldName(String property) {
		return null;
	}

	/** @return regresa el contacto*/
	public Contacto getContacto() {
		return contacto;
	}

	/** @param contacto el contacto a establecer */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}
