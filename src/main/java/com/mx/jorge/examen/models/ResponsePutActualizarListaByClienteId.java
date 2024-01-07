package com.mx.jorge.examen.models;

public class ResponsePutActualizarListaByClienteId {
	
	private RequestPutActualizarListaByClienteId request;
	private String mensaje;
	
	public ResponsePutActualizarListaByClienteId() {
	
	}

	public ResponsePutActualizarListaByClienteId(RequestPutActualizarListaByClienteId request, String mensaje) {
		super();
		this.request = request;
		this.mensaje = mensaje;
	}

	public RequestPutActualizarListaByClienteId getRequest() {
		return request;
	}

	public void setRequest(RequestPutActualizarListaByClienteId request) {
		this.request = request;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
