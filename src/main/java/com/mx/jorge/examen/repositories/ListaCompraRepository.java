package com.mx.jorge.examen.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mx.jorge.examen.entyties.Cliente;
import com.mx.jorge.examen.entyties.ListaCompra;

public interface ListaCompraRepository extends CrudRepository<ListaCompra, Long>{
	
	List<ListaCompra> findByCliente(Cliente cliente);
	
	List<ListaCompra> findByClienteAndNombre(Cliente cliente, String nombre);

}
