package com.test.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.test.market.domain.Product;

public interface ProductRepository {
	
	//En esta interface s�lo se van a indicar el n�mbre de los m�todos en t�rminos del d�minio, es decir traducidos
	
	//M�todo que retorne una lista de productos
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScarseProducts(int quantity);
	Optional<Product> getProduct(int productId);
	Product save(Product product);
	void delete(int productId);

}
