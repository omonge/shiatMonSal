function confirmEliminar(genero,nombreElementoAEliminar)
{
	var textoConfrim = "¿Realmente desea eliminar est" + genero + " " + nombreElementoAEliminar + " ?";
	return confirm(textoConfrim);
}

function confirmProcesar(nombreElementoAModificar)
{
	var textoConfrim = "¿Realmente desea modificar esta " + nombreElementoAModificar + "?";
	return confirm(textoConfrim);
}

function confirmCerrarPlanilla()
{
	var textoConfrim = "¿Realmente desea cerrar esta Fecha de Pago? Si lo realiza no se podrá realizar cambios en la Planilla";
	return confirm(textoConfrim);
}

function confirmAplicarMasivamente()
{
	var textoConfrim = "¿Realmente desea aplicar el Ajuste? El proceso se aplica masivamente a todos los Funcionarios";
	return confirm(textoConfrim);
}

function confirmEliminarMasivamente()
{
	var textoConfrim = "¿Realmente desea eliminar el Ajuste? El proceso se aplica masivamente a todos los Funcionarios";
	return confirm(textoConfrim);
}

function confirmAplicarAguinaldo()
{
	var textoConfrim = "¿Realmente desea aplicar Aguinaldo Masivamente? El proceso se aplica masivamente a todos los Funcionarios";
	return confirm(textoConfrim);
}

function confirmAplicarSalEscolar()
{
	var textoConfrim = "¿Realmente desea aplicar Salario Escolar? El proceso se aplica masivamente a todos los Funcionarios";
	return confirm(textoConfrim);
}

function confirmFeriado()
{
	var textoConfrim = "¿Realmente desea aplicar Feriado? El proceso se aplica masivamente a todos los Funcionarios";
	return confirm(textoConfrim);
}
/**
 * Acopla el campo al formato indicado.	
 * Recibe como parametro el campo y el formato al cual tiene que acloparse el formato.
 * Para el formato el simbolo # representa un numero, ejemplo: 2222-2200 se puede utilizar  
 * el formato '###-####' recibiedolo como parametro
 * La mejor forma de llamar esta funcion es en el evento onKeyPress. 
 * ejemplo: onkeypress = "return maskField(this, '####-##-##', event);"
 */
function maskField(textObj, mask, e, permitePunto){
	var cadena = textObj.value;
	//alert(e.keyCode);
	//var whichCode = (window.Event) ? e.which : e.keyCode;
	var whichCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
	//alert(whichCode);		
	if ((whichCode == 9) || (whichCode == 13) || (whichCode == 8) || (whichCode == 127)) return true;//TAB o Enter o borrar o suprimir
	key = String.fromCharCode(whichCode);  // Get key value from key code
	//alert(key);
	index = cadena.length;
	//alert(index);
	if(mask == "" || mask.length == index){return false;}
	if(mask.charAt(0) == '-' && index==0){ //si la mascara acepta negativos && es la primera letra
		if(isNaN(key) && whichCode != 45) //si no es un numero y es diferente a el '-'
			return false;
	}else{
		if(mask.charAt(0)=='-' && cadena.charAt(0) != '-') //si la mascara acepta negativos y el numero es negativo
			index++; //incrementa el indice para que no permita mas digitos en la mascara
		if(index==mask.length) // cuando se alcance la longitud de la mascara return false
			return false;
		if(mask.charAt(index) == '#'){
			if(isNaN(key) || (whichCode == 32))
			{
				if(permitePunto==1 && (whichCode == 46))
						return true;
				return false;
			}
		}else{
			if(mask.charAt(index) != cadena.charAt(index)){
				if(cadena.indexOf('.') == -1)//validación que no permite dos puntos decimales en la cadena (aplica solo para números)
					textObj.value = cadena + mask.charAt(index);
				if(mask.charAt(index+1) == '#'){
					if(isNaN(key)){
						return false;	
					}
				}
			}
		}	
	}	
	return true;
}

function validaEmail(value){	
	var exp_email1 = /^[A-Za-z][A-Za-z0-9_]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;	
	return exp_email1.test(value);
}

function errorEmail()
{
	var value = document.getElementById('form1:email').value;
	if(!validaEmail(value))	{
		document.getElementById('form1:hiddenEmail').value=-1;
		document.getElementById('form1:mensajeErrorEmail').innerHTML = "Email Invalido";
	}
	else{
		document.getElementById('form1:hiddenEmail').value=1;
		document.getElementById('form1:mensajeErrorEmail').innerHTML = "Email Correcto";
	}	
}

function validaEmailBoton()
{
	var value = document.getElementById('form1:email').value;
	if(!validaEmail(value))	{		
		alert("Email Invalido");
	}
	else{
		alert("Email Correcto");		
	}	
}

function mascaraCedula(objeto,event,tieneHidden)
{
	if(document.getElementById('form1:checkBoxTipoCedula').checked){
		objeto.maxLength=17;
		if(tieneHidden)
			document.getElementById('form1:hidden').value=1;
		return maskField(objeto, '###-######-######', event,0);
	}
	else{
		objeto.maxLength=11;
		if(tieneHidden)
			document.getElementById('form1:hidden').value=0;
		return maskField(objeto, '#-####-####', event,0);
	}
}

function reiniciaCedula()
{
	document.getElementById('form1:txtCedula').value="";
}

