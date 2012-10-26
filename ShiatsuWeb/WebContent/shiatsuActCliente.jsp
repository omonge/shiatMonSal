<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- saved from url=(0014)about:internet -->

<html><!-- InstanceBegin template="/Templates/plantilla.dwt" codeOutsideHTMLIsLocked="false" -->
<head>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.jenia.org/jsf/popup" prefix="jp" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<!-- InstanceBeginEditable name="doctitle" -->
<title>Shiatsu - Inicio </title>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="theme/css/estilo1.css" rel="stylesheet" type="text/css" />

<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
</head>
<f:view locale="es_CR">
<f:loadBundle var="rcs" basename="com.shiatsu.web.bundles.recursos" />
<body bgcolor="#ffffff">
<div class="header" id="menu">
        <section id="navContainer">
			<nav>
				<ul class="nav">
		            <li><a href="shiatsuInicio.jsf?init=true">Inicio</a></li>
		            <li><a href="#">Login</a></li>
		            <li><a href="#">Clientes</a>
		                <ul>
		                    <li><a href="shiatsuListaClientes.jsf?init=true">Lista Clientes</a></li>
		                    <li><a href="#">sub2</a></li>
		                    
		                                    <li><a href="#">sub3</a></li>
		                                    <li><a href="#">sub3</a></li>
		                                    <li><a href="#">sub3</a></li>
		                                    <li><a href="#">sub3</a></li>
		                    <li>
		                        <a href="#">sub3</a>
		                        <ul>
		                            <li>
		                                <a href="#">sub1</a>
		                                <ul>
		                                    <li><a href="#">sub1</a></li>
		                                    <li><a href="#">sub2</a></li>
		                                    <li><a href="#">sub3</a></li>
		                                </ul>
		                            </li>
		                            <li>
		                                <a href="#">sub2</a>
		                                <ul>
		                                    <li><a href="#">sub1</a></li>
		                                    <li><a href="#">sub2</a></li>
		                                    <li><a href="#">sub3</a></li>
		                                </ul>
		                            </li>
		                            <li><a href="#">subs3</a></li>
		                        </ul>
		                    </li>

		                </ul>
		            </li>
		            <li><a href="#">Acerca De</a>
		                
		            </li>
		            <li><a href="#">Contacto</a></li>
		        </ul>
			</nav>
	</section>
