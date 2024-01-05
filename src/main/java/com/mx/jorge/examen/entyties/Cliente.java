package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = -2404793229768249799L;
	
	@Id
	private Long idCliente;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	private byte activo;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List<ListaCompra> listaCompra;

	public Cliente() {

	}

	public Cliente(Long idCliente, String nombre, byte activo, List<ListaCompra> listaCompra) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.activo = activo;
		this.listaCompra = listaCompra;
	}


	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}


	public List<ListaCompra> getListaCompra() {
		return listaCompra;
	}


	public void setListaCompra(List<ListaCompra> listaCompra) {
		this.listaCompra = listaCompra;
	}

}
