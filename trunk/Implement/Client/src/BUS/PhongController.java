/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.ILoaiPhongDAO;
import DAO.IPhongDAO;
import DAO.ITinhTrangPhongDAO;
import DTO.LoaiPhong;
import DTO.Phong;
import DTO.TinhTrangPhong;
import Utils.CompareOption;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class PhongController {
    IPhongDAO phongDAO;
    ILoaiPhongDAO loaiPhongDAO;
    ITinhTrangPhongDAO tinhTrangPhongDAO;

    public PhongController()
    {
        phongDAO = DAOFactory.getInstance().getPhongDAO();
        loaiPhongDAO = DAOFactory.getInstance().getLoaiPhongDAO();
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

    public boolean updatePhong(Phong phong)
    {
        return phongDAO.updatePhongTheoId(phong.getId(), phong);
    }

    public ArrayList getDSLau(CompareOption option)
    {
        return phongDAO.getDSLau(option);
    }

    public int getLauCaoNhat()
    {
        ArrayList lst = phongDAO.getDSLau(CompareOption.GiamDan);
        if(lst!=null && lst.size()>0)
        {
            return Integer.parseInt(lst.get(0).toString());
        }
        else
            return 0;
    }

    public ArrayList<LoaiPhong> getDSLoaiPhong()
    {
        return loaiPhongDAO.getDSLoaiPhong();
    }

    public ArrayList<TinhTrangPhong> getDSTinhTrangPhong()
    {
        return tinhTrangPhongDAO.getDSTinhTrangPhong();
    }

    public ArrayList<Phong> timPhong(int id, int loaiPhong, int tinhTrang)
    {
        return phongDAO.getDSPhongTheoDK(id, loaiPhong, tinhTrang);
    }

    public ArrayList<Phong> getDSPhongChuaThue() {
        return phongDAO.getDSPhongChuaThue();
    }
}
