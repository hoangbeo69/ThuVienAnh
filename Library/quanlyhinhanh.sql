-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 29, 2020 lúc 06:13 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlyhinhanh`
--
CREATE DATABASE IF NOT EXISTS `quanlyhinhanh` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `quanlyhinhanh`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinh_anh`
--

CREATE TABLE IF NOT EXISTS `hinh_anh` (
  `ha_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ha_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ha_filepath` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `ha_dungluong` int(11) NOT NULL,
  `user_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ha_date` date NOT NULL,
  PRIMARY KEY (`ha_id`),
  KEY `khoangoai2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hinh_anh`
--

INSERT INTO `hinh_anh` (`ha_id`, `ha_name`, `ha_filepath`, `ha_dungluong`, `user_id`, `ha_date`) VALUES
('IMG00001', 'tree-2560x1440-sky-clouds-4k-19728.jpg', 'tree-2560x1440-sky-clouds-4k-19728.jpg', 570177, 'USER01', '2019-08-04'),
('IMG00002', 'temple-3840x1840-forest-4k-19669.jpg', 'temple-3840x1840-forest-4k-19669.jpg', 957314, 'USER01', '2019-05-09'),
('IMG00004', 'clouds-planets-snow-239.jpg', 'clouds-planets-snow-239.jpg', 770250, 'USER01', '2019-10-03'),
('IMG00005', 'lake-mountains-levitation-284.jpg', 'lake-mountains-levitation-284.jpg', 860712, 'USER01', '2019-08-04'),
('IMG00006', 'fantasy_japanese.jpg', 'fantasy_japanese.jpg', 947244, 'USER01', '2019-01-03'),
('IMG00007', 'sunset-artwork-4k-20035.jpg', 'sunset-artwork-4k-20035.jpg', 736453, 'USER01', '2019-09-12'),
('IMG00008', 'pointed_earsrealisticwlop.jpg', 'pointed_earsrealisticwlop.jpg', 241268, 'USER01', '2019-08-11'),
('IMG00009', 'long_hair pointed_earssarlia.jpg', 'long_hair pointed_earssarlia.jpg', 210099, 'USER01', '2019-07-03'),
('IMG00010', 'headdress jpeg_artifactslong_hair.jpg', 'headdress jpeg_artifactslong_hair.jpg', 222050, 'USER01', '2019-12-03'),
('IMG16170', 'ed_hair sword tagme_thighhighs weapon wlop.jpg', '51016ed_hair sword tagme_thighhighs weapon wlop.jpg', 4393960, 'USER01', '2020-05-27'),
('IMG34115', 'house_building_photoshop_blizzard_glare_116610_3840x2160.jpg', '365house_building_photoshop_blizzard_glare_116610_3840x2160.jpg', 1398962, 'USER01', '2020-05-19'),
('IMG39730', 'house_building_photoshop_blizzard_glare_116610_3840x2160.jpg', '5893house_building_photoshop_blizzard_glare_116610_3840x2160.jpg', 1398962, 'USER01', '2020-05-27'),
('IMG40590', 'silhouette_forest_animals_129984_3840x2160.jpg', '25082silhouette_forest_animals_129984_3840x2160.jpg', 3226380, 'USER01', '2020-05-27'),
('IMG42279', 'forest-3840x2160-sunset-artwork-4k-20035.jpg', '160forest-3840x2160-sunset-artwork-4k-20035.jpg', 736453, 'USER01', '2020-05-27'),
('IMG51525', 'kusakabe_satsuki scenic stairs tonari_no_totoro torii tree.jpg', '841kusakabe_satsuki scenic stairs tonari_no_totoro torii tree.jpg', 1117989, 'USER01', '2020-05-27'),
('IMG54689', 'japan-2560x1440-scenery-oriental-4k-5k-18609.jpg', '192japan-2560x1440-scenery-oriental-4k-5k-18609.jpg', 1196834, 'USER01', '2020-05-19'),
('IMG57814', 'jpeg_artifacts logo petals pointed_ears realistic wlop.jpg', '579jpeg_artifacts logo petals pointed_ears realistic wlop.jpg', 241268, 'USER01', '2020-05-27'),
('IMG58826', 'nobody original realistic reflection scenic sky stairs train.jpg', '2714nobody original realistic reflection scenic sky stairs train.jpg', 2258848, 'USER01', '2020-05-27'),
('IMG73229', 'forest-3800x2149-world-tree-4k-19731.jpg', '23forest-3800x2149-world-tree-4k-19731.jpg', 1734021, 'USER01', '2020-05-27'),
('IMG7581', 'space-3840x2160-planet-man-dog-4k-19737.jpg', '309space-3840x2160-planet-man-dog-4k-19737.jpg', 1516318, 'USER01', '2020-05-19'),
('IMG78131', '74189140_120701462679117_6248196543933841408_n.jpg', '97374189140_120701462679117_6248196543933841408_n.jpg', 75614, 'USER02', '2020-05-19'),
('IMG89801', 'ferrari-testarossa-3840x2160-retrowave-pink-4k-19899.jpg', '774ferrari-testarossa-3840x2160-retrowave-pink-4k-19899.jpg', 704155, 'USER01', '2020-05-19'),
('IMG96736', 'castle-3840x2160-river-ship-4k-19760.jpg', '46410castle-3840x2160-river-ship-4k-19760.jpg', 1683877, 'USER01', '2020-05-27');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tai_khoan`
--

CREATE TABLE IF NOT EXISTS `tai_khoan` (
  `user_id` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `tk_username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tk_password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  UNIQUE KEY `tk_username` (`tk_username`),
  KEY `khoangoai1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tai_khoan`
--

INSERT INTO `tai_khoan` (`user_id`, `tk_username`, `tk_password`) VALUES
('USER5699', 'demo1', 'matkhau'),
('USER01', 'hoangbeo69', 'hoangbeo69'),
('USER02', 'tiendung', 'tiendung'),
('USER03', 'tientung', 'tientung');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_birth` date NOT NULL,
  `user_email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `user_dungluong` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_birth`, `user_email`, `user_dungluong`) VALUES
('USER01', 'Nguyễn Minh Hoàng', '1999-09-27', 'nguyenminhhoang2709@gmail.com', 104857600),
('USER02', 'Lưu Tiếng Dũng', '1999-09-22', 'luutiengdung@gmail.com', 104857600),
('USER03', 'Nguyễn Tiến Tùng', '1999-02-06', 'nguyentientung@gmail.com', 104857600),
('USER5699', 'Nguyễn Văn A', '1999-09-23', 'nguyenvana@gmail.com', 104857600);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `hinh_anh`
--
ALTER TABLE `hinh_anh`
  ADD CONSTRAINT `khoangoai2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD CONSTRAINT `khoangoai1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
