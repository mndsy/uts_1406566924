package com.uts.apap.service;

import java.util.List;

import com.uts.apap.model.ProductModel;

public interface ProductService {
	List<ProductModel> getAllProducts();
	
	ProductModel getProduct(int id);
	
	void updateProduct(ProductModel product);
	void addProduct(ProductModel product);
	void deactive(ProductModel product);
}
