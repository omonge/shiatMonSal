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
<title>ChronoManager - Consulta Clientes</title>
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
   		<h:outputText styleClass="outputText" value="#{rcs['titulo.clienteConsulta']}"/>
   <!-- InstanceEndEditable --></h2>

   </td>
     </tr>

  <tr height="100%">

   <td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
   
	<h:form  styleClass="form" id="form1" enctype="multipart/form-data">
   		<table border="1">
   		<tbody>
   			<tr>   				
				<td class="Tit04Tabla"><h:outputText styleClass="outputText"
					id="lblBuscar"
					value="#{rcs['buscar.titulo']}"></h:outputText></td>
				<td class="odd"><h:inputText styleClass="inputText"
					id="txtBuscar"
					value="#{clienteController.criterioBusqueda}"></h:inputText>
					<h:message errorClass="error" infoClass="info" styleClass="error"
					id="msgtxtBuscar" for="txtBuscar"></h:message>
				</td>
			</tr>			
		</tbody>
	</table>
	<h:commandButton type="submit"
				value="#{rcs['buscar.boton.codigo']}"
				styleClass="commandButton" id="btnBuscarCodigo"
				action="#{clienteController.buscarPorCodigo}">
	</h:commandButton>
	<h:commandButton type="submit"
				value="#{rcs['buscar.boton.descripcion']}"
				styleClass="commandButton" id="btnBuscarNombre"
				action="#{clienteController.buscarPorDescripcion}">
	</h:commandButton>
	<br/>
	<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"/>
	<br/>
   <h:dataTable border="1" columnClasses="" headerClass="Tit04Tabla"
				footerClass="Tit04Tabla" rowClasses="even,odd"
				styleClass="dataTable" id="table1"
				value="#{clienteController.clientes}" var="clientes" rows="20">		
		<h:column id="Columna1">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.codigo']}"
					id="lbl1"></h:outputText>
			</f:facet>
				<h:outputText styleClass="outputText" id="text1"
						value="#{clientes.pvLoCodigo}">
			    </h:outputText>
		</h:column>
		<h:column id="Columna2">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.nombre']}"
					id="lbl2"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text2"
					value="#{clientes.pvStNombre}">					
			</h:outputText>
		</h:column>
		<h:column id="Columna3">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.direccion']}"
					id="lbl3"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text3"
				value="#{clientes.pvStDireccion}">
			</h:outputText>			
		</h:column>
		<h:column id="Columna4">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.email']}"
					id="lbl4"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text4"
				value="#{clientes.pvStEmail1}">
			</h:outputText>			
		</h:column>
		<h:column id="Columna7">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.email']}"
					id="lbl7"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text7"
				value="#{clientes.pvStEmail2}">
			</h:outputText>			
		</h:column>
		<h:column id="Columna5">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.fax']}"
					id="lbl5"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text5"
				value="#{clientes.pvLofax}">
			</h:outputText>			
		</h:column>		
		<h:column id="Columna6">
			<f:facet name="header">
				<h:outputText styleClass="outputText"
					value="#{rcs['cliente.estado']}"
					id="lbl6"></h:outputText>
			</f:facet>			
			<h:outputText styleClass="outputText" id="text6"
				value="#{clientes.pvInestado}">
			</h:outputText>			
		</h:column>
	</h:dataTable>
	<t:dataScroller for="table1" fastStep="10" pageCountVar="pageCount"
				pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
				paginatorMaxPages="9" paginatorTableClass="paginator"
				paginatorActiveColumnStyle="font-weight:bold;" immediate="true">
		<f:facet name="first">
			<t:graphicImage url="theme/arrow-first.gif" border="1" />
		</f:facet>
		<f:facet name="last">
			<t:graphicImage url="theme/arrow-last.gif" border="1" />
		</f:facet>
		<f:facet name="previous">
			<t:graphicImage url="theme/arrow-previous.gif" border="1" />
		</f:facet>
		<f:facet name="next">
			<t:graphicImage url="theme/arrow-next.gif" border="1" />
		</f:facet>
		<f:facet name="fastforward">
			<t:graphicImage url="theme/arrow-ff.gif" border="1" />
		</f:facet>
		<f:facet name="fastrewind">
			<t:graphicImage url="theme/arrow-fr.gif" border="1" />
		</f:facet>
	</t:dataScroller>
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
