/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.TinhTrangPhong;
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
public class MySqlTinhTrangPhongDAO implements ITinhTrangPhongDAO {

    public ArrayList<TinhTrangPhong> getDSTinhTrangPhong() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select distinct * from tinh_trang_phong order by id;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();

            ArrayList<TinhTrangPhong> lst = new ArrayList<TinhTrangPhong>();
            TinhTrangPhong tinhTrangPhong = null;
            while(rs.next())
            {
                tinhTrangPhong = new TinhTrangPhong();
                tinhTrangPhong.setId(rs.getInt("id"));
                tinhTrangPhong.setTen(rs.getString("ten"));

                lst.add(tinhTrangPhong);
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

    public TinhTrangPhong getTinhTrangPhongTheoId(int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select * from tinh_trang_phong where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            TinhTrangPhong tinhTrangPhong = null;
            while(rs.next())
            {
                tinhTrangPhong = new TinhTrangPhong();
                tinhTrangPhong.setId(rs.getInt("id"));
                tinhTrangPhong.setTen(rs.getString("ten"));
            }

            statement.close();

            return tinhTrangPhong;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlTinhTrangPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public TinhTrangPhong getTinhTrangPhongTheoTen(String ten) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select * from tinh_trang_phong where ten like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, ten);

            ResultSet rs = statement.executeQuery();

            TinhTrangPhong tinhTrangPhong = null;
            while(rs.next())
            {
                tinhTrangPhong = new TinhTrangPhong();
                tinhTrangPhong.setId(rs.getInt("id"));
                tinhTrangPhong.setTen(rs.getString("ten"));
            }

            statement.close();

            return tinhTrangPhong;
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
