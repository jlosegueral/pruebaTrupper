package com.mx.jorge.examen.entyties;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ListaCompraDetallePk implements Serializable{

	private static final long serialVersionUID = -1957568485386265304L;
	
	@Column(name= "id_lista")
	private Long idLista;
	
	@Column(name = "id_producto")
	private Long idProducto;

	public ListaCompraDetallePk() {
		
	}

	public ListaCompraDetallePk(Long idLista, Long idProducto) {
		this.idLista = idLista;
		this.idProducto = idProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLista, idProducto);
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
		return Objects.equals(idLista, other.idLista) && Objects.equals(idProducto, other.idProducto);
	}
	
	
}
