/**
 * ClienteDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ClienteDao;
import com.shiatsu.domain.Cliente;
import com.utilidades.business.BusinessErrorHelper;


public class ClienteDaoImpl extends HibernateDaoSupport implements ClienteDao {


	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscar(Cliente cliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente WHERE UPPER(cliente.pvStCodigo) = ?";
        Object[] values = {cliente.getPvStCodigo().toUpperCase()};
        List<Cliente> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return null;
        }else{
        	return clientes.get(0);
        }
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
	public List<Cliente> getClientes(Cliente cliente) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Cliente> lista = new ArrayList<Cliente>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((cliente.getPvStCodigo() != null) && (!"".equals(cliente.getPvStCodigo())) ) {
            if(and){
                hql += "AND (cliente.pvStCodigo = ?) ";
            }else{
                hql += "cliente.pvStCodigon = ?) ";
            } 
            filtros.add(cliente.getPvStCodigo());
            and = true;
        }
        if((cliente.getPvDaNacimiento() != null) ){
            if(and){
                hql += "AND (cliente.pvDaNacimiento = ?) ";
            }else{
                hql += "(cliente.pvDaNacimiento = ?) ";
            }
            filtros.add(cliente.getPvDaNacimiento());
            and = true;
        }
        if((cliente.getPvInEstado() != null) && (!Cliente.ESTADO_DEFAULT.equals(cliente.getPvInEstado()))){
            if(and){
                hql += "AND (cliente.pvInEstado = ?) ";
            }else{
                hql += "(cliente.pvInEstado = ?) ";
            }
            filtros.add(cliente.getPvInEstado());
            and = true;
        }
        
        if((cliente.getPvInProfesion() != null) && (cliente.getPvInProfesion().intValue() > Cliente.PROFESION_DEFAULT.intValue()) ){
            if(and){
                hql += "AND (cliente.pvInProfesion = ?) ";
            }else{
                hql += "(cliente.pvInProfesion = ?) ";
            }
            filtros.add(cliente.getPvInProfesion());
            and = true;
        }
        
        if((cliente.getPvInSexo() != null) && (!Cliente.SEXO_DEFAULT.equals(cliente.getPvInSexo()))){
            if(and){
                hql += "AND (cliente.pvInSexo = ?) ";
            }else{
                hql += "(cliente.pvInSexo = ?) ";
            }
            filtros.add(cliente.getPvInSexo());
            and = true;
        }
        
        if((cliente.getPvInTipoAlopecia() != null) && (cliente.getPvInTipoAlopecia().intValue() > Cliente.ALOPECIA_DEFAULT.intValue())){
            if(and){
                hql += "AND (cliente.pvInTipoAlopecia = ?) ";
            }else{
                hql += "(cliente.pvInTipoAlopecia = ?) ";
            }
            filtros.add(cliente.getPvInTipoAlopecia());
            and = true;
        }
        
        if((cliente.getPvLoTelefonoCasa() != null)  && (cliente.getPvLoTelefonoCasa().longValue() > Cliente.TELEFONO_DEFAULT.longValue() )){
            if(and){
                hql += "AND (cliente.pvLoTelefonoCasa = ?) ";
            }else{
                hql += "(cliente.pvLoTelefonoCasa = ?) ";
            }
            filtros.add(cliente.getPvLoTelefonoCasa());
            and = true;
        }
        
        if((cliente.getPvLoTelefonoCelular() != null)  && (cliente.getPvLoTelefonoCelular().longValue() > Cliente.TELEFONO_DEFAULT.longValue())){
            if(and){
                hql += "AND (cliente.pvLoTelefonoCelular = ?) ";
            }else{
                hql += "(cliente.pvLoTelefonoCelular = ?) ";
            }
            filtros.add(cliente.getPvLoTelefonoCelular());
            and = true;
        }
        
        if((cliente.getPvStFacturaNombre() != null)  && (!"".equals(cliente.getPvStFacturaNombre())) ){
            if(and){
                hql += "AND (UPPER(TRIM(cliente.pvStFacturaNombre)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(cliente.pvStFacturaNombre)) = ?) ";
            }
            filtros.add(cliente.getPvStFacturaNombre());
            and = true;
        }
        
        
        if((cliente.getPvStNombre() != null) && (!"".equals(cliente.getPvStNombre())) ){
            if(and){
                hql += "AND (UPPER(TRIM(cliente.pvStNombre)) like ?) ";
            }else{
                hql += "(UPPER(TRIM(cliente.pvStNombre)) like ?) ";
            }
            filtros.add("%"+cliente.getPvStNombre()+"%");
            and = true;
        }
        
        if(and){
            hql += " ORDER BY cliente.nombre ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            }
            ht.setMaxResults(200);
            lista = ht.find(hql,values);
            ht.setMaxResults(0);
        }
        return lista;
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


	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Cliente cliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT cliente.pvStCodigo FROM Cliente cliente WHERE UPPER(cliente.pvStCodigo) = ?";
        Object[] values = {cliente.getPvStCodigo().toUpperCase()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

}
