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
     * neu khong xay ra loi thi tra ve chuoi rong
     * */
    public String tiepNhanViecThuePhong(ThuePhong thuePhong)
    {
        try
        {
            String error = kiemTraNghiepVuThuePhong(thuePhong);
            if(error.equals(""))
            {
                if(thuePhongDAO.ghiNhanThuePhong(thuePhong))
                    return "";
                else
                    return "Thue phong that bai";
            }
            else
                return error;
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }

    public boolean tiepNhanViecTraPhong(ThuePhong thuePhong)
    {
        return thuePhongDAO.ghiNhanTraPhong(thuePhong);
    }

    /**
     * ham de kiem tra nhung rang buoc nghiep vu khi thue phong
     * tra ve String hien thi loi xay ra
     * neu hop le thi tra ve chuoi rong
     * */
    private String kiemTraNghiepVuThuePhong(ThuePhong thuePhong)
    {
        //ngay thue phai lon hon hoac bang ngay hien tai
        Date ngayThue = thuePhong.getNgayThue();

        Calendar calendar = Calendar.getInstance();
        Date ngayHienTai = calendar.getTime();
        if(ngayThue.after(ngayHienTai))
        {
            return "Ngay thue phai sau ngay hien tai!";
        }

        return "";
    }

    public ArrayList<LoaiThue> layDSLoaiThue()
    {
        return thuePhongDAO.layDSLoaiThue();
    }

    public ArrayList<ThuePhong> layDSThuePhong()
    {
        return null;
    }

    public int tinhTienThuePhong(Phong phong, int soNgayThue)
    {
        return phong.getIdLoaiPhong().getGia() * soNgayThue;
    }
}
