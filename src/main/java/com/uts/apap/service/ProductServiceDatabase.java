package com.uts.apap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uts.apap.mapper.ProductMapper;
import com.uts.apap.model.ProductModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceDatabase implements ProductService {
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<ProductModel> getAllProducts() {
		log.info("get all products in database");
		return productMapper.selectAllProduct();
	}

	@Override
	public ProductModel getProduct(int id) {
		log.info("get product with id {}", id);
		return productMapper.selectProduct(id);
	}

	@Override
	public void updateProduct(ProductModel product) {
		log.info("update product with id {}", product.getId());
		productMapper.updateProduct(product);
	}

}
