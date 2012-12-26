<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />

<!-- saved from url=(0014)about:internet -->

<html lang="es"><!-- InstanceBegin template="/Templates/plantilla.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Content-Type"         content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type"   content="text/css">
    <meta http-equiv="X-UA-Compatible"      content="IE=EmulateIE7"/> 
	<!-- InstanceBeginEditable name="doctitle" -->
<title>Shiatsu - Inicio </title>
<!-- InstanceEndEditable --> 
	<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
	<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
	<%@ taglib uri="http://www.jenia.org/jsf/popup" prefix="jp" %>
	<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <link href="html5/normalize.css"                rel="stylesheet" type="text/css" /> 
    <link href="html5/plantilla_html5.css"          rel="stylesheet" type="text/css" />
    <link href="theme/hmenu/src/skin-modern3.css"   rel="stylesheet" type="text/css" />
    <link href="theme/styles/SIGETR.css"            rel="stylesheet" type="text/css" />
    <link href="theme/styles/shiatzu.css"              rel="stylesheet" type="text/css" />
    <link href="theme/styles/menu.css"              rel="stylesheet" type="text/css" />
    <link href="theme/styles/stylesheet.css"        rel="stylesheet" type="text/css" />
    <link href="theme/styles/tablas.css"            rel="stylesheet" type="text/css" />
    <link href="theme/stylesheet.css"               rel="stylesheet" type="text/css" />
    <link href="theme/tabpanel.css"                 rel="stylesheet" type="text/css" />
    <link href="theme/Master.css"                   rel="stylesheet" type="text/css" />
    
    <script type="text/javascript" src="html5/jquery.js"></script> 
    <script type="text/javascript" src="html5/plantilla_html5.js"></script> 
    <script type="text/javascript" src="theme/hmenu/src/hmenu.js"></script>
    <script type="text/javascript">document.writeln("<style type='text/css'>#menu { display: none; }</style>");</script>    
</head> 

