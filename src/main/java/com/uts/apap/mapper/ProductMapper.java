package com.uts.apap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.uts.apap.model.ProductModel;

@Mapper
public interface ProductMapper {

	@Select("SELECT * FROM product")
	List<ProductModel> selectAllProduct();
}
