package com.mx.jorge.examen.dao;

public class ProductoDao {
	
	private Long idProdcto;
	
	private int cantidadProducto;

	public ProductoDao() {
		
	}

	public ProductoDao(Long idProdcto, int cantidadProducto) {
		super();
		this.idProdcto = idProdcto;
		this.cantidadProducto = cantidadProducto;
	}

	public Long getIdProdcto() {
		return idProdcto;
	}

	public void setIdProdcto(Long idProdcto) {
		this.idProdcto = idProdcto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
	
}
