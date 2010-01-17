/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


/**
 *
 * @author bin
 */
public abstract class Phong {
    protected int id;

    protected int lau;
    protected int gia;
    protected String hinhAnh;
    protected String moTa;
    protected TinhTrangPhong idTinhTrang;

    //protected LoaiPhong idLoaiPhong;

    protected String tenLoaiPhong;
    protected int donGiaPhong;

    public Phong() {
    }

    public Phong(int id) {
        this.id = id;
    }

    public static Phong getInstance(int id)
    {
        switch(id)
        {
            case 0:
                return new PhongVIP();
            case 1:
                return new PhongHangTrung();
            case 2:
                return new PhongHangThuong();
        }
        return null;
    }

    public String getTenLoaiPhong()
    {
        return this.tenLoaiPhong;
    }        
    
    public void setDonGiaPhong(int donGia)
    {
        this.donGiaPhong = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLau() {
        return lau;
    }

    public void setLau(int lau) {
        this.lau = lau;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public TinhTrangPhong getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(TinhTrangPhong idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public abstract int getDonGiaPhong();
    public abstract int tinhTienDatCoc(int tienCocToiDa);
    public abstract int tinhTienThuePhong(int ngayThue);
}