/**
 * ClienteBo.java
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Cliente;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;


/**
 * @author oscar.monge
 *
 */
public interface ClienteBo {
	/**
	 * Metodo que agrega un registro en la tabla de Cliente
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Cliente cliente) throws BusinessErrorHelper;// throws BussinessError;
	
	/**
	 * Metodo que modifica un registro en la tabla de Cliente
	 * @param cliente
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Cliente cliente) throws BusinessErrorHelper;//throws BussinessError;
	
	/**
	 * Metodo que elimina un registro en la tabla de Cliente
	 * @param cliente
	 */
	public void eliminar(Cliente cliente) throws BusinessErrorHelper;
	
	/**
     * Busca una Cliente por su código
     * @param codigo
     * @return El ajuste correspondiente
     */
    public Cliente buscar(Long codigo);
    
    /**Metodo existe
    * Permite verificar la existencia de un Cliente en la base de datos
    *@param cliente
    *@return true si el cliente existe, false en caso contrario
    */
    public boolean existe(Cliente cliente);
    
    /**Metodo getClientes
    * Devuelve los clientes existentes en la base de datos
    *@return Lista de Clientes, lista vacía en caso contrario.
    */
    public List<Cliente>getClientes();

	/**Metodo getClientesDescripcion
	* Devuelve los clientes cuya descripción coincida con los datos dados
	*@param nombre
	*@return Lista de Clientes, lista vacia en caso contrario
	*/
	public List<Cliente> getClientesDescripcion(String nombre);
	
}
