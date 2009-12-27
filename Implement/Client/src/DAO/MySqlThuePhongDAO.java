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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlThuePhongDAO implements IThuePhongDAO {

    public boolean ghiNhanThuePhong(ThuePhong tp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean ghiNhanTraPhong(ThuePhong tp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ThuePhong layThuePhong(KhachHang k, Phong p, Date ngay) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<LoaiThue> layDSLoaiThue() {
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
}
