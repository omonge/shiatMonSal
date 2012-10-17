/**
 * ClienteBo.java
 */
package com.vvs.chrono.bo;

import java.util.List;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.domain.Cliente;

/**Interfaz com.vvs.chrono.bo.ClienteBo
 * Sistema:  ChronoManager 
 * Descripción: La Interfaz<code>ClienteBo.java</code>Define los métodos de 
 * lógica de negocios relacionados a un Cliente
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010 18:47:22
 */
public interface ClienteBo {
	/**
	 * Metodo que agrega un registro en la tabla de Cliente
	 * @param ajuste
	 */
	public void agregar(Cliente cliente) throws BussinessError;
	
	/**
	 * Metodo que modifica un registro en la tabla de Cliente
	 * @param cliente
	 */
	public void modificar(Cliente cliente)throws BussinessError;
	
	/**
	 * Metodo que elimina un registro en la tabla de Cliente
	 * @param cliente
	 */
	public void eliminar(Cliente cliente)throws BussinessError;
	
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
