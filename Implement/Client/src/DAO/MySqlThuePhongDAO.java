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
            connector.openConnection();

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
            khachHangDAO.insertKhachHang(tp.getLstKhachHang());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            connector.openConnection();

            //them vao bang chi tiet thue phong
            String sql = "INSERT INTO CHI_TIET_THUE_PHONG(id, id_phong, ngay_thue, tong_gia, id_loai_thue) VALUES (?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            String sIdPhong = "" + tp.getPhong().getId();
            SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            sIdPhong += formatIdChiTietThue.format(tp.getNgayThue());

            statement.setString(1, sIdPhong);
            statement.setInt(2, tp.getPhong().getId());
            statement.setString(3, sdf.format(tp.getNgayThue()));
            statement.setInt(4, 0);
            statement.setInt(5, tp.getIdLoaiThue().getId());

            statement.executeUpdate();
            statement.close();

            //them vao bang thue phong
            sql = "INSERT INTO THUE_PHONG(id_chi_tiet_thue, id_khach) VALUES ";

            int i;
            ArrayList<KhachHang> lstKhach = tp.getLstKhachHang();
            for(i=0;i<lstKhach.size();i++)
            {
                KhachHang khach = lstKhach.get(i);

                String tmpSql = "('" + sIdPhong + "','" + khach.getId() + "'),";
                sql += tmpSql;
            }

            sql = sql.substring(0, sql.length()-1);
            sql += ";";

            statement = connector.getConnection().prepareCall(sql);
            //them vao bang thue phong
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

            connector.openConnection();
            String sql = "update chi_tiet_thue_phong set ngay_tra = ?, tong_gia = ? where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            statement.setString(1, sdf.format(tp.getNgayTra()));
            statement.setInt(2, tp.getTongGia());
            statement.setString(3, tp.getId());

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
            connector.openConnection();
            String sql = "select * " +
                            "from chi_tiet_thue_phong, loai_thue " +
                            "where tong_gia = 0 and loai_thue.id = chi_tiet_thue_phong.id_loai_thue; ";

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            ArrayList<ThuePhong> lstThuePhong = new ArrayList<ThuePhong>();
            ThuePhong thuePhong = null;

            Phong phong = null;
            MySqlPhongDAO phongDAO = new MySqlPhongDAO();

            LoaiThue loaiThue = null;
            while(rs.next())
            {
                thuePhong = new ThuePhong();
                thuePhong.setNgayThue(rs.getDate("ngay_thue"));
                //thuePhong.setNgayTra(rs.getDate("ngay_tra"));
                thuePhong.setTongGia(rs.getInt("tong_gia"));
                thuePhong.setId(rs.getString("id"));

                phong = phongDAO.getPhongTheoId(rs.getInt("id_phong"));
                if(phong!=null)
                    thuePhong.setPhong(phong);

                loaiThue = new LoaiThue();
                loaiThue.setId(rs.getInt("loai_thue.id"));
                loaiThue.setLoai(rs.getString("loai_thue.loai"));
                thuePhong.setIdLoaiThue(loaiThue);

                //query khach
                thuePhong.setLstKhachHang(getDSKhachHangThuePhong(rs.getString("id")));

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

    public ArrayList<ThuePhong> getDSThuePhong(int nam, int thang) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<KhachHang> getDSKhachHangThuePhong(String sChiTietThue)
    {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection();
            String sql = "select id_khach from thue_phong where thue_phong.id_chi_tiet_thue = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, sChiTietThue);

            ResultSet rs = statement.executeQuery();
            ArrayList<KhachHang> lstKhachHang = new ArrayList<KhachHang>();
            KhachHang khach = null;
            MySqlKhachHangDAO khachDAO = new MySqlKhachHangDAO();

            while(rs.next())
            {
                khach = khachDAO.getKhachHangTheoId(rs.getString("id_khach"));
                lstKhachHang.add(khach);
            }

            statement.close();
            return lstKhachHang;

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
