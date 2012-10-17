package com.vvs.chrono.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.vvs.bussiness.BussinessError;
import com.vvs.chrono.bo.ClienteBo;
import com.vvs.chrono.bo.ContactoBo;
import com.vvs.chrono.domain.Cliente;
import com.vvs.chrono.domain.Contacto;
import com.vvs.chrono.web.bundles.Bundle;
import com.vvs.jsf.AbstractFacesController;

public class ContactoController extends AbstractFacesController {

	/** Atributo <code>TUPLA de Contacto</code> */
	private Contacto 	  contacto;
    /** Atributo <code>agregar</code> */
    private Boolean 	  agregar;
    private String 		  criterioBusqueda;
    private HtmlDataTable dataTableContactos;
    private List<Contacto> contactos;
    
    private ClienteBo 	  clienteBo;
    private ContactoBo	  contactoBo;
    
	public ContactoController() {
		this.reiniciarController();
		//this.buscarTodos();
	}
	
	public void reiniciarController(){
		this.contacto=new Contacto();
		this.agregar=true;
		this.reiniciarFiltro();
	}
	/**Método reiniciarFiltro
	* Reinicia el filtro del controller
	*/
	private void reiniciarFiltro(){
		this.criterioBusqueda=null;
		this.dataTableContactos=new HtmlDataTable();
		this.contactos =  new ArrayList<Contacto>();
	}
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("contacto.pvLoCodigo")) 		return "form1:txtPvLoCodigo";
			if (property.equals("contacto.cmbPvLoCliente")) 	return "form1:cmbPvLoCliente";
			if (property.equals("contacto.cmbPvInEstado"))	 	return "form1:cmbPvInEstado";
			if (property.equals("contacto.pvStApellido")) 		return "form1:txtPvStApellido";
			if (property.equals("contacto.pvLoFax"))    		return "form1:txtPvLoFax";
			if (property.equals("contacto.pvLoTelefono1")) 		return "form1:txtPvLoTelefono1";
			if (property.equals("contacto.pvLoTelefono2")) 		return "form1:txtPvLoTelefono2";
			if (property.equals("contacto.pvStComentario")) 	return "form1:txtPvStComentario";
			if (property.equals("contacto.pvStDireccion")) 		return "form1:txtPvStDireccion";
			if (property.equals("contacto.pvStEmail1")) 		return "form1:txtPvStEmail1";
			if (property.equals("contacto.pvStEmail2")) 		return "form1:txtPvStEmail2";
			if (property.equals("contacto.pvStNombre")) 		return "form1:txtPvStNombre";
			if (property.equals("contactoBo.eliminar")) 		return "form1:txtPvLoCodigo";
			if (property.equals("contactoBo.modificar")) 		return "form1:txtPvLoCodigo";
			if (property.equals("contactoBo.agregar")) 			return "form1:txtPvLoCodigo";
			if (property.equals("contacto.pvInEstado")) 	    return "form1:cmbPvInEstado";
			if (property.equals("contacto.buscar")) 	    	return "form1:txtBuscar";
		}
		return null;
	}
	/**
     * Retorna una lista de selectItems que contienen clientes
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los clientes existentes
     */
	public List<SelectItem> getClienteItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
        List<Cliente> clientes = this.clienteBo.getClientes();
        items.add(new SelectItem(new Long(0), Bundle.rcs.getString("seleccioneOpcion")));        
        for(int i=0; i < clientes.size(); i++) {
        	Cliente cliente = (Cliente) clientes.get(i);
            items.add(new SelectItem(cliente.getPvLoCodigo(), cliente.getPvStNombre()));
        }
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen estados del Contacto
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Contacto.ACTIVO,    Bundle.rcs.getString("activo")));
		items.add(new SelectItem(Contacto.INACTIVO,  Bundle.rcs.getString("inactivo")));
		return items;
	}
	@SuppressWarnings("deprecation")
	public String abrirPopUpContacto(){
		this.contacto = (Contacto) this.dataTableContactos.getRowData();
		this.getFacesContext().getApplication().createValueBinding("#{popUpDetalleContactoController.contacto}").setValue(this.getFacesContext(),this.contacto);
		return "success";
	}
	public String cerrarPopUpContacto(){
		return "success";
	}
