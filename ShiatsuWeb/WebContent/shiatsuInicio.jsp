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
                    		<h2><!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.inicio']}"/><!-- InstanceEndEditable --></h2>
                   		</td>
                  	</tr>
                  	<tr height="100%">
                    	<td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
		
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