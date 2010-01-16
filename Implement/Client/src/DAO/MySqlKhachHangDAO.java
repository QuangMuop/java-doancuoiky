/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
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
            connector.openConnection();

            String sql = "select * from khach_hang, loai_khach_hang where khach_hang.id_loai_khach_hang = loai_khach_hang.id and khach_hang.id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, id);

            ResultSet rs = statement.executeQuery();
            KhachHang khach = null;
            
            while(rs.next())
            {
                int loaiKhachHang = rs.getInt("id_loai_khach_hang");
                khach = KhachHang.getInstance(loaiKhachHang);

                khach.setId(rs.getString("id"));
                khach.setDiaChi(rs.getString("dia_chi"));
                khach.setGioiTinh(rs.getString("gioi_tinh"));
                khach.setDienThoai(rs.getString("dien_thoai"));
                khach.setTen(rs.getString("ten"));
                khach.setNgaySinh(rs.getDate("ngay_sinh"));
                khach.setDonGiaKhachHang(rs.getInt("don_gia"));

                //loaiKhachHang = new LoaiKhachHang();
                //loaiKhachHang.setId(rs.getInt("id_loai_khach_hang"));
                //loaiKhachHang.setTen(rs.getString("ten_loai_khach_hang"));
                //loaiKhachHang.setGia(rs.getInt("don_gia"));

                //khach.setIdLoaiKhachHang(loaiKhachHang);
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
            connector.openConnection();

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

            String tenLoaiKhach = khachhang.getTenLoaiKhachHang().toLowerCase();
            if(tenLoaiKhach.equals("trong nuoc"))
            {
                statement.setInt(7, 0);
            }
            else
                statement.setInt(7, 1);

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
            connector.openConnection();

            String sql = "insert into khach_hang (id,ten, gioi_tinh, dia_chi, dien_thoai, ngay_sinh, id_loai_khach_hang) values ";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            boolean hasNewMember = false;

            int i;
            for(i=0;i<lstKhachHang.size();i++)
            {
                if(!checkKhachHangDaTonTai(lstKhachHang.get(i).getId()))
                {
                    hasNewMember = true;

                    KhachHang khach = lstKhachHang.get(i);
                    String tmpSql = "('" + khach.getId() + "','" + khach.getTen() + "','" + khach.getGioiTinh() + "','" + khach.getDiaChi() + "','" + khach.getDienThoai() + "','" + sdf.format(khach.getNgaySinh()) + "',";
                    String tenLoaiKhachHang = khach.getTenLoaiKhachHang().toLowerCase();
                    if(tenLoaiKhachHang.equals("trong nuoc"))
                    {
                        tmpSql += 0 + "),";
                    }
                    else
                        tmpSql += 1 + "),";


                    sql += tmpSql;
                }
            }

            if(!hasNewMember)
                return true;

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

    public boolean checkKhachHangDaTonTai(String id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select id from khach_hang where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, id);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }
    public int getDonGiaKhachHangTheoTen(String tenLoaiKhach) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select don_gia from loai_khach_hang where ten_loai_khach_hang like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, tenLoaiKhach);

            ResultSet rs = statement.executeQuery();
            int donGia = -1;
            while(rs.next())
            {
                donGia = rs.getInt("don_gia");
            }

            statement.close();
            return donGia;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateDonGiaLoaiKhachHangTheoTen(String tenLoaiKhachHang, int donGia) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "update loai_khach_hang set don_gia = ? where ten_loai_khach_hang = ?;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, donGia);
            statement.setString(2, tenLoaiKhachHang);

            if(statement.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<KhachHang> getDSLoaiKhachHang() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select distinct * from loai_khach_hang order by id;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            ArrayList<KhachHang> lst = new ArrayList<KhachHang>();
            while(rs.next())
            {
                KhachHang khach = KhachHang.getInstance(rs.getInt("id"));
                khach.setDonGiaKhachHang(rs.getInt("don_gia"));
                lst.add(khach);
            }

            statement.close();
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
