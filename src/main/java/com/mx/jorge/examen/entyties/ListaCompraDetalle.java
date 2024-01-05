package com.mx.jorge.examen.entyties;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "lista_compra_detalle")
public class ListaCompraDetalle implements Serializable{

	private static final long serialVersionUID = 9179046891194503059L;
	
	@EmbeddedId
	private ListaCompraDetallePk pk;
	
	@ManyToOne
	@MapsId("idLista")
	@JoinColumn(name = "id_lista", nullable = false)
	@JsonBackReference
	private ListaCompra listaCompra;
	
	@ManyToOne
	@MapsId("idProducto")
	@JoinColumn(name = "id_producto", nullable = false)
	@JsonBackReference
	private Producto producto;
	
	private int cantidad;

	public ListaCompraDetalle() {
		
	}

	public ListaCompraDetalle(ListaCompraDetallePk pk, ListaCompra listaCompra, Producto producto, int cantidad) {
		super();
		this.pk = pk;
		this.listaCompra = listaCompra;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public ListaCompraDetallePk getPk() {
		return pk;
	}

	public void setPk(ListaCompraDetallePk pk) {
		this.pk = pk;
	}

	public ListaCompra getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
