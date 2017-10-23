package com.uts.apap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.uts.apap.model.ProductModel;

@Mapper
public interface ProductMapper {

	@Select("SELECT * FROM product")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nama", column="nama"),
			@Result(property="deskripsi", column="deskripsi"),
			@Result(property="kategori", column="kategori"),
			@Result(property="pabrikan", column="pabrikan"),
			@Result(property="berat", column="berat"),
			@Result(property="harga", column="harga"),
			@Result(property="tahunProduksi", column="tahun_produksi"),
			@Result(property="jumlahStok", column="jumlah_stok"),
			@Result(property="kondisi", column="kondisi")
	})
	List<ProductModel> selectAllProduct();
	
	@Select("SELECT * FROM product WHERE id=#{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nama", column="nama"),
			@Result(property="deskripsi", column="deskripsi"),
			@Result(property="kategori", column="kategori"),
			@Result(property="pabrikan", column="pabrikan"),
			@Result(property="berat", column="berat"),
			@Result(property="harga", column="harga"),
			@Result(property="tahunProduksi", column="tahun_produksi"),
			@Result(property="jumlahStok", column="jumlah_stok"),
			@Result(property="kondisi", column="kondisi")
	})
	ProductModel selectProduct(int id);
}
