package com.mx.jorge.examen.service;

import com.mx.jorge.examen.models.RequestPostListaCompra;
import com.mx.jorge.examen.models.RequestPutActualizarListaByClienteId;
import com.mx.jorge.examen.models.ResponseDeleteListaByIdCliente;
import com.mx.jorge.examen.models.ResponseGetListaByCustomerId;
import com.mx.jorge.examen.models.ResponsePostListaCompra;
import com.mx.jorge.examen.models.ResponsePutActualizarListaByClienteId;

public interface ICrudListaDetalle {
	
	ResponsePostListaCompra crearListaCompra (RequestPostListaCompra request);
	
	ResponseGetListaByCustomerId getListaComprasByCustomerId(Long idCliente);
	
	ResponsePutActualizarListaByClienteId actualizaListaByCustomerId(RequestPutActualizarListaByClienteId request);
	
	ResponseDeleteListaByIdCliente deleteListaByCustomerId(Long idLista);

}
