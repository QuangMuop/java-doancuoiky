/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class PhongVIP extends Phong {
    public PhongVIP()
    {
        this.tenLoaiPhong = "VIP";
    }

    @Override
    public int getDonGiaPhong() {
        return this.donGiaPhong;
    }

    @Override
    public int tinhTienDatCoc(int tienCocToiDa) {
        return tienCocToiDa;
    }

    @Override
    public int tinhTienThuePhong(int ngayThue) {
        return this.donGiaPhong*ngayThue;
    }
}
