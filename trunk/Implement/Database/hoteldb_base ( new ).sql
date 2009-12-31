CREATE DATABASE IF NOT EXISTS `HOTELDB`;

USE `HOTELDB`;

-- Drop all tables
DROP TABLE IF EXISTS `THUE_PHONG`;
DROP TABLE IF EXISTS `THAM_SO`;
DROP TABLE IF EXISTS `PHONG`;
DROP TABLE IF EXISTS `TINH_TRANG_PHONG`;
DROP TABLE IF EXISTS `LOAI_PHONG`;
DROP TABLE IF EXISTS `KHACH_HANG`;
DROP TABLE IF EXISTS `LOAI_THUE`;
DROP TABLE IF EXISTS `LOAI_KHACH_HANG`;

-- tao bang loai khach hang
DROP TABLE IF EXISTS `hoteldb`.`loai_khach_hang`;
CREATE TABLE  `hoteldb`.`loai_khach_hang` (
  `id` INTEGER unsigned NOT NULL,
  `ten_loai_khach_hang` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- tao bang loai phong
DROP TABLE IF EXISTS `hoteldb`.`loai_phong`;
CREATE TABLE  `hoteldb`.`loai_phong` (
  `id` INTEGER unsigned NOT NULL DEFAULT '0',
  `ten` text NOT NULL,
  `gia` INTEGER unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- tao bang loai thue
DROP TABLE IF EXISTS `hoteldb`.`loai_thue`;
CREATE TABLE  `hoteldb`.`loai_thue` (
  `id` INTEGER unsigned NOT NULL DEFAULT '0',
  `loai` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- tao bang tinh trang phong
DROP TABLE IF EXISTS `hoteldb`.`tinh_trang_phong`;
CREATE TABLE  `hoteldb`.`tinh_trang_phong` (
  `id` INTEGER unsigned NOT NULL DEFAULT '0',
  `ten` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- tao bang tham so
DROP TABLE IF EXISTS `hoteldb`.`tham_so`;
CREATE TABLE  `hoteldb`.`tham_so` (
  `id` INTEGER NOT NULL DEFAULT '0',
  `ten` text NOT NULL,
  `kieu_du_lieu` text NOT NULL,
  `gia_tri` text NOT NULL,
  `kich_hoat` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoD;


-- tao bang khach hang
DROP TABLE IF EXISTS `hoteldb`.`khach_hang`;
CREATE TABLE  `hoteldb`.`khach_hang` (
  `id` varchar(15) NOT NULL,
  `ten` text NOT NULL,
  `gioi_tinh` text,
  `dia_chi` text NOT NULL,
  `dien_thoai` text NOT NULL,
  `ngay_sinh` datetime NOT NULL,
  `id_loai_khach_hang` INTEGER unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_khach_hang_Loai_khach_hang` (`id_loai_khach_hang`),
  CONSTRAINT `FK_khach_hang_Loai_khach_hang` FOREIGN KEY (`id_loai_khach_hang`) REFERENCES `loai_khach_hang` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


-- Tao bang PHONG
DROP TABLE IF EXISTS `hoteldb`.`phong`;
CREATE TABLE  `hoteldb`.`phong` (
  `id` INTEGER unsigned NOT NULL AUTO_INCREMENT,
  `lau` INTEGER unsigned DEFAULT NULL,
  `gia` INTEGER unsigned DEFAULT NULL,
  `id_tinh_trang` INTEGER unsigned NOT NULL,
  `id_loai_phong` INTEGER unsigned NOT NULL,
  `hinh_anh` text,
  `mo_ta` text,
  PRIMARY KEY (`id`),
  KEY `FK_phong_loai_phong` (`id_loai_phong`),
  KEY `FK_phong_tinh_trang` (`id_tinh_trang`),
  CONSTRAINT `FK_phong_tinh_trang` FOREIGN KEY (`id_tinh_trang`) REFERENCES `tinh_trang_phong` (`id`),
  CONSTRAINT `FK_phong_loai_phong` FOREIGN KEY (`id_loai_phong`) REFERENCES `loai_phong` (`id`)
) ENGINE=InnoDB;


-- tao bang chi tiet thue phong
DROP TABLE IF EXISTS `hoteldb`.`chi_tiet_thue_phong`;
CREATE TABLE  `hoteldb`.`chi_tiet_thue_phong` (
  `id` VARCHAR(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_phong` INTEGER unsigned NOT NULL,
  `ngay_thue` date NOT NULL,
  `ngay_tra` date NOT NULL,
  `tong_gia` INTEGER unsigned NOT NULL,
  `id_loai_thue` INTEGER unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_chi_tiet_thue_phong_phong` (`id_phong`),
  KEY `FK_chi_tiet_thue_phong_loai_thue` (`id_loai_thue`),
  CONSTRAINT `FK_chi_tiet_thue_phong_loai_thue` FOREIGN KEY (`id_loai_thue`) REFERENCES `loai_thue` (`id`),
  CONSTRAINT `FK_chi_tiet_thue_phong_phong` FOREIGN KEY (`id_phong`) REFERENCES `phong` (`id`)
) ENGINE=InnoDB;

-- tao bang thue phong
DROP TABLE IF EXISTS `hoteldb`.`thue_phong`;
CREATE TABLE  `hoteldb`.`thue_phong` (
  `id_chi_tiet_thue` VARCHAR(20) unsigned NOT NULL,
  `id_khach` varchar(15) NOT NULL,
  PRIMARY KEY (`id_chi_tiet_thue`,`id_khach`),
  KEY `FK_thue_phong_khach` (`id_khach`),
  CONSTRAINT `FK_thue_phong_khach` FOREIGN KEY (`id_khach`) REFERENCES `khach_hang` (`id`),
  CONSTRAINT `FK_thue_phong_chi_tiet_thue` FOREIGN KEY (`id_chi_tiet_thue`) REFERENCES `chi_tiet_thue_phong` (`id`)
) ENGINE=InnoDB;


-- Insert data
-- LOAI_KHACH_HANG
INSERT INTO `LOAI_KHACH_HANG`(`id`, `ten_loai_khach_hang`) VALUES (0, 'Trong Nuoc'),
                                                                  (1, 'Nuoc Ngoai');


-- KHACH_HANG
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  ('10', 'Ly Thuong Kiet', 'Nam', 'Dia chi', 'Dien thoai', '1234-12-13', 1),
  ('1', 'Tran Quoc Tuan', 'Nam', 'Dia chi', 'Dien thoai', '1234-12-24', 1),
  ('2', 'Phan Van Khai', 'Nam', 'Dia chi', 'Dien thoai', '1960-01-01', 1),
  ('3', 'Ho Chi Minh', 'Nam', 'Dia chi', 'Dien thoai', '1969-05-19', 1),
  ('4', 'Athur', 'Nam', 'Dia chi', 'Dien thoai', '0123-02-14', 0),
  ('5', 'Obama', 'Nam', 'Dia chi', 'Dien thoai', '1958-06-01', 0),
  ('6', 'Binladen', 'Nam', 'Dia chi', 'Dien thoai', '1957-03-08', 0),
  ('7', 'Nguyen Hoang Vu', 'Nam', 'Dia chi', 'Dien thoai', '1988-10-28', 1),
  ('8', 'Lam Chi Dinh', 'Nam', 'Dia chi', 'Dien thoai', '1970-01-09', 0),
  ('9', 'Mizore-chan', 'Nu', 'Dia chi', 'Dien thoai', '2007-01-01', 0);


-- LOAI_THUE
INSERT INTO `LOAI_THUE`(`id`, `loai`) VALUES
  (0, 'Dat phong'),
  (1, 'Thue phong');



-- TINH_TRANG_PHONG
INSERT INTO `TINH_TRANG_PHONG`(`id`, `ten`) VALUES
  (0, 'Con trong'),
  (1, 'Da thue');


-- LOAI_PHONG
INSERT INTO `LOAI_PHONG`(`id`, `ten`, `gia`) VALUES
  (0, 'VIP', 500000),
  (1, 'Hang trung', 400000),
  (2, 'Hang thuong', 350000);


-- PHONG
INSERT INTO `PHONG`(`id`, `lau`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (1,1, null, 0, 0, '', ''),
  (2,1, null, 0, 0, '', ''),
  (3,1, null, 0, 0, '', ''),
  (4,1, null, 1, 0, '', ''),
  (5,1, null, 1, 0, '', ''),
  (6,1, null, 0, 1, '', ''),
  (7,2, null, 0, 1, '', ''),
  (8,2, null, 1, 1, '', ''),
  (9,2, null, 1, 1, '', ''),
  (10,2, null, 0, 1, '', ''),
  (11,2, null, 0, 1, '', ''),
  (12,2, null, 0, 1, '', ''),
  (13,2, null, 0, 1, '', ''),
  (14,2, null, 0, 1, '', ''),
  (15,3, null, 1, 1, '', ''),
  (16,3, null, 1, 2, '', ''),
  (17,3, null, 1, 2, '', ''),
  (18,3, null, 1, 2, '', ''),
  (19,3, null, 1, 2, '', ''),
  (20,3, null, 0, 2, '', ''),
  (21,3, null, 0, 2, '', '');


-- THUE_PHONG
INSERT INTO `CHI_TIET_THUE_PHONG`(`id`,`id_phong`,`ngay_thue`,`tong_gia`,`id_loai_thue`) VALUES
  (1,1,'2009-1-1',0,1),
  (2,2,'2009-1-1',0,1),
  (3,3,'2009-1-1',0,1),
  (4,4,'2009-1-1',0,1),
  (5,5,'2009-1-1',0,1),
  (6,6,'2009-1-1',0,1);


INSERT INTO `THUE_PHONG`(`id_chi_tiet_thue`, `id_khach`) VALUES
  (1, '2'),
  (1, '3'),
  (1, '4'),
  (2, '5'),
  (3, '6'),
  (4, '7'),
  (5, '8'),
  (6, '9');


