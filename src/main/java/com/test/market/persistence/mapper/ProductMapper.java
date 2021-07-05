package com.test.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.test.market.domain.Product;
import com.test.market.persistence.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	@Mappings({
		@Mapping(source = "idProducto", target = "productId"),
		@Mapping(source = "nombre", target = "name"),
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "precioVenta", target = "price"),
		@Mapping(source = "cantidadStock", target = "stok"),
		@Mapping(source = "estado", target = "active"),
		@Mapping(source = "categoria", target = "category"), //Para convertir automaticamente categoria en category se el parámetro uses = {CategoryMapper.class} en la anotación @Mapper de la interface
	})
	
	Product toProduct(Producto producto);
	
	List<Product> toProducts(List<Producto> productos);
	
	@InheritInverseConfiguration
	@Mapping(target = "codigoBarras", ignore = true)
	Producto toProducto(Product product);


}
