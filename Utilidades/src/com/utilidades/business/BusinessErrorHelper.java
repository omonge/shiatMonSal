package com.utilidades.business;

import java.util.Map;
import java.util.TreeMap;

public class BusinessErrorHelper extends Exception{
	@SuppressWarnings("rawtypes")
	private Map errors;
	@SuppressWarnings("rawtypes")
	public BusinessErrorHelper() {
		 super();
	     this.errors = new TreeMap();
	}
	
	/**
	 * @return the errors
	 */
	@SuppressWarnings("rawtypes")
	public Map getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	@SuppressWarnings("rawtypes")
	public void setErrors(Map errors) {
		this.errors = errors;
	}

}
