/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IKhachHangDAO;
import DAO.IThamSoDAO;
import DTO.KhachHang;
import DTO.ThamSo;
import Utils.MyDateTime;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class KhachHangController {
    IKhachHangDAO khachDAO;    
    IThamSoDAO thamSoDAO;
    int TuoiToiThieu;

    public KhachHangController()
    {
        khachDAO = DAOFactory.getInstance().getKhachHangDAO();        
        thamSoDAO = DAOFactory.getInstance().getThamSoDAO();
        TuoiToiThieu = -1;
        ThamSo thamSo = thamSoDAO.getThamSo("TuoiToiThieu");
        if(thamSo.isUse())
        {
            TuoiToiThieu = thamSo.getValue();
        }
    }

    public ArrayList<KhachHang> getDSLoaiKhachHang()
    {
        return khachDAO.getDSLoaiKhachHang();
    }

    public boolean insertKhachHang(KhachHang khach)
    {
        return khachDAO.insertKhachHang(khach);
    }

    public String kiemTraKhachHang(KhachHang khach)
    {
        if(khach.getTen().equals(""))
        {
            return "Vui lòng nhập tên khách hàng";
        }
        if(khach.getNgaySinh()==null)
        {
            return "Vui lòng nhập vào ngày sinh của khách hàng";
        }
        else
        {
            if(TuoiToiThieu!=-1)
            {
                if((MyDateTime.getYear(MyDateTime.getNow()) - MyDateTime.getYear(khach.getNgaySinh())) <16)
                    return "Tuổi tối thiểu để thuê khách sạn là " + TuoiToiThieu;
            }
        }
        if(khach.getId().equals(""))
        {
            return "Vui lòng nhập vào CMND khách hàng";
        }
        else
        {
            return khach.kiemTraMaPhong();
        }
    }

    public boolean capNhatLoaiKhachHang(String loaiKhachHang, int donGia)
    {
        return khachDAO.updateDonGiaLoaiKhachHangTheoTen(loaiKhachHang, donGia);
    }
}
