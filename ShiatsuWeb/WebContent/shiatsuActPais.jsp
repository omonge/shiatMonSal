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
                                <div id="usuario" class="flotarIzquierda"> 
                                        <h:outputText styleClass="outputText" id="usuario" value="Shiatzu"/>  
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
									<li>Tipo Alopecia
									  <ul>
										<li><a href="shiatsuActTipoAlopecia.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConstipoAlopecia.jsf?init=true">Consulta</a></li> 
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
					<!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.pais.mantenimiento']}"/><!-- InstanceEndEditable -->
                    </div>
                    <div id="cuerpo" class="Text">
						<!-- InstanceBeginEditable name="contenido" -->
       <h:form  styleClass="form" id="form1" >
       <h:inputHidden value="#{paisController.init}" ></h:inputHidden>
   <table border="0">
		<tbody>
		<c:if test="${!paisController.agregar}">	
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="lnlPvInCodigo" value="#{rcs['pais.codigo']}"></h:outputText>
			    </td>
		  	    <td class="formPaddingData">
		  	    	<h:inputText styleClass="inputText" id="txtPvInCodigo"
		  	    				 value="#{paisController.pais.pvInCodigo}" size="10" maxlength="10" disabled="#{!paisController.agregar}">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTtxtPvInCodigo" for="txtPvInCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
		    </tr>
		    </c:if>
        <tr>
            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblPvStDescripcion" value="#{rcs['pais.descripcion']}"></h:outputText></td>
            <td class="formPaddingData">
              	<h:inputText styleClass="inputText" id="txtPvStDescripcion" 
	  	    				 value="#{paisController.pais.pvStDescripcion}" size="50" maxlength="50" style="text-transform: uppercase">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtPvStDescripcion" for="txtPvStDescripcion" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        
        <c:if test="${!paisController.agregar}">	
			<tr>
	            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblEstado" value="#{rcs['pais.estado']}"/></td>
	            <td class="formPaddingData">
	                <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInEstado" value="#{paisController.pais.pvStEstado}">
									<f:selectItems value="#{paisController.estadoItems}"/>
					</h:selectOneMenu>
	                <h:message styleClass="error" id="msgTxtEstado" for="cmbPvInEstado" errorClass="error" infoClass="info" warnClass="warn"/>
	            </td>
	        </tr>
		</c:if>
		<tr>
            <td colspan="2">
	            <h:commandButton type="submit" value="#{rcs['boton.agregar']}"   styleClass="commandButton" id="btnAgregar"   rendered="#{paisController.agregar}" 	action="#{paisController.insertar}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.modificar']}" styleClass="commandButton" id="btnModificar" rendered="#{!paisController.agregar}" 	action="#{paisController.modificar}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.eliminar']}"  styleClass="commandButton" id="btnEliminar"  rendered="#{!paisController.agregar}"  	action="#{paisController.eliminar}" onclick="return confirmEliminar('e','pais');"></h:commandButton>
			    <h:commandButton type="submit" value="#{rcs['boton.regresar']}"  styleClass="commandButton" id="bntRegresar"  action="#{paisController.regresar}"></h:commandButton>	            
            </td>
        </tr>
		</tbody>
	</table>
		
		<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"></h:messages>
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