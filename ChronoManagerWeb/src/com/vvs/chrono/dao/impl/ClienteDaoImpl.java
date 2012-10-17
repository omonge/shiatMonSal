/**
 * ClienteDaoImpl.java
 */
package com.vvs.chrono.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.dao.ClienteDao;
import com.vvs.chrono.domain.Cliente;

/**Clase|Interfaz com.vvs.chrono.daoImpl.ClienteDaoImpl
 * Sistema:  ChronoManager 
 * Descripcion: TODO
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010 
 */
public class ClienteDaoImpl extends HibernateDaoSupport implements ClienteDao {

	/** vea @see com.vvs.chrono.dao.ClienteDao#agregar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void agregar(Cliente cliente) throws BussinessError {
		 HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(cliente);
	}

	/** vea @see com.vvs.chrono.dao.ClienteDao#buscar(java.lang.Long)*/
	@Override
	public Cliente buscar(Long codigo) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
		return (Cliente)hibernate.get(Cliente.class, codigo);
	}

	/** vea @see com.vvs.chrono.dao.ClienteDao#eliminar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void eliminar(Cliente cliente) throws BussinessError {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(cliente);
	}

	/** vea @see com.vvs.chrono.dao.ClienteDao#existe(com.vvs.chrono.domain.Cliente)*/
	@Override
	public boolean existe(Cliente cliente) {
		return this.buscar(cliente.getPvLoCodigo()) != null ? true : false;
	}

	/** vea @see com.vvs.chrono.dao.ClienteDao#modificar(com.vvs.chrono.domain.Cliente)*/
	@Override
	public void modificar(Cliente cliente) throws BussinessError {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getClientes() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente ORDER BY cliente.pvStNombre";
        List<Cliente> clientes = hibernate.find(hql);
        return clientes; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getClientesDescripcion(String nombre) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente WHERE UPPER(cliente.pvStNombre) like ? ORDER BY cliente.pvStNombre";
        Object[] values = {nombre.toUpperCase() + "%"};
        List<Cliente> clientes = hibernate.find(hql,values);
        return clientes; 
	}

}
