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
<title>ChronoManager - Actualización Contactos</title>
<!-- InstanceEndEditable -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">

  @import url("theme/hmenu/src/skin-modern.css");

</style>

<script type="text/javascript">

  _dynarch_menu_url = "theme/hmenu/src/";

</script>

<script type="text/javascript" src="theme/hmenu/src/hmenu.js"></script>

<script type="text/javascript">

  document.writeln("<style type='text/css'>#menu { display: none; }</style>");

</script>

<script language="javascript" src="script.js"></script>

<link href="theme/estilo1.css" rel="stylesheet" type="text/css" />

<!--Fireworks CS3 Dreamweaver CS3 target.  Created Mon May 12 11:31:38 GMT-0600 2008-->

<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->

</head>

<f:view locale="es_CR">

<f:loadBundle var="rcs" basename="com.vvs.chrono.web.bundles.recursos" />

<body bgcolor="#ffffff">



<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">

<!-- fwtable fwsrc="banner_ctp_rh.png" fwpage="Page 1" fwbase="plantilla.png" fwstyle="Dreamweaver" fwdocid = "1063142010" fwnested="0" -->

  <tr>



   <td height="100"><img name="plantillaVVS_r1_c1" src="images/banner/plantillaVVS_r1_c1.gif" width="177" height="100" border="0" id="plantillaVVS_r1_c1" alt="" /></td>

   <td><img name="plantillaVVS_r1_c2" src="images/banner/plantillaVVS_r1_c2.gif" width="37" height="100" border="0" id="plantillaVVS_r1_c2" alt="" /></td>

   <td width="100%"><img name="plantillaVVS_r1_c3" src="images/banner/plantillaVVS_r1_c3.gif" width="100%" height="100" border="0" id="plantillaVVS_r1_c3" alt="" /></td>

   <td><img name="plantillaVVS_r1_c4" src="images/banner/plantillaVVS_r1_c4.gif" width="136" height="100" border="0" id="plantillaVVS_r1_c4" alt="" /></td>

   <td><img name="plantillaVVS_r1_c5" src="images/banner/plantillaVVS_r1_c5.gif" width="131" height="100" border="0" id="plantillaVVS_r1_c5" alt="" /></td>

   <td><img name="plantillaVVS_r1_c6" src="images/banner/plantillaVVS_r1_c6.gif" width="90" height="100" border="0" id="plantillaVVS_r1_c6" alt="" /></td>

   <td><img name="plantillaVVS_r1_c7" src="images/banner/plantillaVVS_r1_c7.gif" width="127" height="100" border="0" id="plantillaVVS_r1_c7" alt="" /></td> 

   

  </tr>

  <tr>

   <td colspan="7" valign="top">

     <ul id="menu">
		<li>

		</li>

     </ul>   

   </td>

  </tr>

  <tr>

   <td colspan="7">&nbsp;</td>

  </tr>

  <tr>

   <td colspan="7" valign="top">

   <h2>

   <!-- InstanceBeginEditable name="titulo" -->
   		<h:outputText styleClass="outputText" value="#{rcs['titulo.contactoActualizacion']}"/>
   <!-- InstanceEndEditable --></h2>

   </td>
     </tr>

  <tr height="100%">

   <td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
   
	<h:form  styleClass="form" id="form1" enctype="multipart/form-data">
   <table border="1">
		<tbody>
		<tr>
	  		<td class="Tit04Tabla">
	  			<h:outputText styleClass="outputText" id="txt1"
				value="#{rcs['contacto.codigo']}"></h:outputText>
		    </td>
	  	    <td><h:inputText styleClass="inputText" id="txtPvLoCodigo" readonly="true"
	  	    value="#{contactoController.contacto.pvLoCodigo}" size="5" maxlength="5"></h:inputText> 
	  	    <h:message styleClass="error" id="msgTxtCodigo" for="txtPvLoCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
	    </tr>
		<tr>
			<td class="Tit04Tabla">
	  		<h:outputText styleClass="outputText" id="txt2"
			value="#{rcs['contacto.nombre']}"></h:outputText></td>
	  	    <td><h:inputText styleClass="inputText" id="txtPvStNombre" 
	  	    value="#{contactoController.contacto.pvStNombre}" size="20" maxlength="50"></h:inputText> 
	  	    <h:message styleClass="error" id="msgTxtNombre" for="txtPvStNombre" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla"><h:outputText styleClass="outputText" id="txt3"
			value="#{rcs['contacto.apellido']}"></h:outputText></td>
	  	    <td><h:inputText styleClass="inputText" id="txtPvStApellido" 
	  	    value="#{contactoController.contacto.pvStApellido}" size="20" maxlength="20"></h:inputText> 
	  	    <h:message styleClass="error" id="msgTxtApellido" for="txtPvStApellido" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla"><h:outputText styleClass="outputText" id="txt8"
			value="#{rcs['contacto.cliente']}"></h:outputText></td>
		 	<td><h:selectOneMenu styleClass="selectOneMenu" id="cmbPvLoCliente"  
		 	value="#{contactoController.contacto.pvLoCliente}">
			<f:selectItems value="#{contactoController.clienteItems}"/></h:selectOneMenu>
            <h:message styleClass="error" id="msgTxtCliente" for="cmbPvLoCliente" 
            errorClass="error" infoClass="info" warnClass="warn" ></h:message></td>
         </tr>
		<tr>
	  		<td class="Tit04Tabla" colspan="2">
  			<h:outputText styleClass="outputText" id="txt4"
			value="#{rcs['contacto.email']}"></h:outputText></td>
		 </tr> 
		 <tr>
	  	    <td><h:inputText styleClass="inputText" id="txtPvStEmail1" 
	  	    value="#{contactoController.contacto.pvStEmail1}" size="20" maxlength="50"></h:inputText> 
	  	   <h:message styleClass="error" id="msgTxtEmail1" for="txtPvStEmail1" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
	  	   	<td><h:inputText styleClass="inputText" id="txtPvStEmail2" 
	  	    value="#{contactoController.contacto.pvStEmail2}" size="20" maxlength="50"></h:inputText> 
	  	    <h:message styleClass="error" id="msgTxtpvStEmail2" for="txtPvStEmail2" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla" colspan="2">
	  			<h:outputText styleClass="outputText" id="txt5"
				value="#{rcs['contacto.telefono']}"></h:outputText>
		    </td>
		 </tr> 
		 <tr>
	  	    <td>
	  	    	<h:inputText styleClass="inputText" id="txtPvLoTelefono1" 
	  	    				 value="#{contactoController.contacto.pvLoTelefono1}" size="10" maxlength="10">
	  	    	</h:inputText> 
	  	    	<h:message styleClass="error" id="msgTxtTelefono1" for="txtPvLoTelefono1" errorClass="error" infoClass="info" warnClass="warn"></h:message>
	  	   	</td>
	  	   	<td>	
	  	   		<h:inputText styleClass="inputText" id="txtPvLoTelefono2" 
	  	    				 value="#{contactoController.contacto.pvLoTelefono2}" size="10" maxlength="10">
	  	    	</h:inputText> 
	  	    	<h:message styleClass="error" id="msgTxtTelefono12" for="txtPvLoTelefono2" errorClass="error" infoClass="info" warnClass="warn"></h:message>
	  	   </td>
	    </tr>
	    <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="text6" value="#{rcs['contacto.fax']}"></h:outputText></td>
            <td>
              	<h:inputText styleClass="inputText" id="txtPvLoFax" 
	  	    				 value="#{contactoController.contacto.pvLoFax}" size="10" maxlength="10">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtFax" for="txtPvLoFax" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>	
        <c:if test="${!contactoController.agregar}">
			<tr>
	            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="text7" value="#{rcs['contacto.estado']}"></h:outputText></td>
	            <td>
	                <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInEstado"  value="#{contactoController.contacto.pvInEstado}">
									<f:selectItems value="#{clienteController.estadoItems}"/>
					</h:selectOneMenu>
	                <h:message styleClass="error" id="msgTxtEstado" for="cmbPvInEstado" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
	            </td>
	        </tr>
        </c:if>	
		<tr>
            <td colspan="2">
	            <h:commandButton type="submit" value="#{rcs['boton.agregar']}"   styleClass="commandExButton" id="btnAgregar"   rendered="#{contactoController.agregar}"  action="#{contactoController.agregarContacto}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.modificar']}" styleClass="commandExButton" id="btnModificar" rendered="#{!contactoController.agregar}" action="#{contactoController.modificarContacto}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.eliminar']}"  styleClass="commandExButton" id="btnEliminar"  rendered="#{!contactoController.agregar}" action="#{contactoController.eliminarContacto}"></h:commandButton>
            </td>
        </tr>	
        <tr>
			<td>
	 			<h:commandButton type="submit" value="#{rcs['boton.regresar']}"  styleClass="commandExButton" id="btnRegresar"  action="#{contactoController.regresar}"></h:commandButton>
		    </td>
		</tr>			
		</tbody>
	</table>
		<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"></h:messages>
		
	</h:form>	
   <!-- InstanceEndEditable -->   </td>

  </tr>

  <tr>

	<td width="100%" colspan="7" align="center" background="images/spacer_Footer.png" height="26">

		<div align="center" style="color:#FFFFFF"><h:outputText styleClass="outputText" id="txtTituloVersion" value="#{rcs['version']}"/></div>

	</td>

  </tr>

</table>
</body>

</f:view>

<!-- InstanceEnd --></html>
