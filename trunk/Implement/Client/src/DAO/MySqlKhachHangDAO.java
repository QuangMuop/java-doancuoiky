/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import DTO.LoaiKhachHang;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlKhachHangDAO implements IKhachHangDAO {

    public KhachHang getKhachHangTheoId(int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select khach_hang.*, loai_khach_hang.ten_loai_khach_hang from khach_hang, loai_khach_hang where khach_hang.id_loai_khach_hang = loai_khach_hang.id and khach_hang.id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            KhachHang khach = null;
            LoaiKhachHang loaiKhachHang = null;
            while(rs.next())
            {
                khach = new KhachHang();
                khach.setId(rs.getInt("id"));
                khach.setDiaChi(rs.getString("dia_chi"));
                khach.setGioiTinh(rs.getString("gioi_tinh"));
                khach.setDienThoai(rs.getString("dien_thoai"));
                khach.setTen(rs.getString("ten"));
                khach.setNgaySinh(rs.getDate("ngay_sinh"));

                loaiKhachHang = new LoaiKhachHang();
                loaiKhachHang.setId(rs.getInt("id_loai_khach_hang"));
                loaiKhachHang.setTen("loai_khach_hang.ten");

                khach.setIdLoaiKhachHang(loaiKhachHang);
            }
            return khach;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean insertKhachHang(KhachHang khachhang) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "insert into khach_hang (ten, gioi_tinh, dia_chi, dien_thoai, ngay_sinh, id_loai_khach_hang) values(?,?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, khachhang.getTen());
            statement.setString(2, khachhang.getGioiTinh());
            statement.setString(3, khachhang.getDiaChi());
            statement.setString(4, khachhang.getDienThoai());
            statement.setDate(5,(Date) khachhang.getNgaySinh());
            statement.setInt(6, khachhang.getIdLoaiKhachHang().getId());

            //execute query
            if(statement.executeUpdate(sql)>0)
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
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
