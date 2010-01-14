/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IThuePhongDAO;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import Utils.MyDateTime;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bin
 */
public class ThuePhongController {
    IThuePhongDAO thuePhongDAO;

    public ThuePhongController()
    {
        thuePhongDAO = DAOFactory.getInstance().getThuePhongDAO();
    }

    /**
     * ham de thue phong
     * tra ve ma so xac nhan viec thue phong thanh cong
     * neu xay ra loi thi tra ve chuoi rong
     * */
    public String tiepNhanViecThuePhong(ThuePhong thuePhong)
    {
        try
        {
            return thuePhongDAO.insertThuePhong(thuePhong);
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }

    public boolean tiepNhanViecTraPhong(ThuePhong thuePhong)
    {
        return thuePhongDAO.updateThuePhong(thuePhong);
    }

    public boolean huyDatPhong(String secutiryCode)
    {
        return thuePhongDAO.deleteThuePhong(secutiryCode);
    }

    /**
     * ham de kiem tra nhung rang buoc nghiep vu khi thue phong
     * tra ve String hien thi loi xay ra
     * neu hop le thi tra ve chuoi rong
     * */
    public String kiemTraNghiepVuThuePhong(ThuePhong thuePhong)
    {   
        //kiem tra danh sach khach hang
        if(thuePhong.getLstKhachHang().size()==0)
        {
            return "Phải nhập vào thông tin khách hàng";
        }

        //ngay thue phai lon hon hoac bang ngay hien tai
        Date ngayThue = thuePhong.getNgayThue();

        Calendar calendar = Calendar.getInstance();
        Date ngayHienTai = calendar.getTime();
        if(MyDateTime.SubDate(ngayThue, ngayHienTai)>0)
        {
            return "Ngày thuê phải sau ngày hiện tại";
        }

        return "";
    }

    public ArrayList<LoaiThue> layDSLoaiThue()
    {
        return thuePhongDAO.getDSLoaiThue();
    }

    public LoaiThue layLoaiThueTheoTen(String ten)
    {
        return thuePhongDAO.getLoaiThueTheoTen(ten);
    }

    public ArrayList<ThuePhong> layDSThuePhong()
    {
        return thuePhongDAO.getDSThuePhong();
    }

    public ResultSet thongKeThuePhong(int tuThang, int denThang, int nam)
    {
        return thuePhongDAO.thongKeThuePhong(tuThang, denThang, nam);
    }

    public int tinhTienThuePhong(ThuePhong thuePhong, int soNgayThue) {
        Phong phong = thuePhong.getPhong();
        int gia = (phong.getGia() + phong.getIdLoaiPhong().getGia())*(soNgayThue+1);
        return gia;
    }
}
