package com.mx.jorge.examen.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jorge.examen.dao.ListaCompraDao;
import com.mx.jorge.examen.dao.ProductoDao;
import com.mx.jorge.examen.entyties.Cliente;
import com.mx.jorge.examen.entyties.ListaCompra;
import com.mx.jorge.examen.entyties.ListaCompraDetalle;
import com.mx.jorge.examen.entyties.ListaCompraDetallePk;
import com.mx.jorge.examen.entyties.Producto;
import com.mx.jorge.examen.models.RequestPostListaCompra;
import com.mx.jorge.examen.models.RequestPutActualizarListaByClienteId;
import com.mx.jorge.examen.models.ResponseDeleteListaByIdCliente;
import com.mx.jorge.examen.models.ResponseGetListaByCustomerId;
import com.mx.jorge.examen.models.ResponsePostListaCompra;
import com.mx.jorge.examen.models.ResponsePutActualizarListaByClienteId;
import com.mx.jorge.examen.repositories.ClienteRepository;
import com.mx.jorge.examen.repositories.ListaCompraDetalleRepository;
import com.mx.jorge.examen.repositories.ListaCompraRepository;
import com.mx.jorge.examen.repositories.ProductoRepository;

@Service
public class CrudListaDetalleImpl implements ICrudListaDetalle {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ListaCompraRepository listaCompraRepository;

