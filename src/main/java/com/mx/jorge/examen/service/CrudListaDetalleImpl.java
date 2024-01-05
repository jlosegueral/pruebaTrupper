package com.mx.jorge.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jorge.examen.entyties.Cliente;
import com.mx.jorge.examen.models.RequestPostListaCompra;
import com.mx.jorge.examen.models.ResponsePostListaCompra;
import com.mx.jorge.examen.repositories.ClienteRepository;

@Service
public class CrudListaDetalleImpl implements ICrudListaDetalle {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public ResponsePostListaCompra crearListaCompra(RequestPostListaCompra request) {
		
		
		
		
		return null;
	}

	@Override
	public List<Cliente> getClientes() {
		return (List<Cliente>) repository.findAll();
	}
		

}
