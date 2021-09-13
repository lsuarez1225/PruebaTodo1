package com.todo1.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo1.prueba.model.CarroCompras;

@Repository
public interface CarroComprasRepository extends JpaRepository<CarroCompras, Integer>{

	@Query(value = "FROM CarroCompras WHERE userid = :idUsuario AND productid = :idProducto")
	public Optional<CarroCompras> consultarCarroComprasActivo(Integer idUsuario, Integer idProducto);
}
