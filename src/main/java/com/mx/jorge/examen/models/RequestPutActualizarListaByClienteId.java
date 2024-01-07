package com.mx.jorge.examen.models;

import java.util.List;

import com.mx.jorge.examen.dao.ProductoDao;

public class RequestPutActualizarListaByClienteId {
	
	private Long idCliente;
	private String nombreLista;
	private String nombreListaActualizada;
	private List<ProductoDao> productos;
	
	public RequestPutActualizarListaByClienteId() {
	
	}

	public RequestPutActualizarListaByClienteId(Long idCliente, String nombreLista, String nombreListaActualizada,
			List<ProductoDao> productos) {
		super();
		this.idCliente = idCliente;
		this.nombreLista = nombreLista;
		this.nombreListaActualizada = nombreListaActualizada;
		this.productos = productos;
	}

	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	
	public String getNombreListaActualizada() {
		return nombreListaActualizada;
	}

	public void setNombreListaActualizada(String nombreListaActualizada) {
		this.nombreListaActualizada = nombreListaActualizada;
	}

	public List<ProductoDao> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDao> productos) {
		this.productos = productos;
	}

}
