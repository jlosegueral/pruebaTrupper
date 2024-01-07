package com.mx.jorge.examen.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mx.jorge.examen.entyties.ListaCompra;
import com.mx.jorge.examen.entyties.ListaCompraDetalle;
import com.mx.jorge.examen.entyties.ListaCompraDetallePk;
import com.mx.jorge.examen.entyties.Producto;

public interface ListaCompraDetalleRepository extends CrudRepository<ListaCompraDetalle, ListaCompraDetallePk> {
	
	List<ListaCompraDetalle> findByListaCompra(ListaCompra listaCompra);
	
	List<ListaCompraDetalle> findByListaCompraAndProducto(ListaCompra listaCompra, Producto producto);

}
