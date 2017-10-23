package com.uts.apap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("title", "Daftar Seluruh Produk");
		return "view-all";
	}
}
