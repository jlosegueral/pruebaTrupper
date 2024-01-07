package com.mx.jorge.examen.models;

public class ResponseDeleteListaByIdCliente {
	
	private Long idLista;
	private String mensaje;
	
	public ResponseDeleteListaByIdCliente() {
		
	}

	public ResponseDeleteListaByIdCliente(Long idLista, String mensaje) {
		super();
		this.idLista = idLista;
		this.mensaje = mensaje;
	}

	public Long getIdLista() {
		return idLista;
	}

	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
