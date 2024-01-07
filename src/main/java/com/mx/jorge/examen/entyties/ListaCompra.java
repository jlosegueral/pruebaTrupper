package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

	private static final long serialVersionUID = -5965792719742161179L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
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
	
	private boolean activo;

	@OneToMany(mappedBy = "listaCompra")
	@JsonManagedReference
	private Set<ListaCompraDetalle> listaDetalle;

	public ListaCompra() {

	}

	public ListaCompra(Long idLista, Cliente cliente, String nombre, boolean activo) {
		this.idLista = idLista;
		this.cliente = cliente;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	public ListaCompra(Cliente cliente, String nombre, boolean activo) {
		this.cliente = cliente;
		this.nombre = nombre;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ListaCompraDetalle> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(Set<ListaCompraDetalle> listaDetalle) {
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@PrePersist
	protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
	}

}
