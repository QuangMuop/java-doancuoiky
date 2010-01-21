/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IPhongDAO;
import DAO.ITinhTrangPhongDAO;
import DTO.Phong;
import DTO.TinhTrangPhong;
import Utils.MyCompare;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class PhongController {
    IPhongDAO phongDAO;    
    ITinhTrangPhongDAO tinhTrangPhongDAO;

    public PhongController()
    {
        phongDAO = DAOFactory.getInstance().getPhongDAO();        
        tinhTrangPhongDAO = DAOFactory.getInstance().getTinhTrangPhongDAO();
    }

    public Phong getPhongTheoId(int id)
    {
        return phongDAO.getPhongTheoId(id);
    }
    
    public ArrayList<Phong> getDSPhongTheoLau(int floor)
    {
        return phongDAO.getDSPhongTheoLau(floor);
    }

    public ArrayList<Phong> getDSPhong()
    {
        return phongDAO.getDSPhong();
    }

    public boolean updatePhong(Phong phong)
    {
        return phongDAO.updatePhongTheoId(phong.getId(), phong);
    }

    private ArrayList getDSLau(MyCompare.CompareOption option)
    {
        return phongDAO.getDSLau(option);
    }

    public int getLauCaoNhat()
    {
        ArrayList lst = this.getDSLau(MyCompare.CompareOption.GiamDan);
        if(lst!=null && lst.size()>0)
        {
            return Integer.parseInt(lst.get(0).toString());
        }
        else
            return 0;
    }

    public ArrayList<String> getDSLoaiPhong()
    {
        return phongDAO.getDSLoaiPhong();
    }

    public ArrayList<TinhTrangPhong> getDSTinhTrangPhong()
    {
        return tinhTrangPhongDAO.getDSTinhTrangPhong();
    }

    public TinhTrangPhong getTinhTrangPhongTheoTen(String ten)
    {
        return tinhTrangPhongDAO.getTinhTrangPhongTheoTen(ten);
    }

    public ArrayList<Phong> timPhong(int id, String loaiPhong, int tinhTrang)
    {
        return phongDAO.getDSPhongTheoDK(id, loaiPhong, tinhTrang);
    }

    public ArrayList<Phong> getDSPhongChuaThue() {
        return phongDAO.getDSPhongConTrong();
    }

    public int getDonGiaPhongTheoTen(String ten)
    {
        return phongDAO.getDonGiaPhongTheoTen(ten);
    }

    public Integer[] getListIdPhongChuaThue() {
        return phongDAO.getListIdPhongConTrong();
    }

    public boolean capNhatLoaiPhong(String tenLoaiPhong, int donGia) {
        return phongDAO.updateDonGiaPhongTheoTen(tenLoaiPhong, donGia);//loaiPhongDAO.updateLoaiPhongTheoId(loaiPhong, loaiPhong.getId());
    }

    public String kiemTraNghiepVuPhong(Phong phong)
    {
        if(phong.getGia()<0)
            return "Giá tiền của phòng không được âm";
        if(phong.getId()<0)
            return "Số phòng không được âm";
        if(phong.getLau()<0)
            return "Số lầu không được âm";
        return "";
    }
}