</div>
<section  id="container">
		<section id="innerContainer">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
                  	<tr>
                   		<td height="50" valign="top">
                    		<h2><!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.cliente.mantenimiento']}"/><!-- InstanceEndEditable --></h2>
                   		</td>
                  	</tr>
                  	<tr height="100%">
                    	<td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
                    	<div align="center">
					<h:form  styleClass="form" id="form1" enctype="multipart/form-data">
   <table border="0">
		<tbody>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="txt1"
					value="#{rcs['cliente.codigo']}"></h:outputText>
			    </td>
		  	    <td>
		  	    	<h:inputText styleClass="inputText" id="txtPvLoCodigo"
		  	    				 value="#{clienteController.cliente.pvLoCodigo}" size="10" maxlength="10" disabled="#{!clienteController.agregar}">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTxtCodigo" for="txtPvLoCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
		    </tr>
		    <tr>
			  		<td class="Tit04Tabla">
			  			<h:outputText styleClass="outputText" id="lblNombre"
						value="#{rcs['cliente.nombre']}"></h:outputText>
				    </td>
			  	    <td>
			  	    	<h:inputText styleClass="inputText" id="txtPvStNombre" 
			  	    				 value="#{clienteController.cliente.pvStNombre}" size="50" maxlength="50">
			  	    	</h:inputText> 
			  	    	<h:message styleClass="error" id="msgTxtNombre" for="txtPvStNombre" errorClass="error" infoClass="info" warnClass="warn"></h:message>
			  	   </td>
			</tr>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="lblDireccion"
					value="#{rcs['cliente.direccion']}"></h:outputText>
			    </td>
		  	    <td>
		  	    	<h:inputText styleClass="inputText" id="txtPvStDireccion" 
		  	    				 value="#{clienteController.cliente.pvStDireccion}" size="50" maxlength="50">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTxtDireccion" for="txtPvStDireccion" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
		    </tr>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="lblEmails"
					value="#{rcs['cliente.email']}"></h:outputText>
			    </td>
			     <td>
		  	    	<h:inputText styleClass="inputText" id="txtPvStEmail1" 
		  	    				 value="#{clienteController.cliente.pvStEmail1}" size="50" maxlength="50">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTxtStEmail1" for="txtPvStEmail1" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
			 </tr> 
			<tr>
	  		<td class="Tit04Tabla" colspan="2">
	  			<h:outputText styleClass="outputText" id="lblTelefonos"
				value="#{rcs['cliente.telefono']}"></h:outputText>
		    </td>
		 </tr> 
		 <tr>
	  	    <td>
	  	    	<h:inputText styleClass="inputText" id="txtPvLoTelefonoCasa" 
	  	    				 value="#{clienteController.cliente.pvLoTelefonoCasa}" size="8" maxlength="8">
	  	    	</h:inputText> 
	  	    	<h:message styleClass="error" id="msgTxtpvInTelefonoCasa" for="txtPvLoTelefonoCasa" errorClass="error" infoClass="info" warnClass="warn"></h:message>
	  	   	</td>
	  	   	<td>	
	  	   		<h:inputText styleClass="inputText" id="txtPvLoTelefonoCelular" 
	  	    				 value="#{clienteController.cliente.pvLoTelefonoCelular}" size="8" maxlength="8">
	  	    	</h:inputText> 
	  	    	<h:message styleClass="error" id="msgTxtpvInTelefonoCelular" for="txtPvLoTelefonoCelular" errorClass="error" infoClass="info" warnClass="warn"></h:message>
	  	   </td>
	    </tr>
	    <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblFacturaANombre" value="#{rcs['cliente.facturaANombre']}"></h:outputText></td>
            <td>
              	<h:inputText styleClass="inputText" id="txtPvStFacturaNombre" 
	  	    				 value="#{clienteController.cliente.pvStFacturaNombre}" size="50" maxlength="50">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtPvStFacturaNombre" for="txtPvStFacturaNombre" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblFrecuenciaCita" value="#{rcs['cliente.frecuencia']}"></h:outputText></td>
            <td>
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInFrecuenciaCita" value="#{clienteController.cliente.pvInFrecuenciaCita}">
									<f:selectItems value="#{clienteController.frecuenciasCitasItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvInFrecuenciaCita" for="cmbPvInFrecuenciaCita" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblProfesion" value="#{rcs['cliente.profesion']}"></h:outputText></td>
            <td>
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvIntProfesion" value="#{clienteController.cliente.pvInProfesion}">
									<f:selectItems value="#{clienteController.profesionItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvIntProfesion" for="cmbPvIntProfesion" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblLugarProfesion" value="#{rcs['cliente.lugarProfesion']}"></h:outputText></td>
            <td>
              	<h:inputText styleClass="inputText" id="txtPvStLugarProfesion" 
	  	    				 value="#{clienteController.cliente.pvStLugarProfesion}" size="50" maxlength="50">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtPvStLugarProfesion" for="txtPvStLugarProfesion" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblNacionalidad" value="#{rcs['cliente.nacionalidad']}"></h:outputText></td>
            <td>
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInNacionalidad" value="#{clienteController.cliente.pvInNacionalidad}">
									<f:selectItems value="#{clienteController.nacionalidadItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvInNacionalidad" for="cmbPvInNacionalidad" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblNacimiento" value="#{rcs['cliente.nacimiento']}"></h:outputText></td>
            <td><h:message styleClass="error" id="msgTxtPvDaNacimiento" for="txtPvDaNacimiento" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblSexo" value="#{rcs['cliente.sexo']}"></h:outputText></td>
            <td>
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvIntSexo" value="#{clienteController.cliente.pvInSexo}">
									<f:selectItems value="#{clienteController.sexoItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvIntSexo" for="cmbPvIntSexo" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
      	<tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblTipoAlopecia" value="#{rcs['cliente.tipoAlopecia']}"></h:outputText></td>
            <td>
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInTipoAlopecia" value="#{clienteController.cliente.pvInTipoAlopecia}">
									<f:selectItems value="#{clienteController.tipoAlopeciaItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgCmbPvInTipoAlopecia" for="cmbPvInTipoAlopecia" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <c:if test="${!clienteController.agregar}">	
			<tr>
	            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblEstado" value="#{rcs['cliente.estado']}"/></td>
	            <td>
	                <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInEstado" value="#{clienteController.cliente.pvInEstado}">
									<f:selectItems value="#{clienteController.estadoItems}"/>
					</h:selectOneMenu>
	                <h:message styleClass="error" id="msgTxtEstado" for="cmbPvInEstado" errorClass="error" infoClass="info" warnClass="warn"/>
	            </td>
	        </tr>
		</c:if>
		<tr>
            <td colspan="2">
	            <h:commandButton type="submit" value="#{rcs['boton.agregar']}"   styleClass="commandButton" id="btnAgregar"   rendered="#{clienteController.agregar}" 	action="#{clienteController.agregarCliente}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.modificar']}" styleClass="commandButton" id="btnModificar" rendered="#{!clienteController.agregar}" 	action="#{clienteController.modificarCliente}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.eliminar']}"  styleClass="commandButton" id="btnEliminar"  rendered="#{!clienteController.agregar}"  	action="#{clienteController.eliminarCliente}" onclick="return confirmEliminar('e','Cliente');"></h:commandButton>
            </td>
        </tr>
		</tbody>
	</table>
		<h:commandButton type="submit" value="#{rcs['boton.regresar']}"  styleClass="commandButton" id="btnRegresar"  action="#{clienteController.regresar}"></h:commandButton>
		<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"></h:messages>
	</h:form>	</div>
					<!-- InstanceEndEditable -->   </td>
                  	</tr>
            </table>
            </section>
	</section>
	<footer>
		©
	</footer>
</body>
</f:view>

<!-- InstanceEnd --></html>