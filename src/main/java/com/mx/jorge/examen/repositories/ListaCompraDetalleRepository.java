package com.mx.jorge.examen.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mx.jorge.examen.entyties.ListaCompraDetalle;
import com.mx.jorge.examen.entyties.ListaCompraDetallePk;

public interface ListaCompraDetalleRepository extends CrudRepository<ListaCompraDetalle, ListaCompraDetallePk> {

}
