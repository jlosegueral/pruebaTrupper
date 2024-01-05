package com.mx.jorge.examen.models;

import java.util.List;

import com.mx.jorge.examen.dao.ProductoDao;

public class RequestPostListaCompra {
	
	private Long idCliente;
	
	private String nombreLista;
	
	private List<ProductoDao> listaProdctos;

	public RequestPostListaCompra() {

	}

	public RequestPostListaCompra(Long idCliente, String nombreLista, List<ProductoDao> listaProdctos) {
		super();
		this.idCliente = idCliente;
		this.nombreLista = nombreLista;
		this.listaProdctos = listaProdctos;
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

	public List<ProductoDao> getListaProdctos() {
		return listaProdctos;
	}

	public void setListaProdctos(List<ProductoDao> listaProdctos) {
		this.listaProdctos = listaProdctos;
	}

}
