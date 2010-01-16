/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachSan;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bin
 */
public class MySqlKhachSanDAO implements IKhachSanDAO {

    public KhachSan getKhachSan() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select * from khach_san;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            KhachSan khachSan = new KhachSan();
            while(rs.next())
            {
                khachSan.setDiaChi(rs.getString("dia_chi"));
                khachSan.setDienThoai(rs.getString("dien_thoai"));
                khachSan.setEmail(rs.getString("email"));
                khachSan.setFax(rs.getString("fax"));
                khachSan.setId(rs.getInt("id"));
                khachSan.setTen(rs.getString("ten"));
                khachSan.setWebsite(rs.getString("website"));
            }
            return khachSan;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateKhachSan(KhachSan khachSan, int id) {
        Connector connector = new MySqlConnector();
        CallableStatement statement = null;
        try {
            connector.openConnection();

            String sql = "update khach_san set dia_chi = ?, dien_thoai = ?, email = ?, fax = ?, ten = ?, website = ? where id = ?";
            statement = connector.getConnection().prepareCall(sql);

            statement.setString(1, khachSan.getDiaChi());
            statement.setString(2, khachSan.getDienThoai());
            statement.setString(3, khachSan.getEmail());
            statement.setString(4, khachSan.getFax());
            statement.setString(5, khachSan.getTen());
            statement.setString(6, khachSan.getWebsite());
            statement.setInt(7, khachSan.getId());

            return statement.executeUpdate()>0;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
