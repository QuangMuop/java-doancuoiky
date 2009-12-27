/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;

public interface IKhachHangDAO {
    public KhachHang getKhachHangTheoId(int id);
    public boolean insertKhachHang(KhachHang k);
}