/**
 * ClienteDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ClienteDao;
import com.shiatsu.domain.Cliente;
import com.utilidades.business.BusinessErrorHelper;


public class ClienteDaoImpl extends HibernateDaoSupport implements ClienteDao {


	@Override
	public Cliente buscar(Long codigo) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
		return (Cliente)hibernate.get(Cliente.class, codigo);
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


	@Override
	public void agregar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(cliente);
	}


	@Override
	public void modificar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(cliente);
	}


	@Override
	public void eliminar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(cliente);
		
	}


	@Override
	public boolean existe(Cliente cliente) {
		return this.buscar(cliente.getPvLoCodigo()) != null ? true : false;
	}

}
