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
                    		<h2><!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.cliente.lista']}"/><!-- InstanceEndEditable --></h2>
                   		</td>
                  	</tr>
                  	<tr height="100%">
                    	<td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
					<div align="center">
					<h:form  styleClass="form" id="form1" enctype="multipart/form-data">
					   		<table border="0">
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
					   <h:dataTable border="0" columnClasses="" headerClass="headerStyle"
									footerClass="Tit04Tabla" rowClasses="even,odd"
									styleClass="dataTable" id="table1"
									value="#{clienteController.clientes}" var="clientes" rows="20" 
									binding="#{clienteController.dataTableClientes}">		
							<h:column id="Columna1">
								<f:facet name="header">
									<h:outputText styleClass="outputText"
										value="#{rcs['cliente.codigo']}"
										id="lbl1"></h:outputText>
								</f:facet>
									<h:commandLink styleClass="commandLink" id="link1" action="#{clienteController.cargarObjeto}">
										<h:outputText styleClass="pad-right" id="text1"
											value="#{clientes.pvLoCodigo}">
										</h:outputText>
										<f:attribute value="center" name="align" />
									</h:commandLink>
							</h:column>
							<h:column id="Columna2">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.nombre']}"
										id="lbl2"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text2"
										value="#{clientes.pvStNombre}">					
								</h:outputText>
								<f:attribute value="center" name="align" />
							</h:column>
							<h:column id="Columna3">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.direccion']}"
										id="lbl3"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text3"
									value="#{clientes.pvStDireccion}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
							<h:column id="Columna4">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.email']}"
										id="lbl4"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text4"
									value="#{clientes.pvStEmail1}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
							<h:column id="Columna5">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.telefonoCasa']}"
										id="lbl5"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text5"
									value="#{clientes.pvLoTelefonoCasa}">
								</h:outputText>			
								<f:attribute value="center" name="align" />
							</h:column>		
							<h:column id="Columna6">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.telefonoCelular']}"
										id="lbl6"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text6"
									value="#{clientes.pvLoTelefonoCelular}">
								</h:outputText>			
								<f:attribute value="center" name="align" />
							</h:column>	
							<h:column id="Columna7">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['cliente.estado']}"
										id="lbl7"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text7"
									value="#{clientes.pvStEstadoDescripcion}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
						</h:dataTable>
						<t:dataScroller for="table1" fastStep="10" pageCountVar="pageCount"
									pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
									paginatorMaxPages="9" paginatorTableClass="paginator"
									paginatorActiveColumnStyle="font-weight:bold;" immediate="true">
							<f:facet name="first">
								<t:graphicImage url="theme/arrow-first.gif" />
							</f:facet>
							<f:facet name="last">
								<t:graphicImage url="theme/arrow-last.gif" />
							</f:facet>
							<f:facet name="previous">
								<t:graphicImage url="theme/arrow-previous.gif" />
							</f:facet>
							<f:facet name="next">
								<t:graphicImage url="theme/arrow-next.gif" />
							</f:facet>
							<f:facet name="fastforward">
								<t:graphicImage url="theme/arrow-ff.gif" />
							</f:facet>
							<f:facet name="fastrewind">
								<t:graphicImage url="theme/arrow-fr.gif"  />
							</f:facet>
						</t:dataScroller>					
						<p>
							<h:commandButton type="submit" value="#{rcs['boton.agregar']}" styleClass="commandButton" id="button1" action="#{clienteController.irAgregar}"></h:commandButton>
						</p>
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