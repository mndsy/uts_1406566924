package com.uts.apap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "redirect:/product/viewall";
	}
	
	@RequestMapping("/product/viewall")
	public String viewAll(Model model, @RequestParam(value="stat", required=false) String stat) {
		List<ProductModel> listProduk = productDAO.getAllProducts();
		
		model.addAttribute("stat", stat);
		model.addAttribute("listProduk", listProduk);
		model.addAttribute("title", "Daftar Seluruh Produk");
		return "view-all";
	}
	
	@RequestMapping("/product/view/{id}")
	public String view(Model model, @PathVariable(value="id") int id, 
			@RequestParam(value="stat", required=false) String stat) {
		ProductModel product = productDAO.getProduct(id);
		
		if(product == null) {
			return "product-not-found";
		}
		else {
			model.addAttribute("stat", stat);
			model.addAttribute("produk", product);
			model.addAttribute("title", "Detail Produk " + product.getNama());
			return "view-detail";
		}
	}
	
	@RequestMapping("/product/update/{id}")
	public String update(Model model, @PathVariable(value="id") int id) {
		ProductModel product = productDAO.getProduct(id);
		
		if(product == null) {
			return "product-not-found";
		}
		else {
			model.addAttribute("produk", product);
			model.addAttribute("title", "Ubah Data Produk " + product.getNama());
			return "form-update";
		}
	}
	
	@RequestMapping("/product/update/submit")
	public String updateSubmit(Model model, @RequestParam(value="id") int id,
			@RequestParam(value="nama") String nama,
			@RequestParam(value="deskripsi") String deskripsi,
			@RequestParam(value="kategori") String kategori,
			@RequestParam(value="pabrikan") String pabrikan,
			@RequestParam(value="berat") double berat,
			@RequestParam(value="harga") int harga,
			@RequestParam(value="tahunProduksi") int tahunProduksi,
			@RequestParam(value="jumlahStok") int jumlahStok,
			@RequestParam(value="kondisi") String kondisi) {
		ProductModel product = productDAO.getProduct(id);
		product.setNama(nama);
		product.setDeskripsi(deskripsi);
		product.setKategori(kategori);
		product.setPabrikan(pabrikan);
		product.setBerat(berat);
		product.setHarga(harga);
		product.setTahunProduksi(tahunProduksi);
		product.setJumlahStok(jumlahStok);
		product.setKondisi(kondisi);
		
		productDAO.updateProduct(product);
		
		return "redirect:/product/view/" + id + "?statusUpdate=success";
	}
	
	@RequestMapping("/product/add")
	public String add(Model model) {
		
		model.addAttribute("title", "Tambah Produk Baru");
		return "form-add";
	}
	
	@RequestMapping("/product/add/submit")
	public String addSubmit(Model model,
			@RequestParam(value="nama") String nama,
			@RequestParam(value="deskripsi") String deskripsi,
			@RequestParam(value="kategori") String kategori,
			@RequestParam(value="pabrikan") String pabrikan,
			@RequestParam(value="berat") double berat,
			@RequestParam(value="harga") int harga,
			@RequestParam(value="tahunProduksi") int tahunProduksi,
			@RequestParam(value="jumlahStok") int jumlahStok,
			@RequestParam(value="kondisi") String kondisi) {
		ProductModel product = new ProductModel();
		product.setNama(nama);
		product.setDeskripsi(deskripsi);
		product.setKategori(kategori);
		product.setPabrikan(pabrikan);
		product.setBerat(berat);
		product.setHarga(harga);
		product.setTahunProduksi(tahunProduksi);
		product.setJumlahStok(jumlahStok);
		product.setKondisi(kondisi);
		
		productDAO.addProduct(product);
		
		return "redirect:/product/viewall?stat=success";
	}
	
	@RequestMapping("/product/deactive/{id}")
	public String deactive(Model model, @PathVariable(value="id") int id) {
		ProductModel product = productDAO.getProduct(id);
		
		if(product == null) {
			return "product-not-found";
		}
		else {
			productDAO.deactive(product);
			return "redirect:/product/view/" + id + "?stat=success";
		}
	}
}