	@Autowired
	private ListaCompraDetalleRepository listaCompraDetalleRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ResponsePostListaCompra crearListaCompra(RequestPostListaCompra request) {

		List<ProductoDao> listaProductosDaoExistentes = new ArrayList<ProductoDao>();
		List<ProductoDao> listaProductosDaoNoExistentes = new ArrayList<ProductoDao>();
		List<ProductoDao> listaProductopsRequest = request.getListaProdctos();
		ResponsePostListaCompra response = null;

		try {

			Optional<Cliente> cliente = clienteRepository.findById(request.getIdCliente());

			if (cliente.isPresent()) {

				List<ListaCompra> listaCompra = listaCompraRepository.findByClienteAndNombre(cliente.get(),
						request.getNombreLista().toUpperCase());

				if (listaCompra.isEmpty()) {

					if (listaProductopsRequest.isEmpty()) {
						response = new ResponsePostListaCompra(request,
								"No se puede crear una lista sin nigun producto");
					} else {

						Stream<ProductoDao> streamProductos = listaProductopsRequest.stream();

						streamProductos.forEach(p -> {
							Optional<Producto> producto = productoRepository.findById(p.getIdProdcto());

							if (producto.isPresent()) {
								listaProductosDaoExistentes.add(p);
							} else {
								listaProductosDaoNoExistentes.add(p);
							}

						});

						if (listaProductosDaoExistentes.isEmpty()) {
							response = new ResponsePostListaCompra(request,
									"No se puede insertar ningun producto, ya que ninguno existe");
						} else {

							ListaCompra listaNueva = new ListaCompra(cliente.get(),
									request.getNombreLista().toUpperCase(), true);

							listaCompraRepository.save(listaNueva);

							List<ListaCompra> listaInsertada = listaCompraRepository
									.findByClienteAndNombre(listaNueva.getCliente(), listaNueva.getNombre().toUpperCase());

							for (ListaCompra listaCompraI : listaInsertada) {

								for (ProductoDao productoDaoExistente : listaProductosDaoExistentes) {

									ListaCompraDetallePk pk = new ListaCompraDetallePk(listaCompraI.getIdLista(),
											productoDaoExistente.getIdProdcto());
									Producto productoInsertado = new Producto(productoDaoExistente.getIdProdcto());
									ListaCompraDetalle listaCompraDetalle = new ListaCompraDetalle(pk, listaCompraI,
											productoInsertado, productoDaoExistente.getCantidadProducto());

									listaCompraDetalleRepository.save(listaCompraDetalle);

								}
							}

							if (listaProductosDaoNoExistentes.isEmpty()) {
								response = new ResponsePostListaCompra(request,
										"Se creo la lista con los productos o el prodcto");
							} else {

								String mensaje = null;

								for (ProductoDao productoNoExistente : listaProductosDaoNoExistentes) {

									mensaje = (Objects.isNull(mensaje)) ? productoNoExistente.getIdProdcto().toString()
											: mensaje + "," + productoNoExistente.getIdProdcto();

								}

								response = new ResponsePostListaCompra(request,
										"Se creo la lista, pero los siguientes productos no se insertaron: " + mensaje
												+ " por que no existen en el catalogo de productos");

							}

						}

					}

				} else {
					response = new ResponsePostListaCompra(request, "No se puede crear la lista, ya existe la lista: "
							+ request.getNombreLista() + " para el cliente " + request.getIdCliente());
				}

			}

			else {
				response = new ResponsePostListaCompra(request,
						"No se puede crear la lista, ya que el cliente: " + request.getIdCliente() + " no existe");
			}

			return response;

		} catch (Exception e) {

			return new ResponsePostListaCompra(request, "Ocurrio un Error: " + e.getMessage());
		}

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseGetListaByCustomerId getListaComprasByCustomerId(Long idCliente) {
		List<ListaCompraDao> listaCompraDao = new ArrayList<ListaCompraDao>();
		List<ProductoDao> listaProductosDao = new ArrayList<ProductoDao>();

		try {
			Optional<Cliente> cliente = clienteRepository.findById(idCliente);

			if (cliente.isPresent()) {

				List<ListaCompra> listasComprasCliente = listaCompraRepository.findByCliente(cliente.get());

				if (!listasComprasCliente.isEmpty()) {

					for (ListaCompra listaCompra : listasComprasCliente) {

						List<ListaCompraDetalle> listaCompraDetalle = listaCompraDetalleRepository
								.findByListaCompra(listaCompra);

						if (!listaCompraDetalle.isEmpty()) {
							for (ListaCompraDetalle listaCompraDet : listaCompraDetalle) {
								ProductoDao productoDao = new ProductoDao(listaCompraDet.getProducto().getIdProducto(),
										listaCompraDet.getCantidad());
								listaProductosDao.add(productoDao);
							}
						}

						ListaCompraDao lstDao = new ListaCompraDao(listaCompra.getNombre(), listaProductosDao);
						listaCompraDao.add(lstDao);

					}

					if (listaProductosDao.isEmpty()) {
						return new ResponseGetListaByCustomerId(idCliente, listaCompraDao,
								"El Cliente " + idCliente + " NO tiene productos en sus listas de compras");
					}

					return new ResponseGetListaByCustomerId(idCliente, listaCompraDao,
							"Listas de Compras del  " + idCliente);

				}

				return new ResponseGetListaByCustomerId(idCliente, listaCompraDao,
						"El Cliente " + idCliente + " NO tiene listas de compras");

			}
			return new ResponseGetListaByCustomerId(null, listaCompraDao,
					"No existe el Cliente con el id: " + idCliente);

		} catch (Exception e) {
			return new ResponseGetListaByCustomerId(idCliente, listaCompraDao,
					"Hubo algún problema al tratar de localizar la informacion del cliente: " + idCliente
							+ " -> ERROR: " + e.getMessage());
		}
	}

	@Override
	public ResponsePutActualizarListaByClienteId actualizaListaByCustomerId(
			RequestPutActualizarListaByClienteId request) {
		Producto producto = null;
		String mensaje = null;
		List<ListaCompra> listaCompra = new ArrayList<ListaCompra>();
		List<ProductoDao> listaProductosDao = new ArrayList<ProductoDao>();
		List<ListaCompraDetalle> listaCompraDetalle = new ArrayList<ListaCompraDetalle>();

		try {
			Optional<Cliente> clienteOpcional = clienteRepository.findById(request.getIdCliente());

			if (clienteOpcional.isPresent()) {

				for (ProductoDao productoDao : request.getProductos()) {
					Optional<Producto> productoOpcional = productoRepository.findById(productoDao.getIdProdcto());
					producto = productoOpcional.orElse(null);
					if (Objects.isNull(producto)) {
						mensaje = (Objects.isNull(mensaje)) ? productoDao.getIdProdcto().toString()
								: mensaje + "," + productoDao.getIdProdcto();
						listaProductosDao.add(null);
					} else {
						listaProductosDao
								.add(new ProductoDao(productoDao.getIdProdcto(), productoDao.getCantidadProducto()));
					}
				}

				boolean todosSonNulos = listaProductosDao.stream().allMatch(p -> p == null);

				if (todosSonNulos == false) {

					listaCompra = listaCompraRepository.findByClienteAndNombre(clienteOpcional.get(),
							request.getNombreLista().toUpperCase());

					if (!listaCompra.isEmpty()) {

						for (ListaCompra lstComp : listaCompra) {
							lstComp.setNombre(request.getNombreListaActualizada().toUpperCase());
							lstComp.setFechaUltimaActualizacion(LocalDateTime.now());
							listaCompraRepository.save(lstComp);

							for (ProductoDao productoDao : listaProductosDao) {

								if (!Objects.isNull(productoDao)) {
									listaCompraDetalle = listaCompraDetalleRepository.findByListaCompraAndProducto(
											lstComp, new Producto(productoDao.getIdProdcto()));

									if (listaCompraDetalle.isEmpty()) {
											
											ListaCompraDetallePk pk = new ListaCompraDetallePk(lstComp.getIdLista(),productoDao.getIdProdcto());
											producto = new Producto(productoDao.getIdProdcto());
											ListaCompraDetalle lsCompDetNueva = new ListaCompraDetalle(pk,lstComp,producto,productoDao.getCantidadProducto());
											
											listaCompraDetalleRepository.save(lsCompDetNueva);
										
									} else {

										for (ListaCompraDetalle lsTcD : listaCompraDetalle) {
											lsTcD.setCantidad(productoDao.getCantidadProducto());
											listaCompraDetalleRepository.save(lsTcD);
										}

									}
								}

							}
						}

						return new ResponsePutActualizarListaByClienteId(request, (Objects.isNull(mensaje))
								? "Se actualizo la lista: " + request.getNombreLista() + " con todos los productos"
								: "Se actualizo la lista: " + request.getNombreLista()
										+ " pero los siguientes idProductos no existen el catalogo de productos: "
										+ mensaje);
					}

					return new ResponsePutActualizarListaByClienteId(request,
							"No se puede actualizar la lista de Compras" + ", por que no existe la lista: "
									+ request.getNombreLista() + " para el cliente: " + request.getIdCliente());

				} else {

					return new ResponsePutActualizarListaByClienteId(request,
							"No se puede actualizar la lista de Compras"
									+ ", por que no existen los productos en el catalogo de productos");
				}

			}

			return new ResponsePutActualizarListaByClienteId(request, "No se puede actualizar la lista de Compras"
					+ ", por que no existe el cliente: " + request.getIdCliente());

		} catch (Exception e) {
			return new ResponsePutActualizarListaByClienteId(request,
					"Hubo un ERROR. No se puede actualizar la lista de Compras -> " + e.getMessage());
		}
	}

	@Override
	public ResponseDeleteListaByIdCliente deleteListaByCustomerId(Long idLista) {

		try {
			Optional<ListaCompra> listaCompraOpcional = listaCompraRepository.findById(idLista);

			if (listaCompraOpcional.isPresent()) {

				List<ListaCompraDetalle> listasCompraDetalle = listaCompraDetalleRepository
						.findByListaCompra(listaCompraOpcional.get());

				for (ListaCompraDetalle listaCompraDetalle : listasCompraDetalle) {
					listaCompraDetalleRepository.deleteById(listaCompraDetalle.getPk());
				}

				listaCompraRepository.deleteById(listaCompraOpcional.get().getIdLista());

				return new ResponseDeleteListaByIdCliente(idLista,
						"Se borro la lista de compras: " + listaCompraOpcional.get().getNombre());
			}

			return new ResponseDeleteListaByIdCliente(idLista, "No se borro la lista de compras, por que no existe");

		} catch (Exception e) {
			return new ResponseDeleteListaByIdCliente(idLista, "Hubo algún error: " + e.getMessage());
		}
	}

}
