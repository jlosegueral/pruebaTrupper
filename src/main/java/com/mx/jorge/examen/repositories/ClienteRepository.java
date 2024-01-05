package com.mx.jorge.examen.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mx.jorge.examen.entyties.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
