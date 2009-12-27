/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiPhong;
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
public class MySqlLoaiPhongDAO implements ILoaiPhongDAO {
    public ArrayList<LoaiPhong> getDSLoaiPhong() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select distinct * from loai_phong;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();

            ArrayList<LoaiPhong> lst = new ArrayList<LoaiPhong>();
            LoaiPhong loaiPhong = null;
            while(rs.next())
            {
                loaiPhong = new LoaiPhong();
                loaiPhong.setId(rs.getInt("id"));
                loaiPhong.setTen(rs.getString("ten"));
                loaiPhong.setGia(rs.getInt("gia"));

                lst.add(loaiPhong);
            }

            statement.close();

            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlTinhTrangPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public LoaiPhong getLoaiPhongTheoId(int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select * from loai_phong where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            LoaiPhong loaiPhong = null;
            while(rs.next())
            {
                loaiPhong = new LoaiPhong();
                loaiPhong.setId(rs.getInt("id"));
                loaiPhong.setTen(rs.getString("ten"));
                loaiPhong.setGia(rs.getInt("gia"));
            }
            statement.close();

            return loaiPhong;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlTinhTrangPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public LoaiPhong getLoaiPhongTheoTen(String ten) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select * from loai_phong where ten like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, ten);

            ResultSet rs = statement.executeQuery();

            LoaiPhong loaiPhong = null;
            while(rs.next())
            {
                loaiPhong = new LoaiPhong();
                loaiPhong.setId(rs.getInt("id"));
                loaiPhong.setTen(rs.getString("ten"));
                loaiPhong.setGia(rs.getInt("gia"));
            }
            statement.close();

            return loaiPhong;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlTinhTrangPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

}
