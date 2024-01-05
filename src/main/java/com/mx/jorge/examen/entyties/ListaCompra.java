package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "lista_compra")
public class ListaCompra implements Serializable{

	private static final long serialVersionUID = 5249843392768585698L;
	
	@Id
	private Long idLista;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
	private Cliente cliente;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaUltimaActualizacion;
	
	private byte activo;
	
	@OneToMany
	@JsonBackReference
	private Set<ListaCompraDetalle> listaDetalle;

	public ListaCompra() {

	}
	
	
	public ListaCompra(Long idLista, Cliente cliente, String nombre, LocalDateTime fechaRegistro,
			LocalDateTime fechaUltimaActualizacion, byte activo, Set<ListaCompraDetalle> listaDetalle) {
		super();
		this.idLista = idLista;
		this.cliente = cliente;
		this.nombre = nombre;
		this.fechaRegistro = fechaRegistro;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.activo = activo;
		this.listaDetalle = listaDetalle;
	}

	
	public Long getIdLista() {
		return idLista;
	}


	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public LocalDateTime getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}


	public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}


	public byte getActivo() {
		return activo;
	}


	public void setActivo(byte activo) {
		this.activo = activo;
	}


	public Set<ListaCompraDetalle> getListaDetalle() {
		return listaDetalle;
	}


	public void setListaDetalle(Set<ListaCompraDetalle> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}


	@PrePersist
	protected void createLocalDate() {
		fechaRegistro = LocalDateTime.now();
	}
	

}
