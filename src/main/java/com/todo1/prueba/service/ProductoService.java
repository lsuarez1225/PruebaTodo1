package com.todo1.prueba.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.prueba.model.Producto;
import com.todo1.prueba.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}
	
	public Map<Integer, Producto> obtenerProductosEnMap() {
		
		Map<Integer, Producto> map = new HashMap<Integer, Producto>();
		
		List<Producto> listaProductos = productoRepository.findAll();
		for (Producto producto : listaProductos) {
			map.put(producto.getId(), producto);
		}
		
		return map;
	}
}
