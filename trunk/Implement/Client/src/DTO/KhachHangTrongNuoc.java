/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class KhachHangTrongNuoc extends KhachHang {
    public KhachHangTrongNuoc()
    {
        this.tenLoaiKhachHang = "Trong Nuoc";
    }

    @Override
    public int getDonGiaKhachHang() {
        return this.donGia;
    }

    @Override
    public String kiemTraMaPhong() {
        if(this.id.length()!=5)
        {
            return "Số CMND phải có 5 chữ số";
        }
        else
            return "";
    }
}
