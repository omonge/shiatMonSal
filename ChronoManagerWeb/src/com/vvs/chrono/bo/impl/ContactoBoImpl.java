/**
 * ContactoBoImpl.java
 */
package com.vvs.chrono.bo.impl;
import java.util.List;

import com.vvs.bussiness.BussinessError;
import com.vvs.bussiness.BussinessObject;
import com.vvs.chrono.bo.ContactoBo;
import com.vvs.chrono.dao.ContactoDao;
import com.vvs.chrono.domain.Contacto;
import com.vvs.chrono.web.bundles.Bundle;

/**Clase com.vvs.chrono.boImpl.ContactoBoImpl
 * Sistema:  ChronoManager 
 * Descripción: La clase<code>ContactoBoImpl.java</code> posee la implementación 
 * de lógica de negocios para el manejo de la clase
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010
 */
public class ContactoBoImpl extends BussinessObject implements ContactoBo {

	private ContactoDao contactoDao;
	
	/** @param contactoDao el contactoDao a establecer */
	public void setContactoDao(ContactoDao contactoDao) {
		this.contactoDao = contactoDao;
	}

	/** vea @see com.vvs.chrono.bo.ContactoBo#agregar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void agregar(Contacto contacto) throws BussinessError {
		try{
			this.contactoDao.agregar(contacto);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("contactoBo.agregar", Bundle.rcs.getString("contactoExiste"));
            this.throwBussinessError();
		}
	}

	/** vea @see com.vvs.chrono.bo.ContactoBo#eliminar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void eliminar(Contacto contacto) throws BussinessError {
		try{
			this.contactoDao.eliminar(contacto);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("contactoBo.eliminar", Bundle.rcs.getString("contactoNoExiste"));
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            this.throwBussinessError();
		}
	}

	/** vea @see com.vvs.chrono.bo.ContactoBo#existe(com.vvs.chrono.domain.Contacto)*/
	@Override
	public boolean existe(Contacto contacto) {
		return this.existe(contacto);
	}

	/** vea @see com.vvs.chrono.bo.ContactoBo#modificar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void modificar(Contacto contacto) throws BussinessError {
		try{
			 if(this.contactoDao.existe(contacto)){
				 this.contactoDao.modificar(contacto);
	         }else{ 
	        	this.addError("contactoBo.modificar", Bundle.rcs.getString("contactoNoExiste"));
	         }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
           this.throwBussinessError();
		}
		
	}
	/** vea @see com.vvs.chrono.bo.ContactoBo#buscar(java.lang.String)*/
	@Override
	public Contacto buscar(Long codigo) {
		return this.contactoDao.buscar(codigo);
	}

	@Override
	public List<Contacto> getContactos() {
		return this.contactoDao.getContactos();
	}

	@Override
	public List<Contacto> getContactosDescripcion(String apellido) {
		return this.contactoDao.getContactosDescripcion(apellido);
	}

}
