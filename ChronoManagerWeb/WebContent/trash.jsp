<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0014)about:internet -->
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.jenia.org/jsf/popup" prefix="jp" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<!-- TemplateBeginEditable name="doctitle" -->
<title>ChronoManager - </title>
<!-- TemplateEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
  @import url(theme/hmenu/src/skin-modern.css);
</style>
<script language="javascript" src="script.js"></script>
<link href="theme/estilo1.css" rel="stylesheet" type="text/css" />
<!--Fireworks CS3 Dreamweaver CS3 target.  Created Mon May 12 11:31:38 GMT-0600 2008-->
<!-- TemplateBeginEditable name="head" --><!-- TemplateEndEditable -->
</head>
<f:view locale="es_CR">
<f:loadBundle var="rcs" basename="com.vvs.chrono.web.bundles.recursos" />
<body bgcolor="#ffffff">
<!--<h:panelGroup rendered="#{seguridadController.conectado}">-->
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
		<!-- parte del menu dinamico -->
		<li>
			<!-- <img src="../images/door.png" width="20" height="20" class="imagenes" alt="Salir" title="Salir" onclick=		"document.getElementById('salirSistema:salir').click();" />-->
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
   <!-- TemplateBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.']}"/><!-- TemplateEndEditable --></h2>
   </td>
  </tr>
  <tr height="100%">
   <td colspan="7" valign="top" height="100%"><!-- TemplateBeginEditable name="contenido" -->
   <h:form  styleClass="form" id="form1" enctype="multipart/form-data">
   		Colocar Contenido
  </h:form>
   
   <!-- TemplateEndEditable -->   </td>
  </tr>
  <tr>
	<td width="100%" colspan="7" align="center" background="images/spacer_Footer.png" height="26">
		<div align="center" style="color:#FFFFFF"><h:outputText styleClass="outputText" id="txtTituloVersion" value="#{txt['version']}"/></div>
	</td>
  </tr>
</table>
<h:form id="salirSistema">
	<!--<h:commandButton id="salir" action="#{seguridadController.salir}" style="display:none;"/>-->
</h:form>
</body>
</f:view>
</html>
