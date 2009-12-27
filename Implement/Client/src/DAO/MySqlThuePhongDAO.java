/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlThuePhongDAO implements IThuePhongDAO {    
    public ThuePhong getThuePhong(KhachHang k, Phong p, Date ngay) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<LoaiThue> getDSLoaiThue() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select distinct * from loai_thue;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();

            ArrayList<LoaiThue> lst = new ArrayList<LoaiThue>();
            LoaiThue loaiThue = null;
            while(rs.next())
            {
                loaiThue = new LoaiThue();
                loaiThue.setId(rs.getInt("id"));
                loaiThue.setLoai(rs.getString("loai"));
                
                lst.add(loaiThue);
            }

            statement.close();

            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean insertThuePhong(ThuePhong tp) {
        Connector connector = new MySqlConnector();
        try {
            //them khach hang vao DB
            MySqlKhachHangDAO khachHangDAO = new MySqlKhachHangDAO();
            khachHangDAO.insertKhachHang(tp.getKhachHang());

            connector.openConnection("HOTELDB", "root", "root");

            String sql = "INSERT INTO THUE_PHONG(id_phong, id_khach_hang, ngay_thue, ngay_tra, tong_gia, id_loai_thue) VALUES (?,?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, tp.getPhong().getId());
            statement.setString(2, tp.getKhachHang().getId());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            statement.setString(3, sdf.format(tp.getNgayThue()));

            statement.setDate(4, null);
            statement.setInt(5, 0);
            statement.setInt(6, tp.getIdLoaiThue().getId());

            if(statement.executeUpdate()>0)
            {
                statement.close();
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateThuePhong(ThuePhong tp) {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection("HOTELDB", "root", "root");
            String sql = "update thue_phong set ngay_tra = ?, tong_gia = ? where id_khach_hang = ? and id_phong = ? and ngay_thue = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            statement.setString(1, sdf.format(tp.getNgayTra()));


            statement.setInt(2, tp.getTongGia());
            statement.setString(3,tp.getKhachHang().getId());
            statement.setInt(4, tp.getPhong().getId());


            statement.setString(5, sdf.format(tp.getNgayThue()));


            if(statement.executeUpdate()>0)
            {
                statement.close();
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<ThuePhong> getDSThuePhong()
    {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection("HOTELDB", "root", "root");
            String sql = "select * from loai_thue, thue_phong where tong_gia = 0 and thue_phong.id_loai_thue = loai_thue.id;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            ArrayList<ThuePhong> lstThuePhong = new ArrayList<ThuePhong>();
            ThuePhong thuePhong = null;

            Phong phong = null;
            MySqlPhongDAO phongDAO = new MySqlPhongDAO();

            KhachHang khach = null;
            MySqlKhachHangDAO khachDAO = new MySqlKhachHangDAO();

            LoaiThue loaiThue = null;
            while(rs.next())
            {
                thuePhong = new ThuePhong();
                thuePhong.setNgayThue(rs.getDate("ngay_thue"));
                thuePhong.setNgayTra(rs.getDate("ngay_tra"));
                thuePhong.setTongGia(rs.getInt("tong_gia"));

                loaiThue = new LoaiThue();
                loaiThue.setId(rs.getInt("loai_thue.id"));
                loaiThue.setLoai(rs.getString("loai_thue.loai"));
                thuePhong.setIdLoaiThue(loaiThue);

                phong = phongDAO.getPhongTheoId(rs.getInt("id_phong"));
                thuePhong.setPhong(phong);

                khach = khachDAO.getKhachHangTheoId(rs.getString("id_khach_hang"));
                thuePhong.setKhachHang(khach);

                lstThuePhong.add(thuePhong);
            }

            statement.close();
            return lstThuePhong;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
