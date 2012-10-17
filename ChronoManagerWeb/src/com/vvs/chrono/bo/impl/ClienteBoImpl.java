/**
 * ClienteBoImpl.java
 */
package com.vvs.chrono.bo.impl;
import java.util.List;

import com.vvs.bussiness.BussinessError;
import com.vvs.bussiness.BussinessObject;
import com.vvs.chrono.bo.ClienteBo;
import com.vvs.chrono.dao.ClienteDao;
import com.vvs.chrono.domain.Cliente;
import com.vvs.chrono.web.bundles.Bundle;

/**Clase com.vvs.chrono.boImpl.ClienteBoImpl
 * Sistema:  ChronoManager 
 * Descripción: La clase<code>ClienteBoImpl.java</code> posee la implementación 
 * de lógica de negocios para el manejo de la clase
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010
 */
public class ClienteBoImpl extends BussinessObject implements ClienteBo {

	private ClienteDao clienteDao;
	
	/** @param clienteDao el clienteDao a establecer */
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	/** vea @see com.vvs.chrono.bo.ClienteBo#agregar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void agregar(Cliente cliente) throws BussinessError {
		try{
			this.clienteDao.agregar(cliente);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.agregar", Bundle.rcs.getString("clienteExiste"));
            this.throwBussinessError();
		}
	}

	/** vea @see com.vvs.chrono.bo.ClienteBo#eliminar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void eliminar(Cliente cliente) throws BussinessError {
		try{
			this.clienteDao.eliminar(cliente);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.eliminar", Bundle.rcs.getString("clienteNoExiste"));
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            this.throwBussinessError();
		}
	}

	/** vea @see com.vvs.chrono.bo.ClienteBo#existe(com.vvs.chrono.domain.Cliente)*/
	@Override
	public boolean existe(Cliente cliente) {
		return this.existe(cliente);
	}

	/** vea @see com.vvs.chrono.bo.ClienteBo#modificar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void modificar(Cliente cliente) throws BussinessError {
		try{
			 if(this.clienteDao.existe(cliente)){
				 this.clienteDao.modificar(cliente);
	         }else{ 
	        	this.addError("clienteBo.modificar", Bundle.rcs.getString("clienteNoExiste"));
	         }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
           this.throwBussinessError();
		}
		
	}
	/** vea @see com.vvs.chrono.bo.ClienteBo#buscar(java.lang.String)*/
	@Override
	public Cliente buscar(Long codigo) {
		return this.clienteDao.buscar(codigo);
	}

	@Override
	public List<Cliente> getClientes() {
		return this.clienteDao.getClientes();
	}

	@Override
	public List<Cliente> getClientesDescripcion(String nombre) {
		return this.clienteDao.getClientesDescripcion(nombre);
	}

}
