/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import DTO.TinhTrangPhong;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlThuePhongDAO implements IThuePhongDAO {    
    
    public ArrayList<LoaiThue> getDSLoaiThue() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

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

    public String insertThuePhong(ThuePhong tp) {
        Connector connector = new MySqlConnector();
        try {
            //them khach hang vao DB
            MySqlKhachHangDAO khachHangDAO = new MySqlKhachHangDAO();
            khachHangDAO.insertKhachHang(tp.getLstKhachHang());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            connector.openConnection();

            //them vao bang chi tiet thue phong
            String sql = "INSERT INTO CHI_TIET_THUE_PHONG(id, id_phong, ngay_thue, tong_gia, id_loai_thue) VALUES (?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            String sIdChiTietThue = "" + tp.getPhong().getId();
            //SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyyMMddhhmmss");

            String sNgayThue = formatIdChiTietThue.format(tp.getNgayThue());

            sIdChiTietThue += sNgayThue;

            statement.setString(1, sIdChiTietThue);
            statement.setInt(2, tp.getPhong().getId());
            statement.setString(3, sdf.format(tp.getNgayThue()));
            statement.setInt(4, 0);
            statement.setInt(5, tp.getIdLoaiThue().getId());

            if(!(statement.executeUpdate()>0))
            {
                statement.close();
                return "";
            }
            //them vao bang thue phong
            sql = "INSERT INTO THUE_PHONG(id_chi_tiet_thue, id_khach) VALUES ";

            int i;
            ArrayList<KhachHang> lstKhach = tp.getLstKhachHang();
            for(i=0;i<lstKhach.size();i++)
            {
                KhachHang khach = lstKhach.get(i);

                String tmpSql = "('" + sIdChiTietThue + "','" + khach.getId() + "'),";
                sql += tmpSql;
            }

            sql = sql.substring(0, sql.length()-1);
            sql += ";";

            statement = connector.getConnection().prepareCall(sql);
            //them vao bang thue phong
            if(statement.executeUpdate()>0)
            {
                statement.close();

                //cap nhat lai thong tin tinh trang phong
                MySqlPhongDAO phongDAO = new MySqlPhongDAO();
                MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();

                TinhTrangPhong tinhTrang = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("Da thue");
                phongDAO.updateTinhTrangPhongTheoId(tp.getPhong().getId(), tinhTrang);
                return sIdChiTietThue;
            }
            else
            {
                statement.close();
                return "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateThuePhong(ThuePhong tp) {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection();
            String sql = "update chi_tiet_thue_phong set ngay_tra = ?, tong_gia = ? where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(1, sdf.format(tp.getNgayTra()));
            statement.setInt(2, tp.getTongGia());
            statement.setString(3, tp.getId());

            if(statement.executeUpdate()>0)
            {
                statement.close();

                //cap nhat lai thong tin tinh trang phong
                MySqlPhongDAO phongDAO = new MySqlPhongDAO();
                MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();

                TinhTrangPhong tinhTrang = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("Con trong");
                phongDAO.updateTinhTrangPhongTheoId(tp.getPhong().getId(), tinhTrang);
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }        
    }

    public ArrayList<ThuePhong> getDSThuePhong()
    {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();
            String sql = "select * " +
                            "from chi_tiet_thue_phong, loai_thue " +
                            "where ngay_tra = '0000-00-00' and loai_thue.id = chi_tiet_thue_phong.id_loai_thue; ";

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();
            ArrayList<ThuePhong> lstThuePhong = new ArrayList<ThuePhong>();
            ThuePhong thuePhong = null;

            Phong phong = null;
            MySqlPhongDAO phongDAO = new MySqlPhongDAO();

            LoaiThue loaiThue = null;
            while(rs.next())
            {
                thuePhong = new ThuePhong();
                thuePhong.setNgayThue(rs.getDate("ngay_thue"));                
                thuePhong.setTongGia(rs.getInt("tong_gia"));
                thuePhong.setId(rs.getString("id"));

                phong = phongDAO.getPhongTheoId(rs.getInt("id_phong"));
                if(phong!=null)
                    thuePhong.setPhong(phong);

                loaiThue = new LoaiThue();
                loaiThue.setId(rs.getInt("loai_thue.id"));
                loaiThue.setLoai(rs.getString("loai_thue.loai"));
                thuePhong.setIdLoaiThue(loaiThue);

                //query khach
                thuePhong.setLstKhachHang(getDSKhachHangThuePhong(rs.getString("id")));

                lstThuePhong.add(thuePhong);
            }

            statement.close();
            return lstThuePhong;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<KhachHang> getDSKhachHangThuePhong(String sChiTietThue)
    {
        Connector connector = new MySqlConnector();
        try {

            connector.openConnection();
            String sql = "select id_khach from thue_phong where thue_phong.id_chi_tiet_thue = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, sChiTietThue);

            ResultSet rs = statement.executeQuery();
            ArrayList<KhachHang> lstKhachHang = new ArrayList<KhachHang>();
            KhachHang khach = null;
            MySqlKhachHangDAO khachDAO = new MySqlKhachHangDAO();

            while(rs.next())
            {
                khach = khachDAO.getKhachHangTheoId(rs.getString("id_khach"));
                lstKhachHang.add(khach);
            }

            statement.close();
            return lstKhachHang;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ResultSet thongKeThuePhong(int tuThang, int denThang, int nam) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();            
            String sql = "select phong.id, loai_phong.ten, loai_phong.gia, " +
                                "sum(TO_DAYS(ngay_tra) - TO_DAYS(ngay_thue) + 1) as `SoNgayThue`, " +
                                "sum(tong_gia) as `TongGiaTien` " +
                        "from chi_tiet_thue_phong, loai_phong, phong " +
                        "where month(ngay_thue) >= ? and month(ngay_thue) <= ? and year(ngay_thue) = ? " +
                                "and month(ngay_tra) >= ? and month(ngay_tra) <= ? and year(ngay_tra) = ? " +
                                "and phong.id = chi_tiet_thue_phong.id_phong and phong.id_loai_phong = loai_phong.id " +
                        "group by id_phong;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            statement.setInt(1, tuThang);
            statement.setInt(2, denThang);
            statement.setInt(3, nam);
            statement.setInt(4, tuThang);
            statement.setInt(5, denThang);
            statement.setInt(6, nam);

            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public LoaiThue getLoaiThueTheoTen(String ten) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select from loai_thue where loai = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            statement.setString(1, ten);

            ResultSet rs = statement.executeQuery();

            LoaiThue loaiThue = null;
            while(rs.next())
            {
                loaiThue = new LoaiThue();
                loaiThue.setId(rs.getInt("id"));
                loaiThue.setLoai(rs.getString("loai"));

            }

            statement.close();

            return loaiThue;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean deleteThuePhong(String secutiryCode) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();
            String sql = "delete from thue_phong where id_chi_tiet_thue = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            statement.setString(1, secutiryCode);

            if(statement.executeUpdate()>0)
            {
                statement.close();

                //lay id phong
                sql = "select id_phong from chi_tiet_thue_phong where id = ?";
                statement = connector.getConnection().prepareCall(sql);
                statement.setString(1, secutiryCode);

                int idPhong = -1;
                ResultSet rs = statement.executeQuery();
                while(rs.next())
                {
                    idPhong = rs.getInt("id_phong");
                }
                if(idPhong == -1)
                    return false;

                //cap nhat lai thong tin tinh trang phong
                MySqlPhongDAO phongDAO = new MySqlPhongDAO();
                MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();

                TinhTrangPhong tinhTrang = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("Con trong");
                phongDAO.updateTinhTrangPhongTheoId(idPhong, tinhTrang);
                statement.close();

                //xoa chi tiet thue phong
                sql = "delete from chi_tiet_thue_phong where id = ?;";
                statement = connector.getConnection().prepareCall(sql);
                statement.setString(1, secutiryCode);
                if(statement.executeUpdate()>0)
                    return true;
                else
                    return false;
            }
            else
            {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public String insertThuePhong(ThuePhong tp, DataOutputStream dos) {
        Connector connector = new MySqlConnector();
        try {
            //them khach hang vao DB
            MySqlKhachHangDAO khachHangDAO = new MySqlKhachHangDAO();
            khachHangDAO.insertKhachHang(tp.getLstKhachHang());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            connector.openConnection();

            //them vao bang chi tiet thue phong
            String sql = "INSERT INTO CHI_TIET_THUE_PHONG(id, id_phong, ngay_thue, tong_gia, id_loai_thue) VALUES (?,?,?,?,?);";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            String sIdChiTietThue = "" + tp.getPhong().getId();
            //SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyyMMddhhmmss");

            String sNgayThue = formatIdChiTietThue.format(tp.getNgayThue());

            sIdChiTietThue += sNgayThue;

            statement.setString(1, sIdChiTietThue);
            statement.setInt(2, tp.getPhong().getId());
            statement.setString(3, sdf.format(tp.getNgayThue()));
            statement.setInt(4, 0);
            statement.setInt(5, tp.getIdLoaiThue().getId());



            if(!(statement.executeUpdate()>0))
            {
                statement.close();
                return "";
            }

            /////////////////////
            try {
                dos.writeChars("Bat dau insert bang thue phong" + "\n");
            } catch (IOException ex) {
                Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ///////////////////////

            //them vao bang thue phong
            sql = "INSERT INTO THUE_PHONG(id_chi_tiet_thue, id_khach) VALUES ";

            int i;
            ArrayList<KhachHang> lstKhach = tp.getLstKhachHang();
            for(i=0;i<lstKhach.size();i++)
            {
                KhachHang khach = lstKhach.get(i);

                String tmpSql = "('" + sIdChiTietThue + "','" + khach.getId() + "'),";
                sql += tmpSql;
            }

            sql = sql.substring(0, sql.length()-1);
            sql += ";";

            /////////////////////
            try {
                dos.writeChars("cau lenh sql " + sql + "\n");
            } catch (IOException ex) {
                Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ///////////////////////

            statement = connector.getConnection().prepareCall(sql);
            //them vao bang thue phong
            if(statement.executeUpdate()>0)
            {
                /////////////////////
            try {
                dos.writeChars("insert bang thue phong thanh cong" + "\n");
            } catch (IOException ex) {
                Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ///////////////////////

                statement.close();

                //cap nhat lai thong tin tinh trang phong
                MySqlPhongDAO phongDAO = new MySqlPhongDAO();
                MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();

                TinhTrangPhong tinhTrang = tinhTrangPhongDAO.getTinhTrangPhongTheoTen("Da thue");
                phongDAO.updateTinhTrangPhongTheoId(tp.getPhong().getId(), tinhTrang);
                return sIdChiTietThue;
            }
            else
            {
                statement.close();
                return "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlThuePhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        finally
        {
            connector.closeConnection();
        }
    }
}