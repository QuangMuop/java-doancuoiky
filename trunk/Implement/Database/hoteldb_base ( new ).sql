CREATE DATABASE IF NOT EXISTS `hoteldb`;

USE `hoteldb`;

-- Drop all tables
DROP TABLE IF EXISTS `thue_phong`;
DROP TABLE IF EXISTS `tham_so`;
DROP TABLE IF EXISTS `chi_tiet_thue_phong`;
DROP TABLE IF EXISTS `phong`;
DROP TABLE IF EXISTS `tinh_trang_phong`;
DROP TABLE IF EXISTS `khach_hang`;
DROP TABLE IF EXISTS `loai_phong`;
DROP TABLE IF EXISTS `loai_thue`;
DROP TABLE IF EXISTS `loai_khach_hang`;
DROP TABLE IF EXISTS `khach_san`;

-- tao bang loai khach hang
DROP TABLE IF EXISTS `hoteldb`.`loai_khach_hang`;
CREATE TABLE  `hoteldb`.`loai_khach_hang` (
  `id` Integer unsigned NOT NULL,
  `ten_loai_khach_hang` text NOT NULL,
  `don_gia` integer unsigned NOT NULL DEFAULT '0',
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
) ENGINE=InnoDB;


-- tao bang khach hang
DROP TABLE IF EXISTS `hoteldb`.`khach_hang`;
CREATE TABLE  `hoteldb`.`khach_hang` (
  `id` varchar(15) NOT NULL,
  `ten` text NOT NULL,
  `gioi_tinh` text,
  `dia_chi` text,
  `dien_thoai` text,
  `ngay_sinh` datetime DEFAULT NULL,
  `id_loai_khach_hang` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_khach_hang_Loai_khach_hang` (`id_loai_khach_hang`),
  CONSTRAINT `FK_khach_hang_Loai_khach_hang` FOREIGN KEY (`id_loai_khach_hang`) REFERENCES `loai_khach_hang` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


-- Tao bang phong
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
  `id` VARCHAR(20) NOT NULL,
  `id_phong` INTEGER unsigned NOT NULL,
  `ngay_thue` date NOT NULL,
  `ngay_tra` date NOT NULL ,
  `tong_gia` INTEGER unsigned NOT NULL,
  `id_loai_thue` INTEGER unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_chi_tiet_thue_phong_phong` (`id_phong`),
  KEY `FK_chi_tiet_thue_phong_loai_thue` (`id_loai_thue`),
  CONSTRAINT `FK_chi_tiet_thue_phong_loai_thue` FOREIGN KEY (`id_loai_thue`) REFERENCES `loai_thue` (`id`),
  CONSTRAINT `FK_chi_tiet_thue_phong_phong` FOREIGN KEY (`id_phong`) REFERENCES `phong` (`id`)
) ENGINE=InnoDB;

ALTER TABLE `hoteldb`.`chi_tiet_thue_phong` MODIFY COLUMN `ngay_tra` DATE NOT NULL DEFAULT '0000-00-00';


-- tao bang thue phong
DROP TABLE IF EXISTS `hoteldb`.`thue_phong`;
CREATE TABLE  `hoteldb`.`thue_phong` (
  `id_chi_tiet_thue` VARCHAR(20) NOT NULL,
  `id_khach` varchar(15) NOT NULL,
  PRIMARY KEY (`id_chi_tiet_thue`,`id_khach`),
  KEY `FK_thue_phong_khach` (`id_khach`),
  CONSTRAINT `FK_thue_phong_khach` FOREIGN KEY (`id_khach`) REFERENCES `khach_hang` (`id`),
  CONSTRAINT `FK_thue_phong_chi_tiet_thue` FOREIGN KEY (`id_chi_tiet_thue`) REFERENCES `chi_tiet_thue_phong` (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `hoteldb`.`khach_san`;
CREATE TABLE  `hoteldb`.`khach_san` (
  `id` integer unsigned NOT NULL,
  `Ten` text NOT NULL,
  `dia_chi` text NOT NULL,
  `dien_thoai` text NOT NULL,
  `fax` text NOT NULL,
  `email` text NOT NULL,
  `website` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Insert data
insert into khach_san values (1,'Khach san Rex','551/6 Le Quang Dinh P1 Go Vap HCM','0908957105','123456789','rex@gmail.com','www.google.com');

-- loai_khach_hang
INSERT INTO `loai_khach_hang`(`id`, `ten_loai_khach_hang`) VALUES (0, 'Trong Nuoc'),
                                                                  (1, 'Nuoc Ngoai');

-- loai_thue
INSERT INTO `loai_thue`(`id`, `loai`) VALUES
  (0, 'Dat phong'),
  (1, 'Thue phong');



-- tinh_trang_phong
INSERT INTO `tinh_trang_phong`(`id`, `ten`) VALUES
  (0, 'Con trong'),
  (1, 'Da thue');


-- loai_phong
INSERT INTO `loai_phong`(`id`, `ten`, `gia`) VALUES
  (0, 'VIP', 500000),
  (1, 'Hang trung', 400000),
  (2, 'Hang thuong', 350000);


insert into tham_so (`id`,`ten`,`kieu_du_lieu`,`gia_tri`,`kich_hoat`) values (1,'SoKhachHangToiDa','int','3',true),
                                                                            (2,'TienDatCocKhiThue','int','10000',true);
										(3,'TuoiToiThieu','int',16,true);

-- phong
INSERT INTO `phong`(`id`, `lau`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (1,1, null, 0, 0, '', ''),
  (2,1, null, 0, 0, '', ''),
  (3,1, null, 0, 0, '', ''),
  (4,1, null, 0, 0, '', ''),
  (5,1, null, 0, 0, '', ''),
  (6,1, null, 0, 1, '', ''),
  (7,2, null, 0, 1, '', ''),
  (8,2, null, 0, 1, '', ''),
  (9,2, null, 0, 1, '', ''),
  (10,2, null, 0, 1, '', ''),
  (11,2, null, 0, 1, '', ''),
  (12,2, null, 0, 1, '', ''),
  (13,2, null, 0, 1, '', ''),
  (14,2, null, 0, 1, '', ''),
  (15,3, null, 0, 1, '', ''),
  (16,3, null, 0, 2, '', ''),
  (17,3, null, 0, 2, '', ''),
  (18,3, null, 0, 2, '', ''),
  (19,3, null, 0, 2, '', ''),
  (20,3, null, 0, 2, '', ''),
  (21,3, null, 0, 2, '', '');

