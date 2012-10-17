<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/plantillaPopup.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.jenia.org/jsf/popup" prefix="jp" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<!-- InstanceBeginEditable name="doctitle" -->
<title>ChronoManager - Titulo</title>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
  @import url("theme/hmenu/src/skin-modern.css");
</style>
<script language="javascript" src="script.js"></script>
<link href="theme/estilo1.css" rel="stylesheet" type="text/css" />
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
</head>
<f:view locale="es_CR">
<f:loadBundle var="rcs" basename="com.vvs.chrono.web.bundles.recursos" />
<body bgcolor="#ffffff">
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">  
   <tr>
   <td colspan="7" valign="top">
   <h2>
   <!-- InstanceBeginEditable name="titulo" -->
   			<h:outputText styleClass="outputText" value="#{rcs['contactoPop.titulo']}"/>
   <!-- InstanceEndEditable -->
   </h2>
   </td>
   <td><img src="theme/plantilla/spacer.gif" width="1" height="33" border="0" alt="" /></td>
  </tr>
  <tr height="100%">
   <td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
   		<h:form  styleClass="form" id="form1" enctype="multipart/form-data">
   <table border="1">
		<tbody>
		<tr>
	  		<td class="Tit04Tabla">
	  		<h:outputText styleClass="outputText" id="txt1"
			value="#{rcs['contacto.codigo']}"></h:outputText></td>
	  	    <td><h:outputText styleClass="outputText" id="txtCodigo"
	  	    value="#{popUpDetalleContactoController.contacto.pvLoCodigo}"></h:outputText></td>
	    </tr>
		<tr>
	  		<td class="Tit04Tabla"><h:outputText styleClass="outputText" id="txt2"
			value="#{rcs['contacto.nombre']}"></h:outputText></td>
	  	    <td><h:outputText styleClass="outputText" id="txtNombre" 
	  	    value="#{popUpDetalleContactoController.contacto.pvStNombre}" ></h:outputText></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla"><h:outputText styleClass="outputText" id="txt3"
			value="#{rcs['contacto.apellido']}"></h:outputText></td>
	  	    <td><h:outputText styleClass="outputText" id="txtApellido" 
	  	    value="#{popUpDetalleContactoController.contacto.pvStApellido}"></h:outputText></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla"><h:outputText styleClass="outputText" id="txt8"
			value="#{rcs['contacto.cliente']}"></h:outputText></td>
		 	<td><h:outputText styleClass="selectOneMenu" id="txtCliente"  
		 	value="#{popUpDetalleContactoController.contacto.pvLoCliente}"></h:outputText></td>
         </tr>
		<tr>
	  		<td class="Tit04Tabla" colspan="2">
	  			<h:outputText styleClass="outputText" id="txt4"
				value="#{rcs['contacto.email']}"></h:outputText>
		    </td>
		 </tr> 
		 <tr>
	  	    <td><h:outputText styleClass="outputText" id="txtEmail1" 
	  	    value="#{popUpDetalleContactoController.contacto.pvStEmail1}"></h:outputText></td>
	  	   	<td><h:outputText styleClass="outputText" id="txtpvStEmail2" 
	  	    value="#{popUpDetalleContactoController.contacto.pvStEmail2}" ></h:outputText></td>
	    </tr>
	    <tr>
	  		<td class="Tit04Tabla" colspan="2"><h:outputText styleClass="outputText" id="txt5"
			value="#{rcs['contacto.telefono']}"></h:outputText></td>
		 </tr> 
		 <tr>
	  	    <td><h:outputText styleClass="outputText" id="txtpvLoTelefono1" 
	  	    value="#{popUpDetalleContactoController.contacto.pvLoTelefono1}"></h:outputText></td>
	  	   	<td><h:outputText styleClass="outputText" id="txtpvLoTelefono2" 
	  	    value="#{popUpDetalleContactoController.contacto.pvLoTelefono2}"></h:outputText></td>
	    </tr>
	    <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="text6" value="#{rcs['contacto.fax']}"></h:outputText></td>
            <td><h:outputText styleClass="outputText" id="txtFax" 
	  	    value="#{popUpDetalleContactoController.contacto.pvLoFax}"></h:outputText></td>
        </tr>	
		<tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="text7" 
            value="#{rcs['contacto.estado']}"></h:outputText></td>
            <td><h:outputText styleClass="outputText" id="txtEstado"  
            value="#{popUpDetalleContactoController.contacto.pvStEstadoDescripcion}"></h:outputText></td>
        </tr>			
		</tbody>
	</table>
		<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"></h:messages>
	</h:form>	
   <!-- InstanceEndEditable -->
   </td>
   </tr>
</table>
</body>
</f:view>
<!-- InstanceEnd --></html>
