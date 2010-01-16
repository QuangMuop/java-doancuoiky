/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

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
            connector.openConnection();

            String sql = "select phong.*, tinh_trang_phong.ten , loai_phong.ten, loai_phong.gia from phong, tinh_trang_phong, loai_phong where phong.id_tinh_trang =  tinh_trang_phong.id and phong.id_loai_phong = loai_phong.id and phong.id = ?";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, id);

            //execute query
            ResultSet rs = statement.executeQuery();

            Phong phong = null;
            TinhTrangPhong tinhTrangPhong;
            //LoaiPhong loaiPhong;

            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();
            //MySqlLoaiPhongDAO loaiPhongDAO = new MySqlLoaiPhongDAO();

            while(rs.next())
            {
                int id_loai_phong = rs.getInt("id_loai_phong");
                phong = Phong.getInstance(id_loai_phong);

                 phong.setId(rs.getInt("id"));
                 phong.setLau(rs.getInt("lau"));
                 phong.setGia(rs.getInt("gia"));

                 int id_tinh_trang = rs.getInt("id_tinh_trang");
                 tinhTrangPhong = tinhTrangPhongDAO.getTinhTrangPhongTheoId(id_tinh_trang);
                 phong.setIdTinhTrang(tinhTrangPhong);
                 
                 //loaiPhong = loaiPhongDAO.getLoaiPhongTheoId(id_loai_phong);
                 //phong.setIdLoaiPhong(loaiPhong);
                 phong.setDonGiaPhong(rs.getInt("loai_phong.gia"));

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
            connector.openConnection();

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
            connector.openConnection();

            String sql = "select phong.*, tinh_trang_phong.ten , loai_phong.ten, loai_phong.gia from phong, tinh_trang_phong, loai_phong where phong.id_tinh_trang =  tinh_trang_phong.id and phong.id_loai_phong = loai_phong.id and phong.lau = ? order by id";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, floor);

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong = null;
            TinhTrangPhong tinhTrangPhong;

            while(rs.next())
            {
                int idLoaiPhong = rs.getInt("id_loai_phong");
                phong = Phong.getInstance(idLoaiPhong);
                 
                 phong.setId(rs.getInt("id"));
                 phong.setLau(floor);
                 phong.setGia(rs.getInt("gia"));
                 phong.setDonGiaPhong(rs.getInt("loai_phong.gia"));

                 tinhTrangPhong = new TinhTrangPhong();
                 tinhTrangPhong.setId(rs.getInt("id_tinh_trang"));
                 tinhTrangPhong.setTen(rs.getString("tinh_trang_phong.ten"));
                 phong.setIdTinhTrang(tinhTrangPhong);

                 //loaiPhong = new LoaiPhong();
                 //loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                 //loaiPhong.setId(rs.getInt("id_loai_phong"));
                 //loaiPhong.setTen(rs.getString("loai_phong.ten"));
                 //phong.setIdLoaiPhong(loaiPhong);

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

            connector.openConnection();

            if(tinhTrangPhong!=null)
            {
                String sql = "select phong.*, loai_phong.ten, loai_phong.gia from phong, loai_phong where phong.id_loai_phong = loai_phong.id and phong.id_tinh_trang = ? order by id";
                CallableStatement statement = connector.getConnection().prepareCall(sql);
                statement.setInt(1, tinhTrangPhong.getId());

                //execute query
                ResultSet rs = statement.executeQuery();
                ArrayList<Phong> lstPhong = new ArrayList<Phong>();
                Phong phong = null;

                while(rs.next())
                {
                     //phong = new Phong();
                     int idLoaiPhong = rs.getInt("id_loai_phong");
                    phong = Phong.getInstance(idLoaiPhong);

                     phong.setId(rs.getInt("id"));
                     phong.setLau(rs.getInt("lau"));
                     phong.setGia(rs.getInt("gia"));
                     phong.setDonGiaPhong(rs.getInt("loai_phong.gia"));//this.getDonGiaPhongTheoTen(phong.getTenLoaiPhong()));
                     phong.setIdTinhTrang(tinhTrangPhong);

//                     loaiPhong = new LoaiPhong();
//                     loaiPhong.setGia(rs.getInt("loai_phong.gia"));
//                     loaiPhong.setId(rs.getInt("id_loai_phong"));
//                     loaiPhong.setTen(rs.getString("loai_phong.ten"));
//                     phong.setIdLoaiPhong(loaiPhong);

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
            connector.openConnection();

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
            connector.openConnection();

            String sql = "update phong set lau = ?, gia = ?, id_tinh_trang = ?, id_loai_phong = ?, hinh_anh = ?, mo_ta = ? where id = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, phong.getLau());
            statement.setInt(2, phong.getGia());
            statement.setInt(3, phong.getIdTinhTrang().getId());

            String loaiPhong = phong.getTenLoaiPhong().toLowerCase();
            if(loaiPhong.equals("vip"))
            {
                statement.setInt(4, 0);
            }
            else
                if(loaiPhong.equals("hang trung"))
                {
                    statement.setInt(4, 1);
                }
                else
                    statement.setInt(4, 2);

            //statement.setInt(4, phong.getIdLoaiPhong().getId());

            statement.setString(5, phong.getHinhAnh());
            statement.setString(6, phong.getMoTa());
            statement.setInt(7, phong.getId());

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

    /**
     * ham de tim danh sach cac phong thoa nhung dieu kien:
     * id
     * idLoaiPhong
     * idTinhTrangPhong
     * neu nhung truong nao bang -1 thi khong lay
     * */
    public ArrayList<Phong> getDSPhongTheoDK(int id, String idLoaiPhong, int idTinhTrangPhong) {
        String sql = "";
        if(id == -1 && idLoaiPhong.equals("") && idTinhTrangPhong == -1)
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
            if(!idLoaiPhong.equals(""))
            {
                String loaiPhong = idLoaiPhong.toLowerCase();
                if(loaiPhong.equals("vip"))
                {
                    sql += "id_loai_phong = 0 and ";
                }
                else
                    if(loaiPhong.equals("hang trung"))
                    {
                        sql += "id_loai_phong = 1 and ";
                    }
                    else
                        sql += "id_loai_phong = 2 and ";
            }
            if(idTinhTrangPhong != -1)
            {
                sql += "id_tinh_trang = " + idTinhTrangPhong + " and ";
            }
            sql = sql.substring(0, sql.length() - 5);
        }

        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
            ResultSet rs = statement.executeQuery();
            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong = null;

            MySqlTinhTrangPhongDAO tinhTrangPhongDAO = new MySqlTinhTrangPhongDAO();

            while(rs.next())
            {
                int id_LoaiPhong = rs.getInt("id_loai_phong");
                phong = Phong.getInstance(id_LoaiPhong);

                phong.setId(rs.getInt("id"));
                phong.setLau(rs.getInt("lau"));
                phong.setGia(rs.getInt("gia"));
                phong.setHinhAnh(rs.getString("hinh_anh"));
                phong.setMoTa(rs.getString("mo_ta"));
                phong.setDonGiaPhong(this.getDonGiaPhongTheoTen(phong.getTenLoaiPhong()));

                //int id_loai_phong = rs.getInt("id_loai_phong");
                int id_tinh_trang = rs.getInt("id_tinh_trang");

                phong.setDonGiaPhong(this.getDonGiaPhongTheoTen(phong.getTenLoaiPhong()));//loaiPhongDAO.getLoaiPhongTheoId(id_loai_phong).getGia());

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

            connector.openConnection();

            String sql = "select phong.*, loai_phong.ten, loai_phong.gia from phong, loai_phong where phong.id_loai_phong = loai_phong.id and phong.id_tinh_trang = ? order by id";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, tinhTrangPhong.getId());

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong = null;


            while(rs.next())
            {
                 int idLoaiPhong = rs.getInt("id_loai_phong");
                phong = Phong.getInstance(idLoaiPhong);

                 phong.setId(rs.getInt("id"));
                 phong.setLau(rs.getInt("lau"));
                 phong.setGia(rs.getInt("gia"));
                 phong.setDonGiaPhong(rs.getInt("loai_phong.gia"));
                 phong.setIdTinhTrang(tinhTrangPhong);

                 /*
                 loaiPhong = new LoaiPhong();
                 loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                 loaiPhong.setId(rs.getInt("id_loai_phong"));
                 loaiPhong.setTen(rs.getString("loai_phong.ten"));
                 phong.setIdLoaiPhong(loaiPhong);
                  */

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

    public ArrayList<Phong> getDSPhong() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select phong.*, tinh_trang_phong.ten , loai_phong.ten, loai_phong.gia " +
                    "from phong, tinh_trang_phong, loai_phong " +
                    "where phong.id_tinh_trang =  tinh_trang_phong.id and phong.id_loai_phong = loai_phong.id " +
                    "order by id";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList<Phong> lstPhong = new ArrayList<Phong>();
            Phong phong = null;
            TinhTrangPhong tinhTrangPhong;

            while(rs.next())
            {
                 int idLoaiPhong = rs.getInt("id_loai_phong");
                phong = Phong.getInstance(idLoaiPhong);

                 phong.setId(rs.getInt("id"));
                 phong.setLau(rs.getInt("lau"));
                 phong.setGia(rs.getInt("gia"));
                 phong.setHinhAnh(rs.getString("hinh_anh"));
                 phong.setMoTa(rs.getString("mo_ta"));
                 phong.setDonGiaPhong(rs.getInt("loai_phong.gia"));

                 tinhTrangPhong = new TinhTrangPhong();
                 tinhTrangPhong.setId(rs.getInt("id_tinh_trang"));
                 tinhTrangPhong.setTen(rs.getString("tinh_trang_phong.ten"));
                 phong.setIdTinhTrang(tinhTrangPhong);

                 /*
                 loaiPhong = new LoaiPhong();
                 loaiPhong.setGia(rs.getInt("loai_phong.gia"));
                 loaiPhong.setId(rs.getInt("id_loai_phong"));
                 loaiPhong.setTen(rs.getString("loai_phong.ten"));
                 phong.setIdLoaiPhong(loaiPhong);
*/

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

    public Integer[] getListIdPhongConTrong()
    {
        Connector connector = new MySqlConnector();
        try {


            connector.openConnection();

            String sql = "select id from phong where phong.id_tinh_trang = 0 order by id;";


            CallableStatement statement = connector.getConnection().prepareCall(sql);


            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList lstId = new ArrayList();


            while(rs.next())
            {
                 lstId.add(rs.getInt("id"));
            }

            statement.close();

            Integer[] arrInt = new Integer[lstId.size()];
            int i;
            for(i=0;i<lstId.size();i++)
            {
                arrInt[i] = (Integer)lstId.get(i);
            }

            return arrInt;


        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public int getDonGiaPhongTheoTen(String tenLoaiPhong) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select * from loai_phong where ten like ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, tenLoaiPhong);

            ResultSet rs = statement.executeQuery();

            //LoaiPhong loaiPhong = null;
            int donGia = -1;
            while(rs.next())
            {
              //  loaiPhong = new LoaiPhong();
                //loaiPhong.setId(rs.getInt("id"));
                //loaiPhong.setTen(rs.getString("ten"));
                //loaiPhong.setGia(rs.getInt("gia"));
                donGia = rs.getInt("gia");
            }
            statement.close();

            return donGia;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public boolean updateDonGiaPhongTheoTen(String tenLoaiPhong, int donGia) {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "update loai_phong set gia = ? where ten = ?;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);
            //statement.setString(1, loaiPhong.getTen());
            //statement.setInt(2, loaiPhong.getGia());
            //statement.setInt(3, id);

            statement.setInt(1, donGia);// loaiPhong.getGia());
            statement.setString(2, tenLoaiPhong);

            //statement.setInt(3, id);

            if(statement.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
    }

    public ArrayList<String> getDSLoaiPhong() {
        Connector connector = new MySqlConnector();
        try {
            connector.openConnection();

            String sql = "select distinct * from loai_phong;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);

            ResultSet rs = statement.executeQuery();

            ArrayList<String> lst = new ArrayList<String>();
            String loaiPhong = "";
            while(rs.next())
            {
                //loaiPhong = new LoaiPhong();
                //loaiPhong.setId(rs.getInt("id"));
                //loaiPhong.setTen(rs.getString("ten"));
                //loaiPhong.setGia(rs.getInt("gia"));

                loaiPhong = rs.getString("ten");
                lst.add(loaiPhong);
            }

            statement.close();

            return lst;
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
