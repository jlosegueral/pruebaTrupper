package com.mx.jorge.examen.dao;

import java.util.List;

public class ListaCompraDao {
	
private String nombreLista;
	
	private List<ProductoDao> productos;

	public ListaCompraDao() {
	}

	public ListaCompraDao(String nombreLista, List<ProductoDao> productos) {
		super();
		this.nombreLista = nombreLista;
		this.productos = productos;
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	public List<ProductoDao> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDao> productos) {
		this.productos = productos;
	}

}
