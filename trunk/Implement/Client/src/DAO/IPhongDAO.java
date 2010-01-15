/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Phong;
import DTO.TinhTrangPhong;
import Utils.CompareOption;
import java.util.ArrayList;

public interface IPhongDAO {
    public Phong getPhongTheoId(int id);
    public ArrayList<Phong> getDSPhongTheoDK(int id, int idLoaiPhong, int idTinhTrangPhong);
    public ArrayList<Phong> getDSPhongTheoLau(int floor);
    public boolean updatePhongTheoId(int id, Phong phong);
    public ArrayList getDSLau(CompareOption option);
    public ArrayList<Phong> getDSPhongDangThue();
    public ArrayList<Phong> getDSPhongConTrong();
    public boolean updateTinhTrangPhongTheoId(int id, TinhTrangPhong tinhTrangPhong);
    public ArrayList<Phong> getDSPhong();
    public Integer[] getListIdPhongConTrong();
}
