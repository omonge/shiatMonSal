/**
 * ContactoBo.java
 */
package com.vvs.chrono.bo;

import java.util.List;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.domain.Contacto;

/**Interfaz com.vvs.chrono.bo.ContactoBo
 * Sistema:  ChronoManager 
 * Descripción: La Interfaz<code>ContactoBo.java</code>Define los métodos de 
 * lógica de negocios relacionados a un Contacto
 * @author omonge@vistaverde.com
 * Creada el 07/01/2010 
 */
public interface ContactoBo {
	/**
	 * Metodo que agrega un registro en la tabla de Contacto
	 * @param ajuste
	 */
	public void agregar(Contacto contacto) throws BussinessError;
	
	/**
	 * Metodo que modifica un registro en la tabla de Contacto
	 * @param contacto
	 */
	public void modificar(Contacto contacto)throws BussinessError;
	
	/**
	 * Metodo que elimina un registro en la tabla de Contacto
	 * @param contacto
	 */
	public void eliminar(Contacto contacto)throws BussinessError;
	
	/**
     * Busca una Contacto por su código
     * @param codigo
     * @return El ajuste correspondiente
     */
    public Contacto buscar(Long codigo);
    
    /**Metodo existe
    * Permite verificar la existencia de un Contacto en la base de datos
    *@param contacto
    *@return true si el contacto existe, false en caso contrario
    */
    public boolean existe(Contacto contacto);
    
    /**Metodo getContactos
    * Devuelve los contactos existentes en la base de datos
    *@return Lista de Contactos, lista vacía en caso contrario.
    */
    public List<Contacto>getContactos();

	/**Metodo getContactosDescripcion
	* Devuelve los contactos cuya descripción coincida con los datos dados
	*@param apellido
	*@return Lista de Contactos, lista vacia en caso contrario
	*/
	public List<Contacto> getContactosDescripcion(String apellido);
	
}
