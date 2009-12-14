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


-- Tao bang PHONG
CREATE TABLE `PHONG` (
  `id` INTEGER,
  `gia` INTEGER NOT NULL,
  `id_tinh_trang` INTEGER NOT NULL,
  `id_loai_phong` INTEGER NOT NULL,
  `hinh_anh` TEXT,
  `mo_ta` TEXT,

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang KHACH_HANG
CREATE TABLE `KHACH_HANG` (
  `id` INTEGER, -- cmnd/visa
  `ten` TEXT NOT NULL,
  `dia_chi` TEXT NOT NULL,
  `dien_thoai` TEXT NOT NULL,
  `ngay_sinh` DATETIME NOT NULL,
  `quoc_tich` TEXT,

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang LOAI_THUE
CREATE TABLE `LOAI_THUE` (
  `id` INTEGER,
  `loai` TEXT,    -- Dat phong/Thue phong

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang THUE_PHONG
CREATE TABLE `THUE_PHONG` (
  `id_phong` INTEGER,
  `id_khach_hang` INTEGER,
  `ngay_thue` DATETIME,
  `ngay_tra` DATETIME,
  `tong_gia` INTEGER,
  `id_loai_thue` INTEGER NOT NULL,

  PRIMARY KEY(`id_phong`, `id_khach_hang`, `ngay_thue`)
)
ENGINE = InnoDB;

-- Tao bang TINH_TRANG_PHONG
CREATE TABLE `TINH_TRANG_PHONG` (
  `id` INTEGER,
  `ten` TEXT NOT NULL,    -- Da thue/Con trong

  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

-- Tao bang LOAI_PHONG
CREATE TABLE `LOAI_PHONG` (
  `id` INTEGER,
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
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
 ADD CONSTRAINT `FK_PHONG_LOAI_PHONG` FOREIGN KEY `FK_PHONG_LOAI_PHONG` (`id_loai_phong`)
    REFERENCES `loai_phong` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;


ALTER TABLE `hoteldb`.`thue_phong`
 ADD CONSTRAINT `FK_THUE_PHONG_PHONG` FOREIGN KEY `FK_THUE_PHONG_PHONG` (`id_phong`)
    REFERENCES `phong` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
 ADD CONSTRAINT `FK_THUE_PHONG_KHACH_HANG` FOREIGN KEY `FK_THUE_PHONG_KHACH_HANG` (`id_khach_hang`)
    REFERENCES `khach_hang` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
 ADD CONSTRAINT `FK_THUE_PHONG_LOAI_THUE` FOREIGN KEY `FK_THUE_PHONG_LOAI_THUE` (`id_loai_thue`)
    REFERENCES `loai_thue` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;
