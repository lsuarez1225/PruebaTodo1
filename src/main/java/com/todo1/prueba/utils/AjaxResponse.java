package com.todo1.prueba.utils;

public class AjaxResponse {

	private String status;
	private Object object;
	
	public AjaxResponse () {
		
	}
	
	public AjaxResponse (String status, Object object) {
		this.status = status;
		this.object = object;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
