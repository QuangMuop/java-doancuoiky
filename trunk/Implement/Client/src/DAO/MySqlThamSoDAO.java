/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ThamSo;
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
public class MySqlThamSoDAO implements IThamSoDAO {
    public boolean updateThamSo(ThamSo ts) {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection();

            String sql = "update tham_so set gia_tri = ?, kich_hoat = ? where ten = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            statement.setString(1,"" + ts.getValue());
            statement.setBoolean(2, ts.isUse());
            statement.setString(3, ts.getName());

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
            Logger.getLogger(MySqlThamSoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ThamSo getThamSo(String tenThamSo) {
        Connector connector = new MySqlConnector();
        try {
            ThamSo thamSo = new ThamSo();

            connector.openConnection();

            String sql = "select gia_tri, kich_hoat, ten from tham_so where ten = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            statement.setString(1,tenThamSo);

            //execute query
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                thamSo.setUse(rs.getBoolean("kich_hoat"));
                thamSo.setValue(Integer.parseInt(rs.getString("gia_tri")));
                thamSo.setName(rs.getString("ten"));
            }

            statement.close();
            return thamSo;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThamSoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<ThamSo> getDSThamSo() {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection();

            String sql = "select gia_tri, kich_hoat, ten from tham_so;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<ThamSo> lst = new ArrayList<ThamSo>();

            while(rs.next())
            {
                ThamSo thamSo = new ThamSo();

                thamSo.setUse(rs.getBoolean("kich_hoat"));
                thamSo.setValue(Integer.parseInt(rs.getString("gia_tri")));
                thamSo.setName(rs.getString("ten"));

                lst.add(thamSo);
            }

            statement.close();
            return lst;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThamSoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
