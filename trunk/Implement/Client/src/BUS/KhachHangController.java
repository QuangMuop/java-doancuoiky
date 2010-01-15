/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IKhachHangDAO;
import DAO.ILoaiKhachHangDAO;
import DAO.IThamSoDAO;
import DTO.KhachHang;
import DTO.LoaiKhachHang;
import DTO.ThamSo;
import Utils.MyDateTime;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class KhachHangController {
    IKhachHangDAO khachDAO;
    ILoaiKhachHangDAO loaiKhachDAO;
    IThamSoDAO thamSoDAO;
    int TuoiToiThieu;

    public KhachHangController()
    {
        khachDAO = DAOFactory.getInstance().getKhachHangDAO();
        loaiKhachDAO = DAOFactory.getInstance().getLoaiKhachHangDAO();
        thamSoDAO = DAOFactory.getInstance().getThamSoDAO();
        TuoiToiThieu = -1;
        ThamSo thamSo = thamSoDAO.getThamSo("TuoiToiThieu");
        if(thamSo.isUse())
        {
            TuoiToiThieu = thamSo.getValue();
        }
    }

    public ArrayList<LoaiKhachHang> getDSLoaiKhachHang()
    {
        return loaiKhachDAO.getDSLoaiKhachHang();
    }

    public boolean insertKhachHang(KhachHang khach)
    {
        return khachDAO.insertKhachHang(khach);
    }

    public String kiemTraKhachHang(KhachHang khach)
    {
        if(khach.getNgaySinh()==null)
        {
            return "Vui lòng nhập vào ngày sinh của khách hàng";
        }
        if(khach.getId().equals(""))
        {
            return "Vui lòng nhập vào CMND khách hàng";
        }
        if(khach.getTen().equals(""))
        {
            return "Vui lòng nhập tên khách hàng";
        }
        if(TuoiToiThieu!=-1)
        {
            if((MyDateTime.getYear(MyDateTime.getNow()) - MyDateTime.getYear(khach.getNgaySinh())) <16)
                return "Tuổi tối thiểu để thuê khách sạn là " + TuoiToiThieu;
        }
        return "";
    }

    public boolean capNhatLoaiKhachHang(LoaiKhachHang loaiKhachHang)
    {
        return loaiKhachDAO.updateLoaiKhachHangTheoId(loaiKhachHang, loaiKhachHang.getId());
    }
}
