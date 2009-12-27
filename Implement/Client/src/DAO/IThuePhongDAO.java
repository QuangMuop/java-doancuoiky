/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import DTO.Phong;
import DTO.ThuePhong;
import java.util.Date;

public interface IThuePhongDAO {
    public boolean ghiNhanThuePhong(ThuePhong tp);
    public boolean ghiNhanTraPhong(ThuePhong tp);
    public ThuePhong layThuePhong(KhachHang k, Phong p, Date ngay);
}
