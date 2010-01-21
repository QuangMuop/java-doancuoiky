/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiThue;
import DTO.ThuePhong;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface IThuePhongDAO {
    public String insertThuePhong(ThuePhong tp);
    public boolean updateThuePhong(ThuePhong tp);    
    public ArrayList<ThuePhong> getDSThuePhong();
    public ArrayList<LoaiThue> getDSLoaiThue();
    public LoaiThue getLoaiThueTheoTen(String ten);
    public ResultSet thongKeThuePhong(int tuThang, int denThang, int nam);
    public boolean deleteThuePhong(String secutiryCode);
}
