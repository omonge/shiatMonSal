/**
 * ClienteBoImpl.java
 */
package com.shiatsu.bo.impl;
import java.util.List;

import com.shiatsu.bo.ClienteBo;
import com.shiatsu.dao.ClienteDao;
import com.shiatsu.domain.Cliente;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;




/**
 * @author oscar.monge
 *
 */
public class ClienteBoImpl extends BusinessObjectHelper implements ClienteBo {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 5465939057749348216L;
	
	private ClienteDao clienteDao;
	
	/** @param clienteDao el clienteDao a establecer */
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public List<Cliente> getClientes() {
		return this.clienteDao.getClientes();
	}

	@Override
	public List<Cliente> getClientesDescripcion(String nombre) {
		return this.clienteDao.getClientesDescripcion(nombre);
	}

	@Override
	public void agregar(Cliente cliente) throws BusinessErrorHelper {
		try{
			 if(this.clienteDao.existe(cliente)){
				 this.clienteDao.agregar(cliente);
			 }else{
				 throw new Exception();
			 }
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.agregar", Bundle.rcs.getString("clienteExiste"));
            this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Cliente cliente) throws BusinessErrorHelper {
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

	@Override
	public void eliminar(Cliente cliente) throws BusinessErrorHelper {
		try{
			this.clienteDao.eliminar(cliente);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.eliminar", Bundle.rcs.getString("clienteNoExiste"));
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            this.throwBussinessError();
		}
		
	}

	@Override
	public boolean existe(Cliente cliente) {
		return this.clienteDao.existe(cliente);
	}

	@Override
	public Cliente buscar(Long codigo) {
		// TODO Auto-generated method stub
		return this.clienteDao.buscar(codigo);
	}

}
