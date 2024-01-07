package com.mx.jorge.examen.models;

import java.util.List;

import com.mx.jorge.examen.dao.ListaCompraDao;

public class ResponseGetListaByCustomerId {
	
private Long CustomerId;
	
	private List<ListaCompraDao> listasCompras;
	
	private String mensaje;

	public ResponseGetListaByCustomerId() {
		
	}
	
	public ResponseGetListaByCustomerId(Long customerId, List<ListaCompraDao> listasCompras, String mensaje) {
		super();
		CustomerId = customerId;
		this.listasCompras = listasCompras;
		this.mensaje = mensaje;
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}

	public List<ListaCompraDao> getListasCompras() {
		return listasCompras;
	}

	public void setListasCompras(List<ListaCompraDao> listasCompras) {
		this.listasCompras = listasCompras;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
