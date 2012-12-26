package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.UsuarioBo;
import com.shiatsu.domain.Usuario;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class UsuarioController  extends Controller{

	private HtmlDataTable     	  listaDataTable;
    private List<Usuario>    lista;
    private Usuario 	  	  usuario;
	private UsuarioBo	  	  usuarioBo;  
	

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
	
	public UsuarioController() {
		this.reiniciarController();
	}

	@Override
	protected void reiniciarController() {
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}

	@Override
	protected void reiniciarFiltro() {
		this.agregar = Boolean.TRUE;
		this.usuario = new Usuario();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<Usuario>();
	}
	


	/**
     * M�todo para validar el c�digo, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        
    	if ((this.usuario.getPvStDescripcion() != null) && (!"".equals(this.usuario.getPvStDescripcion()))) {
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
        if((this.usuario.getPvInCodigo()!=null)) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * M�todo buscar Busca las listaTipoAlopecia que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Usuario usuario = this.usuarioBo.buscar(this.usuario);
            if (usuario != null) {
                this.lista.add(usuario);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.usuarioBo.getUsuarios(this.usuario);
        		respuesta = "success";
        	}
            else{ 
                this.addWarning(null, Bundle.rcs.getString("todosLosRegistros"));
                this.buscarTodos();
            }
        } 
        if ((respuesta == "success") && (this.lista.isEmpty())) { 
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        } else if (respuesta == "success") {
            this.reiniciarFiltro();
            this.addInfo(null, Bundle.rcs.getString("operacionExitosa"));
        }
        return respuesta;
    }
 
	public void buscarTodos(){
		this.lista = this.usuarioBo.getUsuarios();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la página
	*@return success
	*/
	public String cargarObjeto(){
		 this.usuario = (Usuario) this.listaDataTable.getRowData();
	     this.agregar = false;
		 return "success";
	}


	/*********************** NAVEGACION *******************************/
	
	/**Metodo irAgregar
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
	
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
			if((!this.agregar) && (this.usuario.getPvInCodigo() == null)){
				this.addError(this.getPropertyFieldName("usuario.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.usuario.getPvStDescripcion()== null || ("".equals(this.usuario.getPvStDescripcion())))){
				this.addError(this.getPropertyFieldName("usuario.pvStDescripcion"),Bundle.rcs.getString("campoRequerido"));
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
	
	/**M�todo agregar
	* Agrega un usuario en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	//this.usuario.setPvStEstado(Usuario.ESTADO_ACTIVO);
                this.usuarioBo.agregar(this.usuario);
                this.addInfo(null, Bundle.rcs.getString("datosAgregados"));
                respuesta = "success";
                this.reiniciarFiltro();
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	
	/**M�todo modificar
	* Modificar un usuario en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.usuarioBo.modificar(this.usuario);
                this.addInfo(null, Bundle.rcs.getString("datosModificados"));
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	
	/**M�todo eliminar
	* Eliminar un Usuario en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.usuarioBo.eliminar(this.usuario);
            this.addInfo(null, Bundle.rcs.getString("datosEliminados")); 
            this.reiniciarController();
            this.buscarTodos();
            respuesta = "success";
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
        
	/**
     * Retorna una lista de selectItems que contienen estados del usuario
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		return items;
	}
	
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("Usuario.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("Usuario.pvStDescripcion")) return "form1:pvStDescripcion";
		}
		return null;
	}


	/**
	 * @return the listaDataTable
	 */
	public HtmlDataTable getListaDataTable() {
		return listaDataTable;
	}

	/**
	 * @param listaDataTable the listaDataTable to set
	 */
	public void setListaDataTable(HtmlDataTable listaDataTable) {
		this.listaDataTable = listaDataTable;
	}

	/**
	 * @return the lista
	 */
	public List<Usuario> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	/**
	 * @return the Usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * @param Usuario the Usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	/**
	 * @param UsuarioBo the UsuarioBo to set
	 */
	public void setUsuarioBo(UsuarioBo usuarioBo) {
		this.usuarioBo = usuarioBo;
	}

}
