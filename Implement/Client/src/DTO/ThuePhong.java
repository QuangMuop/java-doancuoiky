/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bin
 */
public class ThuePhong {
    private String id;
    private Date ngayThue;
    private Date ngayTra;
    private int tongGia;
    private Phong phong;
    private ArrayList<KhachHang> lstKhachHang;
    private LoaiThue idLoaiThue;

    public ThuePhong() {
        lstKhachHang = new ArrayList<KhachHang>();
        idLoaiThue = new LoaiThue();
        phong = new Phong();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public ArrayList<KhachHang> getLstKhachHang()
    {
        return lstKhachHang;
    }

    public Date getNgayThue()
    {
        return ngayThue;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setNgayThue(Date ngayThue)
    {
        this.ngayThue = ngayThue;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }
    
    public void setLstKhachHang(ArrayList<KhachHang> khachHang) {
        this.lstKhachHang = khachHang;
    }

    public LoaiThue getIdLoaiThue() {
        return idLoaiThue;
    }

    public void setIdLoaiThue(LoaiThue idLoaiThue) {
        this.idLoaiThue = idLoaiThue;
    }

    public void addKhachHang(KhachHang khach)
    {
        this.lstKhachHang.add(khach);
    }
}
