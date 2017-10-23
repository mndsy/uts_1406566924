package com.uts.apap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.uts.apap.model.ProductModel;

@Mapper
public interface ProductMapper {

	@Select("SELECT * FROM product WHERE flag_aktif=1")
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
			@Result(property="kondisi", column="kondisi"),
			@Result(property="flagAktif", column="flag_aktif")
	})
	List<ProductModel> selectAllProduct();
	
	@Select("SELECT * FROM product WHERE id=#{id} LIMIT 1")
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
			@Result(property="kondisi", column="kondisi"),
			@Result(property="flagAktif", column="flag_aktif")
	})
	ProductModel selectProduct(int id);
	
	@Update("UPDATE product SET nama=#{nama}, deskripsi=#{deskripsi}, kategori=#{kategori}, pabrikan=#{pabrikan}, berat=#{berat}, "
			+ "harga=#{harga}, tahun_produksi=#{tahunProduksi}, jumlah_stok=#{jumlahStok}, kondisi=#{kondisi} WHERE id=#{id}")
	void updateProduct(ProductModel product);
	
	@Insert("INSERT INTO product (nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi, jumlah_stok, kondisi, flag_aktif) "
			+ "VALUES (#{nama}, #{deskripsi}, #{kategori}, #{pabrikan}, #{berat}, #{harga}, #{tahunProduksi}, #{jumlahStok}, "
			+ "#{kondisi}, 1)")
	void insertProduct(ProductModel product);
	
	@Update("UPDATE product SET flag_aktif=0 WHERE id=#{id}")
	void deactive(int id);
}
