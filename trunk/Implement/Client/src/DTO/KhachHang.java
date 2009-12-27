/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Date;


/**
 *
 * @author bin
 */
public class KhachHang {
    private String id;
    
    private String ten;
    private String gioiTinh;
    private String diaChi;
    private String dienThoai;
    private Date ngaySinh;
    private LoaiKhachHang idLoaiKhachHang;

    public KhachHang() {
    }

    public KhachHang(String id) {
        this.id = id;
    }

    public KhachHang(String id, String ten, String diaChi, String dienThoai, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public LoaiKhachHang getIdLoaiKhachHang() {
        return idLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(LoaiKhachHang idLoaiKhachHang) {
        this.idLoaiKhachHang = idLoaiKhachHang;
    }    
}
