/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class KhachHangNuocNgoai extends KhachHang {

    public KhachHangNuocNgoai()
    {
        this.tenLoaiKhachHang = "Nuoc Ngoai";
    }

    @Override
    public int getDonGiaKhachHang() {
        return this.donGia;
    }

    @Override
    public String kiemTraMaPhong() {
        if(this.id.length()!=6)
        {
            return "Số VISA phải có 6 chữ số";
        }
        return "";
    }
}
