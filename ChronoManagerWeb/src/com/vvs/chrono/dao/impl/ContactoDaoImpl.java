/**
 * ContactoDaoImpl.java
 */
package com.vvs.chrono.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.dao.ContactoDao;
import com.vvs.chrono.domain.Contacto;

/**Clase|Interfaz com.vvs.chrono.daoImpl.ContactoDaoImpl
 * Sistema:  ChronoManager 
 * Descripcion: TODO
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010 
 */
public class ContactoDaoImpl extends HibernateDaoSupport implements ContactoDao {
	/** vea @see com.vvs.chrono.dao.ContactoDao#agregar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void agregar(Contacto contacto) throws BussinessError {
		 HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(contacto);
	}

	/** vea @see com.vvs.chrono.dao.ContactoDao#buscar(java.lang.Long)*/
	@Override
	public Contacto buscar(Long codigo) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
		return (Contacto)hibernate.get(Contacto.class, codigo);
	}

	/** vea @see com.vvs.chrono.dao.ContactoDao#eliminar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void eliminar(Contacto contacto) throws BussinessError {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(contacto);
	}

	/** vea @see com.vvs.chrono.dao.ContactoDao#existe(com.vvs.chrono.domain.Contacto)*/
	@Override
	public boolean existe(Contacto contacto) {
		return this.buscar(contacto.getPvLoCodigo()) != null ? true : false;
	}

	/** vea @see com.vvs.chrono.dao.ContactoDao#modificar(com.vvs.chrono.domain.Contacto)*/
	@Override
	public void modificar(Contacto contacto) throws BussinessError {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(contacto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> getContactos() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Contacto contacto ORDER BY contacto.pvStNombre";
        List<Contacto> contactos = hibernate.find(hql);
        return contactos; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> getContactosDescripcion(String apellido) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Contacto contacto WHERE UPPER(contacto.pvStApellido) like ? ORDER BY contacto.pvStNombre";
        Object[] values = {apellido.toUpperCase() + "%"};
        List<Contacto> contactos = hibernate.find(hql,values);
        return contactos; 
	}


}
