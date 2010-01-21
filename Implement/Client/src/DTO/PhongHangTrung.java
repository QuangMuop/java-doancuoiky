/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class PhongHangTrung extends Phong {
    public PhongHangTrung()
    {
        this.tenLoaiPhong = "Hạng Trung";
    }

    @Override
    public int getDonGiaPhong() {
        return this.donGiaPhong;
    }

    @Override
    public int tinhTienDatCoc(int tienCocToiDa) {
        return tienCocToiDa*80/100;
    }

    @Override
    public int tinhTienThuePhong(int ngayThue) {
        return this.donGiaPhong*ngayThue;
    }
}
