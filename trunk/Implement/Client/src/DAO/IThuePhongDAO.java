/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import java.util.ArrayList;
import java.util.Date;

public interface IThuePhongDAO {
    public boolean insertThuePhong(ThuePhong tp);
    public boolean updateThuePhong(ThuePhong tp);
    public ThuePhong getThuePhong(KhachHang k, Phong p, Date ngay);
    public ArrayList<ThuePhong> getDSThuePhong();
    public ArrayList<LoaiThue> getDSLoaiThue();
    public ArrayList<ThuePhong> getDSThuePhong(int nam, int thang);
}
