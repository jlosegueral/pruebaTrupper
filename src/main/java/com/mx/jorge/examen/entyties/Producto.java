package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = -1731879658691742725L;
	
	@Id
	private Long idProducto;
	
	@Column(length = 15)
	private String clave;
	
	@Column(length = 150)
	private String descripcion;
	
	private byte activo;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private Set<ListaCompraDetalle> listaDetalle;

	public Producto() {

	}

	public Producto(Long idProducto, String clave, String descripcion, byte activo,
			Set<ListaCompraDetalle> listaDetalle) {
		this.idProducto = idProducto;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
		this.listaDetalle = listaDetalle;
	}

	public Set<ListaCompraDetalle> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(Set<ListaCompraDetalle> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}
	
}
