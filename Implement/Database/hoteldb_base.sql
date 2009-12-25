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


-- Tao bang PHONG
CREATE TABLE `PHONG` (
  `id` INTEGER AUTO_INCREMENT,
  `gia` INTEGER,
  `id_tinh_trang` INTEGER NOT NULL,
  `id_loai_phong` INTEGER NOT NULL,
  `hinh_anh` TEXT,
  `mo_ta` TEXT,

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang LOAI KHACH HANG
CREATE TABLE  `LOAI_KHACH_HANG` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `loai` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Tao bang KHACH_HANG
CREATE TABLE  `KHACH_HANG` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` text NOT NULL,
  `gioi_tinh` text,
  `dia_chi` text NOT NULL,
  `dien_thoai` text NOT NULL,
  `ngay_sinh` datetime NOT NULL,
  `id_loai_khach_hang` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_khach_hang_Loai_khach_hang` (`id_loai_khach_hang`),
  CONSTRAINT `FK_khach_hang_Loai_khach_hang` FOREIGN KEY (`id_loai_khach_hang`) REFERENCES `loai_khach_hang` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Tao bang LOAI_THUE
CREATE TABLE `LOAI_THUE` (
  `id` INTEGER AUTO_INCREMENT,
  `loai` TEXT,    -- Dat phong/Thue phong

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang THUE_PHONG
CREATE TABLE `THUE_PHONG` (
  `id_phong` INTEGER NOT NULL,
  `id_khach_hang` INTEGER NOT NULL,
  `ngay_thue` DATETIME NOT NULL,
  `ngay_tra` DATETIME,
  `tong_gia` INTEGER,
  `id_loai_thue` INTEGER NOT NULL,

  PRIMARY KEY(`id_phong`, `id_khach_hang`, `ngay_thue`)
)
ENGINE = InnoDB;

-- Tao bang TINH_TRANG_PHONG
CREATE TABLE `TINH_TRANG_PHONG` (
  `id` INTEGER AUTO_INCREMENT,
  `ten` TEXT NOT NULL,    -- Da thue/Con trong

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang LOAI_PHONG
CREATE TABLE `LOAI_PHONG` (
  `id` INTEGER AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `gia` INTEGER NOT NULL,

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang THAM_SO
CREATE TABLE `THAM_SO` (
  `id` INTEGER,
  `ten` TEXT NOT NULL,
  `kieu_du_lieu` TEXT NOT NULL,
  `gia_tri` TEXT NOT NULL,
  `kich_hoat` TEXT NOT NULL,

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Update constraints
ALTER TABLE `hoteldb`.`phong`
 ADD CONSTRAINT `FK_PHONG_TINH_TRANG` FOREIGN KEY `FK_PHONG_TINH_TRANG` (`id_tinh_trang`)
    REFERENCES `tinh_trang_phong` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE ,
 ADD CONSTRAINT `FK_PHONG_LOAI_PHONG` FOREIGN KEY `FK_PHONG_LOAI_PHONG` (`id_loai_phong`)
    REFERENCES `loai_phong` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE ;


ALTER TABLE `hoteldb`.`thue_phong`
 ADD CONSTRAINT `FK_THUE_PHONG_PHONG` FOREIGN KEY `FK_THUE_PHONG_PHONG` (`id_phong`)
    REFERENCES `phong` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE ,
 ADD CONSTRAINT `FK_THUE_PHONG_KHACH_HANG` FOREIGN KEY `FK_THUE_PHONG_KHACH_HANG` (`id_khach_hang`)
    REFERENCES `khach_hang` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE ,
 ADD CONSTRAINT `FK_THUE_PHONG_LOAI_THUE` FOREIGN KEY `FK_THUE_PHONG_LOAI_THUE` (`id_loai_thue`)
    REFERENCES `loai_thue` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


-- Insert data
-- LOAI_KHACH_HANG
INSERT INTO `LOAI_KHACH_HANG`(`id`, `loai`) VALUES
  (2, 0);
INSERT INTO `LOAI_KHACH_HANG`(`id`, `loai`) VALUES
  (1, 1);


-- KHACH_HANG
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (10, 'Ly Thuong Kiet', 'Nam', 'Dia chi', 'Dien thoai', '1234-12-13', 2);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (1, 'Tran Quoc Tuan', 'Nam', 'Dia chi', 'Dien thoai', '1234-12-24', 2);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (2, 'Phan Van Khai', 'Nam', 'Dia chi', 'Dien thoai', '1960-01-01', 2);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (3, 'Ho Chi Minh', 'Nam', 'Dia chi', 'Dien thoai', '1969-05-19', 2);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (4, 'Athur', 'Nam', 'Dia chi', 'Dien thoai', '0123-02-14', 1);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (5, 'Obama', 'Nam', 'Dia chi', 'Dien thoai', '1958-06-01', 1);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (6, 'Binladen', 'Nam', 'Dia chi', 'Dien thoai', '1957-03-08', 1);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (7, 'Nguyen Hoang Vu', 'Nam', 'Dia chi', 'Dien thoai', '1988-10-28', 2);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (8, 'Lam Chi Dinh', 'Nam', 'Dia chi', 'Dien thoai', '1970-01-09', 1);
INSERT INTO `KHACH_HANG`(`id`, `ten`, `gioi_tinh`, `dia_chi`, `dien_thoai`, `ngay_sinh`, `id_loai_khach_hang`) VALUES
  (9, 'Mizore-chan', 'Nu', 'Dia chi', 'Dien thoai', '2007-01-01', 1);


-- LOAI_THUE
INSERT INTO `LOAI_THUE`(`id`, `loai`) VALUES
  (1, 'Dat phong');
INSERT INTO `LOAI_THUE`(`id`, `loai`) VALUES
  (2, 'Thue phong');


-- TINH_TRANG_PHONG
INSERT INTO `TINH_TRANG_PHONG`(`id`, `ten`) VALUES
  (1, 'Con trong');
INSERT INTO `TINH_TRANG_PHONG`(`id`, `ten`) VALUES
  (2, 'Da thue');


-- LOAI_PHONG
INSERT INTO `LOAI_PHONG`(`id`, `ten`, `gia`) VALUES
  (1, 'VIP', 500000);
INSERT INTO `LOAI_PHONG`(`id`, `ten`, `gia`) VALUES
  (2, 'Hang trung', 400000);
INSERT INTO `LOAI_PHONG`(`id`, `ten`, `gia`) VALUES
  (3, 'Hang thuong', 350000);


-- PHONG
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (1, null, 1, 1, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (2, null, 1, 1, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (3, null, 1, 1, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (4, null, 2, 1, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (5, null, 2, 1, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (6, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (7, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (8, null, 2, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (9, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (10, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (11, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (12, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (13, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (14, null, 1, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (15, null, 2, 2, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (16, null, 2, 3, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (17, null, 2, 3, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (18, null, 2, 3, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (19, null, 2, 3, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (20, null, 1, 3, '', '');
INSERT INTO `PHONG`(`id`, `gia`, `id_tinh_trang`, `id_loai_phong`, `hinh_anh`, `mo_ta`) VALUES
  (21, null, 1, 3, '', '');


-- THUE_PHONG
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (1, 2, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (2, 3, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (3, 4, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (3, 5, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (3, 6, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (4, 7, '2009-12-24', null, null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (5, 8, '2009-12-24', '2009-12-25', null, 1);
INSERT INTO `THUE_PHONG`(`id_phong`, `id_khach_hang`, `ngay_thue`, `ngay_tra`, `tong_gia`, `id_loai_thue`) VALUES
  (6, 9, '2009-12-24', null, null, 1);