package com.vvs.chrono.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.bo.ClienteBo;
import com.vvs.chrono.domain.Cliente;
import com.vvs.chrono.web.bundles.Bundle;
import com.vvs.jsf.AbstractFacesController;

public class ClienteController extends AbstractFacesController {
	
	/** Atributo <code>TUPLA de Cliente</code> */
	private Cliente 	  cliente;
    /** Atributo <code>agregar</code> */
    private Boolean 	  agregar;
    private String 		  criterioBusqueda;
    private HtmlDataTable dataTableClientes;
    private List<Cliente> clientes;
    
	private ClienteBo 	  clienteBo;
    
    
	/**Constructor de la clase ClienteController
	 * 
	 */
	public ClienteController() {
		this.reiniciarController();
		//this.buscarTodos();
	}
	
	/**Método reiniciarController
	* Reinicia los componentes del controller
	*/
	public void reiniciarController(){
		this.cliente=new Cliente();
		this.agregar=true;
		this.reiniciarFiltro();
	}
	/**Método reiniciarFiltro
	* Reinicia el filtro del controller
	*/
	private void reiniciarFiltro(){
		this.criterioBusqueda=null;
		this.dataTableClientes=new HtmlDataTable();
		this.clientes = new ArrayList<Cliente>();
	}
	/**
	 * @see com.vvs.jsf.AbstractFacesController#getPropertyFieldName(java.lang.String)
	 */
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("cliente.pvLoCodigo")) 		return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvLoFax"))    		return "form1:txtPvLoFax";
			if (property.equals("cliente.pvLoTelefono1")) 	return "form1:txtPvLoTelefono1";
			if (property.equals("cliente.pvLoTelefono2")) 	return "form1:txtPvLoTelefono2";
			if (property.equals("cliente.pvStComentario")) 	return "form1:txtPvStComentario";
			if (property.equals("cliente.pvStDireccion")) 	return "form1:txtPvStDireccion";
			if (property.equals("cliente.pvStEmail1")) 		return "form1:txtPvStEmail1";
			if (property.equals("cliente.pvStEmail2")) 		return "form1:txtPvStEmail2";
			if (property.equals("cliente.pvStNombre")) 		return "form1:txtPvStNombre";
			if (property.equals("clienteBo.eliminar")) 		return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.modificar")) 	return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.agregar")) 		return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvInEstado")) 	    return "form1:cmbPvInEstado";
			if (property.equals("cliente.buscar")) 	    	return "form1:txtBuscar";
		}
		return null;
	}    
	/**
     * Retorna una lista de selectItems que contienen estados del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.ACTIVO,    Bundle.rcs.getString("cliente.activo")));
		items.add(new SelectItem(Cliente.INACTIVO,  Bundle.rcs.getString("cliente.inactivo")));
		return items;
	}
	/*****************   BUSQUEDAS   ********************/
	
	
	/**Método buscarPorCodigo
	* Busca Cliente por su Código
	*@return success si logra encontrar Cliente, error en caso contrario
	*/
	public String buscarPorCodigo(){
		String correcto = "success";
		try{
		  this.clientes = new ArrayList<Cliente>();
		  if(this.validarBusquedaCodigo()){
		        Long codigoParseado = new Long(Long.parseLong(this.criterioBusqueda));
		        Cliente cliente = this.clienteBo.buscar(codigoParseado);
		        if(cliente != null) {
		        	this.clientes.add(cliente);
		            correcto =  "success";
		        }else{
		        	this.reiniciarController();
		            this.addError(null, Bundle.rcs.getString("noHayDatosCodigo"));
		            correcto = "error";
		        }
		  }
		}catch(Exception e){
			e.printStackTrace();
	        this.addError(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("error") + e.getMessage());//"Error: " + e.getMessage()
	        correcto = "error";
	    }
	    return correcto;
	}
	/**Método buscarPorDescripcion
	* Busca Cliente por su Nombre
	*@return success si logra encontrar Cliente, error en caso contrario
	*/
	public String buscarPorDescripcion(){
		String correcto = "success";
        try{
            this.clientes = new ArrayList<Cliente>();
            if(this.validarBusquedaDescripcion()){
               this.clientes = this.clienteBo.getClientesDescripcion(this.criterioBusqueda);
               if(this.clientes.isEmpty()){
		           this.reiniciarController();
                   this.addError(null, Bundle.rcs.getString("noHayDatosDescripcion"));
                   correcto= "error";
               }
            }
        }catch(Exception e){
        	e.printStackTrace();	       
        	correcto = "error";
            this.addError(this.getPropertyFieldName("cliente.buscar"),Bundle.rcs.getString("error") + e.getMessage());
        }
        return correcto;
	}

	/**Metodo buscarTodos
	* Búsca todos los clientes existentes
	*/
	public void buscarTodos(){
		this.clientes = this.clienteBo.getClientes();
        if(this.clientes.isEmpty()){
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));//"No hay registros"
        }
	}
	/**Método cargarObjeto
	* Carga el objeto seleccionado de la tabla de la página
	*@return success
	*/
	public String cargarObjeto(){
		 this.cliente = (Cliente) this.dataTableClientes.getRowData();
	     this.agregar = false;
		 return "success";
	}
	/**Método irAgregar
	* 
	*@return success
	*/
	public String irAgregar(){
		this.reiniciarController();
		return "success";
	}
	/**Método regresar
	* Regresa a la pantalla de listado
	*@return success
	*/
	public String regresar(){
		this.buscarTodos();
		return "success";
	}
	/**Metodo validarCliente
	* Valida los datos del cliente
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validarCliente(){
		boolean correcto = true;
		try{
			if((this.cliente.getPvLoFax() == null) || (this.cliente.getPvLoFax().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvLoFax"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(cliente.getPvLoFax().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("cliente.pvLoFax"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.cliente.getPvLoTelefono1() == null) ||(this.cliente.getPvLoTelefono1().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvLoTelefono1"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(cliente.getPvLoTelefono1().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("cliente.pvLoTelefono1"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.cliente.getPvLoTelefono2() == null) || (this.cliente.getPvLoTelefono2().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvLoTelefono2"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(cliente.getPvLoTelefono2().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("cliente.pvLoTelefono2"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if(this.cliente.getPvStComentario() != null){
				if(this.cliente.getPvStComentario().length() > Cliente.LONGITUD_COMENTARIO){
					this.addError(this.getPropertyFieldName("cliente.pvStComentario"),Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Cliente.LONGITUD_COMENTARIO.intValue()+ ")");
					correcto = false;
				}	
			}
			if((this.cliente.getPvStDireccion() == null) || (this.cliente.getPvStDireccion().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else{
				if(this.cliente.getPvStDireccion().length() > Cliente.LONGITUD_DIRECCION){
					this.addError(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Cliente.LONGITUD_DIRECCION.intValue()+ ")");
					correcto = false;
				}	
			}
			if((this.cliente.getPvStEmail1() == null) || (this.cliente.getPvStEmail1().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStEmail1"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvStEmail2() == null) || (this.cliente.getPvStEmail2().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStEmail2"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvStNombre() == null) || (this.cliente.getPvStNombre().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStNombre"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
		}catch(NumberFormatException nef){
            this.addError(null, Bundle.rcs.getString("soloNumeros"));
            nef.printStackTrace();
        }catch(Exception e){
        	this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            e.printStackTrace();
		}
		return correcto;
	}
	/**Metodo validarBusquedaCodigo
	* Valida los datos de la busqueda por Código
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validarBusquedaCodigo(){
		 boolean correcto = true;
	        if((this.criterioBusqueda == null) || (this.criterioBusqueda.trim().equals(""))){//No se digitó algo
	            this.reiniciarController();
	        	this.buscarTodos();
	            correcto = false;
	        }else{
	            try{
	                if(Cliente.CODIGO_LONGITUD.intValue() < this.criterioBusqueda.length()){
	                    this.addError(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Cliente.CODIGO_LONGITUD.intValue()+ ")");
	                    correcto = false;
	                }else{
	                    Integer codigo = new Integer(Integer.parseInt(this.criterioBusqueda));//se castea a un Integer para ver si es un dato numérico
	                    if(codigo.intValue() <= 0){
	                        this.addError(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	                        correcto = false;
	                    }
	                }
	            }catch(NumberFormatException nef){
	                this.addError(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("soloNumeros"));//"Búsqueda por código necesita un número");
	                nef.printStackTrace();
	            }catch(Exception e){
	            	this.addError(this.getPropertyFieldName("cliente.buscar"),Bundle.rcs.getString("error") + e.getMessage());
	            	e.printStackTrace();
	            }
	        }
	        return correcto;
	}
	/**Metodo validarBusquedaDescripcion
	* Valida los datos de la búsqueda por descripción
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validarBusquedaDescripcion(){
		 boolean correcto = true;
	        if((this.criterioBusqueda == null) || (this.criterioBusqueda.trim().equals(""))){//No se digitó algo
	            this.buscarTodos();
	            correcto = false;
	        }
	        return correcto;
	}
	/**Método agregar
	* Agrega un cliente en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String agregarCliente(){
		String respuesta = "error";
        try{
            if(this.validarCliente()){
            	this.cliente.setPvInEstado(Cliente.ACTIVO);
                this.clienteBo.agregar(this.cliente);
                this.addInfo(null, Bundle.rcs.getString("datosAgregados"));//"Los datos se agregaron con éxito";
                respuesta = "success";
            }
        }catch(BussinessError be){
            this.processBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**Método modificar
	* Modificar un cliente en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificarCliente(){
		String respuesta = "error";
        try{
            if(this.validarCliente()){
                this.clienteBo.modificar(this.cliente);
                this.addInfo(null, Bundle.rcs.getString("datosModificados"));
                respuesta = "success";
            }
        }catch(BussinessError be){
            this.processBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**Método eliminar
	* Eliminar un cliente en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminarCliente(){
		String respuesta = "error";
        try{
            this.clienteBo.eliminar(this.cliente);
            this.addInfo(null, Bundle.rcs.getString("datosEliminados")); 
            this.reiniciarController();
            this.buscarTodos();
            respuesta = "success";
        }catch(BussinessError be){
            this.processBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/********************************************* GETTERS AND SETTERS*****************************************/

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/** @param cliente el cliente a establecer */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the agregar
	 */
	public Boolean getAgregar() {
		return agregar;
	}

	/** @param agregar el agregar a establecer */
	public void setAgregar(Boolean agregar) {
		this.agregar = agregar;
	}
	/**
	 * @return the criterioBusqueda
	 */
	public String getCriterioBusqueda() {
		if(this.criterioBusqueda != null) return this.criterioBusqueda.toUpperCase();
		else return criterioBusqueda;
	}
	/** @param criterioBusqueda el criterioBusqueda a establecer */
	public void setCriterioBusqueda(String criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}
	/**
	 * @return the dataTableClientes
	 */
	public HtmlDataTable getDataTableClientes() {
		return dataTableClientes;
	}
	/** @param dataTableClientes el dataTableClientes a establecer */
	public void setDataTableClientes(HtmlDataTable dataTableClientes) {
		this.dataTableClientes = dataTableClientes;
	}
	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}
	/** @param List<Cliente> clientes el List<Cliente> clientes a establecer */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/** @param clienteBo el clienteBo a establecer */
	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

}
