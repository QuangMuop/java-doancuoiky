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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlKhachHangDAO implements IKhachHangDAO {

    public KhachHang getKhachHangTheoId(String id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select khach_hang.*, loai_khach_hang.ten_loai_khach_hang from khach_hang, loai_khach_hang where khach_hang.id_loai_khach_hang = loai_khach_hang.id and khach_hang.id like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, id);

            ResultSet rs = statement.executeQuery();
            KhachHang khach = null;
            LoaiKhachHang loaiKhachHang = null;
            while(rs.next())
            {
                khach = new KhachHang();
                khach.setId(rs.getString("id"));
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

            String sql = "insert into khach_hang (id,ten, gioi_tinh, dia_chi, dien_thoai, ngay_sinh, id_loai_khach_hang) values(?,?,?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, khachhang.getId());
            statement.setString(2, khachhang.getTen());
            statement.setString(3, khachhang.getGioiTinh());
            statement.setString(4, khachhang.getDiaChi());
            statement.setString(5, khachhang.getDienThoai());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");            
            String strDate = sdf.format(khachhang.getNgaySinh());
            //statement.setString(6, sdf.format(khachhang.getNgaySinh()));

            statement.setDate(6, Date.valueOf(strDate));

            //statement.setDate(6,(Date) khachhang.getNgaySinh());

            statement.setInt(7, khachhang.getIdLoaiKhachHang().getId());

            //execute query
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
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean insertKhachHang(ArrayList<KhachHang> lstKhachHang) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "insert into khach_hang (id,ten, gioi_tinh, dia_chi, dien_thoai, ngay_sinh, id_loai_khach_hang) values ";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            int i;
            for(i=0;i<lstKhachHang.size();i++)
            {
                KhachHang khach = lstKhachHang.get(i);
                String tmpSql = "('" + khach.getId() + "','" + khach.getTen() + "','" + khach.getGioiTinh() + "','" + khach.getDiaChi() + "','" + khach.getDienThoai() + "','" + sdf.format(khach.getNgaySinh()) + "'," + khach.getIdLoaiKhachHang().getId() + "),";
                sql += tmpSql;
            }

            sql = sql.substring(0, sql.length()-1);
            sql += ";";

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
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
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
