package com.shiatsu.bo.impl;

import java.util.List;

import com.shiatsu.bo.CantonBo;
import com.shiatsu.dao.CantonDao;
import com.shiatsu.domain.Canton;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class CantonBoImpl extends BusinessObjectHelper implements CantonBo {

	private CantonDao cantonDao;
	
	/**
	 * @param pCantonDao the pCantonDao to set
	 */
	public void setCantonDao(CantonDao CantonDao) {
		this.cantonDao = CantonDao;
	}

	@Override
	public void agregar(Canton Canton) throws BusinessErrorHelper {
		try{
			 if(!this.existe(Canton)){
				 this.cantonDao.agregar(Canton);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("CantonBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Canton Canton) throws BusinessErrorHelper {
		try{
			 if(this.cantonDao.existe(Canton)){
				 this.cantonDao.modificar(Canton);
	         }else{ 
	        	this.addError("CantonBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Canton Canton) throws BusinessErrorHelper {
		try{
			 if(this.cantonDao.existe(Canton)){
				 this.cantonDao.eliminar(Canton);
	         }else{ 
	        	this.addError("CantonBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Canton buscar(Canton Canton) { 
		return this.cantonDao.buscar(Canton);
	}

	@Override
	public boolean existe(Canton canton) {
		return this.cantonDao.existe(canton);
	}

	@Override
	public List<Canton> getCanton() {
		return this.cantonDao.getCanton();
	}

	@Override
	public List<Canton> getCanton(Canton canton) {
		return this.cantonDao.getCanton(canton);
	}

}
