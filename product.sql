-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 23, 2017 at 11:26 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uts`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `deskripsi` varchar(200) NOT NULL,
  `kategori` varchar(256) NOT NULL,
  `pabrikan` varchar(32) NOT NULL,
  `berat` double NOT NULL,
  `harga` int(11) NOT NULL,
  `tahun_produksi` int(11) NOT NULL,
  `jumlah_stok` int(11) NOT NULL,
  `kondisi` varchar(10) NOT NULL,
  `flag_aktif` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `nama`, `deskripsi`, `kategori`, `pabrikan`, `berat`, `harga`, `tahun_produksi`, `jumlah_stok`, `kondisi`, `flag_aktif`) VALUES
(1, 'MacBook Pro 11\"', 'Laptop terbaik di dunia', 'Laptop', 'Apple', 1.2, 20000000, 2015, 7, 'Baru', 1),
(2, 'Lenovo', 'Laptop terbaik kedua di dunia', 'Laptop', 'Lenovo', 2, 15000000, 2012, 20, 'Baru', 1),
(3, 'Xiaomi 4', 'Handphone murah yang cukup bagus', 'Handphone', 'Xiaomi', 0.2, 3000000, 2015, 100, 'Baru', 1),
(4, 'Samsung S60', 'Handphone mid-end', 'Handphone', 'Samsung', 0.2, 1500000, 2011, 2, 'Bekas', 1),
(5, 'XPS 15', 'Laptop 15-inch untuk bekerja', 'Laptop', 'Dell', 2, 16500000, 2017, 25, 'Baru', 1),
(11, 'iPhone X 128GB', 'Smartphone terbaru dari Apple, super cool!', 'Handphone', 'Apple', 0.4, 15000000, 2017, 100, 'Baru', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
