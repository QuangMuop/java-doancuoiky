/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import java.util.ArrayList;

public interface IKhachHangDAO {
    public KhachHang getKhachHangTheoId(String id);
    public boolean insertKhachHang(KhachHang k);
    public boolean insertKhachHang(ArrayList<KhachHang> lstKhachHang);
}