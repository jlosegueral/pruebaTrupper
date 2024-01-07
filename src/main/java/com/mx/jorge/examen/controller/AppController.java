package com.mx.jorge.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jorge.examen.models.RequestPostListaCompra;
import com.mx.jorge.examen.models.RequestPutActualizarListaByClienteId;
import com.mx.jorge.examen.service.ICrudListaDetalle;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
	private ICrudListaDetalle service;
	
	@PostMapping("/crearLista")
	public ResponseEntity<?> create(@RequestBody RequestPostListaCompra request) {
		return ResponseEntity.ok(service.crearListaCompra(request));
	}
	
	@GetMapping("/verListaByClienteId/{id}")
	public ResponseEntity<?> getListaComprasByClienteId(@PathVariable Long id) {
		return ResponseEntity.ok(service.getListaComprasByCustomerId(id));
	}

	@PutMapping("/actualizarListaByClienteId")
	public ResponseEntity<?> actualizarListaComprasByClienteId(
			@RequestBody RequestPutActualizarListaByClienteId request) {
		return ResponseEntity.ok(service.actualizaListaByCustomerId(request));
	}

	@DeleteMapping("/borrarListaById/{id}")
	public ResponseEntity<?> borrarListaById(@PathVariable Long id) {
		return ResponseEntity.ok(service.deleteListaByCustomerId(id));
	}

}