/*****************   BUSQUEDAS   ********************/
	
	
	/**Método buscarPorCodigo
	* Busca Contacto por su Código
	*@return success si logra encontrar Contacto, error en caso contrario
	*/
	public String buscarPorCodigo(){
		String correcto = "success";
		try{
		  this.contactos = new ArrayList<Contacto>();
		  if(this.validarBusquedaCodigo()){
		        Long codigoParseado = new Long(Long.parseLong(this.criterioBusqueda));
		        Contacto contacto = this.contactoBo.buscar(codigoParseado);
		        if(contacto != null) {
		        	this.contactos.add(contacto);
		            correcto =  "success";
		        }else{
		        	this.reiniciarController();
		            this.addError(null, Bundle.rcs.getString("noHayDatosCodigo"));
		            correcto = "error";
		        }
		  }
		}catch(Exception e){
			e.printStackTrace();
	        this.addError(this.getPropertyFieldName("contacto.buscar"), Bundle.rcs.getString("error") + e.getMessage());//"Error: " + e.getMessage()
	        correcto = "error";
	    }
	    return correcto;
	}
	/**Método buscarPorDescripcion
	* Busca Contacto por su Nombre
	*@return success si logra encontrar Contacto, error en caso contrario
	*/
	public String buscarPorDescripcion(){
		String correcto = "success";
        try{
            this.contactos = new ArrayList<Contacto>();
            if(this.validarBusquedaDescripcion()){
               this.contactos = this.contactoBo.getContactosDescripcion(this.criterioBusqueda);
               if(this.contactos.isEmpty()){
		           this.reiniciarController();
                   this.addError(null, Bundle.rcs.getString("noHayDatosDescripcion"));
                   correcto= "error";
               }
            }
        }catch(Exception e){
        	e.printStackTrace();	       
        	correcto = "error";
            this.addError(this.getPropertyFieldName("contacto.buscar"),Bundle.rcs.getString("error") + e.getMessage());
        }
        return correcto;
	}

	/**Metodo buscarTodos
	* Búsca todos los contactos existentes
	*/
	public void buscarTodos(){
		this.contactos = this.contactoBo.getContactos();
        if(this.contactos.isEmpty()){
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));//"No hay registros"
        }
	}
	/**Método cargarObjeto
	* Carga el objeto seleccionado de la tabla de la página
	*@return success
	*/
	public String cargarObjeto(){
		 this.contacto = (Contacto) this.dataTableContactos.getRowData();
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
	/**Metodo validarContacto
	* Valida los datos del contacto
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validarContacto(){
		boolean correcto = true;
		try{
			if((this.contacto.getPvLoCliente() == null) || (this.contacto.getPvLoCliente().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.cmbPvLoCliente"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(contacto.getPvLoCliente().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("contacto.cmbPvLoCliente"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.contacto.getPvLoFax() == null) || (this.contacto.getPvLoFax().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvLoFax"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(contacto.getPvLoFax().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("contacto.pvLoFax"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.contacto.getPvLoTelefono1() == null) ||(this.contacto.getPvLoTelefono1().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvLoTelefono1"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(contacto.getPvLoTelefono1().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("contacto.pvLoTelefono1"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if((this.contacto.getPvLoTelefono2() == null) || (this.contacto.getPvLoTelefono2().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvLoTelefono2"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}else if(contacto.getPvLoTelefono2().intValue() <= 0){
	            this.addError(this.getPropertyFieldName("contacto.pvLoTelefono2"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	            correcto = false;
	        }
			if(this.contacto.getPvStComentario() != null){
				if(this.contacto.getPvStComentario().length() > Contacto.LONGITUD_COMENTARIO){
					this.addError(this.getPropertyFieldName("contacto.pvStComentario"),Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Contacto.LONGITUD_COMENTARIO.intValue()+ ")");
					correcto = false;
				}	
			}
			if((this.contacto.getPvStEmail1() == null) || (this.contacto.getPvStEmail1().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvStEmail1"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.contacto.getPvStEmail2() == null) || (this.contacto.getPvStEmail2().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvStEmail2"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.contacto.getPvStNombre() == null) || (this.contacto.getPvStNombre().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvStNombre"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.contacto.getPvStApellido() == null) || (this.contacto.getPvStApellido().equals(""))){
				this.addError(this.getPropertyFieldName("contacto.pvStApellido"),Bundle.rcs.getString("campoRequerido"));
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
	                if(Contacto.CODIGO_LONGITUD.intValue() < this.criterioBusqueda.length()){
	                    this.addError(this.getPropertyFieldName("contacto.buscar"), Bundle.rcs.getString("excedeCodigoLongitud") + " (" + Contacto.CODIGO_LONGITUD.intValue()+ ")");
	                    correcto = false;
	                }else{
	                    Integer codigo = new Integer(Integer.parseInt(this.criterioBusqueda));//se castea a un Integer para ver si es un dato numérico
	                    if(codigo.intValue() <= 0){
	                        this.addError(this.getPropertyFieldName("contacto.buscar"), Bundle.rcs.getString("codigoNoMenorIgualCero"));//"El código no puede ser menor o igual a cero");
	                        correcto = false;
	                    }
	                }
	            }catch(NumberFormatException nef){
	                this.addError(this.getPropertyFieldName("contacto.buscar"), Bundle.rcs.getString("soloNumeros"));//"Búsqueda por código necesita un número");
	                nef.printStackTrace();
	            }catch(Exception e){
	            	this.addError(this.getPropertyFieldName("contacto.buscar"),Bundle.rcs.getString("error") + e.getMessage());
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
	* Agrega un contacto en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String agregarContacto(){
		String respuesta = "error";
        try{
            if(this.validarContacto()){
            	this.contacto.setPvInEstado(Contacto.ACTIVO);
                this.contactoBo.agregar(this.contacto);
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
	* Modificar un contacto en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificarContacto(){
		String respuesta = "error";
        try{
            if(this.validarContacto()){
                this.contactoBo.modificar(this.contacto);
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
	* Eliminar un contacto en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminarContacto(){
		String respuesta = "error";
        try{
            this.contactoBo.eliminar(this.contacto);
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
	
	
	
/************* SETTERS && GETTERS******************************************/
	/** @return regresa el contacto*/
	public Contacto getContacto() {
		return contacto;
	}

	/** @param contacto el contacto a establecer */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	/** @return regresa el agregar*/
	public Boolean getAgregar() {
		return agregar;
	}

	/** @param agregar el agregar a establecer */
	public void setAgregar(Boolean agregar) {
		this.agregar = agregar;
	}

	/** @return regresa el criterioBusqueda*/
	public String getCriterioBusqueda() {
		return criterioBusqueda;
	}

	/** @param criterioBusqueda el criterioBusqueda a establecer */
	public void setCriterioBusqueda(String criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}

	/** @return regresa el dataTableContactos*/
	public HtmlDataTable getDataTableContactos() {
		return dataTableContactos;
	}

	/** @param dataTableContactos el dataTableContactos a establecer */
	public void setDataTableContactos(HtmlDataTable dataTableContactos) {
		this.dataTableContactos = dataTableContactos;
	}

	/** @return regresa el contactos*/
	public List<Contacto> getContactos() {
		return contactos;
	}

	/** @param contactos el contactos a establecer */
	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	/** @param clienteBo el clienteBo a establecer */
	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	/** @param contactoBo el contactoBo a establecer */
	public void setContactoBo(ContactoBo contactoBo) {
		this.contactoBo = contactoBo;
	}
	
	
	

}
