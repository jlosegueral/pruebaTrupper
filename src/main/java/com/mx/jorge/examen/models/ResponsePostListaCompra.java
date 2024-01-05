package com.mx.jorge.examen.models;

public class ResponsePostListaCompra {
	
	private RequestPostListaCompra request;
	
	private String mensaje;

	public ResponsePostListaCompra() {
		 
	}

	public ResponsePostListaCompra(RequestPostListaCompra request, String mensaje) {
		super();
		this.request = request;
		this.mensaje = mensaje;
	}

	public RequestPostListaCompra getRequest() {
		return request;
	}

	public void setRequest(RequestPostListaCompra request) {
		this.request = request;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
