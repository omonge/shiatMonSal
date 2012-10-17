package com.vvs.chrono.web.bundles;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * <p>Clase com.vvs.chrono.web.bundles.Bundle.java</p>
 * <p>Modulo (subsistema): ChronoManager</p>
 * <p>Descripción de <code>Bundle.java</code>. Clase que define los paquetes en que se encuntran los recursos.</p>
 * <p>Fecha creación: 24/10/2009</p>
 * <p>Ultima actualización: 24/10/2009</p>
 * @author Vista Verde Tecnologia (omonge@vistaverdesoft.com)
 * @version 1.1
 */
public class Bundle {
    /** Atributo <code>CHRONO_BUNDLES_RESOURCES</code> define el la dirección del paquete y del archivo en que se encuentran las etiquetas del programa.*/
    private static final String CHRONO_BUNDLES_RESOURCES = "com.vvs.chrono.web.bundles.recursos";
    
    public static final PropertyResourceBundle rcs = (PropertyResourceBundle) ResourceBundle.getBundle(Bundle.CHRONO_BUNDLES_RESOURCES);
}
