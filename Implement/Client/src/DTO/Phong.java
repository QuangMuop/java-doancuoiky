/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


/**
 *
 * @author bin
 */
public class Phong {
    private int id;
    private int lau;
    private int gia;
    private String hinhAnh;
    private String moTa;
    private TinhTrangPhong idTinhTrang;
    private LoaiPhong idLoaiPhong;

    public Phong() {
    }

    public Phong(int id) {
        this.id = id;
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

    public LoaiPhong getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(LoaiPhong idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }    
}
