/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
	 
	private Cliente 	  cliente; 
    private Boolean 	  agregar; 
    private HtmlDataTable listaDataTableCliente;
    private boolean 	  init;
    private List<Cliente> listaCliente;
	private ClienteBo	  clienteBo;  
	
	public ClienteController() { 
		this.reiniciarController();
	}
	
	public void reiniciarController(){
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}
	
	private void reiniciarFiltro(){ 
		this.agregar=Boolean.TRUE;
		this.cliente=new Cliente();
	}
	
	private void reiniciarDatos(){ 
		this.listaDataTableCliente=new HtmlDataTable();
		this.listaCliente = new ArrayList<Cliente>(); 
	}
	
	
	/****************** METODOS *************************************/
 
	 /**
	 * @return the init
	 */ 
	public boolean getInit() {  
		Object dato = this.getFacesContext().getExternalContext().getRequestParameterMap().get("init");
        if (dato != null) {
           this.reiniciarController();
           this.buscarTodos();
        } 
        return init;
	}
	 
	/**
	 * @param init the init to set
	 */
	public void setInit(boolean init) {
		this.init = init;
	}

	/**
     * MÈtodo para validar el cÛdigo, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

    	if ((this.cliente.getPvStNombre() != null) && (!"".equals(this.cliente.getPvStNombre()))) {
            correcto = true;
    	}
    	if ((this.cliente.getPvLoTelefonoCasa() != null) && (this.cliente.getPvLoTelefonoCasa().longValue() > Cliente.TELEFONO_DEFAULT.longValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvLoTelefonoCelular()!= null) && (this.cliente.getPvLoTelefonoCelular().longValue() > Cliente.TELEFONO_DEFAULT.longValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInFrecuenciaCita()!= null) && (this.cliente.getPvInFrecuenciaCita().intValue() > Cliente.FRECUENCIA_CITA_DEFAULT.intValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInProfesion() != null) && (this.cliente.getPvInProfesion().intValue() > Cliente.PROFESION_DEFAULT.intValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInNacionalidad() != null) && (this.cliente.getPvInNacionalidad().intValue() > Cliente.NACIONALIDAD_DEFAULT.intValue())) {
            correcto = true;
    	}    	
    	if ((this.cliente.getPvInSexo() != null) && (this.cliente.getPvInSexo().intValue()  != Cliente.SEXO_DEFAULT.intValue())) {
            correcto = true;
    	} 
    	if ((this.cliente.getPvInTipoAlopecia() != null) && (this.cliente.getPvInTipoAlopecia().intValue()  > Cliente.ALOPECIA_DEFAULT.intValue() )) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInEstado() != null) && (this.cliente.getPvInEstado().intValue() > Cliente.ESTADO_DEFAULT.intValue() )) {
            correcto = true;
    	}
        return correcto;
    }

    /**
     * Metodo validarObjetoId Metodo que valida el id del objeto que se quiere buscar, agregar o modificar
     * @return bool
     */
    private boolean validarObjetoId() { 
        boolean correcto = false;
        if((this.cliente.getPvStCodigo()!=null) && (!"".equals(this.cliente.getPvStCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * MÈtodo buscar Busca las listaCliente que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTableCliente != null){this.listaDataTableCliente.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Cliente cliente = this.clienteBo.buscar(this.cliente);
            if (cliente != null) {
                this.listaCliente.add(cliente);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.listaCliente = this.clienteBo.getClientes(this.cliente);
        		respuesta = "success";
        	}
            else{ 
                this.addMessage(null, Bundle.rcs.getString("todosLosRegistros"),null,FacesController.WARNING);
                this.buscarTodos();
            }
        } 
        if ((respuesta == "success") && (this.listaCliente.isEmpty())) { 
            this.addMessage(null, Bundle.rcs.getString("noHayRegistros"),null,FacesController.ERROR);
        } else if (respuesta == "success") {
            this.reiniciarFiltro();
            this.addMessage(null, Bundle.rcs.getString("operacionExitosa"),null,FacesController.INFO);
        }
        return respuesta;
    }
 
	public void buscarTodos(){
		this.listaCliente = this.clienteBo.getClientes();
        if(this.listaCliente.isEmpty()){
        	this.addMessage(null, Bundle.rcs.getString("noHayRegistros"), null, FacesController.ERROR);
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la p√°gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.cliente = (Cliente) this.listaDataTableCliente.getRowData();
	     this.agregar = false;
		 return "success";
	}
	/**
     * Retorna una lista de selectItems que contienen estados del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.ESTADO_DEFAULT,    Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cliente.ESTADO_ACTIVO,    Bundle.rcs.getString("cliente.activo")));
		items.add(new SelectItem(Cliente.ESTADO_INACTIVO,  Bundle.rcs.getString("cliente.inactivo")));
		return items;
	}
	
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getFrecuenciasCitasItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.CITA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cita.CITA_SEMANAL,  	Bundle.rcs.getString("cita.semanal")));
		items.add(new SelectItem(Cita.CITA_QUINCENAL,  	Bundle.rcs.getString("cita.quincenal")));
		items.add(new SelectItem(Cita.CITA_MENSUAL,  	Bundle.rcs.getString("cita.mensual")));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getProfesionItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.PROFESION_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cita.CITA_SEMANAL,  	Bundle.rcs.getString("cita.semanal")));
		items.add(new SelectItem(Cita.CITA_QUINCENAL,  	Bundle.rcs.getString("cita.quincenal")));
		items.add(new SelectItem(Cita.CITA_MENSUAL,  	Bundle.rcs.getString("cita.mensual")));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getNacionalidadItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.NACIONALIDAD_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cita.CITA_SEMANAL,  	"Costarricense"));
		items.add(new SelectItem(Cita.CITA_QUINCENAL,  	"Extranjero"));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getSexoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.SEXO_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
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
		items.add(new SelectItem(Cliente.ALOPECIA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
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
		this.reiniciarFiltro();
		this.buscarTodos();
		return "success";
	}
	/*********************** VALIDACION  *******************************/
	
	/**Metodo validaInsertar
	* Valida los datos del cliente
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
			if((this.cliente.getPvLoTelefonoCasa() == null) ||(Cliente.TELEFONO_DEFAULT.equals(this.cliente.getPvLoTelefonoCasa()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCasa"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvLoTelefonoCelular() == null ||(Cliente.TELEFONO_DEFAULT.equals(this.cliente.getPvLoTelefonoCelular())))){
				this.addMessage(this.getPropertyFieldName("cliente.pvLoTelefonoCelular"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvStDireccion() == null) || ("".equals(this.cliente.getPvStDireccion()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			/*if((this.cliente.getPvStEmail1() == null) || (this.cliente.getPvStEmail1().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStEmail1"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvStEmail2() == null) || (this.cliente.getPvStEmail2().equals(""))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStEmail2"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}*/
			if((this.cliente.getPvStNombre() == null) || ("".equals(this.cliente.getPvStNombre()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvStNombre"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInEstado() == null) || (Cliente.ESTADO_INACTIVO.equals(this.cliente.getPvInEstado()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInEstado"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInFrecuenciaCita() == null) || (Cliente.FRECUENCIA_CITA_DEFAULT.equals(this.cliente.getPvInFrecuenciaCita()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInFrecuenciaCita"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInNacionalidad() == null) || (Cliente.FRECUENCIA_CITA_DEFAULT.equals(this.cliente.getPvInNacionalidad()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInNacionalidad"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInProfesion() == null) || (Cliente.PROFESION_DEFAULT.equals(this.cliente.getPvInProfesion()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInProfesion"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInSexo() == null) || (Cliente.SEXO_DEFAULT.equals(this.cliente.getPvInSexo()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInSexo"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
				correcto = false;
			}
			if((this.cliente.getPvInTipoAlopecia() == null) || (Cliente.ALOPECIA_DEFAULT.equals(this.cliente.getPvInTipoAlopecia()))){
				this.addMessage(this.getPropertyFieldName("cliente.pvInTipoAlopecia"),Bundle.rcs.getString("campoRequerido"),null,FacesController.ERROR);
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
	/**M√©todo agregar
	* Agrega un cliente en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	this.cliente.setPvInEstado(Cliente.ESTADO_ACTIVO);
                this.clienteBo.agregar(this.cliente);
                this.addMessage(null, Bundle.rcs.getString("datosAgregados"),null,FacesController.INFO);//"Los datos se agregaron con √©xito";
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addMessage(null, Bundle.rcs.getString("error") + e.getMessage(),null,FacesController.ERROR);
        }
        return respuesta;
	}
	/**M√©todo modificar
	* Modificar un cliente en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
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
	/**M√©todo eliminar
	* Eliminar un cliente en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
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
	 * @return the listaDataTableCliente
	 */
	public HtmlDataTable getListaDataTableCliente() {
		return listaDataTableCliente;
	}

	/**
	 * @param listaDataTableCliente the listaDataTableCliente to set
	 */
	public void setListaDataTableCliente(HtmlDataTable listaDataTableCliente) {
		this.listaDataTableCliente = listaDataTableCliente;
	}

	/**
	 * @return the listaCliente
	 */
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	/**
	 * @param listaCliente the listaCliente to set
	 */
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	/**
	 * @return the clienteBo
	 */
	public ClienteBo getClienteBo() {
		return clienteBo;
	}

	/**
	 * @param clienteBo the clienteBo to set
	 */
	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	
}
