package com.uts.apap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uts.apap.model.ProductModel;
import com.uts.apap.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	@Autowired
	ProductService productDAO;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Home");
		return "index";
	}
	
	@RequestMapping("/product/viewall")
	public String viewAll(Model model) {
		List<ProductModel> listProduk = productDAO.getAllProducts();
		
		model.addAttribute("listProduk", listProduk);
		model.addAttribute("title", "Daftar Seluruh Produk");
		return "view-all";
	}
	
	@RequestMapping("/product/view/{id}")
	public String view(Model model, @PathVariable(value="id") int id) {
		ProductModel produk = productDAO.getProduct(id);
		
		model.addAttribute("produk", produk);
		model.addAttribute("title", "Detail Produk " + produk.getNama());
		return "view-detail";
	}
}
