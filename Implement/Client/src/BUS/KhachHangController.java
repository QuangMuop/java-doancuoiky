/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IKhachHangDAO;
import DAO.ILoaiKhachHangDAO;
import DTO.KhachHang;
import DTO.LoaiKhachHang;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class KhachHangController {
    IKhachHangDAO khachDAO;
    ILoaiKhachHangDAO loaiKhachDAO;

    public KhachHangController()
    {
        khachDAO = DAOFactory.getInstance().getKhachHangDAO();
        loaiKhachDAO = DAOFactory.getInstance().getLoaiKhachHangDAO();
    }

    public ArrayList<LoaiKhachHang> getDSLoaiKhachHang()
    {
        return loaiKhachDAO.getDSLoaiKhachHang();
    }

    public boolean insertKhachHang(KhachHang khach)
    {
        return khachDAO.insertKhachHang(khach);
    }
}