<f:view locale="es-CR">
    <f:loadBundle var="rcs" basename="com.shiatsu.web.bundles.recursos" />
        <body onload="DynarchMenu.setup('menu'); getFocus();">
            <div id="wrap"> 
                <header id="tablaBanner">
                </header>
                <nav>
                    <h:form id="formBanner" >
                        
                            <div id="menus">
                                <div id="tarjeta" class="flotarIzquierda"> 
                                        <h:outputText styleClass="outputText" id="tarjeta" value="Shiatzu"/>  
                                </div>
                                <div id="menu_fecha" class="flotarDerecha">
                                    <script language="JavaScript">mostrarFecha();</script> - <h:outputText value="#{rcs['version']}"></h:outputText>
                                </div> 
                                <div id="menu_mes_contable" class="flotarDerecha">
                                    <label></label>  
                                </div>
                            </div>
                            <div style="clear: both"></div>
                            <div id="raya_amarilla"></div>
                            <div id="menu_page">
								<ul id="menu">	 
								<li><a href="Templates/shiatsuInicio.jsf?init=true">Inicio</a></li>
								<li>Cat&aacute;logos
								  <ul>
									<li>Clientes
									  <ul>
										<li><a href="shiatsuActCliente.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsClientes.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaClientes.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Enfermedad
									  <ul>
										<li><a href="shiatsuActEnfermedad.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsEnfermedad.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaEnfermedad.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Medicamento
									  <ul>
										<li><a href="shiatsuActMedicamaento.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsMedicamento.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaMedicamento.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Tipo Alopecia
									  <ul>
										<li><a href="shiatsuActTipoAlopecia.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsTipoAlopecia.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaTipoAlopecia.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Pa&iacute;s 
									  <ul>
										<li><a href="shiatsuActPais.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsPais.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaPais.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Profesi&oacute;n
									  <ul>
										<li><a href="shiatsuActProfesion.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsProfesion.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaProfesion.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
								  </ul>
								</li>
								<li><a href="#">Salir</a> </li>
							  </ul> 
                      </div> 
                  </h:form>
                </nav>
                <section id="main"> 
                    <div id="titulo" class="Tit_04_naranja">
					<!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.tarjeta.mantenimiento']}"/><!-- InstanceEndEditable -->
                    </div>
                    <div id="cuerpo" class="Text">
						<!-- InstanceBeginEditable name="contenido" -->
					
					<h:form  styleClass="form" id="form1"  >
					<h:inputHidden value="#{tarjetaController.init}" ></h:inputHidden>
					   		<table border="0">
					<tbody>
						<tr>
					  		<td class="Tit04Tabla">
					  			<h:outputText styleClass="outputText" id="txt1" value="#{rcs['tarjeta.codigo']}"></h:outputText>
						    </td>
					  	    <td class="formPaddingData">
					  	    	<h:inputText styleClass="inputText" id="txtPvInCodigo"
					  	    				 value="#{tarjetaController.tarjeta.pvInCodigo}" size="10" maxlength="10" >
					  	    	</h:inputText> 
					  	    	<h:message styleClass="error" id="msgTxtPvInCodigo" for="txtPvInCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
					  	   </td>
					    </tr>
					      
					 <tr>
				  	   	
				  	    
				    </tr> 
			        <tr>
			            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblFrecuenciaCita" value="#{rcs['tarjeta.estado']}"></h:outputText></td>
			            <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvStEstado" value="#{tarjetaController.tarjeta.pvStEstado}">
												<f:selectItems value="#{tarjetaController.estadoItems}"/>
								</h:selectOneMenu>
			                <h:message styleClass="error" id="msgCmbPvStEstado" for="cmbPvStEstado" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
			            </td>
			        </tr>
			        <tr>
			            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lbltarjeta" value="#{rcs['tarjeta.descripcion']}"></h:outputText></td>
			            <td class="formPaddingData">
				  	    	
			            <h:inputText styleClass="inputText" id="txtPvStDescripcion" value="#{tarjetaController.tarjeta.pvStDescripcion}" size="50" maxlength="50">
					  	    	</h:inputText><h:message styleClass="error" id="msgTxtPvStDescripcion" for="txtPvStDescripcion" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
			        </tr> 
			         
			        <tr>
			            
			            
			        </tr>
			      	
			        
					<tr>
			            <td colspan="2">
				            <h:commandButton type="submit" value="#{rcs['boton.buscar']}"   styleClass="commandButton" id="btnBuscar"   action="#{tarjetaController.buscar}"></h:commandButton>
				            
				            
				            
			            </td>
			        </tr>
					</tbody>
				</table>
	
						<br/>
						<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"/>
						<br/>
						 
					   <h:dataTable border="0" columnClasses="" headerClass="Tit04Tabla"
									footerClass="Tit04Tabla" rowClasses="even,odd"  
									styleClass="dataTable" id="table1"
									value="#{tarjetaController.lista}" var="var" rows="20" 
									binding="#{tarjetaController.listaDataTable}">		
							
							<h:column id="Columna1">
								<f:facet name="header">
									<h:outputText styleClass="outputText"
										value="#{rcs['tarjeta.codigo']}"
										id="lbl1"></h:outputText>
								</f:facet>
										<h:outputText styleClass="pad-right" id="text1"
											value="#{var.pvInCodigo}">
										</h:outputText>
										<f:attribute value="center" name="align" />
							</h:column>
							
							<h:column id="Columna2">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['tarjeta.estado']}"
										id="lbl2"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text2"
									value="#{var.estadoDescripcion}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
							
							<h:column id="Columna3">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['tarjeta.descripcion']}"
										id="lbl3"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text3"
										value="#{var.pvStDescripcion}">					
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
					
	</h:form>
					<!-- InstanceEndEditable -->   
                    </div>
                </section>
            </div>
            <div id="footer">
                <footer>
                </footer>
            </div> 
            <form method="post" action="Templates/ibm_security_logout" name="logout" id="logout">
                <input type="hidden" name="logoutExitPage" value="main.jsf" />
            </form>   
        </body>
    </f:view>
<!-- InstanceEnd --></html>