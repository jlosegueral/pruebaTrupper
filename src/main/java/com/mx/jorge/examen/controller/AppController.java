package com.mx.jorge.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jorge.examen.entyties.Cliente;
import com.mx.jorge.examen.service.ICrudListaDetalle;

@RestController
public class AppController {
	
	@Autowired
	private ICrudListaDetalle service;
	
	@GetMapping("/get")
	public List<Cliente> getClientesApi(){
		return service.getClientes();
	}

}
