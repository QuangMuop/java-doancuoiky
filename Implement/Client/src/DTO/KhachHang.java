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
public abstract class KhachHang {
    protected String id;
    
    protected String ten;
    protected String gioiTinh;
    protected String diaChi;
    protected String dienThoai;
    protected Date ngaySinh;
    
    protected int donGia;
    protected String tenLoaiKhachHang;

    public KhachHang() {
    }

    public KhachHang(String id) {
        this.id = id;
    }

    public static KhachHang getInstance(int id)
    {
        switch(id)
        {
            case 0:
                return new KhachHangTrongNuoc();                
            case 1:
                return new KhachHangNuocNgoai();
        }
        return null;
    }

    public KhachHang(String id, String ten, String diaChi, String dienThoai, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
    }

    public void setDonGiaKhachHang(int donGia)
    {
        this.donGia = donGia;
    }

    public String getTenLoaiKhachHang()
    {
        return this.tenLoaiKhachHang;
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
    
    public abstract int getDonGiaKhachHang();
    public abstract String kiemTraMaPhong();

}