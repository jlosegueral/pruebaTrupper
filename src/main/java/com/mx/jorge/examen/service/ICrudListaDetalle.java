package com.mx.jorge.examen.service;

import java.util.List;

import com.mx.jorge.examen.entyties.Cliente;
import com.mx.jorge.examen.models.RequestPostListaCompra;
import com.mx.jorge.examen.models.ResponsePostListaCompra;

public interface ICrudListaDetalle {
	
	ResponsePostListaCompra crearListaCompra (RequestPostListaCompra request);
	
	List<Cliente> getClientes();

}
