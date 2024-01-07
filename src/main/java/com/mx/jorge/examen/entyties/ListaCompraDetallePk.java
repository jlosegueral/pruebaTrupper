package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ListaCompraDetallePk implements Serializable{
	
	private static final long serialVersionUID = -8095322390249712235L;
	
	@Column(name = "id_lista")
	private Long idLista;
	
	@Column(name = "id_producto")
	private Long idProducto;
	
	public ListaCompraDetallePk() {

	}

	public ListaCompraDetallePk(Long idProducto, Long idLista) {
		super();
		this.idProducto = idProducto;
		this.idLista = idLista;
	}
	

	public Long getIdCliente() {
		return idProducto;
	}

	public void setIdCliente(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdLista() {
		return idLista;
	}

	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(idProducto, idLista);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCompraDetallePk other = (ListaCompraDetallePk) obj;
		return Objects.equals(idProducto, other.idProducto) && Objects.equals(idLista, other.idLista);
	}
	
}
