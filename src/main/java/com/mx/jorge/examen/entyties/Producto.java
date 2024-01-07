package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 7335572256546539735L;

	@Id
	@Column(name = "id_producto")
	private Long idProducto;
	
	@Column(length = 15)
	private String clave;
	
	@Column(length = 150)
	private String descripcion;
	
	private boolean activo;
	
	@OneToMany(mappedBy = "producto")
	@JsonManagedReference
	private Set<ListaCompraDetalle> listaDetalle;
	
	public Producto() {
		
	}
	
	public Producto(Long idProducto, String clave, String descripcion, boolean activo,
			Set<ListaCompraDetalle> listaDetalle) {
		super();
		this.idProducto = idProducto;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
		this.listaDetalle = listaDetalle;
	}
	
	public Producto(Long idProducto) {
		super();
		this.idProducto = idProducto;
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

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
