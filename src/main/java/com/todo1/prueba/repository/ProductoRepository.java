package com.todo1.prueba.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.prueba.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
}
