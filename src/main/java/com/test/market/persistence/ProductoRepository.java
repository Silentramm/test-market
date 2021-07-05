package com.test.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.market.domain.Product;
import com.test.market.domain.repository.ProductRepository;
import com.test.market.persistence.crud.ProductoCrudRepository;
import com.test.market.persistence.entity.Producto;
import com.test.market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {
	
	private ProductoCrudRepository productoCrudRepository;
	private ProductMapper mapper;
	
	//Metodo que recupere los productos de la base de datos
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}
	
	//Retorna los productos de una categoría
	@Override
	public Optional<List<Product>> getByCategory(int categoryId){
		List<Producto> productos= productoCrudRepository.findByidCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}
	
	//Retorna productos escasos 
	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	//Retorna un producto en particular
	@Override
	public Optional<Product> getProduct(int productId) {
		return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}
	
	//Eliminar producto
	@Override
	public void delete(int productId) { //Se puede el iminar un registro por medio del objeto como tal o su llave primaria
		productoCrudRepository.deleteById(productId);
	}

}
