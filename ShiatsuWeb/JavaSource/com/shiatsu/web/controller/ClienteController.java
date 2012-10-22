/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.domain.Cita;
import com.shiatsu.domain.Cliente;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.web.faces.FacesController;
import com.shiatsu.bo.ClienteBo;

/**
 * @author oscar.monge
 *
 */
public class ClienteController extends FacesController {
	
	/** Atributo <code>TUPLA de Cliente</code> */
	private Cliente 	  cliente;
    /** Atributo <code>agregar</code> */
    private Boolean 	  agregar;
    private String 		  criterioBusqueda;
    private HtmlDataTable dataTableClientes;
    private List<Cliente> clientes;
	private ClienteBo	  clienteBo;
	private Boolean init;
	/**
	 * 
	 */
	public ClienteController() {
		// TODO Auto-generated constructor stub
	}
	private void reiniciarFiltro(){
		this.criterioBusqueda=null;
		this.dataTableClientes=new HtmlDataTable();
		this.clientes = new ArrayList<Cliente>();
	}
	public void reiniciarController(){
		this.cliente=new Cliente();
		this.agregar=Boolean.TRUE;
		this.reiniciarFiltro();
		this.init=Boolean.FALSE;
	}
/****************** METODOS *************************************/
	public String buscarPorCodigo(){
		String correcto = "success";
		try{
		  if(this.validarBusquedaCodigo()){
		        Long codigoParseado = new Long(Long.parseLong(this.criterioBusqueda));
		        Cliente cliente = this.clienteBo.buscar(codigoParseado);
		        if(cliente != null) {
		        	this.clientes.add(cliente);
		            correcto =  "success";
		        }else{
		        	this.reiniciarController();
		            this.addMessage(null, Bundle.rcs.getString("noHayDatosCodigo"),null,FacesController.ERROR);
		            correcto = "error";
		        }
		  }
		}catch(NumberFormatException e){
			e.printStackTrace();
	        correcto = "error";
	    }catch(Exception e){
			e.printStackTrace();
	        this.addMessage(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("error") + e.getMessage(), null, FacesController.ERROR);//"Error: " + e.getMessage()
	        correcto = "error";
	    }
	    return correcto;
	}
	public String buscarPorDescripcion(){
		String correcto = "success";
        try{
            if(this.validarBusquedaDescripcion()){
            	List<Cliente> clientes = this.clienteBo.getClientesDescripcion(this.criterioBusqueda);
               if(clientes.isEmpty()){
		           this.reiniciarController();
                   this.addMessage(null, Bundle.rcs.getString("noHayDatosDescripcion"),null, FacesController.ERROR);
                   correcto= "error";
               }else{
            	   this.clientes = clientes;
               }
            }
        }catch(Exception e){
        	e.printStackTrace();	       
        	correcto = "error";
            this.addMessage(this.getPropertyFieldName("cliente.buscar"),Bundle.rcs.getString("error") + e.getMessage(), null, FacesController.ERROR);
        }
        return correcto;
	}
	/**Metodo buscarTodos
	* Busca todos los clientes existentes
	*/
	public void buscarTodos(){
		this.clientes = this.clienteBo.getClientes();
        if(this.clientes.isEmpty()){
        	this.addMessage(null, Bundle.rcs.getString("noHayRegistros"), null, FacesController.ERROR);
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la página
	*@return success
	*/
	public String cargarObjeto(){
		 this.cliente = (Cliente) this.dataTableClientes.getRowData();
	     this.agregar = false;
		 return "success";
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
	
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getFrecuenciasCitasItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.SEMANAL,  	Bundle.rcs.getString("cita.semanal")));
		items.add(new SelectItem(Cita.QUINCENAL,  	Bundle.rcs.getString("cita.quincenal")));
		items.add(new SelectItem(Cita.MENSUAL,  	Bundle.rcs.getString("cita.mensual")));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getProfesionItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.SEMANAL,  	"Profesional 1"));
		items.add(new SelectItem(Cita.QUINCENAL,  	"Profesional 2"));
		items.add(new SelectItem(Cita.MENSUAL,  	"Profesional 3"));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getNacionalidadItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.SEMANAL,  	"Costarricense"));
		items.add(new SelectItem(Cita.QUINCENAL,  	"Extranjero"));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getSexoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Integer.valueOf(1),  	"Masculino"));
		items.add(new SelectItem(Integer.valueOf(0),  	"Femenino"));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getTipoAlopeciaItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Integer.valueOf(1),  	"Tipo 1"));
		items.add(new SelectItem(Integer.valueOf(0),  	"Tipo 2"));
		return items;
	}
	
	/*********************** NAVEGACION *******************************/
	/**Metodo irAgregar
	* 
	*@return success
	*/
	public String irAgregar(){
		this.reiniciarController();
		return "success";
	}
	public String regresar(){
		this.buscarTodos();
		return "success";
	}
	/*********************** VALIDACION  *******************************/
	
	/**Metodo validarCliente
	* Valida los datos del cliente
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validarCliente(){
		boolean correcto = true;
		try{
			if((this.cliente.getPvLoTelefonoCasa() == null) ||(this.cliente.getPvLoTelefonoCasa().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCasa"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}else if(cliente.getPvLoTelefonoCasa().intValue() <= 0){
	            this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCasa"), Bundle.rcs.getString("codigoNoMenorIgualCero"),null,FacesController.ERROR);//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.cliente.getPvLoTelefonoCelular() == null) || (this.cliente.getPvLoTelefonoCelular().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCelular"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}else if(cliente.getPvLoTelefonoCelular().intValue() <= 0){
	            this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCelular"), Bundle.rcs.getString("codigoNoMenorIgualCero"),null,FacesController.ERROR);//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.cliente.getPvStDireccion() == null) || (this.cliente.getPvStDireccion().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}else{
				if(this.cliente.getPvStDireccion().length() > Cliente.LONGITUD_DIRECCION){
					this.addMessage(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Cliente.LONGITUD_DIRECCION.intValue()+ ")",null,FacesController.ERROR);
					correcto = false;
				}	
			}
			/*if((this.cliente.getPvStEmail1() == null) || (this.cliente.getPvStEmail1().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStEmail1"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvStEmail2() == null) || (this.cliente.getPvStEmail2().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStEmail2"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}*/
			if((this.cliente.getPvStNombre() == null) || (this.cliente.getPvStNombre().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStNombre"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
		}catch(NumberFormatException nef){
            this.addMessage(null, Bundle.rcs.getString("soloNumeros"),null,FacesController.ERROR);
            nef.printStackTrace();
        }catch(Exception e){
        	this.addMessage(null, Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
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
	                    this.addMessage(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Cliente.CODIGO_LONGITUD.intValue()+ ")",null,FacesController.ERROR);
	                    correcto = false;
	                }else{
	                    Integer codigo = new Integer(Integer.parseInt(this.criterioBusqueda));//se castea a un Integer para ver si es un dato numérico
	                    if(codigo.intValue() <= 0){
	                        this.addMessage(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("codigoNoMenorIgualCero"),null,FacesController.ERROR);//"El código no puede ser menor o igual a cero");
	                        correcto = false;
	                    }
	                }
	            }catch(NumberFormatException nef){
	                this.addMessage(this.getPropertyFieldName("cliente.buscar"), Bundle.rcs.getString("soloNumeros"),null,FacesController.ERROR);//"Búsqueda por código necesita un número");
	                nef.printStackTrace();
	            }catch(Exception e){
	            	this.addMessage(this.getPropertyFieldName("cliente.buscar"),Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
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
                this.addMessage(null, Bundle.rcs.getString("datosAgregados"),null,FacesController.INFO);//"Los datos se agregaron con éxito";
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addMessage(null, Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
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
                this.addMessage(null, Bundle.rcs.getString("datosModificados"),null,FacesController.INFO);
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addMessage(null, Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
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
            this.addMessage(null, Bundle.rcs.getString("datosEliminados"),null, FacesController.INFO); 
            this.reiniciarController();
            this.buscarTodos();
            respuesta = "success";
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addMessage(null, Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
        }
        return respuesta;
	}
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("cliente.pvLoCodigo")) 					return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvLoTelefonoCasa")) 			return "form1:txtPvLoTelefonoCasa";
			if (property.equals("cliente.pvLoTelefonoCelular")) 		return "form1:txtPvLoTelefonoCelular";
			if (property.equals("cliente.pvStDireccion")) 				return "form1:txtPvStDireccion";
			if (property.equals("cliente.pvStEmail1")) 					return "form1:txtPvStEmail1";
			if (property.equals("cliente.pvStEmail2")) 					return "form1:txtPvStEmail2";
			if (property.equals("cliente.pvStNombre")) 					return "form1:txtPvStNombre";
			if (property.equals("clienteBo.eliminar")) 					return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.modificar")) 				return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.agregar")) 					return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvInEstado")) 	   			    return "form1:cmbPvInEstado";
			if (property.equals("cliente.buscar")) 	    				return "form1:txtBuscar";
		}
		return null;
	}
/********************** SET Y GETS ****************************/
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the agregar
	 */
	public Boolean getAgregar() {
		return agregar;
	}
	/**
	 * @param agregar the agregar to set
	 */
	public void setAgregar(Boolean agregar) {
		this.agregar = agregar;
	}
	/**
	 * @return the criterioBusqueda
	 */
	public String getCriterioBusqueda() {
		return criterioBusqueda;
	}
	/**
	 * @param criterioBusqueda the criterioBusqueda to set
	 */
	public void setCriterioBusqueda(String criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}
	/**
	 * @return the dataTableClientes
	 */
	public HtmlDataTable getDataTableClientes() {
		return dataTableClientes;
	}
	/**
	 * @param dataTableClientes the dataTableClientes to set
	 */
	public void setDataTableClientes(HtmlDataTable dataTableClientes) {
		this.dataTableClientes = dataTableClientes;
	}
	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	/**
	 * @param clienteBo the clienteBo to set
	 */
	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}
	/**
	 * @return the init
	 */
	public Boolean getInit() {
		if(init==null){
			this.reiniciarController();
		}
		return init;
	}
	/**
	 * @param init the init to set
	 */
	public void setInit(Boolean init) {
		this.init = init;
	}
	
}
