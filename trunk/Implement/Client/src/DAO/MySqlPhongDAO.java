/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiPhong;
import DTO.Phong;
import DTO.TinhTrangPhong;
import Utils.CompareOption;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlPhongDAO implements IPhongDAO {
    public MySqlPhongDAO()
    {

    }

    public Phong getPhongTheoId(int id) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select phong.*, tinh_trang_phong.ten , loai_phong.ten, loai_phong.gia from phong, tinh_trang_phong, loai_phong where phong.id_tinh_trang =  tinh_trang_phong.id and phong.id_loai_phong = loai_phong.id and phong.id = ?";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            //execute query
            ResultSet rs = statement.executeQuery();

            Phong phong = null;
            TinhTrangPhong tinhTrangPhong;
            LoaiPhong loaiPhong;

            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();
            MySqlLoaiPhongDAO loaiPhongDAO = new MySqlLoaiPhongDAO();
            while(rs.next())
            {
                 phong = new Phong();
                 phong.setId(rs.getInt("id"));
                 phong.setLau(rs.getInt("lau"));
                 phong.setGia(rs.getInt("gia"));

                 int id_tinh_trang = rs.getInt("id_tinh_trang");
                 tinhTrangPhong = tinhTrangPhongDAO.getTinhTrangPhongTheoId(id_tinh_trang);
                 phong.setIdTinhTrang(tinhTrangPhong);

                 int id_loai_phong = rs.getInt("id_loai_phong");
                 loaiPhong = loaiPhongDAO.getLoaiPhongTheoId(id_loai_phong);
                 phong.setIdLoaiPhong(loaiPhong);

                 phong.setHinhAnh(rs.getString("hinh_anh"));
                 phong.setMoTa(rs.getString("mo_ta"));
            }

            statement.close();
            return phong;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }
    
    /**
     * lay danh sach tat ca cac lau hien co trong khach san va xep theo option
     * option -- xep tang dan/ xep giam dan
     */
    public ArrayList getDSLau(CompareOption option)
    {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select distinct lau from phong order by lau ";
            if(option == CompareOption.GiamDan)
            {
                sql += "DESC";
            }
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList lstLau = new ArrayList();

            while(rs.next())
            {
                 lstLau.add(rs.getInt("lau"));
            }

            statement.close();
            return lstLau;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<Phong> getDSPhongTheoLau(int floor) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select phong.*, tinh_trang_phong.ten , loai_phong.ten, loai_phong.gia from phong, tinh_trang_phong, loai_phong where phong.id_tinh_trang =  tinh_trang_phong.id and phong.id_loai_phong = loai_phong.id and phong.lau = ? order by id";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, floor);

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong;
            TinhTrangPhong tinhTrangPhong;
            LoaiPhong loaiPhong;

            while(rs.next())
            {
                 phong = new Phong();
                 phong.setId(rs.getInt("id"));
                 phong.setLau(floor);
                 phong.setGia(rs.getInt("gia"));

                 tinhTrangPhong = new TinhTrangPhong();
                 tinhTrangPhong.setId(rs.getInt("id_tinh_trang"));
                 tinhTrangPhong.setTen(rs.getString("tinh_trang_phong.ten"));
                 phong.setIdTinhTrang(tinhTrangPhong);

                 loaiPhong = new LoaiPhong();
                 loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                 loaiPhong.setId(rs.getInt("id_loai_phong"));
                 loaiPhong.setTen(rs.getString("loai_phong.ten"));
                 phong.setIdLoaiPhong(loaiPhong);

                 phong.setHinhAnh(rs.getString("hinh_anh"));
                 phong.setMoTa(rs.getString("mo_ta"));

                lstPhong.add(phong);
            }

            statement.close();
            return lstPhong;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<Phong> getDSPhongDangThue()
    {
        Connector connector = new MySqlConnector();
        try {
            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();
            TinhTrangPhong tinhTrangPhong = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("da thue");

            connector.openConnection("HOTELDB", "root", "root");

            if(tinhTrangPhong!=null)
            {
                String sql = "select phong.*, loai_phong.ten, loai_phong.gia from phong, loai_phong where phong.id_loai_phong = loai_phong.id and phong.id_tinh_trang = ? order by id";
                CallableStatement statement = connector.getConnection().prepareCall(sql);
                statement.setInt(1, tinhTrangPhong.getId());

                //execute query
                ResultSet rs = statement.executeQuery();
                ArrayList<Phong> lstPhong = new ArrayList<Phong>();
                Phong phong;
                LoaiPhong loaiPhong;

                while(rs.next())
                {
                     phong = new Phong();
                     phong.setId(rs.getInt("id"));
                     phong.setLau(rs.getInt("lau"));
                     phong.setGia(rs.getInt("gia"));

                     phong.setIdTinhTrang(tinhTrangPhong);

                     loaiPhong = new LoaiPhong();
                     loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                     loaiPhong.setId(rs.getInt("id_loai_phong"));
                     loaiPhong.setTen(rs.getString("loai_phong.ten"));
                     phong.setIdLoaiPhong(loaiPhong);

                     phong.setHinhAnh(rs.getString("hinh_anh"));
                     phong.setMoTa(rs.getString("mo_ta"));

                    lstPhong.add(phong);
                }
                statement.close();

                return lstPhong;
            }
            else
            {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateTinhTrangPhongTheoId(int id, TinhTrangPhong tinhTrangPhong)
    {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "update phong set id_tinh_trang = ? where id = ?;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, tinhTrangPhong.getId());
            statement.setInt(2, id);

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
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updatePhongTheoId(int id, Phong phong) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            String sql = "update phong set lau = ?, gia = ?, id_tinh_trang = ?, id_loai_phong = ?, hinh_anh = ?, mo_ta = ? where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, phong.getLau());
            statement.setInt(2, phong.getGia());
            statement.setInt(3, phong.getIdTinhTrang().getId());
            statement.setInt(4, phong.getIdLoaiPhong().getId());
            statement.setString(5, phong.getHinhAnh());
            statement.setString(6, phong.getMoTa());
            statement.setInt(7, phong.getId());

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
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    /**
     * ham de tim danh sach cac phong thoa nhung dieu kien:
     * id
     * idLoaiPhong
     * idTinhTrangPhong
     * neu nhung truong nao bang -1 thi khong lay
     * */
    public ArrayList<Phong> getDSPhongTheoDK(int id, int idLoaiPhong, int idTinhTrangPhong) {
        String sql = "";
        if(id == -1 && idLoaiPhong == -1 && idTinhTrangPhong == -1)
        {
            sql = "select * from phong";
        }
        else
        {
            sql = "select * from phong where ";
            if(id != -1)
            {
                sql += "id = " + id + " and ";
            }
            if(idLoaiPhong != -1)
            {
                sql += "id_loai_phong = " + idLoaiPhong + " and ";
            }
            if(idTinhTrangPhong != -1)
            {
                sql += "id_tinh_trang = " + idTinhTrangPhong + " and ";
            }
            sql = sql.substring(0, sql.length() - 5);
        }

        Connector connector = new MySqlConnector();
        try {
            connector.openConnection("HOTELDB", "root", "root");

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
            ResultSet rs = statement.executeQuery();
            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong;

            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();
            MySqlLoaiPhongDAO loaiPhongDAO = new MySqlLoaiPhongDAO();
            while(rs.next())
            {
                phong = new Phong();
                phong.setId(rs.getInt("id"));
                phong.setLau(rs.getInt("lau"));
                phong.setGia(rs.getInt("gia"));
                phong.setHinhAnh(rs.getString("hinh_anh"));
                phong.setMoTa(rs.getString("mo_ta"));

                int id_loai_phong = rs.getInt("id_loai_phong");
                int id_tinh_trang = rs.getInt("id_tinh_trang");

                phong.setIdLoaiPhong(loaiPhongDAO.getLoaiPhongTheoId(id_loai_phong));
                phong.setIdTinhTrang(tinhTrangPhongDAO.getTinhTrangPhongTheoId(id_tinh_trang));

                lstPhong.add(phong);
            }
            statement.close();

            return lstPhong;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<Phong> getDSPhongConTrong()
    {
        Connector connector = new MySqlConnector();
        try {
            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();
            TinhTrangPhong tinhTrangPhong = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("Con trong");

            connector.openConnection("HOTELDB", "root", "root");

            String sql = "select phong.*, loai_phong.ten, loai_phong.gia from phong, loai_phong where phong.id_loai_phong = loai_phong.id and phong.id_tinh_trang = ? order by id";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, tinhTrangPhong.getId());

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong;            
            LoaiPhong loaiPhong;

            while(rs.next())
            {
                 phong = new Phong();
                 phong.setId(rs.getInt("id"));
                 phong.setLau(rs.getInt("lau"));
                 phong.setGia(rs.getInt("gia"));
                 
                 phong.setIdTinhTrang(tinhTrangPhong);

                 loaiPhong = new LoaiPhong();
                 loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                 loaiPhong.setId(rs.getInt("id_loai_phong"));
                 loaiPhong.setTen(rs.getString("loai_phong.ten"));
                 phong.setIdLoaiPhong(loaiPhong);

                 phong.setHinhAnh(rs.getString("hinh_anh"));
                 phong.setMoTa(rs.getString("mo_ta"));

                lstPhong.add(phong);
            }

            statement.close();
            return lstPhong;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }
}
