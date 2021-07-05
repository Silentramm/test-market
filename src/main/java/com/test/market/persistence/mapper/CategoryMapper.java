package com.test.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.test.market.domain.Category;
import com.test.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	//Retornar una categoría
	@Mappings({
		@Mapping(source = "idCategoria", target = "categoryId"), //Source serán las propiedades del entity y el target el dominio
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active"),
	})
	
	Category toCategory(Categoria categoria); //Convertir una Categoria en Category
	
	@InheritInverseConfiguration //Indic que hará la conversión inversa del método anterior y de esta manera no se deben especifcar cada uno de los mapeos individuales
	@Mapping(target = "productos", ignore = true) //Debido a que productos se encuentra en Categorria pero no en Category, se indica que lo ignore
	Categoria toCategoria(Category category);

}
