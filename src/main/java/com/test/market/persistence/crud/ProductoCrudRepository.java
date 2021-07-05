package com.test.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
	
	//Lista de rpductos que pertenezcan a una categoría en específico respetando la nomenclatura de los Query Methods (findBy) y el camelCase POr lo cual en este jemplo se cambia el idCategoria por IdCategoria
	List<Producto> findByidCategoriaOrderByNombreAsc(int idCategoria); //El nombre del parámetro ya no debe repestar el cmalecase si no que el nombre que tiene en la entidad
	
	//Query Method para recuperar los productos escasos y que están en activo
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado); //Se usa el operador LessThan (es menor que) OPerando And para añadie condiciones a la consulta

}
