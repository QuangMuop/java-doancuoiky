/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class PhongHangThuong extends Phong {
    public PhongHangThuong()
    {
        this.tenLoaiPhong = "Hang Thuong";
    }

    @Override
    public int getDonGiaPhong() {
        return this.donGiaPhong;
    }

    @Override
    public int tinhTienDatCoc(int tienCocToiDa) {
        return 0;
    }

    @Override
    public int tinhTienThuePhong(int ngayThue) {
        return this.donGiaPhong*ngayThue;
    }
}
