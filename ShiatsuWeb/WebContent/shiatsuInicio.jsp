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
<link href="theme/css/estilo.css" rel="stylesheet" type="text/css" />

<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
</head>
<f:view locale="es_CR">
<f:loadBundle var="rcs" basename="com.shiatsu.web.bundles.recursos" />
<body bgcolor="#ffffff">
<div class="header" id="menu">
        <div id="logo"><a id="siteLogo"><img src="images/logo.gif"  alt="Some text about the site"/></a></div>
        <ul class="nav">
            <li><a href="#">Inicio</a></li>
            <li><a href="#">Login</a></li>
            <li><a href="#">Servicios</a>
                <ul>
                    <li><a href="#">sub1</a></li>
                    <li><a href="#">sub2</a></li>
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
                <ul>
                    <li><a href="#">sub1</a></li>
                    <li><a href="#">sub2</a></li>
                    <li><a href="#">sub3</a></li>
                </ul>
            </li>
            <li><a href="#">Contacto</a></li>
        </ul>
    </div>
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
      <tr>
       <td height="50" valign="top">
        <h2><!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.inicio']}"/><!-- InstanceEndEditable --></h2>
       </td>
      </tr>
	  <tr height="100%">
   		<td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
<h3>
			

</h3>
	    
<ul id="menu">

		<li><a href="inicio.jsf">Inicio</a></li>
		<li><a>Consultas</a>	
				<ul>
					<li>APP
						<ul>
							<li><a href="#">Listar APP</a></li>
						</ul>
					</li>
					<li>Categorias
						<ul>
							<li><a href="chronoManConCategorias.jsf?init=true">Listar Categorias</a></li>
						</ul>
					</li>
					<li>CRM
						<ul>
							<li>Clientes
								<ul>
									<li><a href="chronoManConClientes.jsf?init=true">Listar Clientes</a></li>
								</ul>
							</li>
							<li>Contactos
								<ul>
									<li><a href="chronoManConContactos.jsf?init=true">Listar Contactos</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li>Proyectos
						<ul>
							<li>Actividades
								<ul>
									<li><a href="#">Listar Actividades</a></li>
									<li><a href="#">Listar Actividades repetitivas</a></li>
								</ul>
							</li>
							<li><a href="#">Listar Proyectos</a></li>	
						</ul>
					</li>
					<li>Funcionarios
						<ul>
							<li><a href="chronoManConFuncionarios.jsf?init=true">Listar Funcionarios</a></li>
							<li><a href="#">Horario del funcionario</a> </li>
						</ul>
					</li>
				</ul>
			</li> 
			<li><a>Configuraci&oacute;n</a>	
				<ul>
					<li>APP
						<ul>
							<li><a href="#">Listar APP</a></li>
						</ul>
					</li>
					<li>Categorias
						<ul>
							<li><a href="chronoManListCategorias.jsf?init=true">Listar Categorias</a></li>
						</ul>
					</li>
					<li>Control de Tiempo
						<ul>
						    <li><a href="#">Mantenimiento Control Horas Laboradas</a></li>	
							<li><a href="#">Listar Control Horas Laboradas</a></li>	
						</ul>
					</li>
					<li>CRM
						<ul>
							<li>Clientes
								<ul>
									<li><a href="chronoManListClientes.jsf?init=true">Listar Clientes</a></li>
								</ul>
							</li>
							<li>Contactos
								<ul>
									<li><a href="chronoManListContactos.jsf?init=true">Listar Contactos</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li>Proyectos
						<ul>
							<li>Actividades
								<ul>
									<li><a href="#">Listar Actividades</a></li>
									<li><a href="#">Actividades repetitivas</a></li>
								</ul>
							</li>
							<li><a href="#">Listar Proyectos</a></li>
						</ul> 
					</li> 
					<li>Funcionarios
						<ul>
							<li><a href="chronoManListFuncionarios.jsf?init=true">Listar Funcionarios</a></li>

							<li><a href="#">Horario del funcionario</a></li>
						</ul>
					</li>
				</ul>
			</li> 
			<li><a>Reportes</a>	
				<ul> 
					<li>Actividades Proyecto</li>
					<li>Contactos Cliente</li> 
					<li>Funcionario Actividad Tiempo</li> 
					<li>Funcionario por Actividad</li>
				</ul>
			</li>
		 </ul>
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