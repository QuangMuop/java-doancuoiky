/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiKhachHang;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bin
 */
public class MySqlLoaiKhachHangDAO implements ILoaiKhachHangDAO {

    public ArrayList<LoaiKhachHang> getDSLoaiKhachHang() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select distinct * from loai_khach_hang order by id;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            ArrayList<LoaiKhachHang> lst = new ArrayList<LoaiKhachHang>();
            LoaiKhachHang loaiKhachHang = null;
            while(rs.next())
            {
                loaiKhachHang = new LoaiKhachHang();
                loaiKhachHang.setId(rs.getInt("id"));
                loaiKhachHang.setTen(rs.getString("ten_loai_khach_hang"));

                lst.add(loaiKhachHang);
            }

            statement.close();
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlLoaiKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public LoaiKhachHang getLoaiKhachHangTheoTen(String ten) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select * from loai_khach_hang where ten_loai_khach_hang like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, ten);

            ResultSet rs = statement.executeQuery();

            LoaiKhachHang loaiKhachHang = null;
            while(rs.next())
            {
                loaiKhachHang = new LoaiKhachHang();
                loaiKhachHang.setId(rs.getInt("id"));
                loaiKhachHang.setTen(rs.getString("ten_loai_khach_hang"));
            }

            statement.close();
            return loaiKhachHang;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlLoaiKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public LoaiKhachHang getLoaiKhachHangTheoId(int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select * from loai_khach_hang where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            LoaiKhachHang loaiKhachHang = null;
            while(rs.next())
            {
                loaiKhachHang = new LoaiKhachHang();
                loaiKhachHang.setId(rs.getInt("id"));
                loaiKhachHang.setTen(rs.getString("ten_loai_khach_hang"));
            }

            statement.close();
            return loaiKhachHang;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlLoaiKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateLoaiKhachHangTheoId(LoaiKhachHang loaiKhachHang, int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "update loai_khach_hang set ten_loai_khach_hang = ? where id = ?;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, loaiKhachHang.getTen());
            statement.setInt(2, id);

            if(statement.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlLoaiKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
