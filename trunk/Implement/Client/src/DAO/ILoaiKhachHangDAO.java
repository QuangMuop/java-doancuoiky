/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiKhachHang;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public interface ILoaiKhachHangDAO {
    public ArrayList<LoaiKhachHang> getDSLoaiKhachHang();
    public LoaiKhachHang getLoaiKhachHangTheoTen(String ten);
    public LoaiKhachHang getLoaiKhachHangTheoId(int id);
}
