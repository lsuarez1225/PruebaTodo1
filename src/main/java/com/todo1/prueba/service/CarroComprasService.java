package com.todo1.prueba.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.prueba.excepcion.RegistroNoEncontrado;
import com.todo1.prueba.model.CarroCompras;
import com.todo1.prueba.model.Producto;
import com.todo1.prueba.repository.CarroComprasRepository;
import com.todo1.prueba.repository.ProductoRepository;

@Service
public class CarroComprasService {

	@Autowired
	CarroComprasRepository carroComprasRepository;
	
	@Autowired
	ProductoService productoService;
	
	public CarroCompras agregarProducto(CarroCompras carroCompras) throws RegistroNoEncontrado {
		
		Optional<CarroCompras> carroActual = carroComprasRepository.consultarCarroComprasActivo(carroCompras.getUserid(), carroCompras.getProductid());
		
		Map<Integer, Producto> mapProductos = productoService.obtenerProductosEnMap();
		
		if (carroActual.isPresent()) {
			Producto producto = mapProductos.get(carroActual.get().getProductid());
			
			carroActual.get().setPrecio(producto.getPrecio());
			carroActual.get().setCantidad(carroActual.get().getCantidad() + carroCompras.getCantidad());
			return carroComprasRepository.save(carroActual.get());
		}
		else {
			Producto producto = mapProductos.get(carroCompras.getProductid());
			carroCompras.setPrecio(producto.getPrecio());
			return carroComprasRepository.save(carroCompras);
		}
	}
	
	public List<CarroCompras> obtenerCarrito() {
		
		Map<Integer, Producto> mapProductos = productoService.obtenerProductosEnMap();
		List<CarroCompras> lista = carroComprasRepository.findAll();
		
		for (CarroCompras carrito : lista) {
			Producto producto = mapProductos.get(carrito.getId());
			carrito.setNombre(producto.getNombre());
			carrito.setDescripcion(producto.getDescripcion());
		}
		
		return lista;
	}

}
